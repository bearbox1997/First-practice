package Works;
/*
 * 表格渲染接口
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.modleCheckReports;
import Entities.modleClasses;
import Entities.modleDepartments;
import Entities.modleEmployees;
import Entities.modleJobs;
import Entities.modleLeaves;
import Entities.modlePaysalarys;
import Entities.modlePunchcards;
import Entities.modleRepaircards;
import net.sf.json.JSONObject;
public class showData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public showData() {
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
		Map map = (Map)jasonObject;
		String tableName = null;
		String condition = null;
		String con_value = null;
		int year=new Date().getYear()+1900;
		int month = new Date().getMonth()+1;
		String timeStart = null;
		String timeEnd = null;
		int k = 0;
		String showStr = "";
		//遍历map中的值 
		for (Object value : map.values()) { 
			if(k==0) {
				tableName = String.valueOf(value);
				System.out.println("提取的tableName为："+tableName);
			}else if(k==1) {
				condition = String.valueOf(value);
				System.out.println("提取的condition为："+condition);
			}else if(k==2) {
				con_value = String.valueOf(value);
			}else if(k==3) {
				timeStart = String.valueOf(value);
			}else if(k==4) {
				timeEnd = String.valueOf(value);
			}
			k++;
		}
		
//		区分表格
		
		
		List<Object> datas = null;
		try {
			if(con_value == null) {
				System.out.println("没有lastIdName，执行全查询");
				if(tableName.equals("checkreports_copy1")) {
					datas = new searchInterface(tableName,year,month).getAll();
				}else {
					datas = new searchInterface(tableName).getAll();
				}
				
			}else {
				if(tableName.equals("checkreports_copy1")) {
					if(timeStart != null) {
						System.out.println("按日期范围查询");
						datas = new searchInterface(tableName,condition,con_value,timeStart,timeEnd).getAll();
					}
					
				}else {
					datas = new searchInterface(tableName,condition,con_value).getAll();
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    	if(tableName.equals("employees_copy1")) {
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>员工编码</th><th>姓名</th><th>年龄</th><th hidden>身份证</th><th hidden>薪水</th><th hidden>联系电话</th><th hidden>紧急联系人</th><th hidden>紧急联系人电话</th><th hidden>个人描述</th><th>性别</th><th>民族</th><th>岗位</th>";
    		showStr += "<th>操作</th></tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
        		modleEmployees data = (modleEmployees)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.geteId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.geteEmpId()+"</td>";
        		showStr += "<td>"+data.geteId()+"</td>";
        		showStr += "<td>"+data.geteName()+"</td>";
        		showStr += "<td>"+data.geteAge()+"</td>";
        		showStr += "<td hidden>"+data.geteIdNum()+"</td>";
        		showStr += "<td hidden>"+data.geteSalary()+"</td>";
        		showStr += "<td hidden>"+data.getePhoneNum()+"</td>";
        		showStr += "<td hidden>"+data.geteEmerContact()+"</td>";
        		showStr += "<td hidden>"+data.geteEmerContactPhoneNum()+"</td>";
        		showStr += "<td hidden>"+data.getePersDesc()+"</td>";
        		showStr += "<td>"+data.geteSex()+"</td>";
        		showStr += "<td>"+data.geteNation()+"</td>";
        		showStr += "<td>"+data.geteDeptId()+"</td>";	
        		showStr += "<td><a href=\"#\" class=\"edit\">编辑</a>";
        		showStr += "<button name=\"deleteEach\" value='"+data.geteId() +"' onclick=\"send(this)\">删除</button>";
        		showStr += "</td></tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("departments_copy1")) {
    		System.out.println("正在生成departments_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>部门编码</th><th>部门名称</th><th>部门职责</th><th>上级部门</th><th>备注</th><th>部门负责人</th>";
    		showStr += "<th>操作</th></tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modleDepartments data = (modleDepartments)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getdInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getdInnerId()+"</td>";
        		showStr += "<td>"+data.getdId()+"</td>";
        		showStr += "<td>"+data.getdName()+"</td>";
        		showStr += "<td>"+data.getdDuty()+"</td>";
        		showStr += "<td>"+data.getdSuper()+"</td>";
        		showStr += "<td>"+data.getdDesc()+"</td>";
        		showStr += "<td>"+data.getdLeader()+"</td>";
        		showStr += "<td><a href=\"#\" class=\"edit\">编辑</a>";
        		showStr += "<button name=\"deleteEach\" value='"+data.getdInnerId() +"' onclick=\"send(this)\">删除</button>";
        		showStr += "</td></tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("jobs_copy1")) {
    		System.out.println("正在生成jobs_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>岗位编码</th><th>岗位名称</th><th>岗位职责</th><th>所在部门</th><th>直接上级</th><th>岗位类别</th>";
    		showStr += "<th>操作</th></tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modleJobs data = (modleJobs)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getjInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getjInnerId()+"</td>";
        		showStr += "<td>"+data.getjId()+"</td>";
        		showStr += "<td>"+data.getjName()+"</td>";
        		showStr += "<td>"+data.getjDesc()+"</td>";
        		showStr += "<td>"+data.getjParent()+"</td>";
        		showStr += "<td>"+data.getjSuper()+"</td>";
        		showStr += "<td>"+data.getjType()+"</td>";
        		showStr += "<td><a href=\"#\" class=\"edit\">编辑</a>";
        		showStr += "<button name=\"deleteEach\" value='"+data.getjInnerId() +"' onclick=\"send(this)\">删除</button>";
        		showStr += "</td></tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("classes_copy1")) {
    		System.out.println("正在生成classes_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>班次编码</th><th>班次名称</th><th>早上上班时间</th><th>下午下班时间</th>";
    		showStr += "<th>操作</th></tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modleClasses data = (modleClasses)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getcInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getcInnerId()+"</td>";
        		showStr += "<td>"+data.getcId()+"</td>";
        		showStr += "<td>"+data.getcName()+"</td>";
        		showStr += "<td>"+String.valueOf(data.getcTimeStart()).substring(0,5)+"</td>";
        		showStr += "<td>"+String.valueOf(data.getcTimeEnd()).substring(0,5)+"</td>";
        		showStr += "<td><a href=\"#\" class=\"edit\">编辑</a>";
        		showStr += "<button name=\"deleteEach\" value='"+data.getcInnerId() +"' onclick=\"send(this)\">删除</button>";
        		showStr += "</td></tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("punchcards_copy1")) {
    		System.out.println("正在生成punchcards_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>打卡人编号</th><th>打卡人姓名</th><th>打卡时间</th>";
    		showStr += "<th>操作</th></tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modlePunchcards data = (modlePunchcards)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getpInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getpInnerId()+"</td>";
        		showStr += "<td>"+data.getpId()+"</td>";
        		showStr += "<td>"+data.getpName()+"</td>";
        		showStr += "<td>"+data.getpDateTime().toString().substring(0,16)+"</td>";
        		showStr += "<td><a href=\"#\" class=\"edit\">编辑</a>";
        		showStr += "<button name=\"deleteEach\" value='"+data.getpInnerId() +"' onclick=\"send(this)\">删除</button>";
        		showStr += "</td></tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("repaircards_copy1")) {
    		System.out.println("正在生成repaircards_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>补卡人编号</th><th>补卡人姓名</th><th>补卡时间</th><th hidden>补卡原因</th>";
    		showStr += "<th>操作</th></tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modleRepaircards data = (modleRepaircards)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getRrInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getRrInnerId()+"</td>";
        		showStr += "<td>"+data.getRrId()+"</td>";
        		showStr += "<td>"+data.getRrName()+"</td>";
        		showStr += "<td>"+data.getRrDateTime().toString().substring(0,16)+"</td>";
        		showStr += "<td hidden>"+data.getRrDesc()+"</td>";
        		showStr += "<td><a href=\"#\" class=\"edit\">编辑</a>";
        		showStr += "<button name=\"deleteEach\" value='"+data.getRrInnerId() +"' onclick=\"send(this)\">删除</button>";
        		showStr += "</td></tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("checkreports_copy1")) {
    		System.out.println("正在生成checkreports_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>员工编号</th><th>员工姓名</th><th>早上上班时间</th><th>下午下班时间</th><th>出勤情况</th>";
    		showStr += "</tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modleCheckReports data = (modleCheckReports)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getChInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getChInnerId()+"</td>";
        		showStr += "<td>"+data.getChId()+"</td>";
        		showStr += "<td>"+data.getChName()+"</td>";
        		showStr += "<td>"+data.getChTimeStart().toString().substring(0,16)+"</td>";
        		showStr += "<td>"+data.getChTimeEnd().toString().substring(0,16)+"</td>";
        		showStr += "<td>"+data.getChMark()+"</td>";
        		showStr += "</tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("paysalarys_copy1")) {
    		System.out.println("正在生成paysalarys_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>领薪人编号</th><th>领薪人姓名</th><th>薪水</th><th>开始计算日期</th><th>结束计算日期</th><th>工时</th>";
    		showStr += "<th>操作</th></tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modlePaysalarys data = (modlePaysalarys)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getpInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getpInnerId()+"</td>";
        		showStr += "<td>"+data.getpId()+"</td>";
        		showStr += "<td>"+data.getpName()+"</td>";
        		showStr += "<td>"+data.getpSalary()+"</td>";
        		showStr += "<td>"+data.getpTimeStart().toString().substring(0,10)+"</td>";
        		showStr += "<td>"+data.getpTimeEnd().toString().substring(0,10)+"</td>";
        		showStr += "<td>"+data.getpHours()+"</td>";
        		showStr += "<td><a href=\"#\" class=\"edit\">编辑</a>";
        		showStr += "<button name=\"deleteEach\" value='"+data.getpInnerId() +"' onclick=\"send(this)\">删除</button>";
        		showStr += "<td></tr>";
        	}
    		showStr += "</tbody></table>";
    	}else if(tableName.equals("leaves_copy1")) {
    		System.out.println("正在生成leaves_copy1表格");
    		showStr += "<table id=\"tb\" class=\"table\"><thead><tr>";
    		showStr += "<th><input name=\"selectAll\" type=\"checkbox\" id=\"selectAll\" style=\"width:15px;height1:15px;\" /></th>";
    		showStr += "<th>Id</th><th>员工编号</th><th>员工姓名</th><th>请假开始时间</th><th>请假结束时间</th><th>请假原因</th>";
    		showStr += "</tr></thead><tbody id=\"show_tbody\" >";
    		for(Object o:datas){
    			modleLeaves data = (modleLeaves)o;
        		showStr += "<tr><td><input name=\"selectEach\" type=\"checkbox\" id=\"selectEach\" value='"+data.getqInnerId()+"' style=\"width:15px;height1:15px;\"/></td>";
        		showStr += "<td>"+data.getqInnerId()+"</td>";
        		showStr += "<td>"+data.getqId()+"</td>";
        		showStr += "<td>"+data.getqName()+"</td>";
        		showStr += "<td>"+data.getqTimeStart().toString().substring(0,16)+"</td>";
        		showStr += "<td>"+data.getqTimeEnd().toString().substring(0,16)+"</td>";
        		showStr += "<td>"+data.getqDesc()+"</td>";
        		showStr += "</tr>";
        	}
    		showStr += "</tbody></table>";
    	}
		
		
		response.setContentType("text/html;charset=utf-8");
//		回传数据
		PrintWriter writer= response.getWriter();
		writer.print(showStr);
		
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
