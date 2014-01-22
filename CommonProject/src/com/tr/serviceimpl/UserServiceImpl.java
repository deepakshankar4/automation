package com.tr.serviceimpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tr.dao.UserDao;
import com.tr.errorandstatuscodes.ErrorCodes;
import com.tr.model.ProtectPassword;
import com.tr.model.UserInfo;
import com.tr.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public String usersLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ProtectPassword passdecris = new ProtectPassword();
		String pass = passdecris.encrypt(password);
		PrintWriter out = response.getWriter();

		try {

			List<UserInfo> usenamelist = userdao.LoginDao(username, pass);

			if (usenamelist.size() != 0) {
				HttpSession hsession = request.getSession(true);

				Iterator<UserInfo> it = usenamelist.iterator();
				UserInfo u_name = null;

				if (it.hasNext()) {
					u_name = (UserInfo) it.next();

					u_name.getClass();

					u_name.getClass();

					hsession.setAttribute("user", u_name.getUsername());
					if (u_name.getReferrer() != null) {
						hsession.setAttribute("referrer", u_name.getReferrer()
								.getUsername());
					}

					return "index";
				}

			} else {
				out.println("wrong username or password!!!");
				request.setAttribute("errorStatus",
						ErrorCodes.getEcommUserLoginError());
				return "errorpage";
			}
		} catch (HibernateException ex) {

			ex.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

		}
		return null;

	}

	@Override
	public String googleloginflow(HttpServletRequest request,
			HttpServletResponse response) {

		String gmail = request.getParameter("gmail");

		try {

			List<UserInfo> usenamelist = userdao.LoginDao(gmail);

			if (usenamelist.size() != 0) {
				HttpSession hsession = request.getSession(true);

				Iterator<UserInfo> it = usenamelist.iterator();
				UserInfo u_name = null;

				if (it.hasNext()) {
					u_name = (UserInfo) it.next();

					u_name.getClass();

					u_name.getClass();

					hsession.setAttribute("user", u_name.getUsername());
					if (u_name.getReferrer() != null) {
						hsession.setAttribute("referrer", u_name.getReferrer()
								.getUsername());
					}

					return "index";
				}

			} else {

				request.setAttribute("errorStatus",
						ErrorCodes.getEcommUserLoginError());
				return "errorpage";
			}
		} catch (HibernateException ex) {

			ex.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			
		}
		return null;
	}

	@Override
	public String ShowProfilePic(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession usrsess = request.getSession(false);
		String userName = (String) usrsess.getAttribute("user");

		try {

			List<UserInfo> inven = userdao.fetchUsers(userName);
			Iterator<UserInfo> invenit = inven.iterator();

			UserInfo userpic = null;
			if (invenit.hasNext()) {
				userpic = invenit.next();
			}

			File imgeFile = userpic.getProfile_pic();
			System.out.println(imgeFile.getAbsolutePath());
			FileInputStream fis = new FileInputStream(imgeFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			response.setContentType("image/jpg");
			BufferedOutputStream output = new BufferedOutputStream(
					response.getOutputStream());
			for (int data; (data = bis.read()) > -1;) {
				output.write(data);
			}

			bis.close();
			fis.close();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {


		}

		return null;
	}

	@Override
	public String ManUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		String referrer = request.getParameter("referrer");
		String email = request.getParameter("email");

		String chlng = request.getParameter("recaptcha_challenge_field");
		String responsecap = request.getParameter("recaptcha_response_field");

		String remoteaddr = request.getRemoteAddr();

		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LcdmegSAAAAAFmScRETZFNj4LHEJ2cdMADqMXQ9");

		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteaddr,
				chlng, responsecap);

		Integer UID = -1;
		PrintWriter out = response.getWriter();

		try {
			if (reCaptchaResponse.isValid()) {
				ProtectPassword pass = new ProtectPassword();

				String pww = pass.encrypt(pw);
				UID = userdao.regNewUser(un, pww, email, referrer);
				if (UID == ErrorCodes.getEcommUserRegError()) {
					request.setAttribute("errorStatus",
							ErrorCodes.getEcommUserRegError());
					return "errorpage";

				}

				return "index";
			} else {
				out.println("invalid input!!!");
				request.setAttribute("info", "invalid captcha!!!");

				return "register";
			}

		} catch (HibernateException ex) {

			ex.printStackTrace();
			out.println("Improper data");
			request.setAttribute("errorStatus",
					ErrorCodes.getEcommUserRegError());
			return "errorpage";

		} catch (Exception ex) {

			ex.printStackTrace();
			request.setAttribute("errorStatus", ErrorCodes.getEcommFatalError());
			return "errorpage";

		}

	}

	@Override
	public String logOut(HttpServletRequest request,
			HttpServletResponse response) {

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
