package ioc;

import org.apache.catalina.User;


public class UserService {
	
		//1.定义dao属性
		private UserDao userDao;
		//2生成set方法
		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		
		
		public void add() {
		
		System.out.println("service............");
		userDao.add();
		
	}





		
}
