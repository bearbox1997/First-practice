package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Tools.ConnectDb;

//   批量删除
public class Delete {
	private ArrayList<String> sql = null;
	private PreparedStatement pstmt = null;
	private String presql = null;
	private String tableName = null;
	
	public Delete(String presql,ArrayList<String> sql,String tableName) {  // 预执行语句presql，参数sql
		System.out.println("开始删除");
		this.presql = presql;
		this.sql = (ArrayList<String>) sql.clone();
		this.tableName = tableName;
		System.out.println("获取到的tableName:    "+ this.tableName);
	}
	
	public void doDelete() throws SQLException {
		Connection conn = new ConnectDb().getConnect();
		conn.setAutoCommit(false);  //  这样就不会自动提交，需要手动commit
		pstmt = conn.prepareStatement(presql);
		for(String target:sql) {
			pstmt.setString(1, target);
			pstmt.addBatch();
		}
		pstmt.executeBatch();
		conn.commit();
		conn.close();
//		如果是员工表，还需要级联删除了登录表
		if(tableName.equals("employees_copy1")) {
			System.out.println("级联删除login");
			String presql_login = "delete from login where Id=?";
			Connection conn_login = new ConnectDb().getConnect();
			conn_login.setAutoCommit(false);  //  这样就不会自动提交，需要手动commit
			PreparedStatement pstmt_login = conn_login.prepareStatement(presql_login);
			for(String target:sql) {
				System.out.println("正在执行删除，target值为："+target);
				pstmt_login = conn_login.prepareStatement(presql_login);
				pstmt_login.setString(1, target);
				pstmt_login.addBatch();
			}
			pstmt_login.executeBatch();
			conn_login.commit();
			conn_login.close();
			
		}
		

	}

}
