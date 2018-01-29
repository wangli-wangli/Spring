package service;

import dao.OrdersDao;

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
		
		//小马多10000
		ordersDao.moreMoney();
		
	}

}
