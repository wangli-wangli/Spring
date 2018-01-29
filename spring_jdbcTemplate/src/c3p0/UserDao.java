package c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

	//得到JdbcTemplate对象
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//添加操作
	public void add() {
		String sql="insert into user value(?,?)";
		jdbcTemplate.update(sql,"李磊","234");
		
	}
}
