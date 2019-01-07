package com.chaoliu1995.hibernate.example.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Email: chaoliu1995@qq.com
 * @CreateDate: 2017年12月17日 下午3:46:19
 */
public interface BaseDao<T> {
	
	Object save(Object entity);

	void delete(Object entity);

	void update(Object entity);

	void saveOrUpdate(Object entity);
	
	T saveEntity(T entity);
	
	/**
	 * 批量保存实体
	 * @param entities 实体集合
	 */
	void saveAll(Collection<T> entities);

	/**
	 * 批量删除实体
	 * @param entities 实体集合
	 */
	void deleteAll(Collection<T> entities);

	/**
	 * 批量更新实体
	 * @param entities 实体集合
	 */
	void updateAll(Collection<T> entities);

	/**
	 * 批量保存或更新实体, 实体没有主键时保存，否则更新
	 * @param entity 实体集合
	 */
	void saveOrUpdateAll(Collection<T> entities);
	
	
	
	
	
	/**
	 * 获取单个实体，根据实体类及实体的主键获取
	 * @param entityClass
	 * @param id
	 * @return
	 */
	<E> E get(Class<E> entityClass, Serializable id);

	/**
	 * 获取单个实体，根据查询语句及参数获取。
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 单个实体，如果查询结果有多个，则返回第一个实体
	 */
	T get(String queryString, Map<String, Object> params);
	
	/**
	 * 获取单个实体，根据查询语句及参数获取,如果没有查询到实体或查询到多个实体，则返回NULL
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 单个实体，如果查询结果有多个，则返回第一个实体
	 */
	T get(String queryString, Object... params);

	/**
	 * 获取单个实体，根据查询语句及参数获取。
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 单个实体，如果查询结果有多个，则返回第一个实体
	 */
	<E> E get(String queryString,Class<E> entityClass, Map<String, Object> params);
	
	/**
	 * 获取单个实体，根据查询语句及参数获取。
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 单个实体，如果查询结果有多个，则返回第一个实体
	 */
	<E> E get(String queryString, Class<E> entityClass, Object... params);

	
	/**
	 * 查询实体列表
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 实体列表
	 */
	List<T> findList(String queryString, Object... params);

	/**
	 * 查询实体列表
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 实体列表
	 */
	List<T> findList(String queryString, Map<String, Object> params);
	
	/**
	 * 查询实体列表
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 实体列表
	 */
	<E> List<E> findList(String queryString, Class<E> entityClass, Object... params);

	/**
	 * 查询实体列表
	 * @param queryString 查询语句
	 * @param params 可选的查询参数
	 * @return 实体列表
	 */
	<E> List<E> findList(String queryString, Class<E> entityClass, Map<String, Object> params);
	

	/**
	 * 执行数据库更新操作
	 * @param sql
	 * @return 更新的记录条数
	 */
	int executeSqlUpdate(String sql);

	public List<T> findByProperty(String name, Object value);

	public List<T> findByProperty(Map<String, Object> conditionMap);

}
