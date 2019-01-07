package com.chaoliu1995.hibernate.example.base.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaoliu1995.hibernate.example.base.BaseDao;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Email: chaoliu1995@qq.com
 * @CreateDate: 2017年12月17日 下午3:47:01
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Object save(Object entity) {
		return getSession().save(entity);
	}

	@Override
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	@Override
	public void update(Object entity) {
		getSession().update(entity);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		getSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T saveEntity(T entity) {
		return (T) getSession().save(entity);
	}

	@Override
	public void saveAll(Collection<T> entities) {
		Object entity = null;
		for (Iterator<T> localIterator = entities.iterator(); localIterator.hasNext();) {
			entity = localIterator.next();
			getSession().save(entity);
		}
	}

	@Override
	public void deleteAll(Collection<T> entities) {
		Object entity = null;
		for (Iterator<T> localIterator = entities.iterator(); localIterator.hasNext();) {
			entity = localIterator.next();
			getSession().delete(entity);
		}
	}

	@Override
	public void updateAll(Collection<T> entities) {
		Object entity = null;
		for (Iterator<T> localIterator = entities.iterator(); localIterator.hasNext();) {
			entity = localIterator.next();
			getSession().update(entity);
		}
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities) {
		Object entity = null;
		for (Iterator<T> localIterator = entities.iterator(); localIterator.hasNext();) {
			entity = localIterator.next();
			getSession().saveOrUpdate(entity);
		}
	}

	@Override
	public <E> E get(Class<E> entityClass, Serializable id) {
		return getSession().get(entityClass, id);
	}

	@Override
	public T get(String queryString, Map<String, Object> params) {
		@SuppressWarnings("unchecked")
		Query<T> query = getSession().createQuery(queryString);
		setParameter(query, params);
		List<T> list = query.setMaxResults(1).list();
		if (list == null || list.isEmpty() || list.size() > 1){
			return null;
		}
		return list.get(0);
	}
	
	@Override
	public T get(String queryString, Object... params){
		@SuppressWarnings("unchecked")
		Query<T> query = getSession().createQuery(queryString);
		for (int i = 0; i < params.length; ++i) {
			query.setParameter(i, params[i]);
		}
		List<T> list = query.setMaxResults(1).list();
		if (list == null || list.isEmpty() || list.size() > 1){
			return null;
		}
		return list.get(0);
	}
	
	@Override
	public <E> E get(String queryString, Class<E> entityClass, Map<String, Object> params){
		Query<E> query = getSession().createQuery(queryString,entityClass);
		for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			query.setParameter(key, params.get(key));
		}
		List<E> list = query.setMaxResults(1).list();
		if (list == null || list.isEmpty() || list.size() > 1){
			return null;
		}
		return list.get(0);
	}
	
	@Override
	public <E> E get(String queryString, Class<E> entityClass, Object... params) {
		Query<E> qry = getSession().createQuery(queryString, entityClass);
		for (int i = 0; i < params.length; ++i) {
			qry.setParameter(i, params[i]);
		}
		List<E> list = qry.setMaxResults(1).list();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	@Override
	public int executeSqlUpdate(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> findByProperty(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByProperty(Map<String, Object> conditionMap) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param query
	 * @param parameterMap
	 * @return
	 */
	private Query<T> setParameter(Query<T> query, Map<String, Object> parameterMap) {
		for (Iterator<String> iterator = parameterMap.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			query.setParameter(key, parameterMap.get(key));
		}
		return query;
	}

	@Override
	public List<T> findList(String queryString, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findList(String queryString, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> List<E> findList(String queryString, Class<E> entityClass, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> List<E> findList(String queryString, Class<E> entityClass, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
}
