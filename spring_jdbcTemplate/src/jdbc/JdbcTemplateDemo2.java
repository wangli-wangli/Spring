package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.corba.se.pept.transport.EventHandler;

public class JdbcTemplateDemo2 {
	/*
	 * QueryRunner runner=new QueryRunner(dataSource);
	 * 返回对象
	 * runner.query(sql,new BeanHandler<User>(User.class))
	 * 
	 * 返回list集合
	 * runner.query(sql,new BeanListHander<User>(User.class))
	 * 
	 * 1.在dbutils时候，有接口ResultSetHandler
	 * dbutils提供了针对不同的结果实现类
	 * 
	 * 2.jdbcTemplate实现查询，有接口RowMapper
	 * jdbcTemplate针对这个接口没有提供实现类，得到不同的类型数据需要自己进行数据封装
	 * 
	 */
	
	//jdbc实现代码
	@Test
	public void testJDBC() {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
			//编写sql语句
			String sql="select * from user where username=?";
			//预编译sql
			preparedStatement=connection.prepareStatement(sql);
			//设置参数值
			preparedStatement.setString(1, "小明");
			//执行sql
			resultSet=preparedStatement.executeQuery();
			//遍历结果集
			while(resultSet.next()) {
				//得到返回结果值
				String username=resultSet.getString("username");
				String password=resultSet.getString("password");
				System.out.println(username+"    "+password);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//1.查询表有多少条记录
	@Test
	public void testCount() {
		//设置数据库信息
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		//调用方法得到记录数
		String sql="select count(*) from user";
		//调用jdbcTemplate的方法
		int count=jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	
	//2.查询返回对象
	@Test
	public void testObject() {
		//设置数据库信息
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		//调用方法得到记录数
		String sql="select * from user where username=?";
		//调用jdbcTemplate的方法
		//第二个参数是接口RowMapper,需要自己写类实现接口，自己做参数封装
		User user=jdbcTemplate.queryForObject(sql,new MyMappper() ,"lucy");
		System.out.println(user);
	}
	
	
	//3.查询list返回对象
	@Test
	public void testList() {
		/*//连接池配置
		ComboPooledDataSource dataSource=new  ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3307/test");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		*/
		//设置数据库信息
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		//写sql语句
		String sql="select * from user";
		//调用jdbcTemplate 的实现方法实现
		List<User> list=jdbcTemplate.query(sql,new MyMappper() );
		System.out.println("list:"+list);
		
	}
	
	

}
 class MyMappper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		// 1.从结果集里面把数据得到
		String username=rs.getString("username");
		String password=rs.getString("password");
		
		//2.把得到的数据封装到对象里面
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	 
	
}
