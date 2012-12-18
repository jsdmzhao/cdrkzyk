package com.jeysan.modules.utils.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtils {
	/**
	 * 一般的上传
	 * @param request
	 * @param fileName
	 * @param filePath
	 */
	public static void uploadFile(HttpServletRequest request, String fileName,
			String filePath) {
		// file upload factory
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// setting upload file path
		factory.setRepository(new File(filePath));
		// set default memory size
		factory.setSizeThreshold(1024 * 1024);
		//   
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			String name, value;
			for (FileItem item : list) {
				name = item.getFieldName();// input name
				value = item.getName();// input content
				if (item.isFormField()) {
					request.setAttribute(name, value);
				} else {
					if (StringUtils.isEmpty(fileName)) {
						value = value.substring(value.lastIndexOf("//") + 1,
								value.length());
					} else {
						value = fileName.concat(".").concat(
								FileUtils.getFileExt(value));
					}
					// 1.--------------
					// output file
					OutputStream fileOutStream = new FileOutputStream(new File(
							filePath, value));
					// input file
					InputStream fileInputStream = item.getInputStream();
					// file buffer
					byte[] buffer = new byte[1024];

					// read
					int length = 0;
					while ((length = fileInputStream.read(buffer)) > 0) {
						fileOutStream.write(buffer, 0, length);
					}

					// close
					fileInputStream.close();
					fileOutStream.close();

					// 2.--------------
					// item.write(new File(path, value));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * spring mvc 里面的上传
	 * @param request
	 * @param fileName
	 * @param filePath
	 */
	public static void uploadFileInSpring(HttpServletRequest request,String fieldName,
			String fileName, String filePath) {
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				File f = new File(filePath);
				if (!f.exists())
					f.mkdirs();
				MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
				MultipartFile file = mhsr.getFile(fieldName);
				String fileNewName = new StringBuilder()
						.append(fileName)
						.append(".")
						.append(
								FileUtils
										.getFileExt(file.getOriginalFilename()))
						.toString();
				BufferedInputStream in = new BufferedInputStream(file
						.getInputStream());
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(new File(filePath, fileNewName)));
				Streams.copy(in, out, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * struts2里面的上传
	 * @param upload
	 * @param fileName
	 * @param filePath
	 */
	public static void uploadFileInStruts(File upload, String fileName,String filePath) {
		try {
			InputStream is = new FileInputStream(upload);
			File f = new File(filePath);
			if(!f.exists())
				f.mkdirs();
			OutputStream os = new FileOutputStream(new File(f,fileName));
			byte buffer[] = new byte[8192];
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
