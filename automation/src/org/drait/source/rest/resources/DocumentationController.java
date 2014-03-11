/**
 * 
 */
package org.drait.source.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;
import com.wordnik.swagger.model.ApiInfo;

/**
 * @author UC167163
 * 
 */
@Controller
@RequestMapping(value = "/documentation")
public class DocumentationController extends ApiDocumentationController {

	public DocumentationController() {

		setBaseControllerPackage("org.drait.source.rest.resources");
		List<String> controllerPackages = new ArrayList<String>();
		controllerPackages.add("org.drait.source.rest.resources");
		setAdditionalControllerPackages(controllerPackages);

		setBaseModelPackage("org.drait.source.domain");
		List<String> modelPackages = new ArrayList<String>();
		modelPackages.add("org.drait.source.domain");
		setAdditionalModelPackages(modelPackages);

		setApiVersion("v1");

		ApiInfo apiInfo = new ApiInfo("swagger4spring-web example app",
				"This is a basic web app for demonstrating swagger4spring-web",
				"http://localhost:8084/terms", "http://localhost:8084/contact",
				"MIT", "http://opensource.org/licenses/MIT");
		setApiInfo(apiInfo);
	}

	public String documentation() {
		return "documentation";
	}
}
