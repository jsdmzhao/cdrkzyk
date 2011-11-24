<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/js/scheduler/css/dhtmlxscheduler.css"/>
<script type="text/javascript" src="${ctx}/js/scheduler/js/dhtmlxscheduler.js"></script>
<script src="${ctx4doc}/dwz3/js/speedup.js" type="text/javascript"></script>
<script src="${ctx4doc}/dwz3/js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="${ctx4doc}/js/jscommon2.js" type="text/javascript"></script>
</head>
	<style type="text/css" media="screen">
		html, body{
			margin:0px;
			padding:0px;
			height:100%;
			overflow:hidden;
		}	
	</style>
	<script type="text/javascript" charset="utf-8">
		function addorupdate(ev) {
			var url = "";
			var startdate = formatDate(ev.start_date);
			var enddate = formatDate(ev.end_date);
			url += "${ctx}/daily/todolist!save.action?id=" + ev.id 
			+ "&startTime=" + startdate 
			+ "&endTime=" + enddate 
			+ "&title=" + encodeURI(ev.text)
			+ "&detail=" + encodeURI(ev.details);
			$.get(url); 
		}
		
		function delEvent(id){
			$.get("${ctx}/daily/todolist!delete.action?id=" + id);
		}
				
		function init() {
			scheduler.config.xml_date="%Y-%m-%d %H:%i";
			scheduler.init('scheduler_here',null,'month');
			//scheduler.load("${ctx}/js/scheduler/common/events.xml");
			scheduler.load("${ctx}/daily/todolist!input.action?"+new Date());
		}
	</script>
</head>


<body onload="init();">
	<div id="scheduler_here" class="dhx_cal_container" style='width:100%; height:100%;'>
		<div class="dhx_cal_navline">
			<div class="dhx_cal_prev_button">&nbsp;</div>
			<div class="dhx_cal_next_button">&nbsp;</div>
			<div class="dhx_cal_today_button"></div>
			<div class="dhx_cal_date"></div>
			<div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
			<div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
			<div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
		</div>
		<div class="dhx_cal_header">
		</div>
		<div class="dhx_cal_data">
		</div>		
	</div>
</body>