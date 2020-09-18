package com.lq;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class MySpringBoot {

	public static void run()throws Exception{
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);

		//项目的classes文件路径
		String path = MySpringBoot.class.getResource("/").getPath();
		System.out.println(path);

		//这相当于在webapps下添加一个项目，其实一个项目也就是一个目录,路径可以是任意
		Context context = tomcat.addWebapp("/",new File("src/main/webapp").getAbsolutePath());
		WebResourceRoot webResource = new StandardRoot(context);
		tomcat.start();
		tomcat.getServer().await();
	}
}