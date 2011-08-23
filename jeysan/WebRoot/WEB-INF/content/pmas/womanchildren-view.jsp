<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<form class="pageForm">
		<div class="pageFormContent" layoutH="56">
			<div style="float: left; width: 98%;">
				<div style="float: left; width: 48%; margin: 2px">

					<div class="tabs" currentIndex="0" eventType="click">
						<div class="tabsHeader">
							<div class="tabsHeaderContent">
								<ul>
									<li>
										<a href="javascript:;"><span>${person.sex==1?'父亲':'母亲'}信息</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="tabsContent" style="height: 160px;">
							<div>
								<p>
									<label>
										姓名(${person.personCode})：
									</label>
									<input type="text" size="30" value="${person.nameh}"
										readonly="readonly" />
								</p>
								<p>
									<label>
										出生日期：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="<fmt:formatDate value="${person.personBasic.birthday}" pattern="yyyy-MM-dd"/>" />
								</p>
								<p>
									<label>
										年龄：
									</label>
									<input type="text" size="30" value="${person.age}"
										readonly="readonly" />
								</p>
								<p>
									<label>
										证件号码(
										<tags:js.dict.getValue value="${person.certType}" />
										)：
									</label>
									<input type="text" size="30" value="${person.code}"
										readonly="readonly" />
								</p>
								<p>
									<label>
										户口类别：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="<tags:js.dict.getValue value="${person.domicileType}"/>" />
								</p>

							</div>
						</div>
						<div class="tabsFooter">
							<div class="tabsFooterContent"></div>
						</div>
					</div>


				</div>
				<div
					style="float: left; width: 48%;margin: 2px">
					<div class="tabs" currentIndex="0" eventType="click">
						<div class="tabsHeader">
							<div class="tabsHeaderContent">
								<ul>
									<li>
										<a href="javascript:;"><span>${person.sex==2?'父亲':'母亲'}信息</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="tabsContent" style="height: 160px;">
							<div>
								<p>
									<label>
										姓名：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="${spouse.nameh}" />
								</p>


								<p>
									<label>
										出生日期：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="<fmt:formatDate value="${spouse.birthday}" pattern="yyyy-MM-dd"/>" />
								</p>

								<p>
									<label>
										年龄：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="${spouse.age}" />
								</p>

								<p>
									<label>
										身份证号码：
									</label>
									<input readonly="readonly type=" text"  ize="30"
										value="${spouse.code}" />
								</p>

								<p>
									<label>
										户口类别：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="<tags:js.dict.getValue value="${spouse.domicileType}"/>" />
								</p>

							</div>
						</div>
						<div class="tabsFooter">
							<div class="tabsFooterContent"></div>
						</div>
					</div>

				</div>
			</div>

			<div style="float: left; width: 150%;margin-top:5px">
				<div class="tabs" currentIndex="0" eventType="click">
					<div class="tabsHeader">
						<div class="tabsHeaderContent">
							<ul>
								<li>
									<a
										href="${ctx}/pmas/womanchildren!multiplysubs.action?personId=${person.id}"
										class="j-ajax"><span>子女信息</span> </a>
								</li>
							</ul>
						</div>
					</div>
					<div class="tabsContent" style="height: 231px;">
						<div></div>
					</div>
					<div class="tabsFooter">
						<div class="tabsFooterContent"></div>
					</div>
				</div>
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
