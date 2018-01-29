package jdbc;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

	//修改操作
	@Test
	public void update() {
		//设置数据库信息
		 DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//创建jdbcTemplate对象，设置数据源   
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		//调用jdbcTmplate对象，设置数据源
		String sql="update user set password=? where username=?";
	    jdbcTemplate.update(sql,"1312","lucy");
	}
	
	//1.添加操作
	@Test
	public void add() {
		//设置数据库信息
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		//调用jdbcTmplate对象，设置数据源
		//创建sql语句
		String sql="insert into user values(?,?)";
		int rows=jdbcTemplate.update(sql,"lucy","250");
		System.out.println(rows);
	}
	
	//删除操作
	@Test
	public void delete() {
		//设置数据库信息
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		//调用jdbcTmplate对象，设置数据源
		//创建sql语句
		String sql="delete from  user where username=?";
		int rows=jdbcTemplate.update(sql,"lucy");
		System.out.println(rows);
	}
	
	
	
}
