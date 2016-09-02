package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.conf.TicketMainInfoProperties;
import com.ggk.ioss.knowledgebasemgr.mapper.TicketMapper;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.ITicketOperator;
import com.ggk.ioss.knowledgebasemgr.utils.DateFormatConvertor;

import au.com.bytecode.opencsv.CSVReader;

@Service
@EnableConfigurationProperties(TicketMainInfoProperties.class)
public class ITicketOperatorImp implements ITicketOperator{
    @Autowired
    private TicketMainInfoProperties ticketMainInfoPro;
    @Autowired
    private TicketMapper ticketMapper;
    
    @Override
    public void saveTicketMainInfo(String filePath) {
        List<TicketMainInfo> list = new ArrayList<TicketMainInfo>();
        DateFormatConvertor convertor = new DateFormatConvertor();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "utf-8");
            CSVReader csvReader = new CSVReader(inputStreamReader,',');
            int count = 0;
            String[] parts;
            csvReader.readNext();    //discard title
            TicketMainInfo tmi;
            while((parts = csvReader.readNext())!= null) {
                try {
                    tmi = new TicketMainInfo();
                    tmi.setEventId(parts[ticketMainInfoPro.getEvent_id_index()]);
                    tmi.setReportArea(parts[ticketMainInfoPro.getReport_area_index()]);
                    tmi.setReportor(parts[ticketMainInfoPro.getReporter_index()]);
                    tmi.setCommitTime(convertor.convertTo24h(parts[ticketMainInfoPro.getCommit_time_index()]));
                    tmi.setEventTitle(parts[ticketMainInfoPro.getEvent_title_index()]);
                    tmi.setEventDescr(parts[ticketMainInfoPro.getEvent_descr_index()]);
                    tmi.setEventType(parts[ticketMainInfoPro.getEvent_type_index()]);
                    tmi.setEventClassify(parts[ticketMainInfoPro.getEvent_classify_index()]);
                    tmi.setOwnerSystem(parts[ticketMainInfoPro.getOwner_system_index()]);
                    tmi.setOwnerModule(parts[ticketMainInfoPro.getOwner_module_index()]);
                    tmi.setSubModule(parts[ticketMainInfoPro.getSub_module_index()]);
                    tmi.setFuncMenu(parts[ticketMainInfoPro.getFunc_menu_index()]);
                    tmi.setAffectRange(parts[ticketMainInfoPro.getAffect_range_index()]);
                    tmi.setAffectDegree(parts[ticketMainInfoPro.getAffect_degree_index()]);
                    tmi.setCriticalDegree(parts[ticketMainInfoPro.getCritical_degree_index()]);
                    tmi.setPri(parts[ticketMainInfoPro.getPri_index()]);
                    tmi.setEventSource(parts[ticketMainInfoPro.getEvent_source_index()]);
                    tmi.setEventStatus(parts[ticketMainInfoPro.getEvent_status_index()]);
                    tmi.setStatusReason(parts[ticketMainInfoPro.getStatus_reason_index()]);
                    tmi.setSolveCode(parts[ticketMainInfoPro.getSolve_code_index()]);
                    tmi.setCloseCode(parts[ticketMainInfoPro.getClose_code_index()]);
                    tmi.setCurrentDealGroup(parts[ticketMainInfoPro.getCurrent_deal_group_index()]);
                    tmi.setCurrentDealor(parts[ticketMainInfoPro.getCurrent_dealor_index()]);
                    tmi.setSolution(parts[ticketMainInfoPro.getSolution_index()]);
                    tmi.setCreateTime(convertor.convertTo24h(parts[ticketMainInfoPro.getCreate_time_index()]));
                    tmi.setUpdateTime(convertor.convertTo24h(parts[ticketMainInfoPro.getUpdate_time_index()]));
                    list.add(tmi);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                
                try {
                    if(++count >= 10){
                        ticketMapper.saveTicketMainInfo(list);
                        count = 0;
                        list = new ArrayList<TicketMainInfo>();
                    }
                } catch (Exception e) {
                    count = 0;
                    list = new ArrayList<TicketMainInfo>();
                    e.printStackTrace();
                }
            }
            ticketMapper.saveTicketMainInfo(list);
            csvReader.close();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
