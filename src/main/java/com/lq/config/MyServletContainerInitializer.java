package com.lq.config;

import org.springframework.util.ReflectionUtils;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(MyApplicationInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

		c.forEach(o -> {
			try {
				Object obj = ReflectionUtils.accessibleConstructor(o).newInstance();
				MyApplicationInitializer initializer = (MyApplicationInitializer) obj;
				initializer.onStartup(ctx);
			}catch (Exception e){
				e.printStackTrace();
			}
		});

	}
}
