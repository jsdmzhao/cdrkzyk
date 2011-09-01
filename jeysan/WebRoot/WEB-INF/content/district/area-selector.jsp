<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					省：
				</label>
				<select>
					<option value="19_440000000000">
						广东省
					</option>
				</select>
			</p>
<div class="divider"></div>
			<p>
				<label>
					地（市）：
				</label>
				<select>
					<option value="207_440400000000">
						珠海市
					</option>
				</select>
			</p>
<div class="divider"></div>
			<p>
				<label>
					县（区、市）：
				</label>
				<select>
					<option value="2210_440472000000">
						高新技术产业开发区
					</option>
				</select>
			</p>
<div class="divider"></div>
			<p>
				<label>
					乡镇（街道）：
				</label>
				<select>
					<option value="26879_440472001000">
						唐家湾镇
					</option>
				</select>
			</p>
<div class="divider"></div>
			<p>
				<label>
					村（居委）：
				</label>
				<select id="village_in_area">
					<option value="">
						请选择
					</option>
					<c:forEach var="a" items="${villages}">
					<option value="${a.id}_${a.code}" <c:if test="${a.code==param.value}">selected="selected"</c:if>>
						${a.name}
					</option>
					</c:forEach>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="button" onclick="setVillageInArea()">
								确定
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
</div>
<script>
function setVillageInArea(){
	var $village_in_area = $('#village_in_area');
	var value = $village_in_area.val();
	if(value == null || value == '')
		return;
	var address_ = $("option:selected",$village_in_area).text();
	var $box = navTab.getCurrentPanel();
	$('#${param.label4id}',$box).val(value.split('_')[1]);
	$('#${param.label4name}',$box).val(address_);
	$.pdialog.closeCurrent();
	<c:if test="${not empty param.onChange}">
	${param.onChange}(value,address_);
	</c:if>
}
</script>