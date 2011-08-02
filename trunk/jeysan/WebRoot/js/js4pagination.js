(function($){
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
				}else{
					var url = $tab.data("url");
					if (url) {
						if ($panel) $panel.loadUrl(url, {}, function(){
							$panel.find("[layoutH]").layoutH();
						});
					}
				}
				$tab.data("action", null);
			}
		}
	});
})(jQuery);