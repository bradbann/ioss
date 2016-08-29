package com.ggk.ioss.knowledgebasemgr.utils;

public class DateFormatConvertor {
    public String convertTo24h(String dateStr) {
        if(dateStr.trim().equals("") || dateStr == null || dateStr.split(" ").length < 2) {
            return null;
        }
        String date = dateStr.split(" ")[0];
        String time = dateStr.split(" ")[1];
        if(time.trim().startsWith("上午12")) {
            String[] hour = time.replace("上午", "").split(":");
            if(hour.length > 2) {
                time = "00:" + hour[1] + ":" + hour[2];
            } else {
                time = "00:00:00";
            }
            
        } else if(time.trim().startsWith("上午")) {
            time = time.replace("上午", "");
        } else if(time.trim().startsWith("下午12")) {
            time = time.replace("下午", "");
        } else {
            String[] hour = time.replace("下午", "").split(":");
            time = (12 + Integer.parseInt(hour[0])) + ":" + hour[1] + ":" + hour[2];
        }
        return date + " " + time;
    }
}
