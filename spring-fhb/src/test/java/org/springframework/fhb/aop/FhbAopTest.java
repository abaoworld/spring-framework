package org.springframework.fhb.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.fhb.aop.service.AopService;

/**
 * @Author huabao.fang
 * @Date 11:08 2019-09-29
 * @Description AOP 测试
 **/
public class FhbAopTest {

	/**
	 * 验证aop流程
	 */
	@Test
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/org/springframework/fhb/aop/fhbAopTestContext.xml");

		AopService aopService = ac.getBean(AopService.class);
		String msg = aopService.sayHi("jack");
		System.out.println(msg);

		ac.close();
	}

}
