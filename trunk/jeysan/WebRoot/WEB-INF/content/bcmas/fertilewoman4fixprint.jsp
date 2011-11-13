<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/print/Export.jsp" %>
<form method="POST" action="../printReport/--WEBBOT-SELF--">
<style type="text/css">
<!--
	table tr td {font-size:12px}
  .limitedwidth {width:977px;height:610px;}
  .In1-table1 {  border: 2px #000000 solid;}
  .In1-td-right {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px}
  .In1-td-leftbottom {  border-color: black black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 1px}
  .In1-td-topbottom2right {  border-color: #000000 black black; border-style: solid; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-topbottom2 {  border-color: black black black #000000; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-bottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px}
  .In1-td-rightbottom {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 0px}
  .In1-td-bottom2 {  border-color: black black #000000; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 2px; border-left-width: 0px}
  .In1-td-top {  border-color: black black #000000; border-style: solid; border-top-width: 2px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px}
  .title_black { font-size: 18px;font-weight: bold;font-family: "宋体";}
  .none { font-size:12px }
 -->
 </style>
<div style="margin:5px;">
<table border="0" cellpadding="0" cellspacing="0" class="limitedwidth">
  		<tr>
  		  <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
  		    <tr>
  		      <td width="529" height="591" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  		        <tr>
  		          <td height="30" colspan="6" align="center" valign="middle" class="title_black">育龄妇女信息卡</td>
	            </tr>
  		        <tr>
  		          <td width="16%" height="24">流动人口编号：</td>
  		          <td width="16%">&nbsp;${model.code}</td>
  		          <td width="16%">婚嫁与统计：</td>
  		          <td width="16%">&nbsp;</td>
  		          <td width="16%">建卡日期：</td>
  		          <td width="16%">&nbsp;<fmt:formatDate value="${model.createDate}" pattern="yyyy-MM-dd"/></td>
	            </tr>
	          </table>
  		        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
  		          <tr>
  		            <td height="300" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  		              <tr>
  		                <td width="50%" height="20" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">户籍地</td>
  		                <td width="50%" colspan="2" align="center" valign="middle" class="In1-td-bottom">&nbsp;&nbsp;现居住地(门牌号码)</td>
	                  </tr>
  		              <tr>
  		                <td width="20" height="20" align="center" class="In1-td-rightbottom">妇</td>
  		                <td width="230" class="In1-td-rightbottom">&nbsp;${model.person.personBasic.domicile}</td>
  		                <td width="20" align="center" class="In1-td-rightbottom">妇</td>
  		                <td width="230" class="In1-td-bottom">&nbsp;${model.person.personBasic.address}</td>
	                  </tr>
  		              <tr>
  		                <td height="20" align="center" class="In1-td-rightbottom">夫</td>
  		                <td class="In1-td-rightbottom">&nbsp;${spouse.domicile}</td>
  		                <td align="center" class="In1-td-rightbottom">夫</td>
  		                <td class="In1-td-bottom">&nbsp;${spouse.address}</td>
	                  </tr>
	                </table>
  		              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		                <tr>
  		                  <td height="20" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">姓名</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">民族</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">文化程度</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">政策面貌</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">户口性质</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">职业</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">是否独生</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">身份证号码</td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">工作单位</td>
	                    </tr>
  		                <tr>
  		                  <td width="20" height="20" align="center" valign="middle" class="In1-td-rightbottom">妇</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${model.nameh}</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.native}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.edu}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.politicalStatus}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.househodeKind}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${model.person.personBasic.job}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.yes.no.getValue value="${model.person.personBasic.isSingle}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${model.person.code}</td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">&nbsp;${model.person.personBasic.company}</td>
	                    </tr>
  		                <tr>
  		                  <td height="20" align="center" valign="middle" class="In1-td-rightbottom">夫</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${spouse.nameh}</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${spouse.native}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${spouse.edu}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${spouse.politicalStatus}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${spouse.househodeKind}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${spouse.job}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.yes.no.getValue value="${spouse.isSingle}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${spouse.code}</td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">&nbsp;${spouse.company}</td>
	                    </tr>
                    </table>
  		              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-td-bottom">
  		                <tr>
  		                  <td width="14%" height="20" align="center" valign="middle">夫婚姻状态：</td>
  		                  <td width="12%" valign="middle">&nbsp;<tags:js.dict.getValue value="${spouse.marryStatus}"/></td>
  		                  <td width="14%" align="center" valign="middle">妇婚姻状态：</td>
  		                  <td width="12%" valign="middle">&nbsp;<tags:js.dict.getValue value="${model.womanBasic.marryStatus}"/></td>
  		                  <td width="12%" align="center" valign="middle">初婚日期：</td>
  		                  <td width="12%" valign="middle">&nbsp;<fmt:formatDate value="${model.womanBasic.firstMarryDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td width="12%" align="center" valign="middle">婚变日期：</td>
  		                  <td width="12%" valign="middle">&nbsp;<fmt:formatDate value="${model.womanBasic.marryCryDate}" pattern="yyyy-MM-dd"/></td>
	                    </tr>
                    </table>
  		              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		                <tr>
  		                  <td width="76" height="32" align="center" valign="middle" class="In1-td-right">领光荣证日期</td>
  		                  <td valign="middle" class="In1-td-right">&nbsp;安排二孩原因：${model.womanBasic.planChild2Cause}</td>
  		                  <td valign="middle" class="In1-td-right">&nbsp;安排再生原因：${model.womanBasic.planBear2Cause}</td>
  		                  <td width="122" align="center" valign="middle">领流动证类型、日期</td>
	                    </tr>
  		                <tr>
  		                  <td height="33" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${model.womanBasic.getGrzDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td valign="middle" class="In1-td-rightbottom">&nbsp;安排二孩日期：<fmt:formatDate value="${model.womanBasic.planChild2Date}" pattern="yyyy-MM-dd"/></td>
  		                  <td valign="middle" class="In1-td-rightbottom">&nbsp;安排再生日期：<fmt:formatDate value="${model.womanBasic.planBear2Date}" pattern="yyyy-MM-dd"/></td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">&nbsp;${model.womanBasic.getLdzType}&nbsp;<fmt:formatDate value="${model.womanBasic.getLdzDate}" pattern="yyyy-MM-dd"/></td>
	                    </tr>
	                  </table>
                      
                      
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
  		                <tr>
  		                  <td width="5%" height="40" align="center" class="In1-td-bottom">健康<br/>状况</td>
  		                  <td width="11%" align="center" class="In1-td-rightbottom">&nbsp;${model.womanBasic.healthStatus}</td>
  		                  <td width="5%" align="center" class="In1-td-bottom">何地<br/>迁入</td>
  		                  <td width="11%" align="center" class="In1-td-rightbottom">&nbsp;${model.person.settleInPlace}</td>
  		                  <td width="5%" align="center" class="In1-td-bottom">迁入<br/>日期</td>
  		                  <td width="11%" align="center" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${model.person.settleInDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td width="5%" align="center" class="In1-td-bottom">迁入<br/>原因</td>
  		                  <td width="11%" align="center" class="In1-td-rightbottom">&nbsp;${model.person.settleInCause}</td>
  		                  <td width="5%" align="center" class="In1-td-bottom">注销<br/>类型</td>
  		                  <td width="11%" align="center" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${model.person.cancelType}"/></td>
  		                  <td width="5%" align="center" class="In1-td-bottom">注销<br/>日期</td>
  		                  <td width="11%" align="center" class="In1-td-bottom">&nbsp;<fmt:formatDate value="${model.person.cancelDate}" pattern="yyyy-MM-dd"/></td>
	                    </tr>
  		                <tr>
  		                  <td height="20" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">教育类型</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">青春期</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">新婚期</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">孕产期</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">育儿期</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-bottom">更年期</td>
	                    </tr>
  		                <tr>
  		                  <td height="20" colspan="2" align="center" valign="middle" class="In1-td-rightbottom">教育日期</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${wfp_map.wfp225.eduDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${wfp_map.wfp226.eduDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${wfp_map.wfp227.eduDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatDate value="${wfp_map.wfp228.eduDate}" pattern="yyyy-MM-dd"/></td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-bottom">&nbsp;<fmt:formatDate value="${wfp_map.wfp229.eduDate}" pattern="yyyy-MM-dd"/></td>
	                    </tr>
  		                <tr>
  		                  <td height="20" colspan="2" align="center" valign="middle" class="In1-td-right">教育地点</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-right">&nbsp;${wfp_map.wfp225.eduAddress}</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-right">&nbsp;${wfp_map.wfp226.eduAddress}</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-right">&nbsp;${wfp_map.wfp227.eduAddress}</td>
  		                  <td colspan="2" align="center" valign="middle" class="In1-td-right">&nbsp;${wfp_map.wfp228.eduAddress}</td>
  		                  <td colspan="2" align="center" valign="middle">&nbsp;${wfp_map.wfp229.eduAddress}</td>
	                    </tr>
	                  </table>
                      
  		              </td>
	              </tr>
              </table>
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" align="center" class="title_black">计划生育系列保险</td>
  </tr>
</table>
   
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
  		                
  		                <tr>
  		                  <td width="17%" height="20" align="center" valign="middle" class="In1-td-rightbottom">投保类型</td>
  		                  <td width="17%" align="center" valign="middle" class="In1-td-rightbottom">投保年月</td>
  		                  <td width="17%" align="center" valign="middle" class="In1-td-rightbottom">投保金额</td>
  		                  <td width="17%" align="center" valign="middle" class="In1-td-rightbottom">投保类型</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">投保年月</td>
  		                  
  		                  <td width="16%" align="center" valign="middle" class="In1-td-bottom">投保金额</td>
	                    </tr>
  		                <tr>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${wbas[0].typeh}"/></td>
  		                  <td height="20" align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${wbas[0].dateh}</td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<fmt:formatNumber value="${wbas[0].moneyh}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;<tags:js.dict.getValue value="${wbas[1].typeh}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-rightbottom">&nbsp;${wbas[1].dateh}</td>
  		                  <td align="center" valign="middle" class="In1-td-bottom">&nbsp;<fmt:formatNumber value="${wbas[1].moneyh}" type="currency" pattern="￥.00"/></td>
	                    </tr>
  		                <tr>
  		                  <td align="center" valign="middle" class="In1-td-right">&nbsp;<tags:js.dict.getValue value="${wbas[2].typeh}"/></td>
  		                  <td height="20" align="center" valign="middle" class="In1-td-right">&nbsp;${wbas[2].dateh}</td>
  		                  <td align="center" valign="middle" class="In1-td-right">&nbsp;<fmt:formatNumber value="${wbas[2].moneyh}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="In1-td-right">&nbsp;<tags:js.dict.getValue value="${wbas[3].typeh}"/></td>
  		                  <td align="center" valign="middle" class="In1-td-right">&nbsp;${wbas[3].dateh}</td>
  		                  <td align="center" valign="middle">&nbsp;<fmt:formatNumber value="${wbas[3].moneyh}" type="currency" pattern="￥.00"/></td>
	                    </tr>
                    </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" align="center" class="title_black">社会抚养费缴交情况</td>
  </tr>
</table> 
           <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
  		                
  		                <tr>
  		                  <td width="30%" height="20" align="center" valign="middle" class="In1-td-rightbottom">缴交原因</td>
  		                  <td width="6%" align="center" valign="middle" class="In1-td-rightbottom">次数</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">应交金额</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">本次缴交金额</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-rightbottom">交款日期</td>
  		                  <td width="16%" align="center" valign="middle" class="In1-td-bottom">收款人</td>
	                    </tr>
<c:forEach var="a" items="${wsu.detailList}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="20" align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;${wsu.cause}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;${wsu.installmentNum}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${wsu.totalMoney}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatNumber value="${a.factMoney}" type="currency" pattern="￥.00"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.dateh}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="5" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.charger}</td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(wsu.detailList)<5}">
<c:set var="tmpRows" value="${5-(fn:length(wsu.detailList))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="20" class="<tagsold:getCss columns="6" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="5" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table>
              </td><td width="20">&nbsp;</td><td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="30" colspan="3" align="center" valign="middle" class="title_black">&nbsp;</td>
                </tr>
                <tr>
                  <td width="70" height="24" valign="middle">联系电话：</td>
                  <td width="90" valign="middle" class="title_black">&nbsp;${model.person.personBasic.tel}</td>
                  <td valign="middle" class="title_black">孕产动态</td>
                </tr>
              </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
                  <tr>
                    <td height="26" align="center" valign="middle" class="In1-td-rightbottom">怀孕政策属性</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">怀孕日期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">孕产结果</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">怀孕终止日期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">终止手术地点</td>
                    <td align="center" valign="middle" class="In1-td-bottom">变化原因</td>
                  </tr>
<c:forEach var="a" items="${wms}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="24" align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.conceptPolicy}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.conceptDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.matenalResult}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.endDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.hospital}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="6" columnIndex="5" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.changeCause}</td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(wms)<5}">
<c:set var="tmpRows" value="${5-(fn:length(wms))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="24" class="<tagsold:getCss columns="6" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="6" columnIndex="5" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="30" align="center" valign="middle" class="title_black">避孕动态</td>
                </tr>
              </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
                  <tr>
                    <td height="26" align="center" valign="middle" class="In1-td-rightbottom">避孕节育措施</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">手术日期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">医院名称</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">变化原因</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">未避孕原因</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">避孕终止日期</td>
                    <td align="center" valign="middle" class="In1-td-bottom">医院类型</td>
                  </tr>
                  <c:forEach var="a" items="${wcs}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="23" align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.method}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.opsDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.hospital}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.changeCause}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.noCause}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="5" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.endDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="7" columnIndex="6" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.hospitalType}"/></td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(wcs)<5}">
<c:set var="tmpRows" value="${5-(fn:length(wcs))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="23" class="<tagsold:getCss columns="7" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="5" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="7" columnIndex="6" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="30" align="center" valign="middle" class="title_black">子女状况</td>
                </tr>
              </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="In1-table1">
                  <tr>
                    <td height="26" align="center" valign="middle" class="In1-td-rightbottom">姓名</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">性别</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">出生日期</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">政策内外</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">孩次</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">出生证号</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">健康状况</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">血缘关系</td>
                    <td align="center" valign="middle" class="In1-td-rightbottom">变化日期</td>
                    <td align="center" valign="middle" class="In1-td-bottom">变化原因</td>
                  </tr>

                  <c:forEach var="a" items="${childs}" varStatus="b" begin="0" end="4">
  		                <tr>
  		                  <td height="35" align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="0" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.nameh}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="1" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.sex}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="2" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="3" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.policy}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="4" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.childIndex}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="5" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.birthCert}</td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="6" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.healthStatus}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="7" rows="5" rowIndex="${b.index}"/>">&nbsp;<tags:js.dict.getValue value="${a.kinship}"/></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="8" rows="5" rowIndex="${b.index}"/>">&nbsp;<fmt:formatDate value="${a.changeDate}" pattern="yyyy-MM-dd" /></td>
  		                  <td align="center" valign="middle" class="<tagsold:getCss columns="10" columnIndex="9" rows="5" rowIndex="${b.index}"/>">&nbsp;${a.changeCause}</td>
	                    </tr>
</c:forEach>
<c:if test="${fn:length(childs)<5}">
<c:set var="tmpRows" value="${5-(fn:length(childs))}"/>
<c:forEach begin="0" end="${tmpRows-1}" varStatus="b">
     <tr>
       <td height="35" class="<tagsold:getCss columns="10" columnIndex="0" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="1" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="2" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="3" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="4" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="5" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="6" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="7" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="8" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
       <td class="<tagsold:getCss columns="10" columnIndex="9" rows="${tmpRows}" rowIndex="${b.index}"/>">&nbsp;</td>
     </tr>
</c:forEach>
</c:if>
                </table></td>
	        </tr>
  		    <tr>
  		      <td height="22" colspan="3">&nbsp;备注</td>
	        </tr>
      </table></td></tr>	
    </table>
</div>
</form>