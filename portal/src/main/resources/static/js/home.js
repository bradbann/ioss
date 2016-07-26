$("#knowledgebasemgr").click(function () {
    SimplePop.alert("系统火速建设中，请稍后...",{
        drag: true,       //是否可拖动图层
    });
});

$('#queryengine').click(function(){
	window.location.href="/html/searchInfo.html";
});

$("#apiinterface").click(function () {
    SimplePop.alert("系统火速建设中，请稍后...",{
        drag: true,       //是否可拖动图层
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