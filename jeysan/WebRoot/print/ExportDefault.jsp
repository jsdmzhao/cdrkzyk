<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%
    String operation = request.getParameter("operation");
    if(StringUtils.isNotEmpty(operation)&&operation.equals("export")){
      response.setContentType("application/msexcel;charset=gb2312");
      response.setHeader("Content-Disposition",";filename=report101.xls");
      out.println("<META http-equiv=Content-Type content=\"application/msexcel; charset=gb2312\">");
    }
%>

<OBJECT id=WebBrowser classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 height=0 width=0> </OBJECT>
<script language='javascript'>
    function hjPrint(){
        pagesetup_null();
        WebBrowser.ExecWB(6,1);
    }
    function hjPrintA(){
        pagesetup_null();
        WebBrowser.ExecWB(6,6);
    }
    function printPreview(){
        pagesetup_null();
        WebBrowser.ExecWB(7,1);
    }
    function printSetting(){
        pagesetup_null();
        WebBrowser.ExecWB(8,1);
    }
    function pagesetup_null() {
        var hkey_root,hkey_path,hkey_key;
        hkey_root = "HKEY_CURRENT_USER"
        hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
        try {
            var RegWsh = new ActiveXObject("WScript.Shell");
            hkey_key = "header";
            RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "");
            hkey_key = "footer";
            RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "");
        } catch(e) {
        }
    }

</script>
<script defer>
    function document.onkeydown(DnEvents)
    {
        k = window.event.keyCode;
        if (k == 13)
        {
            if (confirm("是否直接打印？"))
            {
                hjPrintA();
            }
        }
        if (k == 32)
        {
            if (confirm("是否预览？"))
            {
                printPreview();
            }
        }
    }
</script>
