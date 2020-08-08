package com.mining.config;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ApiSecurityConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				// TODO 这里跨域最好配置域名
				.allowedOrigins("*").maxAge(3600).allowCredentials(true).allowedMethods("GET", "POST", "OPTIONS");
	}
}
