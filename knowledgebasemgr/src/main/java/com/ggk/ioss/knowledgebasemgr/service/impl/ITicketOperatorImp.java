package com.ggk.ioss.knowledgebasemgr.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.ggk.ioss.knowledgebasemgr.conf.TicketMainInfoProperties;
import com.ggk.ioss.knowledgebasemgr.mapper.TicketMapper;
import com.ggk.ioss.knowledgebasemgr.model.TicketMainInfo;
import com.ggk.ioss.knowledgebasemgr.service.ITicketOperator;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ticketMainInfoPro.getFile())),"GBK")); 
            Sheet sheet;
            Workbook book;
            //book = Workbook.getWorkbook(new File(ticketMainInfoPro.getFile()));
            //sheet=book.getSheet(0);
            //int rows = sheet.getRows();
            int count = 0; 
            //int columns = sheet.getColumns();
            String line = br.readLine();
            while((line = br.readLine()) != null) 
            //for(int row = 1; row < rows; row++) {
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");   //根据样例csv，以tab分割
                TicketMainInfo tmi = new TicketMainInfo();
                tmi.setEventId(parts[ticketMainInfoPro.getEvent_id_index()]);
                tmi.setReportArea(parts[ticketMainInfoPro.getReport_area_index()]);
                tmi.setCommitTime(parts[ticketMainInfoPro.getCommit_time_index()].replace("上午", "").replace("下午", ""));
                tmi.setEventTitle(parts[ticketMainInfoPro.getEvent_title_index()]);
                tmi.setEventDescr(parts[ticketMainInfoPro.getEvent_descr_index()]);
                tmi.setEventType(parts[ticketMainInfoPro.getEvent_type_index()]);
                tmi.setEventClassify(parts[ticketMainInfoPro.getEvent_classify_index()]);
                tmi.setOwnerSystem(parts[ticketMainInfoPro.getOwner_system_index()]);
                tmi.setOwnerModule(parts[ticketMainInfoPro.getOwner_module_index()]);
                tmi.setSubModule(parts[ticketMainInfoPro.getSub_module_index()]);
                tmi.setFuncMenu(parts[ticketMainInfoPro.getFunc_menu_index()]);
                tmi.setAffectRange(parts[ticketMainInfoPro.getAffect_range_index()]);
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
                tmi.setCreateTime(parts[ticketMainInfoPro.getCreate_time_index()].replace("上午", "").replace("下午", ""));
                tmi.setUpdateTime(parts[ticketMainInfoPro.getUpdate_time_index()].replace("上午", "").replace("下午", ""));
                for(int column = 0; column < parts.length; column++) {
                    System.out.print(parts[column]+ "\t");
                }
                System.out.println();
                if(++count >= 1000){
                    count = 0;
                    ticketMapper.saveTicketMainInfo(list);
                    list = new ArrayList<TicketMainInfo>();
                } 
            }
            br.close();
            if(count > 0) {
                ticketMapper.saveTicketMainInfo(list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
