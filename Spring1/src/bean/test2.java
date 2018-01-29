package bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.User;

public class test2 {
	@Test
	public void testUser() {
		//1.加载spring配置文件，根据创建对象
		System.out.println("11111");
		ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
	
		//2.得到配置创建的对象
		Bean3 bean2=(Bean3) context.getBean("bean3");
		System.out.println(bean2);
	
	}
}
