package com.chaoliu1995.demo.aop;

import org.apache.log4j.Logger;

public class TransactionManagerAOPXML {
	
	protected Logger log = Logger.getLogger(TransactionManagerAOP.class);
	
	public void transaction(){}
	
	public void openTrsaction(){
		System.out.println("打开事务");
		log.info("打开事务");
	}
	
	public void colseTrsaction(){
		System.out.println("关闭事务");
		log.info("关闭事务");
	}
	
	public void rollback(){
		System.out.println("回滚事务");
		log.info("回滚事务");
	}
}
