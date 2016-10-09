$(function(){
    var thisURL = document.URL; 
    var  param =thisURL.split('?')[1];
    var paramVal= param.split("=")[1];
    
    if("" != paramVal){
        $.ajax({
            url: "/ioss/knowledge/querySingleKnowledge?id="+paramVal,
            type: "GET",
            data: {},
            dataType: "json",
            success: function(data){
                if(data){
                    var regexstr = new RegExp("<[^<]*>", "gi");
                    if(null != data["eventTitle"])
                    $('#title').text(data["eventTitle"].replace(regexstr,""));
                    if(null != data["eventId"])
                    $('#ticketId').text(data["eventId"].replace(regexstr,""));
                    if(null != data["updateTime"])
                    $('#solveDate').text(data["updateTime"].replace(regexstr,""));
//                    $('#description').text(data["eventDescr"].replace(regexstr,""));
                    if(null != data["eventDescr"])
                    $('#description').html(data["eventDescr"]);
//                    $('#solution').text(data["solution"].replace(regexstr,""));
                    if(null != data["solution"])
                    $('#solution').html(data["solution"]);
                }
             }
        });
    }
    
    //点击搜索服务连接
    $('#searchSever').click(function(){
        var url = "/html/search_result.html?content=";
        window.open(url);
    });
});