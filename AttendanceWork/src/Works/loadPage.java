package Works;
/*
 * 初始化页面的Servlet
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/loadPage")
public class loadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public loadPage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileurlJson = getJson(request);
		fileurlJson = fileurlJson.split("=")[1];
		System.out.println(fileurlJson);
		String testname = "C:\\Users\\bearbox\\eclipse-workspace\\AttendanceWork\\WebContent\\MainView\\Menu_list\\"+fileurlJson+".jsp";
		FileReader reader = new FileReader(testname);
		PrintWriter writer=    response.getWriter();
		BufferedReader br = new BufferedReader(reader);
		String line;
		while((line=br.readLine())!=null) {
			writer.println(line);
		}
		reader.close();
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
