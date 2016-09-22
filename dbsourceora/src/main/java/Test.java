import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * File Name：Test.java
 *
 * Copyrighe：copyright@2016 www.ggkbigdata.com. All Rights Reserved
 *
 * Create Time: 2016年9月21日 下午5:50:46
 */

public class Test {

    public static void main(String[] args) {
        String date = "2016-03-31";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = sdf.parse(date + " 00:00:00");
            endDate = sdf.parse(date + " 23:59:59"); 
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(startDate.getTime());

    }

}

