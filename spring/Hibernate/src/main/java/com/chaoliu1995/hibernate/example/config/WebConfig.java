package com.chaoliu1995.hibernate.example.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.chaoliu1995.hibernate.example.controller",useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class })
		})
public class WebConfig {
	
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter(){
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
		mediaTypes.add(MediaType.parseMediaType("text/plain;charset=UTF-8"));
		mediaTypes.add(MediaType.parseMediaType("text/json;charset=UTF-8"));
		stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
		return stringHttpMessageConverter;
	}
	
	/**
	 * Thymeleaf模板解析器
	 * @return
	 */
	@Bean
	public ServletContextTemplateResolver templateResolver(){
	    WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();    
        ServletContext servletContext = webApplicationContext.getServletContext();
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
		templateResolver.setPrefix("/WEB-INF/view/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		templateResolver.setCharacterEncoding("UTF-8");
		//是否启用缓存
		templateResolver.setCacheable(false);
		return templateResolver;
	}
	
	/**
	 * Thymeleaf模板引擎
	 * @param templateResolver
	 * @return
	 */
	@Bean
	public TemplateEngine templateEngine(ServletContextTemplateResolver templateResolver){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}
	
	/**
	 * Thymeleaf视图解析器
	 * @param templateEngine
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
		ThymeleafViewResolver viewResolver  = new ThymeleafViewResolver();
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
	
	/**
	 * 配置静态资源的处理 将请求交由Servlet处理,不经过DispatchServlet
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	/**
	 * 静态文件路径
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	/**
	 * SpringMVC中异常的处理配置
	 * @return
	 */
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
		simpleMappingExceptionResolver.setDefaultErrorView("error/500");
		simpleMappingExceptionResolver.setDefaultStatusCode(500);

		// key是异常类型,value是返回的视图名称
		Properties exceptionMappings = new Properties();
		//exceptionMappings.setProperty(UnauthorizedException.class.getName(), "error/403");
		//exceptionMappings.setProperty(UnauthenticatedException.class.getName(), "error/403");
		exceptionMappings.setProperty(NoHandlerFoundException.class.getName(), "error/404");
		exceptionMappings.setProperty(Exception.class.getName(), "error/500");
		exceptionMappings.setProperty(Throwable.class.getName(), "error/500");
		simpleMappingExceptionResolver.setExceptionMappings(exceptionMappings);

		Properties statusCodes = new Properties();
		statusCodes.setProperty("error/403", "403");
		statusCodes.setProperty("error/404", "404");
		statusCodes.setProperty("error/500", "500");
		simpleMappingExceptionResolver.setStatusCodes(statusCodes);

		simpleMappingExceptionResolver.setWarnLogCategory(SimpleMappingExceptionResolver.class.getName());

		return simpleMappingExceptionResolver;
	}
	
}
