package com.jeysan.modules.utils;

import com.jeysan.modules.utils.encode.EncodeUtils;

public class Constants {
	
	public static final String SESSION_FROM_CACHE = "SESSION_FROM_CACHE_";
	
	public static final String JSESSIONID = "_JSESSIONID_UUID";

	public static final String JSESSION_EXPERITED = "_JSESSIONID_UUID_COOKIE";

	public static final String SUCCESS_SESSION_KEY = "SUCCESS_SESSION_UUID_";
	
	public static final String SPRING_SECURITY_SEPERATOR = "_";
	
	public static class Application{
		public static final String PLATFORM_TITLE = EncodeUtils.encode(ResourceBundleUtils.getSValue("platform.title"),"ISO-8859-1");
		public static final String PLATFORM_COMPANY = EncodeUtils.encode(ResourceBundleUtils.getSValue("platform.company"),"ISO-8859-1");
		public static final String PLATFORM_SITE = ResourceBundleUtils.getSValue("platform.site");
		public static final String PLATFORM_EXPIRE = ResourceBundleUtils.getSValue("platform.expire");
		
		public static final String OTHER_BBS = ResourceBundleUtils.getSValue("other.bbs");
		public static final String OTHER_BBS_ADMIN = ResourceBundleUtils.getSValue("other.bbs_admin");
		public static final String OTHER_IM_ADMIN = ResourceBundleUtils.getSValue("other.im_admin");
	}
}
