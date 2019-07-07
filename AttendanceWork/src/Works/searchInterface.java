package Works;
/*
 * 查询功能接口
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;

import Entities.modleCheckReports;
import Entities.modleClasses;
import Entities.modleDepartments;
import Entities.modleEmployees;
import Entities.modleJobs;
import Entities.modleLeaves;
import Entities.modlePaysalarys;
import Entities.modlePunchcards;
import Entities.modleRepaircards;
import Services.searchAll;

public class searchInterface {
	private ArrayList<Integer> types = new ArrayList<Integer>();
	private ArrayList<Object> datas = null;
	private String tableName = null;
	private int length = 0;
	private int year = 0;
	private int month = 0;
	Object one = null;
	Date d =new Date();
	private String condition = null;
	private String con_value = null;
	private String timeStart = null;
	private String timeEnd = null;
	
	public searchInterface(String tableName) {
		this.tableName = tableName;
	}
	
	public searchInterface(String tableName,String condition,String con_value) {
		this.tableName = tableName;
		this.condition = condition;
		this.con_value = con_value;
	}
	
	public searchInterface(String tableName,String condition,String con_value,String timeStart,String timeEnd) {
		this.tableName = tableName;
		this.condition = condition;
		this.con_value = con_value;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	
	public searchInterface(String tableName,int year,int month) {
		this.tableName = tableName;
		this.year = year;
		this.month = month;
	}
	public List<Object> getAll() throws SQLException {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from " + tableName;
		if(tableName.equals("checkreports_copy1")) {
			if(year != 0) {
				sql = "select t1.pInnerId chInnerId, t1.pId 员工编号,t1.pName 姓名,t1.pDateTime 上班时间, t2.pDateTime 下班时间\r\n" + 
						"from punchcards_copy1 t1, punchcards_copy1 t2\r\n" + 
						"where t1.pId=t2.pId and t1.pDateTime < t2.pDateTime and DATE_FORMAT(t1.pDateTime,'%Y')="+year+" and DATE_FORMAT(t1.pDateTime,'%m')="+month+"\r\n" + 
						"\r\n" + 
						"union\r\n" + 
						"\r\n" + 
						"select t1.rrInnerId chInnerId, t1.rrId 员工编号,t1.rrName 姓名,t1.rrDateTime 上班时间, t2.rrDateTime 下班时间\r\n" + 
						"from repaircards_copy1 t1, repaircards_copy1 t2\r\n" + 
						"where t1.rrId=t2.rrId and t1.rrDateTime < t2.rrDateTime and DATE_FORMAT(t1.rrDateTime,'%Y')="+year+" and DATE_FORMAT(t1.rrDateTime,'%m')="+month+"\r\n" + 
						"\r\n" + 
						"union\r\n" + 
						"\r\n" + 
						"select t1.pInnerId chInnerId, t1.pId 员工编号,t1.pName 姓名,t1.pDateTime 上班时间, t2.rrDateTime 下班时间\r\n" + 
						"from punchcards_copy1 t1, repaircards_copy1 t2\r\n" + 
						"where t1.pId=t2.rrId and t1.pDateTime < t2.rrDateTime and DATE_FORMAT(t1.pDateTime,'%Y')="+year+" and DATE_FORMAT(t1.pDateTime,'%m')="+month+"\r\n" + 
						"\r\n" + 
						"union\r\n" + 
						"\r\n" + 
						"select t2.rrInnerId chInnerId, t2.rrId 员工编号,t2.rrName 姓名,t2.rrDateTime 上班时间, t1.pDateTime 下班时间\r\n" + 
						"from punchcards_copy1 t1, repaircards_copy1 t2\r\n" + 
						"where t1.pId=t2.rrId and t1.pDateTime > t2.rrDateTime and DATE_FORMAT(t2.rrDateTime,'%Y')="+year+" and DATE_FORMAT(t2.rrDateTime,'%m')="+month+"\r\n" + 
						"\r\n" + 
						"ORDER BY 上班时间";
			}else {
				
				sql = "select * from \r\n" + 
						"(select t1.pInnerId chInnerId, t1.pId 员工编号,t1.pName 姓名,t1.pDateTime 上班时间, t2.pDateTime 下班时间\r\n" + 
						"from punchcards_copy1 t1, punchcards_copy1 t2\r\n" + 
						"where t1.pId=t2.pId and t1.pDateTime < t2.pDateTime\r\n" + 
						"\r\n" + 
						"union\r\n" + 
						"\r\n" + 
						"select t1.rrInnerId chInnerId, t1.rrId 员工编号,t1.rrName 姓名,t1.rrDateTime 上班时间, t2.rrDateTime 下班时间\r\n" + 
						"from repaircards_copy1 t1, repaircards_copy1 t2\r\n" + 
						"where t1.rrId=t2.rrId and t1.rrDateTime < t2.rrDateTime\r\n" + 
						"\r\n" + 
						"union\r\n" + 
						"\r\n" + 
						"select t1.pInnerId chInnerId, t1.pId 员工编号,t1.pName 姓名,t1.pDateTime 上班时间, t2.rrDateTime 下班时间\r\n" + 
						"from punchcards_copy1 t1, repaircards_copy1 t2\r\n" + 
						"where t1.pId=t2.rrId and t1.pDateTime < t2.rrDateTime\r\n" + 
						"\r\n" + 
						"union\r\n" + 
						"\r\n" + 
						"select t2.rrInnerId chInnerId, t2.rrId 员工编号,t2.rrName 姓名,t2.rrDateTime 上班时间, t1.pDateTime 下班时间\r\n" + 
						"from punchcards_copy1 t1, repaircards_copy1 t2\r\n" + 
						"where t1.pId=t2.rrId and t1.pDateTime > t2.rrDateTime\r\n" + 
						"\r\n" + 
						"ORDER BY 上班时间) t\r\n" + 
						"\r\n";
				
				if(con_value != null || timeStart != null) {
					sql += "where ";
					if(con_value != null && timeStart.equals("")) {
						sql += "chInnerId like '%" + con_value + "%'";
					}else if(con_value != null && !timeStart.equals("")) {
						sql += "chInnerId like '%" + con_value + "%' and DATE_FORMAT(上班时间,'%Y-%m-%d')>='"+ timeStart +"' and DATE_FORMAT(上班时间,'%Y-%m-%d')<='"+ timeEnd +"'";
					}else if(con_value == null && !timeStart.equals("")) {
						sql += "DATE_FORMAT(上班时间,'%Y-%m-%d')>='"+ timeStart +"' and DATE_FORMAT(上班时间,'%Y-%m-%d')<='"+ timeEnd +"'";
					}
				}
				
			}
			
		}
		System.out.println("正在生成sql语句并查询:"+sql);
		
//		条件查询
		if(con_value != null && !tableName.equals("checkreports_copy1")) {
			System.out.println("searchInterface中执行条件查询");
			sql += " where "+condition+" like '%"+con_value+"%'" ;
			System.out.println("其sql语句为：" + sql);
		}
		
		searchAll seaAll = new searchAll(sql);
		ResultSet rst = seaAll.getResult();
		ResultSetMetaData metaData = rst.getMetaData();
		length = metaData.getColumnCount();
		for(int i=1;i<=metaData.getColumnCount();i++) {
			types.add(metaData.getColumnType(i));
			System.out.println((i-1)+"  "+metaData.getColumnType(i)+"  "+metaData.getColumnTypeName(i)+"  "+metaData.getColumnLabel(i));
		}
		System.out.println(tableName);
		while(rst.next()) {
			System.out.println("数据+1");
			datas = new ArrayList<Object>();
			for(int i=1;i<=length;i++) {
				if(types.get(i-1)==12) {
					String s = rst.getString(i);
					datas.add(s);
				}else if(types.get(i-1)==4) {
					int m = rst.getInt(i);
					datas.add(m);
				}else if(types.get(i-1)==92) {
					Time m = rst.getTime(i);
					datas.add(m);
				}else if(types.get(i-1)==93) {
					Date m = rst.getTimestamp(i)
							;
					datas.add(m);
				}
			}
			if(tableName.equals("employees_copy1")) {
				one = new modleEmployees((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (int)datas.get(3),(String)datas.get(4), (int)datas.get(5), (String)datas.get(6), (String)datas.get(7), (String)datas.get(8), (String)datas.get(9), (String)datas.get(10),(String)datas.get(11), (String)datas.get(12));
			}else if(tableName.equals("jobs_copy1")) {
				one = new modleJobs((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (String)datas.get(3),(String)datas.get(4), (String)datas.get(5), (String)datas.get(6));
			}else if(tableName.equals("departments_copy1")) {
				one = new modleDepartments((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (String)datas.get(3),(String)datas.get(4), (String)datas.get(5), (String)datas.get(6));
			}else if(tableName.equals("classes_copy1")) {
				one = new modleClasses((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (Time)datas.get(3),(Time)datas.get(4));
			}else if(tableName.equals("punchcards_copy1")) {
				one = new modlePunchcards((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (Date)datas.get(3));
			}else if(tableName.equals("repaircards_copy1")) {
				one = new modleRepaircards((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (Date)datas.get(3),(String)datas.get(4));
			}else if(tableName.equals("checkreports_copy1")) {
				String chMark = "";
				int hourStart,minStart;
				int hourEnd;
				hourStart = ((Date)datas.get(3)).getHours();
				hourEnd = ((Date)datas.get(4)).getHours();
				minStart = ((Date)datas.get(3)).getMinutes();
				if(hourStart>9 || (hourStart==9 && minStart>0)) {
					chMark += "迟到  ";
				}
				if(hourEnd<18){
					chMark += "早退  ";
				}
				if(chMark.equals("")) {
					chMark += "正常";
				}
				one = new modleCheckReports((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (Date)datas.get(3),(Date)datas.get(4),chMark);
			}else if(tableName.equals("paysalarys_copy1")) {
				one = new modlePaysalarys((String)datas.get(0), (String)datas.get(1), (String)datas.get(2),(int)datas.get(3), (Date)datas.get(4),(Date)datas.get(5),(int)datas.get(6));
			}else if(tableName.equals("leaves_copy1")) {
				one = new modleLeaves((String)datas.get(0), (String)datas.get(1), (String)datas.get(2), (Date)datas.get(3),(Date)datas.get(4),(String)datas.get(5));
			}
			
			list.add(one);
		}
		seaAll.closeConn();
		return list;
	}
}
