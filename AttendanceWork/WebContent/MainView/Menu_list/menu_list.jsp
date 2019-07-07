<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%;width:100%">

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script>
        $(document).ready(function() {
            function fixHeight() {
                $("#fragmentdiv").attr("height", $(window).height() - 54 + "px");
            }
            $(window).resize(function() {
                fixHeight();
            }).resize();
        })
    </script>
    
    <script>
$(function(){
	/* 全选和全不选 */
	$("#selectAll").click(function(){
		if($(this).is(':checked')){
			$(":checkbox").prop("checked",true);
		}else{
			$(":checkbox").prop("checked",false);
		}
	});
	
	/* 单选判断是否全选 */
	$("input[name='selectEach']").click(function(){
		var checkedNum = $("input[type='checkbox']:checked").length;
		var totalNum = $("input[type='checkbox']").length;
		if($(this).is(':checked')){
			if(checkedNum == totalNum-1){
				$("#selectAll").prop("checked",true);
			}
		}else{
			$("#selectAll").prop("checked",false);
		}
		
	});
	
});
</script>

    <script type="text/javascript">
        function clickEach(each) {
            var targetId = each.getAttribute('title'); /* 目标页面的名称 */
            var targetdiv = document.getElementById("fragmentdiv"); /* 所要显示的组件 */
            targetdiv.src = targetId + ".jsp";
            var url = "/AttendanceWork/loadPage";
            var fileName = targetId;
            var data = {
                fileName: fileName
            };
            $.ajax({
                type: "post",
                async: true,
                url: url,
                data: data,
                success: function(datas) {
                    var fragmentdiv = document.getElementById("fragmentdiv");
                    fragmentdiv.innerHTML = datas;
                }
            });
        }
    </script>
</head>

<!--图标样式-->
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">

<body style="height: 100%;width:100%;overflow:visible;">
    <div class="s-side">
    	<div style="border:0;text-align: center;">
    		${name}
    		<form style="display: inline-block;margin-left: 15px;" action="/AttendanceWork/loginServlet" method="get">
    			<input  type="submit" value="注销登录">
    			
    		</form>
    	</div>
        <ul>
            <!--导航栏信息。-->
            
            <li class="s-firstItem first">
                <a href="#">
                    <i class="fa fa-home"></i>
                    <span>考勤</span>
                </a>
            </li>
            <li class="first">
                <div class="d-firstNav s-firstNav clearfix">
                    <i class="fa fa-bars"></i>
                    <span>公司架构</span>
                    <i class="fa fa-caret-right fr "></i>
                </div>
                <ul class="d-firstDrop s-firstDrop">
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tEmployees">
                            <i class="fa fa-minus-square-o"></i>
                            <span>员工</span>
                        </div>

                    </li>
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tJobs">
                            <i class="fa fa-minus-square-o"></i>
                            <span>岗位</span>
                        </div>

                    </li>
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tDepartments">
                            <i class="fa fa-minus-square-o"></i>
                            <span>部门</span>
                        </div>
                    </li>
                </ul>
            </li>
            <li class="first">
                <div class="d-firstNav s-firstNav">
                    <i class="fa fa-bars"></i>
                    <span>考勤数据</span>
                    <i class="fa fa-caret-right fr"></i>
                </div>
                <ul class="d-firstDrop s-firstDrop">
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tClasses">
                            <i class="fa fa-minus-square-o"></i>
                            <span>班次</span>
                        </div>

                    </li>
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tPunchcards">
                            <i class="fa fa-minus-square-o"></i>
                            <span>打卡单</span>
                        </div>

                    </li>
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tRepaircards">
                            <i class="fa fa-minus-square-o"></i>
                            <span>补卡单</span>
                        </div>
                    </li>
                </ul>
            </li>
            <li class="first">
                <div class="d-firstNav s-firstNav">
                    <i class="fa fa-bars"></i>
                    <span>考勤报表</span>
                    <i class="fa fa-caret-right fr"></i>
                </div>
                <ul class="d-firstDrop s-firstDrop">
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tcheckreports">
                            <i class="fa fa-minus-square-o"></i>
                            <span>考勤表</span>
                        </div>

                    </li>
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tPaysalarys">
                            <i class="fa fa-minus-square-o"></i>
                            <span>派薪单</span>
                        </div>

                    </li>
                    <li>
                        <div class="d-secondNav s-secondNav" onclick="clickEach(this)" title="tLeaves">
                            <i class="fa fa-minus-square-o"></i>
                            <span>请假单</span>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    
    <iframe id="fragmentdiv" style="height: 100%;width:100%;margin_left:20%;border:0;overflow:hidden;" src="echarts.jsp"></iframe>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</body>

</html>