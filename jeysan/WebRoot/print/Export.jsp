<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<%
    String operation = request.getParameter("operation");
    if(StringUtils.isNotEmpty(operation)&&operation.equals("export")){
      response.setContentType("application/msexcel;charset=utf-8");
      response.setHeader("Content-Disposition",";filename=report101.xls");
      out.println("<META http-equiv=Content-Type content=\"application/msexcel; charset=utf-8\">");
    }
%>

<script language="javascript" src="${ctx}/print/CheckActivX.js"></script>
<OBJECT  ID="LODOP" CLASSID="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" WIDTH=0 HEIGHT=0> </OBJECT>
<script language="javascript">CheckLodop();</script>
<script language='javascript'>
    function hjPrint(){
        CreateOneFormPage();
        LODOP.PRINT();
    }
    function hjPrintA(){
        CreateOneFormPage();
        LODOP.PRINTA();
    }
    function printPreview(){
        CreateOneFormPage();
        LODOP.PREVIEW();
    }
    function printSetting(){
        CreateOneFormPage();
        LODOP.PRINT_SETUP();
    }
    function CreateOneFormPage() {
    //    LODOP.SET_PRINT_PAPER(0,10, 795, 1414, "统计表");
        var forms = document.forms;
     //   for(var i=0;i<forms.length;i++){
     //       LODOP.ADD_PRINT_HTML(i*795, 0, 795, 1414, forms[i].innerHTML);
      //  }
        // LODOP.ADD_PRINT_HTML(0, 0, 2000, 1125, document.forms[0].innerHTML);
       // LODOP.ADD_PRINT_HTML(1125, 0, 2000, 1125, document.forms[1].innerHTML);
       // LODOP.ADD_PRINT_HTML(2250, 0, 2000, 1125, document.forms[2].innerHTML);
       	LODOP.PRINT_INIT("${param.title}");
       	for(var i=0;i<forms.length;i++){
       		<c:if test="${param.pager_type==null||param.pager_type=='A4'}">
       		LODOP.ADD_PRINT_HTM(0,20,350,1414,forms[i].innerHTML);
       		</c:if>
           	<c:if test="${param.pager_type=='A3'}">
           	LODOP.ADD_PRINT_HTM(0,-220,2000,1125,forms[i].innerHTML);
           	</c:if>
       		if(i != forms.length -1){
				LODOP.NewPage();
			}
       	}
    };
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