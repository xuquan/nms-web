package com.otn.common.dbo.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseDAO {
	
	private static Logger logger = Logger.getLogger(BaseDAO.class);

	/**
	 * 单例
	 */
	private static BaseDAO instance = new BaseDAO();

	public static BaseDAO getInstance() {
		return instance;
	}

	/**
	 * 添加实体
	 * 
	 * @param obj
	 *            ，要添加的实体对象
	 * @throws Exception
	 */
	public void add(Object obj) {
		Session session = null;
		Transaction tx  = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx  = session.beginTransaction();
			session.save(obj);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			logger.error(e);
			throw e;
		} finally {
			if (session != null) {
				if(session.isOpen()){
					session.close();
				}
			}
		}
	}
	
	/**
	 * 添加实体
	 * 
	 * @param obj
	 *            ，要添加的实体对象
	 * @throws Exception
	 */
	public void add(Object obj, Session session) {
		try {
			session.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			session.beginTransaction().rollback();// 事务回滚
		} finally {
			
		}
	}
	
	/**
	 * 添加列表
	 * 
	 * @param obj
	 *            ，要添加的实体对象
	 * @throws Exception
	 */
	public void add(List<Object> objList) {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			session.beginTransaction().begin();
			// 插入批次，写入数据库，释放内存
			int count = 0;
			// 多次添加使用一个session
			for(Object obj : objList){
				add(obj, session);
				count++;
				if(count % 50 == 0){
					session.flush();
					session.clear();
				}
			}
			// 提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null){
				session.beginTransaction().rollback();// 事务回滚
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	/**
	 * 删除实体
	 * 
	 * @param obj
	 *            ，要删除的实体
	 * @throws Exception
	 */
	public void delete(Object obj) throws Exception {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			// 删除实体
			session.delete(obj);
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			if(session!=null && session.isOpen()){
				session.beginTransaction().rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * 更新实体
	 * 
	 * @param obj
	 *            ，要更新的实体
	 * @throws Exception
	 */
	public void update(Object obj) throws Exception {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			// 删除实体
			session.update(obj);
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			if(session!=null && session.isOpen()){
				session.beginTransaction().rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * 根据指定的hql进行查询，并返回查询结果
	 * 
	 * @param hql
	 *            ，hql语句
	 * @return 查询结果
	 * @throws Exception
	 */
	public List<?> findByHQL(String hql) throws Exception {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			// 删除实体
			Query queryObject = session.createQuery(hql);
			return queryObject.list();
		} catch (Exception e) {
			if(session!=null && session.isOpen()){
				session.beginTransaction().rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * 根据指定的实体类型和主键的值，查找实体对象
	 * 
	 * @param cls
	 *            ，实体的类
	 * @param key
	 *            ，主键的值
	 * @return，查找的实体对象
	 * @throws Exception
	 */
	public Object findById(String cls, Serializable key) throws Exception {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			// 删除实体
			Object instance = session.get(cls, key);
			return instance;
		} catch (Exception e) {
			if(session!=null && session.isOpen()){
				session.beginTransaction().rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * 获取单表内容
	 * 
	 * @param obj
	 * @return
	 * @throws Exception 
	 */
	public List<?> getList(String className) throws Exception {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			// 删除实体
			Query qry = session.createQuery("from " + className);
			return qry.list();
		} catch (Exception e) {
			if(session!=null && session.isOpen()){
				session.beginTransaction().rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * 删除表格
	 * @throws Exception 
	 */
	public void deleteAll(String className) throws Exception {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			// 删除实体
			Query qry = session.createQuery("delete " + className);
			qry.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if(session!=null && session.isOpen()){
				session.beginTransaction().rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * 获取表格长度
	 * 
	 * @param className
	 * @return
	 * @throws Exception 
	 */
	public long count(String className) throws Exception {
		Session session = null;
		try {
			// 取得session对象
			session = HibernateSessionFactory.getSession();
			// 删除实体
			Query qry = session.createQuery("select count(*) from " + className
					+ " x");
			List<?> list = qry.list();
			Long count = (Long) list.get(0);
			return count;
		} catch (Exception e) {
			if(session!=null && session.isOpen()){
				session.beginTransaction().rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}