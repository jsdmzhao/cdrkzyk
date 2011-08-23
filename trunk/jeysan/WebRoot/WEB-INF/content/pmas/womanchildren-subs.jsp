<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<table class="table" width="100%" layouth="328">
			<thead>
				<tr>
					<th width="30" align="center">
						序号
					</th>
					<th width="80">
						姓名
					</th>
					<th width="80">
						性别
					</th>
					<th width="80">
						出生日期
					</th>
					<th width="80">
						出生地点
					</th>
					<th width="80">
						政策内外
					</th>
					<th width="80">
						政策外类型
					</th>
					<th width="80">
						孩次
					</th>
					<th width="80">
						出生证号
					</th>
					<th width="80">
						健康状况
					</th>
					<th width="80">
						血缘关系
					</th>
					<th width="80">
						变化日期
					</th>
					<th width="80">
						变化原因
					</th>
					<th width="80">
						出生医院名称
					</th>
					<th width="80">
						出生医院类
					</th>
					<th width="80">
						收养日期
					</th>
					<th width="80">
						收养证号
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${person.womanChildrenLst}" varStatus="b">
					<tr target="sid_xxx" rel="${a.id}">
						<td height="25">
							${b.index+1}
						</td>
						<td>
							${a.nameh}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.sex}"></tags:js.dict.getValue>
						</td>
						<td>
							<fmt:formatDate value="${a.birthday}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.birthAddress}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.policy}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.outType}"></tags:js.dict.getValue>
						</td>
						<td>
							${a.childIndex}
						</td>
						<td>
							${a.birthCert}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.healthStatus}"></tags:js.dict.getValue>
						</td>
						<td>
							<tags:js.dict.getValue value="${a.kinship}"></tags:js.dict.getValue>
						</td>
						<td>
							<fmt:formatDate value="${a.changeDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.changeCause}
						</td>
						<td>
							${a.hospital}
						</td>
						<td>
							<tags:js.dict.getValue value="${a.hospitalType}"></tags:js.dict.getValue>
						</td>
						<td>
							<fmt:formatDate value="${a.adoptDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${a.adoptCept}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>