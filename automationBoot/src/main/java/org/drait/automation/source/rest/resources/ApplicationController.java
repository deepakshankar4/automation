/**
 * 
 */
package org.drait.automation.source.rest.resources;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DEEPAK
 * 
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/application")
public class ApplicationController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@ResponseBody
	public String home() {
		return "hello world";
	}

}
