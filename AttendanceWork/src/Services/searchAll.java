package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Tools.ConnectDb;
//  通过sql语句进行查询

public class searchAll {
	private String sql = null;
	private ResultSet res = null;
	private Statement stmt = null;
	Connection conn = null;
	public searchAll(String sql) {
		this.sql = sql;
	}
	
//	返回查询结果集
	public ResultSet getResult() throws SQLException {
		conn = new ConnectDb().getConnect();
		stmt = conn.createStatement();
		res = stmt.executeQuery(sql);
		return res;
	}
	
	public void closeConn() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
}
