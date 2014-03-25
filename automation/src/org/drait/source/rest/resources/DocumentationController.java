/**
 * 
 */
package org.drait.source.rest.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;

/**
 * @author DEEPAK
 *
 */
@Controller
@RequestMapping(value = "/documentation")
public class DocumentationController extends ApiDocumentationController {
	
	public DocumentationController() {
		setBaseControllerPackage("org.drait.source.rest");
        setBaseModelPackage("org.drait.source.domain");
        setApiVersion("v1");
	}
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	   public String documentation() {
	        return "documentation";
	    }

}
