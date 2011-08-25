package com.jeysan.cpf.util;

public class Constants {
	/**
	 * 是否进行一孩登记
	 * @author 黄静
	 *
	 */
	public static final class RegisterType{
		public static final Integer YES = 712;//已登记
		public static final Integer NO = 713;//未登记
	}
	
	/**
	 * 再生育申请状态
	 * @author 黄静
	 *
	 */
	public static final class Birth2Type{
		public static final Integer YES = 714;//已申请
		public static final Integer NO = 715;//未申请
	}
	
	/**
	 * 审批状态
	 * @author 黄静
	 *
	 */
	public static final class CheckType{
		public static final Integer YES = 716;//已审批
		public static final Integer NO = 717;//未审批
	}
	
	/**
	 * 记录状态
	 * @author 黄静
	 *
	 */
	public static final class RECORD_TYPE{
		public static final Integer HAS_LIST = 718;//已列出
		public static final Integer HAS_REGISTER = 719;//已登记
	}
	
	/**
	 * 审批决定
	 * @author 黄静
	 *
	 */
	public static final class IS_AGREE{
		public static final Integer AGREE = 12;//同意
		public static final Integer DISAGREE = 13;//不同意
	}
	
	/**
	 * 取环类型
	 * @author 黄静
	 *
	 */
	public static final class GETIUD_TYPE{
		public static final Integer BIRTH2 = 158;//取环生育二孩
		public static final Integer OLDAGE = 159;//退出育龄期取环
		public static final Integer DISEASE = 160;//因病取环
	}
}
