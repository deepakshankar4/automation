/**
 * 
 */
package org.drait.source.rest.resources;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/swagger", method = RequestMethod.GET)
	public ModelAndView swagger(){
		ModelAndView modelAndView = new ModelAndView("swagger");
		
		return modelAndView;
	}

}
