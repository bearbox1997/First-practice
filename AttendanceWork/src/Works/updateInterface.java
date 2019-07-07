package Works;
/*
 * 更新数据的Servlet
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Insert;
import Services.Update;
import Tools.ConnectDb;
import net.sf.json.JSONObject;

//@WebServlet("/updateEmployees")
public class updateInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public updateInterface() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teststr = getJson(request);
		System.out.println("收到页面传来的添加数据");
		System.out.println(teststr);
		JSONObject  jasonObject = JSONObject.fromObject(teststr);
		System.out.println("我被执行");
		Map map = (Map)jasonObject;
		String presql = null;
		String predatas = null;
		String tableName = null;
		int k = 0;
		//遍历map中的值 
		for (Object value : map.values()) { 
			if(k==0) {
				presql = String.valueOf(value);
			}else if(k==1) {
				predatas = String.valueOf(value);
			}else if(k==2) {
				tableName = String.valueOf(value);
			}
			
		  System.out.println(value);
		  k++;
		}
		predatas = predatas.replace("[", "");
		predatas = predatas.replace("]", "");
		predatas = predatas.replace("\"", "");
		System.out.println(predatas);
		String datas[] = predatas.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		
		Date salaryStart = null;
		Date salaryEnd = null;
		String pId = "";
		
		int i = 0;
		for(String s:datas) {
			if(i==0) {
			}else {
				if(tableName.equals("employees_copy1")) {
					if(i==4 || i==6) {
						list.add(Integer.valueOf(s));
					}else {
						
						list.add(s);
					}
				}else if(tableName.equals("jobs_copy1")) {
					list.add(s);
				}else if(tableName.equals("departments_copy1")) {
					list.add(s);
				}else if(tableName.equals("classes_copy1")) {
					if(i==4 || i==5) {
						System.out.println(s.length());
						if(s.length() ==5) {
							s = s + ":00";
						}
						s.replace(":", "-");
						System.out.println(s);
						
						
						list.add(Time.valueOf(s));
						System.out.println(Time.valueOf(s));
					}else {
						list.add(s);
						System.out.println(s);
					}
					
				}else if(tableName.equals("punchcards_copy1")) {
					if(i==4) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						ParsePosition pos = new ParsePosition(0);
						Date strtodate = formatter.parse(s, pos);
						list.add(strtodate);
					}else {
						list.add(s);
					}
				}else if(tableName.equals("repaircards_copy1")) {
					if(i==4) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						ParsePosition pos = new ParsePosition(0);
						Date strtodate = formatter.parse(s, pos);
						list.add(strtodate);
					}else {
						list.add(s);
					}
				}else if(tableName.equals("paysalarys_copy1")) {
					System.out.println("现在");
					if(i==5 || i==6) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						ParsePosition pos = new ParsePosition(0);
						Date strtodate = formatter.parse(s.substring(0,10), pos);
						System.out.println(strtodate);
						if(i==5) {
							salaryStart = strtodate;
							System.out.println(salaryStart);
							
						}
						if(i==6) {
							salaryEnd = strtodate;
							System.out.println(salaryEnd);
						}
						
						list.add(strtodate);
					}else if(i==4) {
						list.add(Integer.valueOf(s));
					}else if(i==7) {
						System.out.println("i值为7");
						int yearStart,yearEnd,monthStart,monthEnd,dayStart,dayEnd;
						yearStart = salaryStart.getYear()+1900;
						yearEnd = salaryEnd.getYear()+1900;
						monthStart = salaryStart.getMonth()+1;
						monthEnd = salaryEnd.getMonth()+1;
						dayStart = salaryStart.getDate();
						dayEnd = salaryEnd.getDate();
						System.out.println("执行5");
						String sStart = "'"+yearStart+"-"+monthStart+"-"+dayStart+"'";
						String sEnd = "'"+yearEnd+"-"+monthEnd+"-"+dayEnd+"'";
						System.out.println("执行6");
						
//						连数据库，获取工时数
						String salarysql = "select sum(hourss) from (\r\n" + 
								"select t1.pInnerId ID, t1.pId 员工编号,t1.pName 姓名,t1.pDateTime 上班时间, t2.pDateTime 下班时间,TIMESTAMPDIFF(HOUR,t1.pDateTime, t2.pDateTime) hourss\r\n" + 
								"from punchcards_copy1 t1, punchcards_copy1 t2\r\n" + 
								"where t1.pId=t2.pId and t1.pDateTime < t2.pDateTime and DATE_FORMAT(t1.pDateTime,'%Y-%m-%d')=DATE_FORMAT(t2.pDateTime,'%Y-%m-%d')\r\n" + 
								"\r\n" + 
								"union\r\n" + 
								"\r\n" + 
								"select t1.rrInnerId ID, t1.rrId 员工编号,t1.rrName 姓名,t1.rrDateTime 上班时间, t2.rrDateTime 下班时间,TIMESTAMPDIFF(HOUR,t1.rrDateTime, t2.rrDateTime) hourss\r\n" + 
								"from repaircards_copy1 t1, repaircards_copy1 t2\r\n" + 
								"where t1.rrId=t2.rrId and t1.rrDateTime < t2.rrDateTime and DATE_FORMAT(t1.rrDateTime,'%Y-%m-%d')=DATE_FORMAT(t2.rrDateTime,'%Y-%m-%d')\r\n" + 
								"\r\n" + 
								"union\r\n" + 
								"\r\n" + 
								"select t1.pInnerId ID, t1.pId 员工编号,t1.pName 姓名,t1.pDateTime 上班时间, t2.rrDateTime 下班时间,TIMESTAMPDIFF(HOUR,t1.pDateTime, t2.rrDateTime) hourss\r\n" + 
								"from punchcards_copy1 t1, repaircards_copy1 t2\r\n" + 
								"where t1.pId=t2.rrId and t1.pDateTime < t2.rrDateTime and DATE_FORMAT(t1.pDateTime,'%Y-%m-%d')=DATE_FORMAT(t2.rrDateTime,'%Y-%m-%d')\r\n" + 
								"\r\n" + 
								"union\r\n" + 
								"\r\n" + 
								"select t2.rrInnerId, t2.rrId 员工编号,t2.rrName 姓名,t2.rrDateTime 上班时间, t1.pDateTime 下班时间,TIMESTAMPDIFF(HOUR,t2.rrDateTime, t1.pDateTime) hourss\r\n" + 
								"from punchcards_copy1 t1, repaircards_copy1 t2\r\n" + 
								"where t1.pId=t2.rrId and t1.pDateTime > t2.rrDateTime and DATE_FORMAT(t1.pDateTime,'%Y-%m-%d')=DATE_FORMAT(t2.rrDateTime,'%Y-%m-%d')\r\n" + 
								"\r\n" + 
								"ORDER BY 上班时间\r\n" + 
								"\r\n" + 
								"\r\n" + 
								") h\r\n" + 
								"where 员工编号="+pId+" and 上班时间>="+sStart+" and 下班时间<="+sEnd+"";
						Connection conn = new ConnectDb().getConnect();
						try {
							System.out.println("执行1");
							Statement stmt = conn.createStatement();
							System.out.println("执行2");
							ResultSet rst = stmt.executeQuery(salarysql);
							System.out.println("执行3");
							if(rst.next()) {
								System.out.println("执行4");
								list.add(rst.getInt(1));
								System.out.println("获取到的工时："+rst.getInt(1));
								
//								更新数据库
								String sql = "update paysalarys_copy1 set pTimeStart="+sStart+",pTimeEnd="+sEnd+", pSalary="+(10*rst.getInt(1))+",pHours="+rst.getInt(1)+" where pId="+pId;
								System.out.println(sql);
								Connection conn_new = new ConnectDb().getConnect();
								Statement stmt_new = conn_new.createStatement();
								stmt_new.executeUpdate(sql);
								conn_new.close();
								System.out.println("更新完");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						
						
					}else {
						if(i==2) {
							pId = "'"+s+"'";
						}
						list.add(s);
					}
				}else if(tableName.equals("leaves_copy1")) {
					if(i==4 || i==5) {
						System.out.println("时间长度为："+s.length());
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						ParsePosition pos = new ParsePosition(0);
						Date strtodate = formatter.parse(s, pos);
						list.add(strtodate);
					}else {
						list.add(s);
					}
				}
				
			}
			i++;
		}
		System.out.println(list);
		ArrayList<Object> list_new = new ArrayList<Object>();
		Object last = null;
		int k2=0;
		for(Object o:list) {
			if(k2==0) {
				last = o;
			}else {
				list_new.add(o);
			}
			k2++;
		}
		list_new.add(last);
		
		try {
			try {
				if(!tableName.equals("paysalarys_copy1")) {
					new Update(presql,list_new).doUpdate();
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
	public String getJson(HttpServletRequest request) {
        StringBuffer json = new StringBuffer();
        String line = "";
        BufferedReader read;
        try {
            read = request.getReader();
            if((line = read.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(deleteInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json.toString();
    }

}
