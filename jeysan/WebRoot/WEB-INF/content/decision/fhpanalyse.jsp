<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="page">
	<div class="pageContent">
		<form class="pageForm">
			<div class="pageFormContent" layoutH="56">
				<div style="float:left; display:block; margin:10px;padding:10px; overflow:auto; width:90%; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<p>
						<a class="button" href="javascript:void(0)" onclick="JS_print('${ctx }/decision/fhpanalyse!stat_yffp.action','title')"><span>年度实有流动人口基本情况统计表</span></a>
					</p>
					<div class="divider"></div>
					<p>
						<a class="button" href="javascript:" target="navTab" rel="fhpanalyse_sub"><span>期间（年月）实有流动人口基本情况统计表</span></a>
					</p>
				</div>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>