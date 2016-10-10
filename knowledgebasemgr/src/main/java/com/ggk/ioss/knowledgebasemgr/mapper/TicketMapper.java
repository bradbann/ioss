package com.ggk.ioss.knowledgebasemgr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ggk.ioss.knowledgebasemgr.model.TicketDealInfo;
import com.ggk.ioss.knowledgebasemgr.model.TicketES;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;

public interface TicketMapper {
    
    public List<TicketDealInfo> queryTicketDealInfoByPage(@Param("start")long start, @Param("limit")long limit);
    
    public Long queryTicketDealInfoTotalNumber();
    
    public List<TicketMainInfo> queryTicketMainInfoByPage(@Param("start")long start, @Param("limit")long limit);
    
    public TicketMainInfo queryTicketMainInfoById(@Param("event_id")String eventId);
    
    public Long queryTicketMainInfoTotalNumber();
    
    public List<TicketES> queryTicketES(@Param("start") long start, @Param("limit")long limit);
    
    public void saveTicketMainInfo(@Param("list") List<TicketMainInfo> list);
    
    public void saveSyncLog(@Param("syncType") String syncType, @Param("syncUrl") String syncUrl, 
            @Param("syncStatus") String syncStatus);
}
