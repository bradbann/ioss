$('#search').click(function(){
	var content = $('#input_context').val();
	if(content != null)
	$.ajax({
		url:'http://localhost:8004/ioss/knowledge/queryer?queryParams='+content,
		type:'post',
		datatype:'json',
		success:function(data){
			debugger
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
