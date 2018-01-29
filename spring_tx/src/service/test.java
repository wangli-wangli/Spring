package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class test {
	  @Test
	     public void testDemo() {
	    	 ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
	    	OrdersService ordersService=(OrdersService) context.getBean("ordersService");
	    	
	    	ordersService.accountMoney();
	     }
}
