﻿<%@ page contentType="text/html;charset=UTF-8"%>
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
										<a href="javascript:;"><span>母亲信息</span> </a>
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
									<input type="text" size="30" value="${fertileWoman.nameh}"
										readonly="readonly" />
								</p>
								<p>
									<label>
										出生日期：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="<fmt:formatDate value="${fertileWoman.person.personBasic.birthday}" pattern="yyyy-MM-dd"/>" />
								</p>
								<p>
									<label>
										年龄：
									</label>
									<input type="text" size="30" value="${fertileWoman.person.age}"
										readonly="readonly" />
								</p>
								<p>
									<label>
										证件号码：
									</label>
									<input type="text" size="30"
										value="${fertileWoman.person.code}" readonly="readonly" />
								</p>
								<p>
									<label>
										户口类别：
									</label>
									<input readonly="readonly" type="text" size="30"
										value="<tags:js.dict.getValue value="${fertileWoman.person.domicileType}"/>" />
								</p>

							</div>
						</div>
						<div class="tabsFooter">
							<div class="tabsFooterContent"></div>
						</div>
					</div>


				</div>
				<div style="float: left; width: 48%; margin: 2px">
					<div class="tabs" currentIndex="0" eventType="click">
						<div class="tabsHeader">
							<div class="tabsHeaderContent">
								<ul>
									<li>
										<a href="javascript:;"><span>父亲信息</span> </a>
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
									<input readonly="readonly" type="text" size="30"
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
			<div class="divider"></div>
			<div style="float: left; width: 98%;">
				<p>
					<label>
						姓名：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${fertileWoman.nameh}" />
				</p>
				<p>
					<label>
						妇女编码：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="${fertileWoman.code}" />
				</p>
				<p>
					<label>
						登记日期：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${dateh}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						是否再生一孩：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<tags:js.yes.no.getValue value="${isSecond}"/>" />
				</p>
				<p>
					<label>
						再生一孩条件：
					</label>
					<input readonly="readonly" type="text" size="30" value="${cond}" />
				</p>
				<p>
					<label>
						部门意见：
					</label>
					<input readonly="readonly" type="text" size="30" value="${deptOpt}" />
				</p>
				<p>
					<label>
						经办人：
					</label>
					<input readonly="readonly" type="text" size="30" value="${agent}" />
				</p>
				<p>
					<label>
						合同签署日期：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${assignDate}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						生育合同编号：
					</label>
					<input readonly="readonly" type="text" size="30" value="${code}" />
				</p>
				<p>
					<label>
						一孩预产期：
					</label>
					<input readonly="readonly" type="text" size="30"
						value="<fmt:formatDate value="${edd}" pattern="yyyy-MM-dd"/>" />
				</p>
				<p>
					<label>
						备注：
					</label>
					<input readonly="readonly" name="remark" type="text" size="30"
						value="${remark}" />
				</p>
			</div>
			<div class="divider"></div>
			<div style="float: left; width: 150%; margin-top: 5px">
				<div class="tabs" currentIndex="0" eventType="click">
					<div class="tabsHeader">
						<div class="tabsHeaderContent">
							<ul>
								<li>
									<a
										href="${ctx}/pmas/womanchildren!multiplysubs.action?personId=${fertileWoman.person.id}"
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