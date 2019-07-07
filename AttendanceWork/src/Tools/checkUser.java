package Tools;
/*
 * 判断用户身份
 */
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Services.searchAll;

public class checkUser {
	String Id;
	String password;
	String username;
	public checkUser(String Id,String password) {
//		数据库，查询的用户名，用户密码
		this.Id = Id;
		this.password = password;
	}
	public boolean isUser() throws ClassNotFoundException, SQLException{
		Connection conn = new ConnectDb().getConnect();
//		执行查询
		String sql;
		sql = "select UserName from login where Id='"+Id+"' and PassWord='"+password+"'";
		ResultSet rs = new searchAll(sql).getResult();
		if(rs.next()) {
			username = rs.getString(1);
			return true;
		}	
		return false;
	}
}
