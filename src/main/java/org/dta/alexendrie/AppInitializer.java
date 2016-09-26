package org.dta.alexendrie;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override	protected Class<?>[] getRootConfigClasses() {		return new Class[] { App.class };	} 
	@Override	protected Class<?>[] getServletConfigClasses() {		return new Class[] { App.class };		}
	@Override	protected String[] getServletMappings() {		return new String[] { "/"};	}
	
}