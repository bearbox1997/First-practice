<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Works.searchInterface,Entities.modleEmployees,java.util.ArrayList,java.util.List,Services.Delete"%>
<!-- 修改0：:类名 -->
<!DOCTYPE html>
<html style="width: 80%;height:100%;margin-left: 17%;margin-right: 2%;">
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="js/jquery.min.js"></script>
    <script src="js/echarts.min.js"></script>
</head>
<body style="height:100%;margin-left: 5%;margin-right: 5%;">
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="echarts_employees" style="width: 45%;height:60%;float:left;margin-top:15%"></div>
    <div id="echarts_checkreports" style="width: 45%;height:60%;float:left;margin-top:15%"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var echarts_employees = echarts.init(document.getElementById('echarts_employees'));
        var echarts_checkreports = echarts.init(document.getElementById('echarts_checkreports'));
        // 指定图表的配置项和数据
        var option_employees = {
            title: {
                text: '员工年龄分布表'
            },
            tooltip: {},
            legend: {
                data:['男','女']
            },
            xAxis: {
            	name: '年龄',
                data: ["18-30","31-40","41-50","51-60"]
            },
            yAxis: {
            	name: '人数'
            },
            series: [{
                name: '男',
                type: 'bar',
                color:['#9BCA63'],
                data: []
            },
            {
                name: '女',
                type: 'bar',
                color:['#FE8463'],
                data: []
            }]
        };
        var option_checkreports = {
                title: {
                    text: '考勤情况表'
                },
                tooltip: {},
                legend: {
                	data:[]
                },
                xAxis: {
                	name: '出勤情况',
                    data: ["正常","迟到","早退"]
                },
                yAxis: {
                	name: '人数'
                },
                width:360,
                series: [{
                    name: '员工',
                    type: 'bar',
                    barWidth : 45,
                    itemStyle: {
                        normal: {
                            color: function(params) {
                                var colorList = [
                                  '#F4E001','#F0805A','#26C0C0'
                                ];
                                return colorList[params.dataIndex]
                            },
                            label: {
                                show: true,
                                position: 'top',
                                formatter: '{b}\n{c}'
                            }
                        }
                    },
                    data: []
                }]
            };

        // 使用刚指定的配置项和数据显示图表。
        echarts_employees.setOption(option_employees);
        echarts_checkreports.setOption(option_checkreports);
        
        show_employees();
        show_checkreports();
        /* 员工表 */
       	function show_employees(){
       		var EchartsName = "employees_copy01";
       		var url = "/AttendanceWork/getEchartsData"
       		var json = {EchartsName:EchartsName};
       		var str = JSON.stringify(json);
       		$.ajax({
       	        type:"post",
       	        async:true,
       	        url:url,
       	        data:str,
       	     	dataType:"json",
       	        success:function(result){
       	        	var nums_man = [];
       	        	var nums_woman = [];
       	        	var data = result.json;
       	        	for(var i=0;i<4;i++){
       	        		nums_man.push(data[i]);
       	        		nums_woman.push(data[i+4]);
       	        	}
       	        	echarts_employees.setOption({
	       	        	series: [{
	       	                 name: '男',
	       	                 data: nums_man
	       	             },
	       	             {
	       	                 name: '女',
	       	                 data: nums_woman
	       	             }]
       	        	})
       	        }
       	    });
       	}
       	
       	/* 考勤表 */
       	function show_checkreports(){
       		var EchartsName = "checkreports_copy01";
       		var url = "/AttendanceWork/getEchartsData"
       		var json = {EchartsName:EchartsName};
       		var str = JSON.stringify(json);
       		$.ajax({
       	        type:"post",
       	        async:true,
       	        url:url,
       	        data:str,
       	     	dataType:"json",
       	        success:function(result){
       	        	var nums = [];
       	        	var data = result.json;
       	        	for(var i=0;i<3;i++){
       	        		nums.push(data[i]);
       	        	}
       	        	echarts_checkreports.setOption({
	       	        	series: [{
	       	                 name: '员工',
	       	                 data: nums
	       	             }]
       	        	})
       	        }
       	    });
       	}
        
    </script>
</body>
</html>