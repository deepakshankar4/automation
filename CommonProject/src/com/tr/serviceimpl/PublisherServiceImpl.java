package com.tr.serviceimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.dao.PublisherDao;
import com.tr.errorandstatuscodes.ErrorCodes;
import com.tr.model.ProtectPassword;
import com.tr.model.Publisher;
import com.tr.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {
	@Autowired
	private PublisherDao publisherdao;

	@Override
	public String PubLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String publishername = request.getParameter("username");
		String password = request.getParameter("password");
		ProtectPassword passdecris = new ProtectPassword();
		String pass = passdecris.encrypt(password);

		try {

			List<Publisher> pubnamelist = publisherdao.Pub_login_dao(
					publishername, pass);
			HttpSession hsession = request.getSession(true);

			Iterator<Publisher> it = pubnamelist.iterator();
			Publisher publ;
			if (it.hasNext()) {
				publ = it.next();

				hsession.setAttribute("publisher", publ.getPublisherName());

				return "pubwel";
			} else {

				request.setAttribute("errorStatus",
						ErrorCodes.getEcommPubLoginError());
				return "errorpage";
			}
		} catch (HibernateException ex) {

			ex.printStackTrace();

		} finally {

		}

		return null;

	}

	@Override
	public String PubReg(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String pn = request.getParameter("pubname");
		String on = request.getParameter("ownname");
		String pw = request.getParameter("password");

		String chlng = request.getParameter("recaptcha_challenge_field");
		String responsecap = request.getParameter("recaptcha_response_field");

		String remoteaddr = request.getRemoteAddr();

		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LcdmegSAAAAAFmScRETZFNj4LHEJ2cdMADqMXQ9");

		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteaddr,
				chlng, responsecap);

		PrintWriter out = response.getWriter();
		try {
			if (reCaptchaResponse.isValid()) {

				ProtectPassword pass = new ProtectPassword();
				String pww = pass.encrypt(pw);

				publisherdao.regNewPub(pn, on, pww);

				return "index";
			} else {
				out.println("invalid input!!!");

				return "pubregister";
			}

		} catch (HibernateException ex) {
			out.println("username already exists!!!");
		}

		return null;
	}

	@Override
	public String pubLogOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		try {
			HttpSession session = request.getSession();

			session.invalidate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Inside index page controller");

		return "index";
	}

}
