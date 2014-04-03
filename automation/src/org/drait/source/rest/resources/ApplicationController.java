/**
 * 
 */
package org.drait.source.rest.resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author DEEPAK
 * 
 */
@Controller
@RequestMapping(value = "/application")
public class ApplicationController {

	private static final Logger LOGGER = Logger
			.getLogger(ApplicationController.class.getName());

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		LOGGER.info("Welcome to TRIM! The client locale is " + locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

	@RequestMapping(value = "/automation-ui", method = RequestMethod.GET)
	public ModelAndView automationUIRenderer() {
		return new ModelAndView("student-details");
	}

}
