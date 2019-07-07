package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import Tools.ConnectDb;

public class Insert {
	private String presql = null;
	private ArrayList<Object> values = null;
	private PreparedStatement pstmt = null;
	
	public Insert(String presql,ArrayList<Object> values) {
		this.presql = presql;
		this.values = (ArrayList<Object>) values.clone();
	}
	
	public void doInsert() throws SQLException {
		Connection conn = new ConnectDb().getConnect();
		conn.setAutoCommit(false);  //  这样就不会自动提交，需要手动commit
		pstmt = conn.prepareStatement(presql);
		System.out.println("获取到的sql："+presql);
		System.out.println("预执行");
		int i=1;
		for(Object value:values) {
			String type = value.getClass().toString();
			if(type.equals("class java.lang.String")) {
				pstmt.setString(i, (String)value);
			}else if(type.equals("class java.lang.Double")){
				pstmt.setDouble(i, (Double)value);
			}else if(type.equals("class java.lang.Integer")) {
				pstmt.setInt(i, (Integer)value);
			}else if(type.equals("class java.sql.Time")) {
				pstmt.setTime(i, Time.valueOf(value.toString()));
			}else if(type.equals("class java.util.Date")) {
				Date date = (Date)value;
				int year = 1900+date.getYear();
				int month = 1+date.getMonth();
				int day = date.getDate();
				int hour = date.getHours();
				int minute = date.getMinutes();
				int second = 0;
				String s= ""+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
				System.out.println(s);
                Timestamp  fTimestamp = Timestamp.valueOf(s);
				pstmt.setTimestamp(i,fTimestamp);
			}
			i++;
		}
		pstmt.executeUpdate();
		conn.commit();
		conn.close();
		
		
	}
	
	
}
