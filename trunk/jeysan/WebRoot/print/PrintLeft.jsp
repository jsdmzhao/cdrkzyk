<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 2008-11-18
  Time: 10:05:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
   <link href="../css/print1.css" type="text/css" rel="stylesheet"/>
	<link href="../css/css1.css" type="text/css" rel="stylesheet"/>
</head>
<script>
 var pager_type = 'A4';
</script>

<body leftmargin="0" topmargin="0">
<center>
  <table  width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr><td height="300" align="center" valign="top">

      </td></tr>
         <tr class="table_bgcolor_td2">
            <td height="30" >
                <input name="printSet" type="button" class="bottom_bg1" value="A3/A4切换" onclick="exchangePagerType()">
            </td>
        </tr>
       <tr><td>
           <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_bgcolor">
        <tr class="table_bgcolor_td2">
            <td height="30" align="center">
                <input name="printSetting" type="button" class="button" value="打印设置" onclick="printSetting()" style="width: 80px">
            </td>
        </tr>
        <tr class="table_bgcolor_td2">
            <td height="30"  align="center">
                <input name="printPreview" type="button" class="button" value="打印预览" onclick="printPreview()" style="width: 80px">
            </td>
        </tr>
        <tr class="table_bgcolor_td2">
            <td height="30"  align="center">
                <input name="printSetting" type="button" class="button" value="选择打印机" onclick="hjPrintA()" style="width: 80px">
            </td>
        </tr>
        <tr class="table_bgcolor_td2">
            <td height="30"  align="center">
                <input name="hjPrint" type="button" class="button" value="打 印" onclick="hjPrint()" style="width: 80px">
            </td>
        </tr>
         <tr class="table_bgcolor_td2">
            <td height="30" >
                <input name="printSet" type="button" class="bottom_bg1" value="Excel导出" onclick="exportExcel()">
            </td>
        </tr>
       <tr class="table_bgcolor_td2">
            <td height="30" align="center">
                <input name="closeB" type="button" class="button" value="关 闭" onclick="parent.close()" style="width: 80px">
            </td>
        </tr>
    </table>
      </td></tr>
      <tr><td>

      </td></tr>
      </table>

</center>
</body>
</html>
<script language='javascript'>
    function check() {
        var url = parent.printMainFrm.location.href ;
        if (url.indexOf("operation=export") == -1)
            return;
        else{
            alert("请先返回");
            history.back();
        }
    }
    function hjPrint(){
        check();
        parent.printMainFrm.hjPrint();
    }
    function hjPrintA(){
        check();
        parent.printMainFrm.hjPrintA();
    }
    function printPreview(){
       check();
       parent.printMainFrm.printPreview();
    }
    function printSetting(){
        check();
        parent.printMainFrm.printSetting();
    }
     function exportExcel(){
        var url = parent.printMainFrm.location.href ;
        parent.printMainFrm.location.href = url + ((url.indexOf("?")==-1)?"?":"&")+"operation=export";
    }
     function exchangePagerType(){
    	 var url = parent.printMainFrm.location.href ;
    	 var new_pager_type = (pager_type=='A3'?'A4':'A3');
    	 if(url.indexOf('pager_type='+pager_type) != -1){
         	 parent.printMainFrm.location.href = url.replace('pager_type='+pager_type,'pager_type='+new_pager_type);
         }else{
        	 parent.printMainFrm.location.href = url + ((url.indexOf("?")==-1)?"?":"&")+"pager_type="+new_pager_type;
         }
         pager_type = new_pager_type;
      }
</script>