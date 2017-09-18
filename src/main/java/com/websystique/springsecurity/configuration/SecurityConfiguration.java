package com.websystique.springsecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/spring-security.xml")
//@EnableWebSecurity
public class SecurityConfiguration /* extends WebSecurityConfigurerAdapter */ {

	
//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
// 
//	  http.authorizeRequests()
//	  	.antMatchers("/", "/home").permitAll() 
//		.antMatchers("/admin/**").access("hasRole('ADMIN')")
//		.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//		.and().formLogin()
//		.and().exceptionHandling().accessDeniedPage("/Access_Denied");
// 
//	}
}
