/**
 * 
 */
package org.drait.source.rest.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author DEEPAK
 * 
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public void logoutAuthenticatedUser(HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("logout called!!!");
		String user = null;
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		user = authentication.getName();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response,
					authentication);
		}
		SecurityContextHolder.getContext().setAuthentication(null);

		System.out.println("successful logout of: " + user);

	}

}
