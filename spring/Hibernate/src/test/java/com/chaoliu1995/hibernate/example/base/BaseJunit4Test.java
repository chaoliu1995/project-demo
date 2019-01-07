package com.chaoliu1995.hibernate.example.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.chaoliu1995.hibernate.example.config.AppConfig;

/** 
* @Author: LiuChao
* @Description: 单元测试基类
* @Email: chaoliu1995@QQ.com
* @CreateDate: 2017年10月17日 下午7:11:50
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})  
@Transactional
public class BaseJunit4Test {
	
}
