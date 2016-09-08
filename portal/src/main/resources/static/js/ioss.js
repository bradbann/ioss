//输入框获得焦点事件
$('#input').focus(function(){
	//搜索框输入事件
	$('#input').bind('input propertychange', function() {
		// todo 补充监听100ms的操作
		 $.ajax({
	          url: '/ioss/knowledge/queryhotwords?keyword='+$(this).val(),
	          type:'GET',
	          dataType: "json",
	          success: function( data ) {
	        	  // todo 判断数据的合法性
	        	  if(null != data)
	              setDom(data.data);
	          }
	        });
		});
	
	function setDom(data){
		var obj = $('#tips'),str='<div style="border:0.5px solid gainsboro;"><ul id="ul-list" style = "padding-left:0;margin-bottom:0px;font-size:18px;line-height:2em;">';
		obj.html('');
		for(var i=0;i<data.length;i++){
			var temp = decodeURIComponent(data[i]);
			str+='<a href = "javascript:void(0)"><li style="list-style-type:none;padding-left:10px;">'+temp+'</li></a>';
		}
		str+='</ul></div>'
		obj.html(str);
		
		//产生列表后将索引设为-1
		var index = -1;
		// 点击选择联想词
		obj.find('a').unbind();
		
		obj.find('a').mouseover(function(){
			$("li").removeClass('l-on');
			var index = $("ul a").index(this);
			$("li").eq(index).addClass('l-on');
		});
		
		obj.find('a').mouseout(function(){
			$("li").removeClass('l-on');
		});
		
		obj.find('a').click(function(){
			var regexstr = new RegExp("<[^<]*>", "gi");
			var content = $(this).find('li').html().replace(regexstr,"");
			$('#input').val(content);
			obj.html('');
		});
		
		//上下键实现选择li
		$(document).keydown(function (event) {
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
		
		function pickVal(type){
			var obj = $('#tips ul li');
			var length = obj.length;
			if(length){
				obj.removeClass('l-on');
				if(type>39){
					if(index<0||index==length-1){
						index=0;
					}else{
						index++;
					}
					var html = $("ul li").eq(index).html()
					var regexstr = new RegExp("<[^<]*>", "gi");
					if(html){
						html = html.replace(regexstr,"");
						$("#input").val(html); 
						obj.removeClass('l-on');
						obj.eq(index).addClass('l-on');
						//按Enter键实现搜索
						$(document).keydown(function(event){
						    var e = event || window.event || arguments.callee.caller.arguments[0];
						    
						    if(e && e.keyCode==13){ // enter 键
						    	$('#searchbtn').click();
						    }
						});
					}
				}else{
					if(index<=0||index>=length){
						index=length-1;
					
				}else{
					index--;
				}
				var html = $("ul li").eq(index).html();
				var regexstr = new RegExp("<[^<]*>", "gi");
				var html = html.replace(regexstr,"");
				$("#input").val(html); 
				obj.removeClass('l-on');
				obj.eq(index).addClass('l-on');
				//按Enter键实现搜索
				$(document).keydown(function(event){
				    var e = event || window.event || arguments.callee.caller.arguments[0];
				    
				    if(e && e.keyCode==13){ // enter 键
				    	$('#searchbtn').click();
				    }
				});
				}
			}
		}
	}
});

//input元素失去焦点事件发生时，清空list元素
$('#input').blur(function(){
	var obj = $('#tips');
	setTimeout(function(){
		obj.html('');
	},300)
});

//鼠标点击按钮实现搜索
$('#searchbtn').click(function(){
	var inputContent = $('#input').val();
	if("" == inputContent){
		SimplePop.alert("请输入搜索内容...",{
	        drag: true,       // 是否可拖动图层
	    });
	}
	else{
		var param = encodeURI(inputContent);
		var url = "/html/search_result.html?content="+param;
		window.open(url);
		}
	});

//按Enter键实现搜索
$(document).keydown(function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    
    if(e && e.keyCode==13){ // enter 键
    	// 要做的事情
    	$('#searchbtn').click();
    }
});