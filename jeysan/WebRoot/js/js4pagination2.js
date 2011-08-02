(function($){
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
				}else{
					var url = $tab.data("url");
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
				$tab.data("action", null);
			}
		}
	});
})(jQuery);