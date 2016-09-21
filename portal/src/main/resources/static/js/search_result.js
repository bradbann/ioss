var curIndex = -1;
//flag变量标记输入框输入方式：1代表手动输入；0代表上下键选定改变输入框内容
var flag = 0;
var url = encodeURI("/ioss/knowledge/queryhotwords?keyword=");
$.ajax({
	url: url,
	type:'GET',
	dataType: "json",
	success: function( data ) {
		if(null != data){
		//初始化热词
		$('#hotword1').html(data.data[0]);
		$('#hotword2').html(data.data[1]);
		$('#hotword3').html(data.data[2]);
		$('#hotword4').html(data.data[3]);
		$('#hotword5').html(data.data[4]);
		}
	}
});

//根据URL中传的参数进行搜索，并分页显示
var thisURL = document.URL; 
var  param =thisURL.split('?')[1]; 
if(undefined != param){
	var paramVal= param.split("=")[1];
	$('#inpputContent').val(decodeURI(paramVal));
	if("" != paramVal)
	{
		var url = encodeURI("/ioss/knowledge/queryer?queryParams="+paramVal);
		$.ajax({
			url:url,
			type:'get',
			datatype:'json',
			success:function(data){
			var jsonData = JSON.parse(data);
			if("" != jsonData)
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
			        $('#searchresult').html(html);
			        $('#pagination').show();
			    }
			});
			else {
				$('#pagination').hide();
				$('#searchresult').html('<h4 style = "font-family:黑体;margin-bottom:100px;margin-top:25px;">抱歉，没有相关内容...</h4>');
			}
		}
		});
	}
}

$(function(){
	//热词点击事件
	$('#hotword1').click(function(){
		var content = $(this).text();
		var url = "/html/search_result.html?content=";
		url = encodeURI(url+content);
		window.open(url);
	});
	$('#hotword2').click(function(){
		var content = $(this).text();
		var url = "/html/search_result.html?content=";
		url = encodeURI(url+content);
		window.open(url);
	});
	$('#hotword3').click(function(){
		var content = $(this).text();
		var url = "/html/search_result.html?content=";
		url = encodeURI(url+content);
		window.open(url);
	});
	$('#hotword4').click(function(){
		var content = $(this).text();
		var url = "/html/search_result.html?content=";
		url = encodeURI(url+content);
		window.open(url);
	});
	$('#hotword5').click(function(){
		var content = $(this).text();
		var url = "/html/search_result.html?content=";
		url = encodeURI(url+content);
		window.open(url);
	});
	
	//输入框监听事件
	$('#inpputContent').bind('input propertychange', function(){
		if(!flag){
			flag=1;
		}else{
				var url = encodeURI("/ioss/knowledge/queryhotwords?keyword="+$(this).val());
			 	$.ajax({
		          url: url,
		          type:'GET',
		          dataType: "json",
		          success: function( data ) {
		        	  if(null != data)
		        		  setDom(data.data);
		          }
		        });
		}
	});
	
	//上下键实现选择热词
	$(document).keydown(function(event){
		switch(event.which){
			case 38:
			pickVal(38);
			break;
		
		　　case 40: 
			pickVal(40);
			break;
			
		　　default: break; 
		}
	});
	
//input元素失去焦点事件发生时，清空list元素
$('#inpputContent').blur(function(){
	var obj = $('#tips');
	setTimeout(function(){
		obj.html('');
	},300)
});

//鼠标点击按钮实现搜索
$('#searchbtn').click(function(){
	var inputContent = $('#inpputContent').val();
	if("" == inputContent){
		SimplePop.alert("请输入搜索内容...",{
	        drag: true,       // 是否可拖动图层
	    });
	}
	else{
		 var url = encodeURI("search_result.html?content="+inputContent);
		 location.replace(url);
		}
	});

	//按Enter键实现搜索
	$(document).keydown(function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	    
	    if(e && e.keyCode==13){ // enter 键
	    	//取消浏览器默认行为
	    	e.preventDefault();
	    	$('#searchbtn').click();
	    }
	});
	
	//搜索服务点击事件
	$('#searchSever').click(function(){
		var url = "/html/search_result.html?content=";
		window.open(url);
	});
});
	
	//初始化联想词列表
	function setDom(data){
		var index = -1;
		var obj = $('#tips'),str='<div style="border:0.5px solid gainsboro;background:#fff;"><ul id="ul-list" style = "margin-bottom:0px;font-size:18px;line-height:2em;padding:0">';
		obj.html('');
		curIndex = -1;
		for(var i=0;i<data.length;i++){
			
			str+='<a class="a" href = "javascript:void(0)"><li class = "li" style="list-style-type:none;padding-left:10px;text-align:left">'+data[i]+'</li></a>';
		}
		str+='</ul></div>'
		obj.html(str);
		
		// 点击选择联想词
		obj.find('a').unbind();
		obj.find('a').mouseover(function(){
			$("li").removeClass('l-on');
			var index = $("ul a").index(this);
			curIndex = index;
			$("li").eq(index).addClass('l-on');
		});
			
		obj.find('a').mouseout(function(){
			$("li").removeClass('l-on');
		});
			
		obj.find('a').click(function(){
			var regexstr = new RegExp("<[^<]*>", "gi");
			var content = $(this).find('li').html().replace(regexstr,"");
			$('#inpputContent').val(content);
			obj.html('');
		});
	}

//将数据转换为html
function parseHtml(data){
	var htmlstr = "";
	for(var i in data){
		var eventId = data[i]["eventId"];
		var title = data[i]["title"];
		var description = data[i]["description"];
		var commitTime = data[i]["commitTime"];
		var updateTime = data[i]["updateTime"];
		if(typeof commitTime == 'undefined'){
			commitTime = '';
		}
		
		if(typeof updateTime == 'undefined'){
			updateTime = '';
		}
		
		if(null != commitTime && null != updateTime)
		htmlstr += 
			'<div class = "row resultDiv">'+
				'<div class = "col-xs-9" style="height:90px;line-height:25px;padding:0;display:block;overflow:hidden;text-overflow:ellipsis;white-space: nowrap;"><div><a href = "ticket_detail.html?id='+eventId+'"  target="_blank">'+title+'</a></div><div style = "font-size:16px;overflow:hidden;text-overflow:ellipsis;white-space: nowrap;">问题描述：'+description+'</div></div>'+
				'<div class = "col-xs-3" style = "height:90px;position:relative; padding:0"><span style = "border:1px solid #24C0D7;border-radius:5px;padding:1px 5px;float:right;position:absolute;right:0px;top:15px;background:white;behavior:url(/js/ie-css3.htc);font-size:16px;">'+updateTime.substr(0,10)+
				'</span><a href = "../html/ticket.html?eventId='+eventId+'" style = "color:#008000;position:absolute;top:60px;left:-300%;font-size:14px;" target="_blank">http://www.gditsm.com/</a><span style = "behavior:url(/js/ie-css3.htc);background:#24C0D7!important;border-radios:5px;border-radius:5px;color:#fff;padding:1px 5px;position:absolute;top:47px;right:0px;font-size:16px;display:inline-block;">'+commitTime.substr(0,10)+'</span>'+
				'<span style="position:absolute; right:120px;top:20px;font-size:14px">更新时间</span><span style="position:absolute; right:120px;top:50px;font-size:14px">提交时间</span></div>'+'<span style = "behavior:url(/js/ie-css3.htc);background:#24C0D7!important;border-radios:5px;border-radius:5px;color:#fff;padding:1px 5px;position:absolute;top:60px;right:0px;font-size:16px;display:inline-block;"></span>'+
			'</div>';
	}
	return htmlstr;
}

//上下键选择函数
function pickVal(type){
	var obj = $('#tips ul li');
	var length = obj.length;
	if(length){
		flag = 0;
//		obj.removeClass('l-on');
		if(type>39){
			if(curIndex<0||curIndex>=length-1){
				curIndex=0;
			}else{
				curIndex++;
			}
			var html = $("ul li").eq(curIndex).html()
			var regexstr = new RegExp("<[^<]*>", "gi");
			var html = html.replace(regexstr,"");
			$("#inpputContent").val(html); 
			$("li").removeClass('l-on');
			obj.eq(curIndex).addClass('l-on');
		}else{
			if(curIndex<=0||curIndex>length-1){
				curIndex=length-1;
				
			}else{
				curIndex--;
			}
			var html = $("ul li").eq(curIndex).html();
			var regexstr = new RegExp("<[^<]*>", "gi");
			var html = html.replace(regexstr,"");
			$("#inpputContent").val(html); 
			$("li").removeClass('l-on');
			obj.eq(curIndex).addClass('l-on');
		}
	}
}

