package org.springframework.context.support;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * @Author huabao.fang
 * @Date 07:25 2019-09-17
 * @Description 测试spring循环依赖问题
 *
 *
 * demo有两个涉及两个类即A，B
 * A 中使用autowire注解注入类型为B的属性b
 * B 中使用autowire注解注入类型为A的属性a
 * 断点调试结果如下:
 * 1 在finishBeanFactoryInitialization这一步 通过getBean来实例化各种bean的
 * 2 首先实例化对象b(为什么是它？)
 * 3 检查对象b的属性，发现b内存在被注入的属性a 于是getBean('a')
 * 4 getBean('a')里面同样会对a进行实例化
 * 5 检查对象a的属性，发现a内存存在被注入的属性b,于是再getBean('b'),此时返回的是属性a为null的对象b
 * 6 通过反射将 对象b设置到对象a的属性b上
 * 7 再是将 已设置属性b的对象a，通过反射设置到b上
 * 此上是此次调试的结果  语言表述上可能比较啰嗦和粗俗
 *
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


