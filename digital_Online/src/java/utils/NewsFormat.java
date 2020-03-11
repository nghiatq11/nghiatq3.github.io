/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Nam
 */
public class NewsFormat {
    
    //parse date time format in sql server to java.util.date to contain year, month, date, hour, minutes and second
    public static Date parseDatetimeStringToDate(String date) throws ParseException {
        
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(date);
    }
    
    //format java.util.date to string with pattern to display for user
    public static String formatDateToString(Date date) {
        return new SimpleDateFormat("MMM dd yyyy - h:mma").format(date).replace("AM", "am").replace("PM","pm");
    }
    
    //change all newline character (\n) to <br> tag to get newline in html
    public static String formatNewsContent(String content) {
        return content.replaceAll("\n", "<br>");
    }
    
}
