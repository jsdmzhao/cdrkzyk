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
		loadUrl: function(url,data,callback){
			$(this).ajaxUrl({url:encodeURL4JS(url), data:data, callback:callback});
		}
	});

})(jQuery);