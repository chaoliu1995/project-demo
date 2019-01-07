package com.chaoliu1995.hibernate.example.base.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.chaoliu1995.hibernate.example.base.BaseDao;
import com.chaoliu1995.hibernate.example.base.BaseService;

/** 
* @Author: ChaoLiu
* @Description: 
* @Email: chaoliu1995@qq.com
* @CreateDate: 2017年12月17日 下午5:45:36
*/
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	private BaseDao<T> baseDao;

	@Override
	public Object save(Object entity) {
		return baseDao.save(entity);
	}

	@Override
	public void delete(Object entity) {
		baseDao.delete(entity);
	}

	@Override
	public void update(Object entity) {
		baseDao.update(entity);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		baseDao.saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T saveEntity(T entity) {
		return (T)baseDao.save(entity);
	}
	
	
}
