$("#knowledgebasemgr").click(function () {
    SimplePop.alert("系统火速建设中...",{
        drag: true,       //是否可拖动图层
    });
});

$('#queryengine').click(function(){
	window.open("/html/search.html");
});

$("#apiinterface").click(function () {
    SimplePop.alert("系统火速建设中...",{
        drag: true,       //是否可拖动图层
    });
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