package com.jeysan.cpf.comm.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.comm.entity.FileManager;
import com.jeysan.cpf.comm.service.FileManagerManager;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.file.FileUtils;
import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/comm")
public class FileManagerAction extends ActionSupport {

	private FileManagerManager fileManagerManager;
	private static final long serialVersionUID = -1826212472390477005L;

	public String upload() {
		try {
			HttpServletRequest request = Struts2Utils.getRequest();
			request.setCharacterEncoding("UTF-8");
			// 判断上传表单是否为上传表单类型
			if (ServletFileUpload.isMultipartContent(request)) {
				User user = (User)request.getSession().getAttribute("_js_user");
				File f = new File(FileUtils.getRealPath(request, Constants.UPLOAD_DIR));
				if (!f.exists())
					f.mkdirs();
				MultiPartRequestWrapper mhsr = (MultiPartRequestWrapper) request;
				File[] files = mhsr.getFiles("Filedata");
				StringBuilder fileIds = new StringBuilder();
				StringBuilder fileNames = new StringBuilder();
				for (File file : files) {
					String fileNewName = new StringBuilder().append(
							UUID.randomUUID()).append(".").append(
							FileUtils.getFileExt(file.getName())).toString();
					BufferedInputStream in = new BufferedInputStream( new FileInputStream(file));
					BufferedOutputStream out = new BufferedOutputStream(
							new FileOutputStream(new File(
									FileUtils.getRealPath(request,
											Constants.UPLOAD_DIR), fileNewName)));
					Streams.copy(in, out, true);

					FileManager fileManager = new FileManager();
					fileManager.setFilePath(Constants.UPLOAD_DIR);
					fileManager.setFileSize(new BigDecimal(1));
					String type = Struts2Utils.getParameter("type");
					if (StringUtils.isNotEmpty(type))
						fileManager.setFileType(Integer.parseInt(type));
					fileManager.setHander(user.getUserCode());
					fileManager.setHandinTime(new Date());
					fileManager.setNewName(fileNewName);
					fileManager.setArea(user.getOrg().getOrgCode());
					fileManager.setOrinName(file.getName());
					String flag = Struts2Utils.getParameter("flag");
					if (StringUtils.isNotEmpty(flag))
						fileManager.setFlag(Integer.parseInt(flag));
					else
						fileManager.setFlag(0);
					
					
					fileManagerManager.saveFileManager(fileManager);
					fileIds.append(",").append(fileManager.getId());
					fileNames.append(",").append(fileNewName);
				}
				Map result4Json = new HashMap();
				result4Json.put("fileId", fileIds.substring(1));
				result4Json.put("fileName", fileNames.substring(1));
				Struts2Utils.renderJson(result4Json);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}
		return NONE;
	}

	public String delete() {
		String id = StringUtils.trim(Struts2Utils.getParameter("id"));
		if (StringUtils.isNotEmpty(id)) {
			FileManager fileManager = fileManagerManager.getFileManager(Long.parseLong(id));
			fileManagerManager.deleteFileManagerIncludeFile(fileManager);
		}
		return NONE;
	}

	@Autowired
	public void setFileManagerManager(FileManagerManager fileManagerManager) {
		this.fileManagerManager = fileManagerManager;
	}

}
