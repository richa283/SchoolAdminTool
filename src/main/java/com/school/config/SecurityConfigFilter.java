package com.school.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//This is going to create filter chain

@EnableWebSecurity(debug = true)
public class SecurityConfigFilter extends WebSecurityConfigurerAdapter {

	@Autowired
	public DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	//	 In memory authentication		
		auth.inMemoryAuthentication().withUser("Aman").password("tomar").roles("admin").and().withUser("Kavyansh")
				.password("jain").roles("admin");

		//JDBC authentication
	//	auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	// ByDefault formLogin and Basic http login are activated
	// Here we are making custom authorization flow
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/processPhoto","/saveAdmissison").permitAll().and().csrf().disable();
		
//	http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); //Basic Http authorization
//	http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/customLogin").and().csrf().disable(); //FormLogin authorization
//	http.authorizeRequests().anyRequest().denyAll(); //will deny all end points

//	http.authorizeRequests().anyRequest().permitAll(); //will deny all end points
/*
	 Securing one or multiple endpoints
		 authenticate() + formLogin() / httpBasic() -> Combination
*/
//		http.authorizeRequests().antMatchers("/stulist").authenticated().and().formLogin().loginPage("/customlogin").and().logout().and().exceptionHandling().accessDeniedPage("/accessdenied");
 
//		http.authorizeRequests().antMatchers("/stulist").hasAnyAuthority("user").and().formLogin().loginPage("/customlogin").and().logout();
//		http.authorizeRequests().antMatchers("/studentsList").authenticated().and().formLogin(); //authorize only /studentsList endpoint
//		http.authorizeRequests().antMatchers("/stulist").authenticated().antMatchers("/contact").permitAll().and().formLogin();
		
	//	http.authorizeRequests().anyRequest().authenticated().and().formLogin(); // Authorize all request
	//	http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/customlogin"); // Authorize all request

	}
}
