package org.khl.chat;

import org.khl.chat.controller.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleChatApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<AuthFilter> loggingFilter(){
	    FilterRegistrationBean<AuthFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new AuthFilter());
	    registrationBean.addUrlPatterns("/users/*");
	    registrationBean.setOrder(0);
	    
	    return registrationBean;    
	}

}
