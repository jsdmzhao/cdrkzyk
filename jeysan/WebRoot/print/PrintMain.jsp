<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<frameset rows="*" cols="100,*" frameborder="1" border="1" framespacing="1" noresize>
  <frame src="${ctx }/print/PrintLeft.jsp" name="printleftFrm" scrolling="no"  noresize>
  <frameset rows="1000,*" frameborder="0" border="0" framespacing="0">
    <frame src='${url}'  name="printMainFrm" scrolling="yes" noresize >
  </frameset>
</frameset>
<noframes><body>

</body></noframes>
</html>
