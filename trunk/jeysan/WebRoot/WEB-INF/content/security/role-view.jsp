<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56"
				style="width: 400px; float: left">
				<p>
					<label>
						角色编码：
					</label>
					<input name="roleCode" readonly="readonly" type="text" size="30"
						value="${roleCode}" />
				</p>
				<p>
					<label>
						角色名称：
					</label>
					<input name="roleName" readonly="readonly" type="text" size="30"
						value="${roleName}" />
				</p>
				<p>
					<label>
						是否启用：
					</label>
					<input name="roleEnable" readonly="readonly" type="text" size="30"
						value="<tags:js.yes.no.getValue value="${roleEnable}"/>" />
				</p>
				<p>
					<label>
						是否受限：
					</label>
					<input name="roleIslimited" readonly="readonly" type="text" size="30"
						value="<tags:js.yes.no.getValue value="${roleIslimited}"/>" />
				</p>

				<div class="divider"></div>
				<p>
					<label>
						角色描述：
					</label>
					<textarea name="roleInfo" readonly="readonly" cols="23" rows="5">${roleInfo}</textarea>
				</p>


			</div>
			<div style="float: left; width: 260px; margin-left: 20px">
				<div>
					<h2 class="contentTitle" style="width: 200px">
						已分配资源
					</h2>
				</div>
				<div id="allResources"
					style="float: left; display: block; overflow: auto; width: 250px; height: 400px; border: solid 1px #CCC; line-height: 21px; background: #FFF;">
					<ul class="tree treeFolder expand">
						<c:forEach items="${hasResources}" var="a" varStatus="b">
							<li>
								<a tname="checkedResourceIds_" tvalue="${a.key.id}">${a.key.resourceName}</a>
								<ul>
									<c:forEach items="${a.value}" var="c" varStatus="d">
										<li>
											<a tname="checkedResourceIds" tvalue="${c.id}">${c.resourceName}</a>
										</li>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="Button" onclick="navTab.closeCurrentTab()">
									取消
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>
