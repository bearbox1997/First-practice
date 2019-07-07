package Tools;
/*
 * 登录的Servlet
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import net.sf.json.JSONObject;
import Tools.checkUser;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public loginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取用户名和密码
		String Id = request.getParameter("username");
		String pwd = request.getParameter("password");
		// 校验用户名和密码是否正确
		checkUser checkuser= new checkUser(Id, pwd);
		boolean isUser = false;
		try {
			isUser = checkuser.isUser();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isUser) {// 验证成功
			String name = checkuser.username;
			HttpSession session = request.getSession();//获取session
			session.setAttribute("name", name);// 将用户名和密码保存在session中
			session.setAttribute("pwd", pwd);// 将用户名和密码保存在session中
			response.sendRedirect("MainView/Menu_list/menu_list.jsp");// 跳转到menu_list.jsp页面
			System.out.println("已跳转");
		} else {// 校验不成功，则留在跳转到login.jsp页面
			response.sendRedirect("Login/login.jsp");
		}  
	}

}
