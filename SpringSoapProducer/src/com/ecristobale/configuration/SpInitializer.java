package com.ecristobale.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[0];
	}
	
	@Override
	protected String getServletName() {
		return "soap";
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SoapServiceConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
	
	

}
