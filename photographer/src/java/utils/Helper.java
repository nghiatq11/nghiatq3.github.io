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
        if (pagecount <= 4) { //nếu số trang nhỏ hơn 4 sẽ k hiển thị first và last
            for (int i = gap + 1; i > 0; i--) {
                if (pageindex - i > 0) { //gán link cho các trang trước trang index
                    result += hyperlink("" + (pageindex - i), href + (pageindex - i));
                }
            }

            result += "<div class=\"numberpage\">" + pageindex + "</div>";//trang index k đc phép để link
            for (int i = 1; i <= gap + 1; i++) {//gán link cho các trang sau trang index
                if (pageindex + i <= pagecount) {
                    result += hyperlink("" + (pageindex + i), href + (pageindex + i));
                }
            }
        } else {
            if (pageindex > gap + 1) { //nếu chọn trang cách trang first <=2 thì first  xuất hiện
                result += hyperlink("first", href + 1);
            }

            for (int i = gap; i > 0; i--) {
                if (pageindex - i > 0) {
                    result += hyperlink("" + (pageindex - i), href + (pageindex - i));
                }
            }

            result += "<div class=\"numberpage\">" + pageindex + "</div>";

            for (int i = 1; i <= gap; i++) { //gán link cho các trang sau trang index
                if (pageindex + i <= pagecount) {
                    result += hyperlink("" + (pageindex + i), href + (pageindex + i));
                }
            }

            if (pageindex + gap < pagecount) { //disiplay last page
                result += hyperlink("last", href + pagecount);
            }
        }
        return result;
    }
    public static String pagerGallery(int pageindex, int pagecount, int gap,int idGalery) {//
        String result = "";
        String href = "detail?idGallery="+idGalery+"&page=";
        if (pagecount <= 4) { //nếu số trang nhỏ hơn 4 sẽ k hiển thị first và last
            for (int i = gap + 1; i > 0; i--) {
                if (pageindex - i > 0) { //gán link cho các trang trước trang index
                    result += hyperlink("" + (pageindex - i), href + (pageindex - i));
                }
            }

            result += "<div class=\"numberpage\">" + pageindex + "</div>";//trang index k đc phép để link
            for (int i = 1; i <= gap + 1; i++) {//gán link cho các trang sau trang index
                if (pageindex + i <= pagecount) {
                    result += hyperlink("" + (pageindex + i), href + (pageindex + i));
                }
            }
        } else {
            if (pageindex > gap + 1) { //nếu chọn trang cách trang first <gap+1 thì first  xuất hiện(gap laf khoangr cacsh từ index đến các trang 2 bên)
                result += hyperlink("first", href + 1);
            }

            for (int i = gap; i > 0; i--) {
                if (pageindex - i > 0) {
                    result += hyperlink("" + (pageindex - i), href + (pageindex - i));
                }
            }

            result += "<div class=\"numberpage\">" + pageindex + "</div>";

            for (int i = 1; i <= gap; i++) { //gán link cho các trang sau trang index
                if (pageindex + i <= pagecount) {
                    result += hyperlink("" + (pageindex + i), href + (pageindex + i));
                }
            }

            if (pageindex + gap < pagecount) { //disiplay last page
                result += hyperlink("last", href + pagecount);
            }
        }
        return result;
    }
    
   
}
