/**
 * 
 */
package com.mms.loader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Daddy
 *
 */
public class BackendLoader {

	ApplicationContext context = null;
	/**
	 * 
	 */
	public BackendLoader() {
		context = new ClassPathXmlApplicationContext("classpath:/app_bean.xml");
	}

	public <T> T getBean(String name, Class<T> clazz)
	{
		return this.context.getBean(name, clazz);
	}
}
