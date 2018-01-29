package ioc;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.glass.ui.Application;

public class test {
    
	@Test
	public void testUser() {
		//1.加载spring配置文件，根据创建对象
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
		//2.得到配置创建的对象
		UserService userService=(UserService) context.getBean("userService");
		userService.add();
	}
}
