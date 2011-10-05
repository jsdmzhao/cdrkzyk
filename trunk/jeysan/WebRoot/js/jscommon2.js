/**
 * table表格class为list增加/减少一行tr,通用方法。
 * 如果table表格class为table，此方法要重写
 * @param type
 * @return
 */
function operateRow(type){//alert($("tr[target='subDictId']").html());
	var $box = navTab.getCurrentPanel();
	var length = $('#tr_list>tr',$box).length;
	if(type=='add'){
		var $tr = $($('#tr_list>tr',$box).get(0)).clone();
		resetTrContent($tr,length,true)
		$('#tr_list',$box).append($tr);
		$('table.list',$box).initUI().cssTable();
	}else if(type=='delete'){
		if(length<=1) return;
		var hasRemoved = false;
		if ($('#rowIndex',$box).size() != 0){
			var index = $('#rowIndex',$box).val();//var index = $('#rowIndex')[0].value;
			if(index!=null&&index!=-1){
				$('#tr_list>tr',$box).eq(index-1).remove();
				$('#rowIndex',$box).val(-1);
				hasRemoved = true;
				$('table.list',$box).initUI().cssTable();
				calculateNames($box);
			}
		}
		if(!hasRemoved) $('#tr_list>tr',$box).eq(length-1).remove();
	}
}
/**
 * 重新计算隐藏域的名称之前，
 * 清空tr的背景样式，因为在方法cssTable里面只做了操作：
 * if (index % 2 == 1) $tr.addClass("trbg");
 * 所以做删除tr操作时需要清空样式
 * @return
 */
function calculateNames($box){
	$('#tr_list>tr',$box).each(function(index){
		var $tr = $(this);
		if (index % 2 == 0) $tr.removeClass("trbg");
		resetTrContent($tr,index,false)
	});
}
/**
 * 重新计算隐藏域的名称
 * @param $tr
 * @param index
 * @param isNeededClear 是否需要做清空内容的操作
 * @return
 */
function resetTrContent($tr,index,isNeededClear){
	$tr.attr('rel',index+1);
	$('td',$tr).each(function(i){
		var $td = $(this);
		if(i==0){
			$(':first-child',$td).text(index+1);
			if(isNeededClear) $(':last-child',$td).val(-1);
		}else{
			var $firstchild = $(':first-child',$td);
			if(isNeededClear) $firstchild.val('');
			var name = $firstchild.attr('name');
			if(name.indexOf('_')!=-1)
				name = name.split('_')[0];
			$firstchild.attr('name',name+'_'+(index+1));
		}
	});
}
/**
 * datagrid包含有输入框的通用验证方法,去掉了错误提示
 * @param value
 * @return
 */
function validateSubs(form){//alert("2211:::"+JSON.stringify($(form).serializeArray()));
	$(form).validate({
		focusInvalid: false,
		focusCleanup: true,
		errorElement: "span",
		ignore:".ignore",
		invalidHandler: function(form, validator) {
			var errors = validator.numberOfInvalids();
			if (errors) {
				var message = DWZ.msg("validateFormError",[errors]);
				alertMsg.error(message);
			}
		},
		errorPlacement:function(error,element) {
			//alert(error);
		}
	});//alert($($('table.list').get(0)).html());
	return validateCallback(form,navTabAjaxDone4Update);
}
function AddToFavorite() {
	if (document.all) {
		window.external.addFavorite(document.URL, document.title);
	} else if (window.sidebar) {
		window.sidebar.addPanel(document.title, document.URL, "");
	} else {
        alert("加入收藏失败，请尝试使用Ctrl+D进行添加");
	}
}

//设为首页   
function setHomepage() {
	if (document.all) {
		document.body.style.behavior = 'url(#default#homepage)';
		document.body.setHomePage(document.URL);
	} else if (window.sidebar) {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				alert("该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true");
				return;
			}
		}
		var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
		prefs.setCharPref('browser.startup.homepage', document.URL);
	}
}
/**
 * 通用的方法，指定年月往后推移几周后的年月
 * 比如getNextYM('2011-10',3)='2012-01'
 */
function getNextYM(ym,len){
	var yms = ym.split('-');
	var now_y = parseInt(yms[0],10);
	var now_m = parseInt(yms[1],10);
	if(len >= 12){
		now_y += Math.floor(len/12);
		now_m += len%12;
	}else{
		now_m += len;
	}
	if(now_m > 12){
		now_y++;
		now_m -= 12;
	}
	return now_y + '-' + (now_m>9?(''+now_m):('0'+now_m));
}

/**
 *下面都为页面辅助方法,零散的,不可通用------------------------------------------------------------------ 
 *
 */
/**
 * 首页定位焦点用
 */
function initFocus(){
	var j_orgcode = $.cookie('j_orgcode');
	var j_username = $.cookie('j_username');
	$('#j_orgcode').val(j_orgcode);
	$('#j_username').val(j_username);
	if(j_orgcode==null||j_orgcode==''){
		$('#j_orgcode').focus();
	}else if(j_username==null||j_username==''){
		$('#j_username').focus();
	}else
		$('#j_password').focus();
}
/**
 * 代码生成器模块：判断列是否被修改
 */
function valueHasChanged(flag){
	$('#msgTip').text(flag?'当前窗口的数据未保存？':'当前窗口的数据已保存！');
}
/**
 * 代码生成器模块：列表页面，点击修改按钮时，当前行选中
 * @param objId
 * @return
 */
function boxChecked(objId){
	var current_checkbox = $('#'+objId)[0];
	if(!current_checkbox.checked)
		current_checkbox.checked = true;
}
/**
 * 代码生成器模块：没有指定模块moudle，不能保存
 * @param value
 * @return
 */
function validateModuleInColumn(value){
	if( value == '' || value == null){
		alertMsg.warn('此表的模块未指定，不能保存');
	}else
		validateCallback($('#form3')[0],function(json){valueHasChanged(false);DWZ.ajaxDone(json);})
}
/**
 * 保存配置信息或者生成模板
 * @param flag
 * @return
 */
function saveTemplate(flag){
	var obj_hasSelected = $('#form2').find("input[id^='AA_']");
	if(obj_hasSelected==null||obj_hasSelected.size()==0){
		alertMsg.info('没有可供选择的信息');
		return;
	}
	var hasSelected = false;
	obj_hasSelected.each(function(){
		if(this.checked){
			hasSelected = true;
		}
	});
	if(!hasSelected){
		alertMsg.warn('保存表失败，请选择信息');
		return;
	}
	$('#flag').val(flag?1:0);//$('#flag')[0].value=(flag?1:0);
	if(flag){
		alertMsg.confirm("您确定要生成项目模块吗？此操作将会覆盖原有文件，请做好备份。", {
            okCall: function(){
				validateCallback($('#form2')[0]);
            }
		});
	}else
		validateCallback($('#form2')[0]);
}

/**
 * 打印
 * @param {} action
 * @param {} title
 */
function JS_print(action,title){
	var ctx = action.substring(0,action.indexOf('/',1));
	showWindowRaw(ctx + '/print/print!print.action?url='+ action+'&print=print&title='+title,800,600);
}
/**
 * 打印
 * @param {} title
 * @param {} jsonArray
 */
function JS_print2(title){
	var $form = $('#pagerForm',navTab.getCurrentPanel());
	$('#numPerPage',$form).val(-1);
	var params = $form.serializeArray();
	var paramsInForm = '';
	var name = null,value = null;
	for(var i=0;i<params.length;i++){
		name = params[i].name;
		value = params[i].value;
		if(value == null || value == '')
			continue;
		paramsInForm += '&' + name + '=' + encodeURI(value);
	}
	var rule = new Array();
	var hcode = '';
	var htype = '';
	var htitle = '';
	var $this = null;
	$('table thead tr th:gt(0)',navTab.getCurrentPanel()).each(function(){
		$this = $(this);
		hcode = $this.attr('orderField');
		if(hcode == null || hcode == '')
			hcode = $this.attr('hcode');
		if(hcode != null && hcode != ''){
			htype = $this.attr('htype');
			if(htype == null || htype == '')
				htype = 'normal';
			htitle = $this.children().eq(0).html();
			if(htitle != null && htitle != '')
				htitle = encodeURI(htitle);
						
			//alert($(this).attr('orderField'));;
			rule[rule.length] = {a:htitle,b:hcode,c:htype};
		}
	});
	var action = $form.attr('action');
	var url = action.substring(0,action.indexOf('/',1));
	url += '/print/print!print.action?print=print&url='+ action;
	url += '&title='+encodeURI(title);
	url += paramsInForm;
	url += '&rule='+JSON.stringify(rule);
	//alert(url);
	showWindowRaw(url,800,600);
}
/**
 * 弹出窗口
 * @param {} strurl
 * @param {} width
 * @param {} height
 */
function showWindowRaw(strurl, width, height) {
    window.open(strurl, 'report_select', 'toolbar=no,location=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,width=' + width + ',height=' + height);
}
function pdialogOpen(url,title){
	$.pdialog.open(url, 'btnLook', title, {width:405,height:300});
}
