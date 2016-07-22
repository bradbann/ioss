$('#search').click(function(){
	var content = $('#input_context').val();
	if($('#searchMng').text()=="搜索管理"){
    	alert("请选择搜索类型！");
    	return;
	}
	if(content != null)
	$.ajax({
		url:'/ioss/knowledge/queryer?queryParams='+content,
		type:'post',
		datatype:'json',
		success:function(data){
			var JsonData = JSON.parse(data);
			var htmlStr = "";
			for(var i in JsonData){
				htmlStr += 
					'<div class = "div1">'+
						'<div>'+
							'<h4 style = "color:blue;">eventId:'+JsonData[i]["eventId"]+' '+JsonData[i]["title"]+'</h4>'+
							'<div>'+
								'<span style = "font-size:14px;">'+JsonData[i]["description"]+'</span>'+
							'</div>'+
						'</div>'+
					'</div>';
			}
			$('#context').html(htmlStr);
		}
	});
});

document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    
    if(e && e.keyCode==13){ // enter 键
         //要做的事情
    	$('#search').click();
    }
}; 
