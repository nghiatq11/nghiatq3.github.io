/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author quang
 */
public class Helper {
    public static String hyperlink(String label, String href) {
        return "<a href=\"" + href + "\">" + "<div class=\"numberpage\">" + label + "</div>" + "</a>";
    }
    public static String pager(int pageindex, int pagecount, int gap, String href) {
        String result = "";
        if (pagecount <= 4) { //if bumber of page > 4 it disappear first và last
            for (int i = gap + 1; i > 0; i--) {
                if (pageindex - i > 0) { //get link for page before index
                    result += hyperlink("" + (pageindex - i), href + (pageindex - i));
                }
            }

            result += "<div class=\"numberpage\">" + pageindex + "</div>";//index not get link
            for (int i = 1; i <= gap + 1; i++) {//get link for page index
                if (pageindex + i <= pagecount) {
                    result += hyperlink("" + (pageindex + i), href + (pageindex + i));
                }
            }
        } else {
            if (pageindex > gap + 1) { //if you choose first <=2 thì first disappear
                result += hyperlink("first", href + 1);
            }

            for (int i = gap; i > 0; i--) {
                if (pageindex - i > 0) {
                    result += hyperlink("" + (pageindex - i), href + (pageindex - i));
                }
            }

            result += "<div class=\"numberpage\">" + pageindex + "</div>";//index not get link

            for (int i = 1; i <= gap; i++) { //get link for page after index
                if (pageindex + i <= pagecount) {
                    result += hyperlink("" + (pageindex + i), href + (pageindex + i));
                }
            }

            if (pageindex + gap < pagecount) { //display last page
                result += hyperlink("last", href + pagecount);
            }
        }
        return result;
    }
    
   
}
