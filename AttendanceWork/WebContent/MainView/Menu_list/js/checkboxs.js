/**
 *   checkbox复选框的操作
 */
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