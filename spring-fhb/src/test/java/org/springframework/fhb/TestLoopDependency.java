package org.springframework.fhb;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author huabao.fang
 * @Date 23:22 2019-09-16
 **/
public class TestLoopDependency {


	public void test1(){

		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/org/springframework/context/support/fhbLoopDependencyContext.xml");
		ac.close();
	}

}
