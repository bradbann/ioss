$(function(){
	$('#div1').show();
	var thisURL = document.URL;    
	var  param =thisURL.split('?')[1];  
	var paramVal= param.split("=")[1];
	if(paramVal == "1"){
		selectType1();
	}
	if(paramVal == "2"){
		selectType2();
	}
});
		
function selectType1(){
	$('#searchMng').html('<span class = "caret" style="margin-right:12px;margin-top:-4px;border-top:6px solid;border-right:6px solid transparent;border-left:6px solid transparent;"></span>'+$('#selectType1').text());
	$('#div2').hide();
	$('#div1').show();
}
function selectType2(){
	$('#searchMng').html('<span class = "caret" style="margin-right:12px;margin-top:-4px;border-top:6px solid;border-right:6px solid transparent;border-left:6px solid transparent;"></span>'+$('#selectType2').text());
	$('#div1').hide();
	$('#div2').show();
}

document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    
    if(e && e.keyCode==13){ // enter 键
         //要做的事情
    	$('#search').click();
    }
}; 

function parseHtml(data){
	var htmlstr = "";
	for(var i in data){
		var title = data[i]["title"];
		var content = data[i]["content"];
		var commitTime = data[i]["commitTime"];
		htmlstr += 
			'<div class = "resultDiv">'+
				'<div>'+
					'<a href="../html/ticket_detail.html" target="view_window" style = "font-size:20px;margin:5px 0;color:blue;">'+(title.length>100?(title.substr(0,100)+"..."):title)+'</a>'+
						'<div style = "font-size:14px;margin:5px 0;">描述：'+(content.length>100?(content.substr(0,100)+"..."):content)+'</div>'+
						'<div style = "font-size:14px;margin:5px 0;">解决方案：'+data[i]["content"]+'</div>'+
						'<a href="http://www.baidu.com" target="view_window" style = "font-size:12px;margin:5px 10px 5px 0px;">www.baidu.com</a>'+'<span style = "font-size:14px;margin:5px 10px;">'+commitTime.substr(0,10)+'</span>'+
				'</div>'+
			'</div>';
	}
	return htmlstr;
}

$('#search').click(function(){
	var content = $('#input_context').val();
	if(content != "")
		$.ajax({
			url:'/ioss/knowledge/queryer?queryParams='+content,
			type:'post',
			datatype:'json',
			success:function(data){
				var jsonData = JSON.parse(data);
				if(jsonData != "")
				$('#pagination').pagination({
					dataSource:jsonData ,
					pageNumber: 1,
					pageSize: 10,
					pageRange: 2,
					showGoInput: true,
					showGoButton: true,
				    className: 'paginationjs-theme-blue paginationjs-big',
				    totalNumber: jsonData.length,
				    callback: function(data, pagination) {
				        var html = parseHtml(data);
				        $('#context').html(html);
				        $('#pagination').show();
				    }
				});
				else {
					$('#pagination').hide();
					$('#searchresult').html('<h4 style = "font-family:黑体;margin-bottom:100px;">抱歉，没有相关内容...</h4>');
				}
			}
		});
	else{
		SimplePop.alert("请输入搜索内容...",{darg:true});
	}
});

function tips(){
	SimplePop.alert("功能实现中...",{
        drag: true,       //是否可拖动图层
    });
}
function show_knowledgemgm_list(){
	$('#knowledgemgm_list').show();
}

function hide_knowledgemgm_list(){
	$('#knowledgemgm_list').hide();
}
function show_searchsvr_list(){
	$('#searchsvr_list').show();
}
function hide_searchsvr_list(){
	$('#searchsvr_list').hide();
}
//function show_ticket(){
//	var top = ($(window).height()-$('#ticket').height())/2;
//	var scrollTop = $(document).scrollTop(); 
//	  $("#ticket").css({
//		  "position" : "absolute",
//          "top" : top+scrollTop,
//          "width" : "30%"
//      }).show(); 
//}
//function hide_ticket(){
//	$('#ticket').hide();
//}