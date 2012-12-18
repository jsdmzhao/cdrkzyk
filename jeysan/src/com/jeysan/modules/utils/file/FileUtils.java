package com.jeysan.modules.utils.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class FileUtils {
	public static String getFilePathInClassLoader(String fileName) {
		return Thread.currentThread().getContextClassLoader().getResource("/")
				.getPath()
				+ fileName;
	}

	public static boolean isFile(String filePath) {
		try {
			File file = new File(filePath);
			if (!file.exists())
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void backFile(String sourceFile, String targetDir) {
		File file = new File(sourceFile);
		File target = new File(targetDir);
		if (!target.exists())
			target.mkdirs();
		try {
			org.apache.commons.io.FileUtils.copyFile(file, new File(target,new Date().getTime() + ".xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFileExt(String fileName) {
		if (fileName == null)
			return "";
		String ext = fileName.toLowerCase();
		try {
			int dot = ext.lastIndexOf(".");
			if (dot == -1)
				ext = "";
			else
				ext = ext.substring(dot + 1).trim();
		} catch (Exception e) {
			return "";
		}
		return ext;
	}

	public static String getFileExt(File file) {
		if (file == null)
			return "";
		return getFileExt(file.getName());
	}
	
	public static String getRealPath(HttpServletRequest request,String path){
		return request.getSession().getServletContext().getRealPath(path);
	}
	
	public static void deleteFile(HttpServletRequest request,String fileName){
		File file = new File(getRealPath(request, fileName));
		if(file != null && file.exists())
			file.delete();
	}

	public static void main(String[] argv) {
		System.out.println(getFileExt("F:\\jeysan\\aaa.txt"));
	}
}
