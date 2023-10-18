package com.school.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses(){
		Class[] configFiles = { SchoolConfig.class };
		return configFiles;
	}
	
	@Override
	protected String[] getServletMappings() {
		String[] mappings = { "/" };
		return mappings;
	}
	
}
