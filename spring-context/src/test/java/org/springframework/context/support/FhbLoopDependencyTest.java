package org.springframework.context.support;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * @Author huabao.fang
 * @Date 07:25 2019-09-17
 * @Description 测试spring循环依赖问题
 **/
public class FhbLoopDependencyTest {

	//测试spring循环依赖问题
	@Test
	public void testLoopDependency(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/org/springframework/context/support/fhbLoopDependencyContext.xml");
		assertTrue(ctx.containsBean("a"));
		assertTrue(ctx.containsBean("b"));
		ctx.close();
	}



	public static class A implements Print{
		@Autowired
		private B b;

		public A() {
			System.out.println("A init ...");//fanghuabao 此处断点  可知悉单例Bean如何解决循环依赖问题
		}

		@Override
		public void print(String msg) {
			System.out.println(b);
		}

	}

	public static class B implements Print{
		@Autowired
		private A a;

		public B() {
			System.out.println("B init ...");
		}

		@Override
		public void print(String msg) {
			System.out.println(a);
		}
	}

	public interface Print{

		public void print(String msg);
	}


}


