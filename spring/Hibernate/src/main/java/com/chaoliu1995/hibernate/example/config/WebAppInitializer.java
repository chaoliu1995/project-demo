package com.chaoliu1995.hibernate.example.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web初始化类,替代xml 继承Abs..类后,会同时创建DispatcherServlet和ContextLoaderListener
 * 容器启动及初始化类
 * 前提:Servlet3.0
 */
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}
	
	/**
	 * 配置ContextLoaderListener 指定总的配置类
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	/**
	 * 配置DispatcherServlet 指定mvc配置类
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * 配置ServletMappings  指定DispatcherServlet的url
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.do" };
	}
	
	/**
	 * 配置第三方filter
	 */
	@Override
	protected Filter[] getServletFilters() {
		/**
		 * UTF-8编码filter
		 */
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		// 其他filter
		return new Filter[] { characterEncodingFilter };
	}
	
}
