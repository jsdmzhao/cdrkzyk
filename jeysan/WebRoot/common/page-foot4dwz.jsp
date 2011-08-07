<%@ page language="java"  contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="panelBar">
			<div class="pages">
				<span>显示</span>
				<select class="combox" name="numPerPage" param="numPerPage" change="dwzPageBreak({targetType:'dialog', numPerPage:this.value})">
					<option value="10" <c:if test="${page.pageSize==10}">selected="selected"</c:if>>10</option>
					<option value="15" <c:if test="${page.pageSize==15}">selected="selected"</c:if>>15</option>
					<option value="20" <c:if test="${page.pageSize==20}">selected="selected"</c:if>>20</option>
					<option value="50" <c:if test="${page.pageSize==50}">selected="selected"</c:if>>50</option>
					<option value="100" <c:if test="${page.pageSize==100}">selected="selected"</c:if>>100</option>
				</select>
				<span>条，共${page.totalCount}条，共${page.totalPages}页</span>
			</div>
			
			<div class="pagination" targetType="dialog" totalCount="${page.totalCount}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.pageNo}"></div>
</div>
			