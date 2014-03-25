/**
 * 
 */
package org.drait.system.boot;

import org.drait.security.utility.SecurityConfig;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author DEEPAK
 * 
 */
public class BooterInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { DispatcherServlet.class };
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

}
