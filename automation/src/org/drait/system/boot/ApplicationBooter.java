/**
 * 
 */
package org.drait.system.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author DEEPAK
 * 
 */
public class ApplicationBooter implements WebApplicationInitializer {

	String[] contexts = new String[] {
			"classpath:automation/appContext/applicationContext.xml",
			"classpath:automation/appContext/root-context.xml" };

	@Override
	public void onStartup(ServletContext container) {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocations(contexts);
		ServletRegistration.Dynamic registration = container.addServlet(
				"automationDispatcher", new DispatcherServlet(appContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

	}
}
