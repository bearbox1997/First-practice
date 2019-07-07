<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Works.searchInterface,Entities.modleCheckReports,java.util.ArrayList,java.util.List,Services.Delete,java.util.*"%>
<!DOCTYPE html>
<html ng-app="app">

<head>
    <meta charset="utf-8" />
    <title>考勤表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pagediver.css" />
    <!-- 日期选择样式 -->
    <link rel="stylesheet" href="css/datepicker.css">

    <!-- 编辑功能 -->
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script> <!-- 编辑功能 -->
    <script src="js/bootbox.min.js"></script> <!-- 空值提示 -->
    <script src="js/checkboxs.js"></script>
    <!-- 日期选择框的依赖 -->
    <script src="js/plugins/moment.min.js"></script>
    <script src="js/datepicker.all.js"></script>
    <script src="js/datetimepicker.js"></script>

</head>

<body background="bg.jpg" style="margin-left: 17%;margin-right: 2%;">
    <div class="box">
        <button value="checkreports_copy1" class="tableName" hidden>表名</button> <!-- 修改1：employees_copy1 -->
        <button value="chInnerId" class="idName" hidden>表名</button> <!-- 修改2：eId -->
        <button value="chInnerId" class="lastIdName" hidden>表名</button> <!-- 添加信息的自增Id -->
        <button value="5" class="columnNum" hidden>表名</button> <!-- 修改2：13 -->
        <div class="title">考勤表</div>
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
                    <div class="c-datepicker-date-editor  J-datepicker-range-day" style="margin-top:15px;">
                        <input id="timeStart" placeholder="开始日期" name="" class="c-datepicker-data-input only-date" style="text-align:center;" value="">
                        <span class="">-</span>
                        <input id="timeEnd" placeholder="结束日期" name="" class="c-datepicker-data-input only-date" style="text-align:center" value="">
                    </div>
                    <div class="search_input">
                        <button class="btn btn-primary search_btn" type="button" id="search_btn">查询</button>
                        <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                    </div>
                </div>
            </div>
            <div class="line"></div>
            <!--表格列表-->
            <div id="tableInfo"></div>
            <div id="wrap" class="page_btn clear"></div>
        </div>
    </div>

    <script src="js/mejs.js"></script>
</body>

</html>