package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.SimpleTimeZone;
import java.util.*;

import Tools.ConnectDb;

public class Update {
	private ArrayList<Object> values = null;
	private String presql = null;
	private String condition = null;
	private PreparedStatement pstmt = null;
	
	public Update(String presql,ArrayList<Object> values) {
		this.presql = presql;
		this.values = (ArrayList<Object>) values.clone();
	}
	
	public void doUpdate() throws SQLException, ParseException {
		Connection conn = new ConnectDb().getConnect();
		conn.setAutoCommit(false);  //  这样就不会自动提交，需要手动commit
		pstmt = conn.prepareStatement(presql);
		int i=1;
//		判断数据类型再更新数据库
		for(Object value:values) {
			String type = value.getClass().toString();
			System.out.println(type);
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
		pstmt.addBatch();
		pstmt.executeBatch();
		conn.commit();
		conn.close();
	}
}
