package com.tr.controller;

import java.security.Principal;
import java.util.Date;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tr.service.RolesService;
import com.tr.service.CommonService;

@Controller
public class LoginAdminController {

	@Autowired
	private CommonService commonService;

	@Autowired
	private RolesService rolesService;

	private static final Logger logger = Logger
			.getLogger(LoginAdminController.class);

	@RequestMapping(value = "/secure", method = RequestMethod.GET)
	public String executeSecurity(ModelMap model, Principal principal) {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {
			return "index";
		} else if (roles.contains("ROLE_USER")) {
			return "redirect:/ticketuser.html";
		} else {
			String name = principal.getName();

			model.addAttribute("author", name);
			model.addAttribute("message", "Welcome!!!");
			logger.info("Secure form. Welcome  " + name);
			return "welcome";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		logger.debug(" invoking the fail2login method ");
		logger.info("Failed to login. SQL error");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String printMessage(ModelMap model, Principal principal) {

		String username = principal.getName();
		model.addAttribute("author", username);
		model.addAttribute("message", "Hello Spring Security - USER LOGIN");
		return "welcome";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(ModelMap model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("author", username);
		model.addAttribute("message",
				" You don't have privileges to view this page!!!");
		logger.info("Insufficient privilages");
		return "welcome";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome2() {
		return new ModelAndView("index1");
	}

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	public @ResponseBody
	String getTime() {
		String result = new Date().toString() + "</b>";
		System.out.println("Date:" + new Date().toString());
		return result;
	}
}