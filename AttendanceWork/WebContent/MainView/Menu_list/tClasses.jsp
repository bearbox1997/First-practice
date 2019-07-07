<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Works.searchInterface,Entities.modleClasses,java.util.ArrayList,java.util.List,Services.Delete"%>
<!-- 修改0：:类名 -->
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>班次表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pagediver.css" />
    <!-- 编辑功能 -->
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script> <!-- 编辑功能 -->
    <script src="js/bootbox.min.js"></script> <!-- 空值提示 -->
    <script src="js/checkboxs.js"></script>
    <!-- 时分下拉选择 -->
    <link rel="stylesheet" type="text/css" href="css/timedropper.min.css">
	<script src="js/timedropper.min.js"></script>
</head>

<body style="margin-left: 17%;margin-right: 2%;">
    <div class="box">
        <button value="classes_copy1" class="tableName" hidden>表名</button> <!-- 修改1：employees_copy1 -->
        <button value="cInnerId" class="idName" hidden>表名</button> <!-- 修改2：eId -->
        <button value="cInnerId" class="lastIdName" hidden>表名</button> <!-- 添加信息的自增Id -->
        <button value="5" class="columnNum" hidden>表名</button> <!-- 修改2：13 -->
        <div class="title">班次表</div>
        <div class="content">
            <!--搜索输入框及查询、重置按钮-->
            <div class="container content_width">
                <div class="person_search">
                    <div class="search_input">
                        <div class="input-group mb-3">
                            <span>ID：</span>
                            <input id="Ktext" type="text" class="form-control" placeholder="请输入ID">
                        </div>
                    </div>
                    <div class="search_input">
                        <div class="input-group mb-3" hidden>
                            <span>员工编号：</span>
                            <input id="job_num" type="text" class="form-control" placeholder="请输入员工编号">
                        </div>
                    </div>
                    <div class="search_input">
                        <button class="btn btn-primary search_btn" type="button" id="search_btn">查询</button>
                        <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                        <button class="btn btn-primary search_btn" type="button" style="background:#EEB422;" onclick="deleteMore()">批量删除</button>
                    </div>
                </div>
                <div class="line"></div>
            </div>
            <!--添加按钮及bootstrap的模态框-->
            <div class="export">
                <button id="new_add" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#renyuan" onclick="addBox()">
                    <img src="img/add_two.png" />
                    <span>添加</span>
                </button>
                <div class="modal fade" id="renyuan">
                    <div class="modal-dialog modal-lg modal_position">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">添加</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <table id="xztb" class="table">
                                    <!--新修改弹窗的样式-->
                                    <tbody>
                                        <!------------------------------------             修改3：开始             --------------------------------->
                                        <tr hidden>
                                            <td><input type="checkbox" style="width:15px;height1:15px;" /></td>
                                        </tr>
                                        <tr>
                                            <td class="tb_bg"><label for="">
                                                    <font style="font-size: 14px; color: red;">*</font>ID
                                                </label>
                                            </td>
                                            <td><input class="cInnerId  notEdit increaseId" id="increaseId" type="number" placeholder="请输入ID" maxlength="6" /></td>
                                            <td class="tb_bg"><label for="">
                                                    <font style="font-size: 14px; color: red;">*</font>班次编号
                                                </label>
                                            </td>
                                            <td><input class="cId notEdit changeEdit" type="text" placeholder="请输入班次编号" maxlength="6" /></td>
                                        </tr>
                                        <tr>
                                            <td class="tb_bg"><label for="">
                                                    <font style="font-size: 14px; color: red;">*</font>班次名称
                                                </label>
                                            </td>
                                            <td><input class="cName" type="text" placeholder="请输入班次名称" maxlength="6" /></td>
                                        </tr>
                                        <tr>
                                            <td class="tb_bg"><label for="">
                                                    <font style="font-size: 14px; color: red;">*</font>上班时间
                                                </label>
                                            </td>
                                            <td><input class="cTimeStart picktime" type="text" placeholder="请输入上班时间" /></td>
                                            <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>下班时间</label>
                                            </td>
                                            <td><input class="cTimeEnd picktime" type="text" placeholder="请输入下班时间" /></td>
                                        </tr>
                                        <!------------------------------------             修改3：结束             --------------------------------->
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                <button id="add_btn" type="button" class="btn btn-secondary">确定</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--表格列表-->
            <div id="tableInfo"></div>
            <div id="wrap" class="page_btn clear"></div>
        </div>
    </div>
    <script src="js/mejs.js"></script>
    <script>
		$(".picktime").timeDropper({
			meridians: false,
			format: 'HH:mm',
		});
</script>
</body>

</html>