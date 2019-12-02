package business.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibSessionFactory {
	private static SessionFactory sf = null;
	static{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		sf = ctx.getBean("sessionFactory",SessionFactory.class);
	}
	
	/**
	 * ·µ»Øsession
	 */
	public static Session getSession(){
		return sf.openSession();
	}
}
