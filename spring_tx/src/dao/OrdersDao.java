package dao;

import javax.sound.midi.VoiceStatus;

import org.springframework.jdbc.core.JdbcTemplate;

import jdk.nashorn.internal.objects.annotations.Where;

public class OrdersDao {
	//注入jdbcTemplate
	private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    /*
     * 
     *写对数据库操作的方法，不写业务操作 
     */
    //小王少钱的方法
    public void lessMoney() {
    	String sql="update account set salary=salary-? Where username=?";
    	jdbcTemplate.update(sql,1000,"小王");
    	
    }
    
    //多钱的方法
    public void moreMoney() {
    	String sql="update account set salary=salary+? where username=?";
    	jdbcTemplate.update(sql,1000,"小马");
    	
    }
}
