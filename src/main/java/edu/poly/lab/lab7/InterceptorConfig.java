package edu.poly.lab.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	AuthInterceptor auth;

//	@Autowired
//	GlobalInterceptor global;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auth).addPathPatterns("/account/admin/**")
				.excludePathPatterns("/assets/**");

		
// 		registry.addInterceptor(auth).addPathPatterns("/account/edit","/acount/home", "/account/chgpwd", "/order/**", "/admin/**")
//		.excludePathPatterns("/assets/**", "/account/admin");
		
//		registry.addInterceptor(global).addPathPatterns("/**").excludePathPatterns("/assets/**");
	}

}
