package service;

import org.springframework.transaction.annotation.Transactional;

import dao.OrdersDao;

@Transactional
public class OrdersService {
	private OrdersDao ordersDao;
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	//调用dao的方法
	//业务逻辑层，写转账业务
	public void accountMoney() {
		//小王少10000
		ordersDao.lessMoney();
		
		//出现异常
		int i=100/0;
		
		//小马多10000
		ordersDao.moreMoney();
		
	}

}
