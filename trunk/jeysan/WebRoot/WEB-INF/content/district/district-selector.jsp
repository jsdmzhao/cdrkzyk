<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="pageContent">
	<div class="pageFormContent" layoutH="56">
		<p>
			<label>
				省：
			</label>
			<select id="district_province_"
				onChange="setDistrict(this,1)">
				<option value="">
					请选择
				</option>
				<c:forEach var="a" items="${districtProvince}">
					<option value="${a.id}_${a.code}">
						${a.name}
					</option>
				</c:forEach>
			</select>
		</p>
<div class="divider"></div>
		<p>
			<label>
				地（市）：
			</label>
			<select id="district_city_"
				onChange="setDistrict(this,2)">
				<option value="">
					请选择
				</option>
			</select>
		</p>
<div class="divider"></div>
		<p>
			<label>
				县（区、市）：
			</label>
			<select id="district_county_"
				onChange="setDistrict(this,3)">
				<option value="">
					请选择
				</option>
			</select>
		</p>
<div class="divider"></div>
		<p>
			<label>
				乡镇（街道）：
			</label>
			<select id="district_town_"
				onChange="setDistrict(this,4)">
				<option value="">
					请选择
				</option>
			</select>
		</p>
<div class="divider"></div>
		<p>
			<label>
				村（居委）：
			</label>
			<select id="district_village_"
				onChange="setDistrict(this,5)">
				<option value="">
					请选择
				</option>
			</select>
		</p>
	</div>
	<div class="formBar">
		<ul>
			<li>
				<div class="buttonActive">
					<div class="buttonContent">
						<button type="button" onclick="setLocationInDistrict()">
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
function setDistrict(obj,type){
	if(type < 5){
		$.post("${ctx}/district/district"+districts[type-1]+"!findSubs.action", {id:obj.value.split('_')[0]}, function(data) {
			var html = "<option value=\"\">请选择</option>";
			for (var i = 0; i < data.length; i++) {
				html += "<option value=\"" + data[i].id+"_"+data[i].code+ "\">" + data[i].name + "</option>";
			}
			$("#district_"+districts[type]+"_").html(html);
			if(obj.value == ""){
				initNonData(type);
			}else
				initNonData(type+1);
		});
	}
}
//行政区划选择框
var districts = new Array("province","city","county","town","village");

function getAddress(){
	var address_ = '';
	var $select = null;
	for (var i = 0; i < districts.length; i++) {
		$select = $("#district_"+districts[i]+"_");
		if($select.val()!=null&&$select.val()!=''){
			address_ += $("option:selected",$select).text();
		}
	}
	return address_;
}
function getValue(){
	var value_ = null;
	var $select = null;
	for (var i = 4; i >= 0; i--) {
		$select = $("#district_"+districts[i]+"_");
		value_ = $select.val();
		if(value_!=null&&value_!='')
			break;
	}
	return value_;
}
function initNonData(type){
	for(var i=type+1;i<=5;i++){
		$("#district_"+districts[i-1]+"_").html("<option value=\"\">请选择</option>");
	}
}
function setLocationInDistrict(){
	var value = getValue();
	if(value == null || value == '')
		return;
	var $box = navTab.getCurrentPanel();
	var address_ = getAddress();
	$('#${param.label4id}',$box).val(value.split('_')[1]);
	$('#${param.label4name}',$box).val(address_);
	$.pdialog.closeCurrent();
	<c:if test="${not empty param.onChange}">
	<c:if test="${not empty param.type}">
	${param.onChange}($("#district_"+districts[${param.type}-1]+"_").val(),address_);
	</c:if>
	</c:if>
}
</script>