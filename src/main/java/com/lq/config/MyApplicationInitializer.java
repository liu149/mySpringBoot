package com.lq.config;

import javax.servlet.ServletContext;

public interface MyApplicationInitializer {

	 void onStartup(ServletContext servletContext);
}
