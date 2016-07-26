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
		htmlstr += 
			'<div class = "resultDiv">'+
				'<div>'+
					'<a href = "#" style = "font-size:16px;margin:5px 0;color:blue;">标题：'+data[i]["title"]+data[i]["title"]+'</a>'+
						'<div style = "font-size:14px;margin:5px 0;">描述：'+data[i]["description"]+'</div>'+
						'<div style = "font-size:14px;margin:5px 0;">状态：'+data[i]["content"]+'</div>'+
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
					$('#context').html('<h4 style = "font-family:黑体;margin-bottom:100px;">抱歉，没有相关内容...</h4>');
				}
			}
		});
});
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