package com.otn.common.dbo.hibernate;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// 创建SessionFactory
	private static SessionFactory sessionFactory;
	// 使用静态代码块(只创建一次)来创建sessionFactory
	static {
		// 读取配置hibernate.cfg.xml
		try {
			File cfgFile = new File("conf/db/hibernate.cfg.xml");
			Configuration configuration = new Configuration().configure(cfgFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获得session
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	// 关闭session,session总是默认保存数据(save(),get(),load()...)
	// 很可能出现内存泄露
	public static void close(Session session) {
		if (session != null) {
			if (session.isOpen()) {// null.isOpen
				session.close();
			}
		}
	}

}