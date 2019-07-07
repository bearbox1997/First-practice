$(document).ready(function(){
	initTable();
})



function addBox(){
//	查询最大Id
	var tableName = $('.tableName').val();
	var lastIdName = $('.lastIdName').val();
	var sql = "select max(" + lastIdName + ") from " + tableName;
	var url = "/AttendanceWork/getLastId"
	var json = {sql:sql};
	var str = JSON.stringify(json);
	$.ajax({
        type:"post",
        async:true,
        url:url,
        data:str,
        success:function(datas){
        	alert(datas);
        	var increaseId_value = $(".increaseId").val();
        	if(increaseId_value==null){
    	        $(".increaseId").attr("value",datas);
        	}else{
        		$(".increaseId").val(datas);
        	}
        }
       
    });
	
    $('.notEdit').attr("disabled","disabled");
	$('.changeEdit').removeAttr("disabled");
	
}


var xmlHttp = new XMLHttpRequest();
/* 单个删除 */
function send(id) {
	var tableName = $('.tableName').val();
	var idName = $('.idName').val();
	var presql="delete from " +tableName + " where "+ idName +"=?"; 
    var json = {presql:presql,eId:id.value,tableName:tableName};
    var str = JSON.stringify(json);
    var url = "/AttendanceWork/deleteInterface";
    
    $.ajax({
        type:"post",
        async:true,
        url:url,
        data:str,
        success:function(datas){
        	initTable();
        }
       
    });
    
    
}
/* 批量删除 */
function deleteMore(){
	var tableName = $('.tableName').val();
	var idName = $('.idName').val();
	var ids = [];
	var boxs = document.getElementsByTagName("input");
	var index = 0;
	for(var i=0;i<boxs.length;i++){
		var each = boxs[i];
		var name = each.getAttribute('name');
		var isChecked = each.checked;
		if(name=="selectEach" && isChecked==true){
			ids[index]=each.value;
			index++;
			var presql="delete from " +tableName + " where "+ idName +"=?"; 
		    var json = {presql:presql,ids:each.value,tableName:tableName}; 
		    var str = JSON.stringify(json);
		    var url = "/AttendanceWork/deleteInterface";
		    
		    $.ajax({
		        type:"post",
		        async:true,
		        url:url,
		        data:str,
		        success:function(datas){
		        	initTable();
		        }
		       
		    });
		    
		}
	}
	initTable();
} 


function initTable(){
	var tableDiv = $('#tableInfo');
	var tableName = $('.tableName').val();
	var condition = "*"
	var json = {tableName:tableName,condition:condition};
	var url = "/AttendanceWork/showData"
	var str = JSON.stringify(json);
	$.ajax({
        type:"post",
        async:true,
        url:url,
        data:str,
        success:function(datas){
        	var tableInfos = document.getElementById('tableInfo');
            var code = "";
            code += datas;
            tableInfos.innerHTML = code;
            var pagi = new Pagination($('#show_tbody'), $('#wrap'));
        }
       
    });
}

$(function () {

    $('#add_btn').click(function () {
        methods.addHandle()
    })
    var dataDiv = document.getElementById("tableInfo");
    dataDiv.addEventListener("click",function(event){
    	var target = event.target;
    	 if(target.nodeName == "A"){
    		 alert("编辑");
    	 $('.notEdit').attr("disabled","disabled");
         trIndex = $('.edit', '#show_tbody').index($(target));
         addEnter = false;
         $(target).parents('tr').addClass('has_case');
         methods.editHandle(trIndex);
    	 }
    })
    $('#show_tbody').on('click','.edit', function () {
    	$('.notEdit').attr("disabled","disabled");
        trIndex = $('.edit', '#show_tbody').index($(this));
        addEnter = false;
        $(this).parents('tr').addClass('has_case');
        methods.editHandle(trIndex);
    })

   $('#search_btn').click(function () {
	   var nameVal = $('#Ktext').val().trim();
	   if (nameVal==='') {
	       bootbox.alert({
	           title: "来自火星的提示",
	           message: "搜索内容不能为空",
	           closeButton:false
	       })
	       return;
	   }
	   
	var tableDiv = $('#tableInfo');
   	var tableName = $('.tableName').val();
   	var con_value = nameVal;
   	var condition = $('.lastIdName').val();
   	var timeStart = $('#timeStart').val();
   	var timeEnd = $('#timeEnd').val();
   	var json = {tableName:tableName,condition:condition,con_value:con_value,timeStart:timeStart,timeEnd:timeEnd};
   	var url = "/AttendanceWork/showData"
   	var str = JSON.stringify(json);
   	$.ajax({
           type:"post",
           async:true,
           url:url,
           data:str,
           success:function(datas){
           	var tableInfos = document.getElementById('tableInfo');
               var code = "";
               code += datas;
               tableInfos.innerHTML = code;
               var pagi = new Pagination($('#show_tbody'), $('#wrap'));
           }
          
       });
	   
	   
	   
    })

    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        /*methods.resectList();*/
    	initTable();
    })

    $('.del').click(function () {
        $(this).parents('tr').remove();
    })

    $('#renyuan').on('hide.bs.modal',function() {
        addEnter = true;
        $('#show_tbody tr').removeClass('has_case');
        $('#xztb input').val(' ');
        $('#xztb select').find('option:first').prop('selected', true)
    });

})

var addEnter = true,
    noRepeat = true,
    jobArr = [],
    phoneArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input'),
    tarSel = $('#xztb select');

var methods = {
		addHandle: function (the_index) {
	        hasNullMes = false;
	        methods.checkMustMes();
	        if (hasNullMes) {
	            return;
	        }
	        if (addEnter) {  //  添加记录
	            methods.checkRepeat();
	            if (noRepeat) {
	                methods.addStr();
	                $('#show_tbody').append('<tr>' + tdStr + '</tr>');
	                $('#renyuan').modal('hide');
	            }
	        }else{
	            methods.updateStr();
	            $('#show_tbody tr').eq(trIndex).empty().append(tdStr);
	            $('#renyuan').modal('hide');
	        }
	    },
		
    editHandle: function (the_index) {

        var tar = $('#show_tbody tr').eq(the_index);
        var nowConArr = [];
        for (var i=0; i<tar.find('td').length-1;i++) {
            var a = tar.children('td').eq(i).html();
            nowConArr.push(a);
        }

        $('#renyuan').modal('show');
    	

        for (var j=0;j<tarInp.length;j++) {
            tarInp.eq(j).val(nowConArr[j])
        }
        for (var p=0;p<tarSel.length;p++) {
            var the_p = p+tarInp.length;
            tarSel.eq(p).val(nowConArr[the_p]);
        }

    },
    addStr: function () {
    	var tableName = $('.tableName').val();
		var idName = $('.idName').val();
		var columnNum = $('.columnNum').val();
//    	保存为json数据
    	var dataJson = [];
    	var index = 0;
        tdStr = '';
        for (var a=0; a<tarInp.length; a++) {
            tdStr+= '<td>' + tarInp.eq(a).val() + '</td>';
        	dataJson[index] = tarInp.eq(a).val();
            index++;
        }
        for (var b=0; b<tarSel.length; b++) {
            tdStr+= '<td>' + tarSel.eq(b).val() + '</td>'
            dataJson[index] = tarSel.eq(b).val();
            index++;
        }
        tdStr+= '<td><a href="#" class="edit">编辑</a><a href="#" class="del"><button name="deleteEach" value="<%=data.geteId() %>" onclick="send(this)">删除</button></a></td>';
//        传Json数据
        var presql = "insert into " + tableName + " values(";
        for(var i=1;i<columnNum;i++){
        	presql = presql + "?,";
        }
        presql = presql + "?)";
	    var json = {presql:presql,datas:dataJson,tableName:tableName};
	    var str = JSON.stringify(json);
	    var url = "/AttendanceWork/insertInterface";
	    xmlHttp.open("post", url, true);
	    xmlHttp.send(str);
	    window.location.reload();
    },
    
    updateStr: function () {
    	var tableName = $('.tableName').val();
		var idName = $('.idName').val();
		var columnNum = $('.columnNum').val();
//    	保存为json数据
    	var dataJson = [];
    	var index = 0;
        tdStr = '';
        for (var a=0; a<tarInp.length; a++) {
            tdStr+= '<td>' + tarInp.eq(a).val() + '</td>'
            dataJson[index] = tarInp.eq(a).val();
            index++;
        }
        for (var b=0; b<tarSel.length; b++) {
            tdStr+= '<td>' + tarSel.eq(b).val() + '</td>'
            dataJson[index] = tarSel.eq(b).val();
            index++;
        }
        tdStr+= '<td><a href="#" class="edit">编辑</a><a href="#" class="del"><button name="deleteEach" value="<%=data.geteId() %>" onclick="send(this)">删除</button></a></td>';
//        传Json数据
        var presql;
//                                                         修改presql：直接增加 if 条件
        if(tableName == "employees_copy1"){
        	presql = "update employees_copy1 set eId=?,eName=?,eAge=?,eIdNum=?,eSalary=?,ePhoneNum=?,eEmerContact=?,eEmerContactPhoneNum=?,ePersDesc=?,eSex=?,eNation=?,eDeptId=? where eEmpId=?";
        }else if(tableName == "jobs_copy1"){
        	presql = "update jobs_copy1 set jId=?,jName=?,jDesc=?,jParent=?,jSuper=?,jType=? where jInnerId=?";
        }else if(tableName == "departments_copy1"){
        	presql = "update departments_copy1 set dId=?,dName=?,dDuty=?,dSuper=?,dDesc=?,dLeader=? where dInnerId=?";
        }else if(tableName == "classes_copy1"){
        	presql = "update classes_copy1 set cId=?,cName=?,cTimeStart=?,cTimeEnd=? where cInnerId=?";
        }else if(tableName == "punchcards_copy1"){
        	presql = "update punchcards_copy1 set pId=?,pName=?,pDateTime=? where pInnerId=?";
        }else if(tableName == "paysalarys_copy1"){
        	presql = "update paysalarys_copy1 set pId=?,pName=?,pSalary=?,pTimeStart=?,pTimeEnd=?,pHours=?   where pInnerId=?";
        }else if(tableName == "repaircards_copy1"){
        	presql = "update repaircards_copy1 set rrId=?,rrName=?,rrDateTime=?,rrDesc=?   where rrInnerId=?";
        }else if(tableName == "leaves_copy1"){
        	presql = "update leaves_copy1 set qId=?,qName=?,qTimeStart=?,qTimeEnd=?,qDesc=?   where qInnerId=?";
        }
	    var json = {presql:presql,datas:dataJson,tableName:tableName};
	    var str = JSON.stringify(json);
	    var url = "/AttendanceWork/updateInterface";
	    xmlHttp.open("post", url, true);
	    xmlHttp.send(str);
	    window.location.reload();
    },
    /*seachName: function () {

        var a = $('#show_tbody tr');
        var nameVal = $('#Ktext').val().trim();
        var nameStr = '',
            nameArr = [];

        if (nameVal==='') {
            bootbox.alert({
                title: "来自火星的提示",
                message: "搜索内容不能为空",
                closeButton:false
            })
            return;
        }

        for (var c=0;c<a.length;c++) {
            var txt = $('td:first', a.eq(c)).html().trim();
            nameArr.push(txt);
            
        }

        a.hide();
        for (var i=0;i<nameArr.length;i++) {
            if (nameArr[i].indexOf(nameVal)>-1) {
                a.eq(i).show();
            }
        }
    },*/
    resectList: function () {
        $('#show_tbody tr').show();
    },
    checkMustMes: function () {
    	var tableName = $('.tableName').val();
    	if(tableName == "classes_copy1"){
    		if ($('.cId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.cName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "班次名称为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.cTimeStart').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "上班时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.cTimeEnd').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "下班时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    	}
    	
    	if(tableName == "departments_copy1"){
    		if ($('.dId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.dName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "部门名称为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.dDuty').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "部门职责为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.dSuper').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "上级部门为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    	}
    	
    	if(tableName == "employees_copy1"){
            if ($('.eId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "员工编号为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            if ($('.eName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "姓名为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            if ($('.eAge').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "年龄为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            if ($('.eIdNum').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "身份证号为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            if ($('.eSalary').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "薪水为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            if ($('.ePhoneNum').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "联系电话为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            if ($('.eEmerContact').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "紧急联系人为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            if ($('.eEmerContactPhoneNum').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "紧急联系人电话为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
            
    	}
    	
    	if(tableName == "jobs_copy1"){
    		if ($('.jId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.jName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "岗位名称为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    	}
    	
    	if(tableName == "leaves_copy1"){
    		if ($('.qId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.qName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "请假人名称为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.qTimeStart').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "开始时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.qTimeEnd').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "结束时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.qDesc').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "请假理由为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    	}
//    	领薪没有修改功能
    	if(tableName == "paysalarys_copy1"){
    		if ($('.pId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.pName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "领薪人名称为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.pTimeStart').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "开始时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.pTimeEnd').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "结束时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    	}
    	if(tableName == "punchcards_copy1"){
    		if ($('.pId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.pName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "打卡人名称为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.pDateTime').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "打卡时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		
    	}
    	if(tableName == "repaircards_copy1"){
    		if ($('.rrId').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.rrName').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "打卡人名称为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.rrDateTime').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "补卡时间为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		if ($('.rrDesc').val().trim()==='') {
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "补卡原因为必选项，请填写",
                    closeButton:false
                })
                hasNullMes = true;
                return
            }
    		
    	}
    	
    },
    checkRepeat: function () {

    	eEmpIdArr = [], eIdArr = [];

        for (var i = 0; i<$('#show_tbody tr:not(".has_case")').length;i++) {
            var par = '#show_tbody tr:not(".has_case"):eq(' + i + ')';
            var a = $('td:eq(1)', par).html().trim(),
                b = $('td:eq(2)', par).html().trim();
            eEmpIdArr.push(a);
            eIdArr.push(b);
        }
        var tableName = $('.tableName').val();
        /*    	alert("checkMustMes");
            	alert("tableName: " + tableName);*/
        if(tableName == "employees_copy1"){
        	var eEmpId = $('.eEmpId').val().trim(),
        	eId = $('.eId').val().trim();
        	if (eEmpIdArr.indexOf(eEmpId)>-1) {
                noRepeat = false;
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "ID重复了，请重新输入",
                    closeButton:false
                })
                return;
            }
            if (eIdArr.indexOf(eId)>-1) {
                noRepeat = false;
                bootbox.alert({
                    title: "来自火星的提示",
                    message: "员工编号重复了，请重新输入",
                    closeButton:false
                })
                return;
            }
        }
        	

        
        noRepeat = true;
    }
}

function Pagination($content, $wrap, options) {
    this.$wrap = $wrap;
    this.$content = $content;
    this.options = $.extend({}, Pagination.defaultOptions, options);
    this.init();
}
Pagination.defaultOptions = {
    size: 8
};
Pagination.prototype.init = function () {
    var totalItemNum = this.$content.children().length;
    var totalPageNum = this.totalPageNum = Math.ceil(totalItemNum / this.options.size);
    this.currentPage = 1;
    this.$wrap.empty();
    this.$content.children(':gt(' + (this.options.size - 1) + ')').hide();
    this.$wrap.append([
        '<span class="page_box">',
        '<a class="prev">上一页</a>',
        '<span class="num">',
        '</span>',
        '<a class="next">下一页</a>',
        '</span>'
    ].join(''));
    for (var i = 0; i < totalPageNum; i++) {
        var $btn = $('<span class="page-item">' + (i + 1) + '</span>');
        $btn.data('page', i + 1);
        this.$wrap.find('.num').append($btn);
    }
    this.$wrap.find('.num').children().eq(0).addClass('current');
    this.initEvents();
};
Pagination.prototype.initEvents = function () {
    var _this = this;
    var $prev = this.$wrap.find('.prev');
    var $next = this.$wrap.find('.next');
    var $num = this.$wrap.find('.num');

    $prev.on('click', function () {
        _this.prev();
    });
    $next.on('click', function () {
        _this.next();
    });
    $num.on('click', '.page-item', function () {
        var page = $(this).data('page');
        _this.goTo(page);
    });
};
Pagination.prototype.prev = function () {
    this.goTo(this.currentPage - 1);
};
Pagination.prototype.next = function () {
    this.goTo(this.currentPage + 1);
};
Pagination.prototype.goTo = function (num) {
    if (typeof num !== 'number') {
        throw new Error('e');
    }
    if(num > this.totalPageNum || num <= 0) {
        return false;
    }

    this.currentPage = num;

    this.$wrap.find('.num')
        .children().eq(this.currentPage - 1)
        .addClass('current').siblings('.current')
        .removeClass('current');

    var left = (this.currentPage - 1) * this.options.size;
    var right = left + this.options.size;

    var $shouldShow = this.$content.children().filter(function (index) {
        return left <= index && index < right;
    });
    this.$content.children().hide();
    $shouldShow.show();
};

var pagi = new Pagination($('#show_tbody'), $('#wrap'));

