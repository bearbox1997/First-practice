package Works;
/*
 * 删除的Servlet
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Delete;
import net.sf.json.JSONObject;

//@WebServlet("/deleteEmployees")
public class deleteInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteInterface() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = getJson(request);
		str = str.replace("\"", "");
		str = str.replace("{", "");
		str = str.replace("}", "");
		String [] arr = str.split(",");
		for(String s:arr) {
			System.out.println(s);
		}
		String presql = arr[0].split(":")[1];
		String tableName = arr[2].split(":")[1];
		ArrayList<String> id = new ArrayList<String>();
		id.add(arr[1].split(":")[1]);
		try {
			new Delete(presql, id,tableName).doDelete();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			输出数据
			PrintWriter writer= response.getWriter();
			String status = "OK";
			writer.print(status);
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
