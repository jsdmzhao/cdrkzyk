<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>KingTrend SOFTWARE--文件管理统一控制器</title>
<meta name="author" content="CANCER LOVE SHALLY - KingTrend SOFTWARE" />
<link rel="stylesheet" type="text/css" href="${ctx4doc}/js/codebase/GooUploader.css"/>
<script src="${ctx4doc}/dwz3/js/jquery-1.4.4.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx4doc}/js/json2.js"></script>
<script  type="text/javascript" src="${ctx4doc}/js/codebase/GooUploader.js"></script>
<script type="text/javascript" src="${ctx4doc}/js/codebase/swfupload/swfupload.js"></script>

<script type="text/javascript">
var uploadSuccess = function(file,data){
	var hiddenId = "<%=request.getParameter("hiddenId")%>";
	var labelId = "<%=request.getParameter("labelId")%>";
	var parentLabelId = $("#"+labelId, opener.document);
	var parentHiddenId = $("#"+hiddenId, opener.document);
	var fileId = JSON.parse(data).fileId;
	var fileName = JSON.parse(data).fileName;
	parentLabelId.append(getLinkHrefStr(fileId,file.name,fileName));
	if(parentHiddenId[0].value != '')
		parentHiddenId[0].value = parentHiddenId[0].value + "," + fileId ;
	else
		parentHiddenId[0].value =  fileId ;	
	//alert(parentLabelId.html());
}
var uploadError = function(file,code,msg){
	//alert(file+code+msg);
}
var fileQueueError = function(file,code,msg){
	if(code == SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT){
		alert('文件太大，不能超过50M');
	}
}
function getLinkHrefStr(fileId,fileLabelName,fileName){
	if(('<%=request.getParameter("isShowPic")%>'==''||'<%=request.getParameter("isShowPic")%>'=='true')&&'<%=request.getParameter("is4SingleFile")%>'=='true' && '<%=request.getParameter("isLimit4Pic")%>'=='true' ){
		if(<%=request.getParameter("isv")%>)
			return  "<div id=\"label_"+fileId+"\" onmouseover=\"$('#deleteImg_"+fileId+"').css('visibility','visible')\" onmouseout=\"$('#deleteImg_"+fileId+"').css('visibility','hidden');\">&nbsp;<a id=\"linkHref_"+fileId+"\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/"+fileName+"\" target=\"_blank\"><img src=\"${ctx}/datafile/"+fileName+"\" border=\"0\" alt=\""+fileLabelName+"\"/></a><img src=\"${ctx4doc}/dwz3/themes/default/images/cancel.png\" id=\"deleteImg_"+fileId+"\" style=\"border:0;cursor:pointer;visibility:hidden\" onclick=\"deleteFile("+fileId+")\"/></div>";
		else
			return  "<div id=\"label_"+fileId+"\">&nbsp;<a id=\"linkHref_"+fileId+"\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/"+fileName+"\" target=\"_blank\"><img src=\"${ctx}/datafile/"+fileName+"\" border=\"0\" alt=\""+fileLabelName+"\"/></a></div>";
	}else{
		if(<%=request.getParameter("isv")%>)
		return  "<div id=\"label_"+fileId+"\" onmouseover=\"$('#deleteImg_"+fileId+"').css('visibility','visible')\" onmouseout=\"$('#deleteImg_"+fileId+"').css('visibility','hidden');\">&nbsp;<a id=\"linkHref_"+fileId+"\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/"+fileName+"\" target=\"_blank\">"+fileLabelName+"</a><img src=\"${ctx4doc}/dwz3/themes/default/images/cancel.png\" id=\"deleteImg_"+fileId+"\" style=\"border:0;cursor:pointer;visibility:hidden\" onclick=\"deleteFile("+fileId+")\"/></div>";
	else
		return  "<div id=\"label_"+fileId+"\">&nbsp;<a id=\"linkHref_"+fileId+"\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/"+fileName+"\" target=\"_blank\">"+fileLabelName+"</a></div>";
	}
}

var property={
	width:300,
	height:300,
	multiple:true,<%if(request.getParameter("fileTypes")==null||request.getParameter("fileTypes")==""){if(request.getParameter("isLimit4Pic")!=null&&request.getParameter("isLimit4Pic").equals("true"))out.print("file_types:\"*.jpg;*.gif;*.png\",");} else out.print("file_types:\""+request.getParameter("fileTypes")+"\",");%>
    //file_types:"*.jpg;*.gif",
    //file_types_description: "Web Image Files",
    post_params:{session_id:"<%=session.getId()%>"},
    btn_add_text:"添加",
    btn_up_text:"上传",
    btn_cancel_text:"放弃",
    btn_clean_text:"清空",
    op_del_text:"单项删除",
    op_up_text:"单项上传",
    op_fail_text:"上传失败",
    op_ok_text:"上传成功",
    op_no_text:"取消上传",
	upload_url:"${ctx}/comm/filemanager!upload.action?type=<%=request.getParameter("type")%>",
	uploadSuccess:uploadSuccess,
	uploadError:uploadError,
	fileQueueError:fileQueueError,
	file_size_limit:51200,
	flash_url:"${ctx4doc}/js/codebase/swfupload.swf",
	file_upload_limit:<%=(request.getParameter("is4SingleFile")!=null&&request.getParameter("is4SingleFile").equals("true"))?1:10%>
	//file_queue_limit:5
};
$(document).ready(function(){
  	$.createGooUploader($("#cancerloveshally"),property);
});
</script>
</head>

<body>
<div id="cancerloveshally"></div>
</body>
</html>