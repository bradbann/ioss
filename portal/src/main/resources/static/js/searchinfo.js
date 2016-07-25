var JsonData;
var htmlStr = "";
//$('#search').click(function(){
//	var content = $('#input_context').val();
//	if($('#searchMng').text()=="搜索管理"){
//    	alert("请选择搜索类型！");
//    	return;
//	}
//	if(content != null)
//	$.ajax({
//		url:'/ioss/knowledge/queryer?queryParams='+content,
//		type:'post',
//		datatype:'json',
//		success:function(data){
//			var JsonData = JSON.parse(data);
//			
//			for(var i in JsonData){
//				htmlStr += 
//					'<div class = "div1">'+
//						'<div>'+
//							'<h4 style = "color:blue;">eventId:'+JsonData[i]["eventId"]+' '+JsonData[i]["title"]+'</h4>'+
//							'<div>'+
//								'<span style = "font-size:14px;">'+JsonData[i]["description"]+'</span>'+
//							'</div>'+
//						'</div>'+
//					'</div>';
//			}
//			$('#context').html(htmlStr);
////			pagination_init();
//		}
//	});
//});

document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    
    if(e && e.keyCode==13){ // enter 键
         //要做的事情
    	$('#search').click();
    }
}; 

//function pagination_init(){
//	var content = $('#input_context').val();
//	if(content != "")
//	$('#pagination').pagination({
//		dataSource:function(){
//			$.ajax({
//				type:'POST',
//				url:'/ioss/knowledge/queryer?queryParams='+content,
//				success:function(data){
//					var JsonData = JSON.parse(data);
//					var page_num = [];
//					for(var i in JsonData){
//						page_num.push(i);
//					}
//					return page_num;
//				}
//			});
//		},
//		pageSize: 5,
//		pageRange: 2,
//		showGoInput: true,
//		showGoButton: true,
//	    className: 'paginationjs-theme-blue paginationjs-big',
//	    totalNumber: 100,
//	    ajax: {
//	        beforeSend: function() {
//	        	for(var i in JsonData){
//	        		$('#context').html(htmlStr);
//	        	}
//	        }
//	    },
//	    callback: function(JsonData, pagination) {
//	        var html = parseHtml(JsonData);
//	        $('#context').html(htmlStr);
//	    }
//	});
//}
function parseHtml(data){
	var htmlstr = "";
	for(var i in data){
		htmlstr += 
			'<div class = "resultDiv">'+
				'<div>'+
					'<h4 style = "color:blue;">eventId:'+data[i]["eventId"]+' '+data[i]["title"]+'</h4>'+
					'<div>'+
						'<span style = "font-size:14px;">'+data[i]["description"]+'</span>'+
					'</div>'+
				'</div>'+
			'</div>';
	}
	return htmlstr;
}

$('#search').click(function(){
	var content1 = $('#input_context').val();
	if(content1 != null)
		$.ajax({
			url:'/ioss/knowledge/queryer?queryParams='+content1,
			type:'post',
			datatype:'json',
			success:function(data){
				var jsonData = JSON.parse(data);
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
				    }
				});
			}
		});
});