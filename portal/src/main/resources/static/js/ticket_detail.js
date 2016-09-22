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
                    $('#title').text(data["eventTitle"].replace(regexstr,""));
                    $('#ticketId').text(data["eventId"].replace(regexstr,""));
                    $('#solveDate').text(data["updateTime"].replace(regexstr,""));
//                    $('#description').text(data["eventDescr"].replace(regexstr,""));
                    $('#description').html(data["eventDescr"]);
//                    $('#solution').text(data["solution"].replace(regexstr,""));
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