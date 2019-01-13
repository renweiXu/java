package com.xu.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xu.config.Config;
import com.xu.service.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="{classpath*:/spring-application.xml}")
public class AopTest {

	@Autowired
	private AopService aopService;
	
	@ContextResolve
	public  void aop(String a) {
		System.out.println("aop×¢½â²âÊÔ¡£¡£¡£¡£¡£");
	}
	
	@Test
	public void test(){
		String doSth = aopService.doSth("123", "456");
		System.out.println(doSth);
	}
	
	public static void main(String[] args) {
		String name = Config.getConfig().get("name");
		System.out.println(name);
	}
}
