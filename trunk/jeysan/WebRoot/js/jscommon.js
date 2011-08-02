(function($){
	/**
	 * 扩展String方法:
	 * 1.默认实现
	 * 2.用于传递多选框的值
	 */
	$.extend(String.prototype, {
		replaceTmById:function(_box) {
			var $parent = _box || $(document);
			if(this.indexOf('hxhxhxhxhxhx')!=-1){//默认实现
				return this.replace(RegExp("({[A-Za-z_]+[A-Za-z0-9_]*})","g"), function($1){
					var $input = $parent.find("#"+$1.replace(/[{}]+/g, ""));
					return $input.size() > 0 ? $input.val() : $1;
				});
			}else{//用于传递多选框的值
				return this.replace(RegExp("({[A-Za-z_]+[A-Za-z0-9_]*})","g"), function($1){
					var $items = $parent.find("input[type='checkbox']").not('.checkboxCtrl');
					var $value = '';
					$items.each(function(){
						if(this.checked) $value += ','+$(this).val();
					});
					return $value=='' ? $1 : $value.substr(1);
				});
			}
		}
	});
	/**
	 * 扩展navTab方法
	 * 1.默认实现:目标tab的刷新是根据reload
	 * 2.当action的值为2时，也就是页面提交的操作为修改，
	 * 这个时候目标tab的刷新为页面中pageForm的submit
	 */
	$.extend(navTab,{
		_reload: function($tab, flag){
			flag = flag || $tab.data("reloadFlag");
			if(flag){
				$tab.data("reloadFlag", null);
				$panel = this._getPanel($tab.data("tabid"));
				var action = $tab.data("action");
				if(action && action == '2'){
					var form = $('#pagerForm',$panel).get(0);
					if ($panel) $panel.loadUrl(form.action, $(form).serializeArray(), function(){
						$panel.find("[layoutH]").layoutH();
					});
				}else if(action && action == '3'){
					//view
				}
				else{
					var url = $tab.data("url");
					if (url) {
						if ($panel) $panel.loadUrl(url, {}, function(){
							$panel.find("[layoutH]").layoutH();
						});
					}
				}
				if(action)	$tab.data("action", null);
			}
		}
	});
	/**
	 * 完善loadUrl的方法
	 * 当客户端为GET方法提交,并且在url中包含有中文参数，这个时候中文参数需要格式化
	 */
	$.fn.extend({
		loadUrl: function(url,data,callback){
		
			var $this = $(this);
			if ($.fn.xheditor) {
				$("textarea.editor", $this).xheditor(false);
			}
			$.ajax({
				type: 'POST',
				url: encodeURL4JS(url),
				cache: false,
				data: data,
				success: function(html){
					var json = DWZ.jsonEval(html);
					if (json.statusCode==DWZ.statusCode.timeout){
						alertMsg.error(DWZ.msg("sessionTimout"), {okCall:function(){
							DWZ.loadLogin();
						}});
					} if (json.statusCode==DWZ.statusCode.error){
						if (json.message) alertMsg.error(json.message);
					} else {
						$this.html(html).initUI();
						if ($.isFunction(callback)) callback();
					}
				},
				error: DWZ.ajaxError
			});
		}
	});
})(jQuery);
/**
 * 将action的行为置于js容器里面，作为函数回调的判断
 * @param json
 * @return
 */
function navTabAjaxDone4Update(json){
	var targetNavTab = navTab._getTab(json.navTabId);
	if(targetNavTab && targetNavTab!=null)
		targetNavTab.data("action",json.action);
	navTabAjaxDone(json);
}
/**
 * 重新编码URL，因为URL链接参数中可能带中文
 * @param url
 * @return
 */
function encodeURL4JS(url){
	if(url.indexOf('?')==-1)
		return url;
	var obj = $.query.load(url);
	$.each(obj.keys, function(key, value) {
	     obj.set(key,encodeURI(encodeURI(value)));
	});
	return url.substr(0,url.indexOf('?')) + obj.toString();
}
/**
 *下面都为页面辅助方法,零散的,不可通用------------------------------------------------------------------ 
 */
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
 * table表格class为list增加/减少一行tr,通用方法。
 * 如果table表格class为table，此方法要重写
 * @param type
 * @return
 */
function operateRow(type){//alert($("tr[target='subDictId']").html());
	var length = $('#tr_list>tr').length;
	if(type=='add'){
		var $tr = $($('#tr_list>tr').get(0)).clone();
		resetTrContent($tr,length,true)
		$('#tr_list').append($tr);
		$('table.list').cssTable();
	}else if(type=='delete'){
		if(length<=1) return;
		var hasRemoved = false;
		if ($('#rowIndex').size() != 0){
			var index = $('#rowIndex').val();//var index = $('#rowIndex')[0].value;
			if(index!=null&&index!=-1){
				$('#tr_list>tr').eq(index-1).remove();
				$('#rowIndex').val(-1);
				hasRemoved = true;
				$('table.list').cssTable();
				calculateNames();
			}
		}
		if(!hasRemoved) $('#tr_list>tr').eq(length-1).remove();
	}
}
/**
 * 重新计算隐藏域的名称之前，
 * 清空tr的背景样式，因为在方法cssTable里面只做了操作：
 * if (index % 2 == 1) $tr.addClass("trbg");
 * 所以做删除tr操作时需要清空样式
 * @return
 */
function calculateNames(){
	$('#tr_list>tr').each(function(index){
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
	return validateCallback(form);
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