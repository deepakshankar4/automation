/**
 * 
 */
package org.drait.source.rest.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author DEEPAK
 * 
 */
@Controller
@RequestMapping(value = "/")
public class BaseController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView swagger() {
		ModelAndView modelAndView = new ModelAndView("home");

		return modelAndView;
	}
}
