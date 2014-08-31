package com.otn.common.dbo.hibernate;
/**
 * Hibernate配置常量
 * @author 高彪
 *
 * 2014年5月26日
 */
public class HibernateConstants {

	/**
	 * 常量类，私有化构造方法
	 * @throws Exception 
	 */
	private HibernateConstants() throws Exception{
		throw new Error();
	}
	
	public static String HIBERNATE_CFG_FILE = "conf/db/hibernate.cfg.xml";
	
	
}
