package Tools;
/*
 * 连接数据库接口
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
	String USER = "root";
	String PASS = "hhh123";
	public ConnectDb() {
	}
	
	public Connection getConnect() {
		try {
//			注册JDBC驱动
			String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			Class.forName(JDBC_DRIVER);
			System.out.println("成功注册JDBC");
//			打开连接
			Connection conn = null;        
			String DB_URL = "jdbc:mysql://localhost:3306/attendance?useSSL=false&serverTimezone=GMT%2B8";
			try {
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("连接成功");		
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
