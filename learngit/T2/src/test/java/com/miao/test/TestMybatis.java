package com.miao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.miao.Dao.UserMapper;
import com.miao.PoJo.User;

public class TestMybatis {
	 @Test
	    public void test() {
	        //��ʼ������
	        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
	        //���bean     
	        UserMapper user = ctx.getBean(UserMapper.class);
	        //�������ݿ�
	        User userInfo = user.selectByPrimaryKey();
	        System.out.println(userInfo.getAppid());
	        System.err.println(userInfo.getAppid());
	        assertNotNull(userInfo);
	    }
}
