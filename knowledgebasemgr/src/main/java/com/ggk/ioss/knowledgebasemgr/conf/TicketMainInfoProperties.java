package com.ggk.ioss.knowledgebasemgr.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ticket.maininfo", ignoreUnknownFields = false)
public class TicketMainInfoProperties {
    private int event_id_index;
    private int report_area_index;
    private int reporter_index;
    private int commit_time_index;
    private int event_title_index;
    private int event_descr_index;
    private int event_type_index;
    private int event_classify_index;
    private int owner_system_index;
    private int owner_module_index;
    private int sub_module_index;
    private int func_menu_index;
    private int affect_range_index;
    private int affect_degree_index;
    private int critical_degree_index;
    private int pri_index;
    private int event_source_index;
    private int event_status_index;
    private int status_reason_index;
    private int solve_code_index;
    private int close_code_index;
    private int current_deal_group_index;
    private int current_dealor_index;
    private int solution_index;
    private int create_time_index;
    private int update_time_index;
    private String file;
    
    public int getEvent_id_index() {
        return event_id_index;
    }
    public void setEvent_id_index(int event_id_index) {
        this.event_id_index = event_id_index;
    }
    public int getReport_area_index() {
        return report_area_index;
    }
    public void setReport_area_index(int report_area_index) {
        this.report_area_index = report_area_index;
    }
    public int getReporter_index() {
        return reporter_index;
    }
    public void setReporter_index(int reporter_index) {
        this.reporter_index = reporter_index;
    }
    public int getCommit_time_index() {
        return commit_time_index;
    }
    public void setCommit_time_index(int commit_time_index) {
        this.commit_time_index = commit_time_index;
    }
    public int getEvent_title_index() {
        return event_title_index;
    }
    public void setEvent_title_index(int event_title_index) {
        this.event_title_index = event_title_index;
    }
    public int getEvent_descr_index() {
        return event_descr_index;
    }
    public void setEvent_descr_index(int event_descr_index) {
        this.event_descr_index = event_descr_index;
    }
    public int getEvent_type_index() {
        return event_type_index;
    }
    public void setEvent_type_index(int event_type_index) {
        this.event_type_index = event_type_index;
    }
    public int getEvent_classify_index() {
        return event_classify_index;
    }
    public void setEvent_classify_index(int event_classify_index) {
        this.event_classify_index = event_classify_index;
    }
    public int getOwner_system_index() {
        return owner_system_index;
    }
    public void setOwner_system_index(int owner_system_index) {
        this.owner_system_index = owner_system_index;
    }
    public int getOwner_module_index() {
        return owner_module_index;
    }
    public void setOwner_module_index(int owner_module_index) {
        this.owner_module_index = owner_module_index;
    }
    public int getSub_module_index() {
        return sub_module_index;
    }
    public void setSub_module_index(int sub_module_index) {
        this.sub_module_index = sub_module_index;
    }
    public int getFunc_menu_index() {
        return func_menu_index;
    }
    public void setFunc_menu_index(int func_menu_index) {
        this.func_menu_index = func_menu_index;
    }
    public int getAffect_range_index() {
        return affect_range_index;
    }
    public void setAffect_range_index(int affect_range_index) {
        this.affect_range_index = affect_range_index;
    }
    public int getAffect_degree_index() {
        return affect_degree_index;
    }
    public void setAffect_degree_index(int affect_degree_index) {
        this.affect_degree_index = affect_degree_index;
    }
    public int getCritical_degree_index() {
        return critical_degree_index;
    }
    public void setCritical_degree_index(int critical_degree_index) {
        this.critical_degree_index = critical_degree_index;
    }
    public int getPri_index() {
        return pri_index;
    }
    public void setPri_index(int pri_index) {
        this.pri_index = pri_index;
    }
    public int getEvent_source_index() {
        return event_source_index;
    }
    public void setEvent_source_index(int event_source_index) {
        this.event_source_index = event_source_index;
    }
    public int getEvent_status_index() {
        return event_status_index;
    }
    public void setEvent_status_index(int event_status_index) {
        this.event_status_index = event_status_index;
    }
    public int getStatus_reason_index() {
        return status_reason_index;
    }
    public void setStatus_reason_index(int status_reason_index) {
        this.status_reason_index = status_reason_index;
    }
    public int getSolve_code_index() {
        return solve_code_index;
    }
    public void setSolve_code_index(int solve_code_index) {
        this.solve_code_index = solve_code_index;
    }
    public int getClose_code_index() {
        return close_code_index;
    }
    public void setClose_code_index(int close_code_index) {
        this.close_code_index = close_code_index;
    }
    public int getCurrent_deal_group_index() {
        return current_deal_group_index;
    }
    public void setCurrent_deal_group_index(int current_deal_group_index) {
        this.current_deal_group_index = current_deal_group_index;
    }
    
    public int getCurrent_dealor_index() {
      return current_dealor_index;
   }
   public void setCurrent_dealor_index(int current_dealor_index) {
      this.current_dealor_index = current_dealor_index;
   }
   public int getSolution_index() {
        return solution_index;
    }
    public void setSolution_index(int solution_index) {
        this.solution_index = solution_index;
    }
    public int getCreate_time_index() {
        return create_time_index;
    }
    public void setCreate_time_index(int create_time_index) {
        this.create_time_index = create_time_index;
    }
    public int getUpdate_time_index() {
        return update_time_index;
    }
    public void setUpdate_time_index(int update_time_index) {
        this.update_time_index = update_time_index;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    
}
