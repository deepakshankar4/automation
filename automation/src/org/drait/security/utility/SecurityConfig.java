/**
 * 
 */
package org.drait.security.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * @author DEEPAK
 * 
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private DataSource datasource
	 */

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user@example.com")
				.password("password").roles("USER", "ADMIN");

		// auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema()
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();

		/*
		 * http.authorizeRequests().antMatchers("/non-secure-content/**")
		 * .permitAll().anyRequest().authenticated().and().formLogin()
		 * .loginPage("/login").permitAll();
		 */

		http.authorizeRequests().antMatchers("/non-secure-content/**")
				.permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll();
	}
}
