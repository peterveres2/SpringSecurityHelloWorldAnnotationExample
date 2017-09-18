package com.websystique.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    
    
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("register");

		return model;

	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, @RequestParam(value = "username", required = false) String user) {


	    // Authenticate the user
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	    grantedAuths.add(new SimpleGrantedAuthority("ROLE_EXAMINEE"));
	    grantedAuths.add(new SimpleGrantedAuthority("ROLE_REGISTRATION"));
	    securityContext.setAuthentication(new UsernamePasswordAuthenticationToken(user, null, grantedAuths));
	    // Create a new session and add the security context.
	    HttpSession session = request.getSession(true);
	    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
	    
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/tests");

		return model;

	}
}
