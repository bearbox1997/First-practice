package Works;
/*
 * 插入数据的Servlet
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Insert;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//@WebServlet("/insertEmployees")
public class insertInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public insertInterface() {
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
		String presql_login = "insert into login (Id,UserName,PassWord) values(?,'Admin','1')";
		String predatas = null;
		String tableName = null;
		int k = 0;
		//遍历map中的值 
		for (Object value : map.values()) { 
			System.out.println("输出value");
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
		ArrayList<Object> list_login = new ArrayList<Object>();
		int i = 0;
		for(String s:datas) {
			if(i==0) {
				
			}else {
				if(tableName.equals("employees_copy1")) {
					if(i==2) {
						list_login.add(s);
					}
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
					System.out.println("正在修改01");
					if(i==4 || i==5) {
						System.out.println("正在修改02");
						if(s.length() ==5) {
							System.out.println("正在修改03");
							s = s + ":00";
						}
						System.out.println(s);
						list.add(Time.valueOf(s));
					}else {
						list.add(s);
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
				}else if(tableName.equals("leaves_copy1")) {
					if(i==4 || i==5) {
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
		try {
			new Insert(presql, list).doInsert();
			if(tableName.equals("employees_copy1")) {
				new Insert(presql_login, list_login).doInsert();
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
