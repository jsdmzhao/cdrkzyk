<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div id="allOrg" style="float:left;width:100%;height:370px;background-color:#ffffff;display:block; overflow:auto;line-height:21px; ">
						<ul class="tree treeFolder">
							<c:forEach items="${level1OrgList}" var="a" varStatus="b">
								<li><a tname="orgId" tvalue="${a.id}">${a.orgName}</a>
									<c:if test="${fn:length(a.orgList)>0}">
									<ul>
										<c:forEach items="${a.orgList}" var="c" varStatus="d">
										<li><a tname="orgId" tvalue="${c.id}">${c.orgName}</a>
											<c:if test="${fn:length(c.orgList)>0}">
											<ul>
												<c:forEach items="${c.orgList}" var="e" varStatus="f">
												<li><a tname="orgId" tvalue="${e.id}">${e.orgName}</a></li>
												</c:forEach>
											</ul>
											</c:if>
										</li>
										</c:forEach>
									</ul>
									</c:if>
								</li>
							</c:forEach>
						</ul>
				</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="setValue()">确定</button></div></div>
					</li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="$.pdialog.closeCurrent();">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>
<script>
function setValue(){
	var jscheckedname = null,jscheckedvalue = null;
	$("div.selected>a",$('#allOrg')).each(function(){
		jscheckedname = $(this).text();
		jscheckedvalue = $(this).attr('tvalue');
	});
	if(jscheckedname==null||jscheckedvalue==null){
		alertMsg.info('请选择机构');
		return;
	}
	//alert(jscheckedname+'**'+jscheckedvalue);
	$('#${o1}',$('#${o3}')).val(jscheckedvalue);
	$('#${o2}',$('#${o3}')).val(jscheckedname);
	$.pdialog.closeCurrent();
}
</script>