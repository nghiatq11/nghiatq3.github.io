/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author quang
 */
public class NewsFormat {

    //format java.util.date to string with pattern to display for user
    public static String formatDateToString(Date date) {
        return new SimpleDateFormat("dd MMM yyyy").format(date);
    }
    
    
    
}
