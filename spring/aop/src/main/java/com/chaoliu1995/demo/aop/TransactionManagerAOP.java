package com.chaoliu1995.demo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TransactionManagerAOP {
	
	protected Logger log = Logger.getLogger(TransactionManagerAOP.class);
	
	@Pointcut("execution(** com.chaoliu1995.SpringAOPExample.service.*.save*(..))")
	public void transaction(){}
	
	@Before("transaction()")
	public void openTrsaction(){
		System.out.println("打开事务");
		log.info("打开事务");
	}
	
	@AfterReturning("transaction()")
	public void colseTrsaction(){
		System.out.println("关闭事务");
		log.info("关闭事务");
	}
	
	@AfterThrowing("transaction()")
	public void rollback(){
		System.out.println("回滚事务");
		log.info("回滚事务");
	}
}
