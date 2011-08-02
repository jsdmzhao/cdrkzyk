<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<form method="post" action="${ctx}/security/role!saveAssignResources.action" onsubmit="return validateCallback(this)">
<input type="hidden" name="id" value="${entity.id}"/>
<div style="width:100%">

<div style="float:left;height:60px">
	<div style="margin:5px">
	角色名称：<input name="roleName" readonly="readonly" type="text" size="30" value="${entity.roleName}"/>
	角色编码：<input name="roleCode" readonly="readonly" type="text" size="30" value="${entity.roleCode}"/>
	</div>
	<div style="margin:5px">
	角色描述：<input name="roleInfo" readonly="readonly" type="text" size="80" value="${entity.roleInfo}"/>
	</div>
</div>

<div style="float:left;height:60px;">
	<div class="buttonActive" style="margin:20px 0 0 40px"><div class="buttonContent"><button type="submit">保存对应关系</button></div></div>
	<div class="button" style="margin:20px 0 0 20px"><div class="buttonContent"><button type="button" onclick="navTab.reload()">重置</button></div></div>
	<div class="button" style="margin:20px 0 0 20px"><div class="buttonContent"><button type="button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
</div>

<div class="divider"></div>

<div style="float:left;width:260px;margin-left:30px">
	<div><h2 class="contentTitle" style="width:200px">可选资源</h2></div>
	<div id="allResources" style=" float:left; display:block; overflow:auto; width:250px;height:400px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
		<ul class="tree treeFolder treeCheck expand" oncheck="treeScan">
			<c:forEach items="${allResources}" var="a" varStatus="b">
				<li><a tname="checkedResourceIds_" tvalue="${a.key.id}">${a.key.resourceName}</a>
					<ul>
						<c:forEach items="${a.value}" var="c" varStatus="d">
						<li><a tname="checkedResourceIds" tvalue="${c.id}">${c.resourceName}</a></li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>

<div style="float:left;width:93px;text-align: center;height:71px;margin-top:150px" class="left2right"></div>

<div style="float:left;width:260px;margin-left:10px">
	<div><h2 class="contentTitle" style="width:200px">已选资源</h2></div>
	<div id="selectedResources" style=" float:left; display:block; overflow:auto; width:250px;height:400px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
		<ul class="tree treeFolder treeCheck expand" oncheck="treeScan">
			<c:forEach items="${allResources}" var="a" varStatus="b">
			<li><a tname="checkedResourceIds_" tvalue="${a.key.id}">${a.key.resourceName}</a>
				<ul>
					<c:if test="${hasResources!=null}">
						<c:if test="${hasResources[a.key]!=null}">
							<c:forEach items="${hasResources[a.key]}" var="c" varStatus="d">
							<li><a tname="checkedResourceIds" tvalue="${c.id}" checked="true">${c.resourceName}</a></li>
							</c:forEach>
						</c:if>
					</c:if>
				</ul>
			</li>
			</c:forEach>
		</ul>
	</div>
</div>

</div>
</form>

<script type="text/javascript">
function treeScan(){
	scanTree(true);
	scanTree(false);
}
function scanTree(isLeft){
	$('ul>li>ul',$(isLeft?'#allResources':'#selectedResources')).each(function(i){
		var $ul = $(this);
			$('>li',$ul).each(function(index){
				var $li = $(this);
				//alert($li.html());
				$('div.ckbox ',$li).each(function(){
					var $div = $(this);
					if($div.hasClass(isLeft?'checked':'unchecked'))
						addToRight(i,index,$li,isLeft);
				});
			});
	});
}
function addToRight(i,index,$li,isLeft){
	$($('ul>li>ul',$(isLeft?'#selectedResources':'#allResources')).get(i)).append($li);
}

</script>


