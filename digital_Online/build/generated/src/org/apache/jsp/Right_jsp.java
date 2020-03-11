package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Right_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_end_begin.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <title>Right</title>\n");
      out.write("            <link href=\"css/right.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <div class=\"right\">\n");
      out.write("                <div class=\"newst\">\n");
      out.write("                    <div class=\"titleNews\">\n");
      out.write("                        <span>Digital News</span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"contentNews\">\n");
      out.write("                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, \n");
      out.write("                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore \n");
      out.write("                        magna aliquam erat volutpat. Ut wisi enim ad minim veniam, \n");
      out.write("                        quis nostrud exerci tation ullamcorper suscipit lobortis \n");
      out.write("                        nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor \n");
      out.write("                        sit amet, consectetuer adipiscing elit, sed diam nonummy nibh \n");
      out.write("                        euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.\n");
      out.write("                        Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper \n");
      out.write("                        suscipit lobortis nisl ut aliquip ex ea commodo consequat.Lorem \n");
      out.write("                        ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy \n");
      out.write("                        nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.\n");
      out.write("                        Xin chao thay tuan\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"newst\">\n");
      out.write("                    <div class=\"titleNews\">\n");
      out.write("                        Search\n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"SearchResultPage.jsp\" method=\"post\">\n");
      out.write("                        <input class=\"searchBox\" type=\"text\" name=\"txtSearch\" size=\"15\"  required>\n");
      out.write("                        <input class=\"searchButton\" type=\"submit\" name=\"btnGo\" value=\"Go\">\n");
      out.write("                    </form>                        \n");
      out.write("                </div>\n");
      out.write("                <div class=\"newst\">\n");
      out.write("                    <div class=\"titleNews\">\n");
      out.write("                        <span>Last Articles</span><br>\n");
      out.write("                    </div>\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setBegin(1);
    _jspx_th_c_forEach_0.setEnd(5);
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <div class=\"lastArticles\">\n");
          out.write("                        <a href=\"Detail.jsp\">Day la bai so 1</a>\n");
          out.write("                    </div>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
