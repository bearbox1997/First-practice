package Works;
/*
 * 过去最大Id值的的Servlet
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.ConnectDb;
import net.sf.json.JSONObject;

//@WebServlet("/getLastId")
public class getLastId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public getLastId() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		接收数据
		String teststr = getJson(request);
		System.out.println(teststr);
		String sql = null;
		sql = teststr.split(":")[1];
		sql = sql.replace("\"", "");
		sql = sql.replace("}", "");
		System.out.println("收到的查询最大Id的sql语句：" + sql);
		
//		连接数据库查询
		Connection conn = new ConnectDb().getConnect();
		
		Statement stmt;
		String Id = null;
		try {
			stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			res.next();
			Id = res.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		输出数据
		PrintWriter writer= response.getWriter();
		 Id = String.format("%06d", Integer.parseInt(Id)+1);
		writer.print(Id);
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
