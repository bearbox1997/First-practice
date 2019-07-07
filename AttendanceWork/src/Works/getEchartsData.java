package Works;
/*
 * Echarts图表的Servlet
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.ConnectDb;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//@WebServlet("/getEchartsData")
public class getEchartsData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getEchartsData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("在哪里");
		String teststr = getJson(request);
		System.out.println(teststr);
		String tableName = null;
		tableName = teststr.split(":")[1];
		tableName = tableName.replace("\"", "");
		tableName = tableName.replace("}", "");
		System.out.println("收到的查询表名：" + tableName);
		
		int size = 0; 
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<String> s = new ArrayList<String>();
		if(tableName.equals("employees_copy01")) {
			size = 8;
			String sql_m1,sql_m2,sql_m3,sql_m4,sql_w1,sql_w2,sql_w3,sql_w4;
			sql_m1 = "select count(*) from employees_copy1 where eSex='男' and eAge>=18 and eAge <=30";
			sql_m2 = "select count(*) from employees_copy1 where eSex='男' and eAge>=31 and eAge <=40";
			sql_m3 = "select count(*) from employees_copy1 where eSex='男' and eAge>=41 and eAge <=50";
			sql_m4 = "select count(*) from employees_copy1 where eSex='男' and eAge>=51 and eAge <=60";
			sql_w1 = "select count(*) from employees_copy1 where eSex='女' and eAge>=18 and eAge <=30";
			sql_w2 = "select count(*) from employees_copy1 where eSex='女' and eAge>=31 and eAge <=40";
			sql_w3 = "select count(*) from employees_copy1 where eSex='女' and eAge>=41 and eAge <=50";
			sql_w4 = "select count(*) from employees_copy1 where eSex='女' and eAge>=51 and eAge <=60";
			s.add(sql_m1);
			s.add(sql_m2);
			s.add(sql_m3);
			s.add(sql_m4);
			s.add(sql_w1);
			s.add(sql_w2);
			s.add(sql_w3);
			s.add(sql_w4);
		}else if(tableName.equals("checkreports_copy01")) {
			size = 3;
//			获取当前日期
			String year = new DecimalFormat("0000").format(new Date().getYear()+1900);
			String month = new DecimalFormat("00").format(new Date().getMonth()+1);
			String day = new DecimalFormat("00").format(new Date().getDate());
			String date = year+"-"+month+"-"+day;
			System.out.println(date);
			
			String sql_1,sql_2,sql_3;
			sql_1 = "select count(*) from (\r\n" + 
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
					") h\r\n" + 
					"where DATE_FORMAT(上班时间,'%Y-%m-%d')='"+date+"' and 上班时间<='"+date+" 09:00' and 下班时间>='"+date+" 18:00' ";
			
			sql_2 = "select count(*) from (\r\n" + 
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
					") h\r\n" + 
					"where DATE_FORMAT(上班时间,'%Y-%m-%d')='"+date+"' and 上班时间>'"+date+" 09:00'";
			
			sql_3 = "select count(*) from (\r\n" + 
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
					") h\r\n" + 
					"where DATE_FORMAT(上班时间,'%Y-%m-%d')='"+date+"' and 下班时间<'"+date+" 18:00' ";
			s.add(sql_1);
			s.add(sql_2);
			s.add(sql_3);
		}
		
		Connection conn = new ConnectDb().getConnect();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			for(int i=0;i<size;i++) {
				ResultSet res = stmt.executeQuery(s.get(i));
				res.next();
				nums.add(res.getInt(1));
			}
			System.out.println("查询的数据："+nums);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		
		JSONArray json = JSONArray.fromObject(nums);
		System.out.println(json.toString());
		JSONObject jso = new JSONObject();
		jso.put("json", json);
		
		PrintWriter out = response.getWriter();
		out.println(jso.toString());
	
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
