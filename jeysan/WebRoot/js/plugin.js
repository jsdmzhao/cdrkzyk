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
				var $panel = this._getPanel($tab.attr("tabid"));
				var action = $tab.data("action");
				if(action && action == '2'){
					var form = $('#pagerForm',$panel).get(0);
					if ($tab.hasClass("external")){
						navTab.openExternal(url, $panel);
					}else {
						if ($panel) $panel.loadUrl(form.action, $(form).serializeArray(), function(){
							navTab._loadUrlCallback($panel);
						});
					}
				}else if(action && action == '3'){
					//view
				}
				else{
					var url = $tab.attr("url");
					if (url) {
						if ($tab.hasClass("external")){
							navTab.openExternal(url, $panel);
						}else {
							$panel.loadUrl(url, {}, function(){
								navTab._loadUrlCallback($panel);
							});
						}
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
		ajaxUrl: function(op){
			var $this = $(this);
			if ($.fn.xheditor) {
				$("textarea.editor", $this).xheditor(false);
			}
			
			$.ajax({
				type: op.type || 'GET',
				dataType: op.dataType || 'html',
				url: op.url,
				data: op.data,
				success: function(response){
					var json = DWZ.jsonEval(response);
					DWZ.debug("statusCode:"+json.statusCode);
					if (json.statusCode==DWZ.statusCode.timeout){
						alertMsg.error(json.message || DWZ.msg("sessionTimout"), {okCall:function(){
							if ($.pdialog) $.pdialog.checkTimeout();
							if (navTab) navTab.checkTimeout();
	
							DWZ.loadLogin();
						}});
					} 
					
					if (json.statusCode==DWZ.statusCode.error){
						if (json.message) alertMsg.error(json.message);
					} else {
						$this.html(response).initUI();
						if ($.isFunction(op.callback)) op.callback(response);
					}
				},
				error: DWZ.ajaxError,
				cache: false
			});
		},
		loadUrl: function(url,data,callback,options){
			$(this).ajaxUrl({url:encodeURL4JS(url), data:data, callback:callback});
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
 * 处理navTab多面板，重新载入当前面板
 * @param {Object} form
 */
function navTabSearch4dwz(form, navTabId){
	var jGroups = $("> .tabsContent > *", navTab);
	//alert(33);alert(jGroups.eq(0));
	var $form = $(form);alert($form);
	if (form[DWZ.pageInfo.pageNum]) form[DWZ.pageInfo.pageNum].value = 1;
	//navTab.reload($form.attr('action'), {data: $form.serializeArray(), navTabId:navTabId});
	//alert($form.attr('action'));
	alert($form.serializeArray());
	jGroup = jGroups.eq(0);
	jGroup.loadUrl($form.attr('action'), {data: $form.serializeArray(), navTabId:navTabId},function(){
		jGroup.find("[layoutH]").layoutH();
	});
	return false;
}
/**
 * 处理navTab中的分页和排序
 * @param args {pageNum:"n", numPerPage:"n", orderField:"xxx"}
 */
function navTabPageBreak4dwz(args){
	args = args || {};
	var form = _getPagerForm(navTab.getCurrentPanel(), args);
	var $form = $(form);
	var params = $form.serializeArray();
	if (args.targetType) params[params.length] = args.targetType;
	//if (form) navTab.reload($(form).attr("action"), {data: params, callback: args.callback});
	var jGroups = $("> .tabsContent > *", navTab);
	jGroup = jGroups.eq(0);
	jGroup.loadUrl($form.attr('action'), {data: params, callback: args.callback},function(){
		jGroup.find("[layoutH]").layoutH();
	});
}