<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="org.springframework.context.ApplicationContext,
                 org.springframework.web.context.WebApplicationContext,
                 com.jeysan.cpf.district.service.DistrictProvinceManager,
                 java.util.List" %>
<%@ attribute name="onChange"	type="java.lang.String"	required="false" description="当值改变时的请求行为" %>
<%	try{	
			ApplicationContext applicationContext=(ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			DistrictProvinceManager districtProvinceManager = applicationContext.getBean("districtProvinceManager",DistrictProvinceManager.class);
			
			String key = "districtProvince";
			List provinces = (List)request.getAttribute(key);
			if(provinces==null){
				provinces = districtProvinceManager.getAll();
				request.setAttribute(key,provinces);
			}
	}catch(Exception e){
		//e.printStackTrace();
	}
%>
<c:choose>
<c:when test="${empty _c_}">
<c:set var="_c_" value="1" scope="request"></c:set>
</c:when>
<c:otherwise>
<c:set var="_c_" value="${_c_+1}" scope="request"></c:set>
</c:otherwise>
</c:choose>
<table cellpadding="0" cellspacing="0" border="0">
<tr>
<td><select style="width:160px" id="district_province_${_c_}" onChange="setDistrict${_c_}(this,1)">
		<option value="">所有省市</option>
		<c:forEach var="a" items="${districtProvince}">
		<option value="${a.id}_${a.code}">${a.name}</option>
		</c:forEach>
	</select>~</td>
<td><select style="width:160px" id="district_city_${_c_}" onChange="setDistrict${_c_}(this,2)">
		<option value="">所有城市</option>
	</select>~</td>
<td><select style="width:160px" id="district_county_${_c_}" onChange="setDistrict${_c_}(this,3)">
		<option value="">所有区县</option>
	</select>~</td>
<td><select style="width:160px" id="district_town_${_c_}" onChange="setDistrict${_c_}(this,4)">
		<option value="">所有街镇</option>
	</select>~</td>
<td><select style="width:160px" id="district_village_${_c_}" onChange="setDistrict${_c_}(this,5)">
		<option value="">所有行政村</option>
	</select></td>
</tr>
</table>
<script>
function setDistrict${_c_}(obj,type){
	if(type < 5){
		$.post("${ctx}/district/district"+districts[type-1][0]+"!findSubs.action", {id:obj.value.split('_')[0]}, function(data) {
			var html = "<option value=\"\">所有";
			html += districts[type][1];
			html += "</option>";
			for (var i = 0; i < data.length; i++) {
				html += "<option value=\"" + data[i].id+"_"+data[i].code+ "\">" + data[i].name + "</option>";
			}
			$("#district_"+districts[type][0]+"_${_c_}").html(html);//alert(districts[type][0]+"**"+obj.value);
			if(obj.value == ""){
				initNonData(${_c_},type);
			}else
				initNonData(${_c_},type+1);
			<c:if test="${not empty onChange}">
			${onChange}(obj,getAddress(${_c_}),type);
			</c:if>
		});
	}else if(type == 5){
		<c:if test="${not empty onChange}">
		${onChange}(obj,getAddress(${_c_}),type);
		</c:if>
	}
}
<c:if test="${_c_ == 1}">
//行政区划选择框
var districts = new Array(["province","省"],["city","城市"],["county","区县"],["town","街镇"],["village","行政村"]);

function getAddress(index){
	var address_ = '';
	var $select = null;
	for (var i = 0; i < districts.length; i++) {
		$select = $("#district_"+districts[i][0]+"_"+index);
		if($select.val()!=null&&$select.val()!=''){
			address_ += $("option:selected",$select).text();
		}
	}
	return address_;
}
function initNonData(index,type){
	for(var i=type+1;i<=5;i++){
		$("#district_"+districts[i-1][0]+"_"+index).html("<option value=\"\">所有"+districts[i-1][1]+"</option>");
	}
}
</c:if>

</script>