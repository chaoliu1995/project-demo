package com.chaoliu1995.hibernate.example.base;

/** 
* @Author: ChaoLiu
* @Description: 
* @Email: chaoliu1995@qq.com
* @CreateDate: 2017年12月17日 下午5:45:16
*/
public interface BaseService<T> {
	
	Object save(Object entity);

	void delete(Object entity);

	void update(Object entity);

	void saveOrUpdate(Object entity);
	
	T saveEntity(T entity);
	
}
