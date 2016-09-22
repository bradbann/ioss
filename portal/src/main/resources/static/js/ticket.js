var thisURL = document.URL; 
    var  param =thisURL.split('?')[1];
    var paramVal= param.split("=")[1];
    
    if("" != paramVal){
        $.ajax({
            url: "/ioss/knowledge/ticket?eventId="+paramVal,
            type: "GET",
            data: {},
            dataType: "json",
            success: function(data){
                if(data){
                    var str = data;
                    var regexstr = new RegExp("<[^<]*>", "gi");
//                    $('#title').text(data["eventTitle"].replace(regexstr,""));
                    $('#reportArea').text(data.data["reportArea"]);
                    $('#reportor').text(data.data["reportor"]);
                    $('#commitTime').text(data.data["commitTime"]);
                    $('#updateTime').text(data.data["updateTime"]);
                    $('#createTime').text(data.data["createTime"]);
                    $('#eventId').text(data.data["eventId"]);
                    $('#eventTitle').text(data.data["eventTitle"]);
                    $('#eventDescr').text(data.data["eventDescr"].replace(regexstr,""));
                    $('#eventType').text(data.data["eventType"]);
                    $('#eventClassify').text(data.data["eventClassify"]);
                    $('#ownerSystem').text(data.data["ownerSystem"]);
                    $('#ownerModule').text(data.data["ownerModule"]);
                    $('#subModule').text(data.data["subModule"]);
                    $('#funcMenu').text(data.data["funcMenu"]);
                    $('#affectRange').text(data.data["affectRange"]);
                    $('#affectDegree').text(data.data["affectDegree"]);
                    $('#criticalDegree').text(data.data["criticalDegree"]);
                    $('#pri').text(data.data["pri"]);
                    $('#eventSource').text(data.data["eventSource"]);
                    $('#eventStatus').text(data.data["eventStatus"]);
                    $('#statusReason').text(data.data["statusReason"]);
                    $('#solveCode').text(data.data["solveCode"]);
                    $('#closeCode').text(data.data["closeCode"]);
                    $('#currentDealGroup').text(data.data["currentDealGroup"]);
                    $('#currentDealor').text(data.data["currentDealor"]);
                    $('#solution').text(data.data["solution"].replace(regexstr,""));
                }
             }
        });
    }
    
$(function(){
    //点击搜索服务连接
    $('#searchSever').click(function(){
        var url = "/html/search_result.html?content=";
        window.open(url);
    });
})