package org.springframework.fhb;

import com.sun.tracing.dtrace.ArgsAttributes;

/**
 * @Author huabao.fang
 * @Date 23:22 2019-09-16
 **/
public class TestLoopDependency {


	public void test1(){

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(FQ_SIMPLE_CONTEXT);
		assertTrue(ctx.containsBean("someMessageSource"));
		ctx.close();
	}

}
