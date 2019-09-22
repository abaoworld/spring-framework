package org.springframework.context.support;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * @Author huabao.fang
 * @Date 07:25 2019-09-17
 * @Description 测试spring 加载和使用properties流程
 **/
public class FhbPropertiesTest {

	//测试spring 加载和使用properties流程
	@Test
	public void fhbProperties(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/org/springframework/context/support/fhbProperties.xml");
		ctx.close();
	}



	public static class A implements Print{
		@Autowired
		private B b;

		public A() {
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


