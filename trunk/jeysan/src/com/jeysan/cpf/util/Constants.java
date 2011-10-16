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
	/**
	 * 查环查孕类型
	 * @author 黄静
	 *
	 */
	public static final class DC_TYPEH{
		public static final Integer NO_CHECK = 186;//不查
		public static final Integer FREE_CHECK = 191;//免查
	}
	/**
	 * 保险情况
	 * @author 黄静
	 *
	 */
	public static final class ASS_STATUS{
		public static final Integer YET_ASS = 720;//已投保
		public static final Integer CANCEL = 721;//已取消
		public static final Integer NO_ASS = 722;//未投保
	}
	/**
	 * 注销类别
	 * @author 黄静
	 *
	 */
	public static final class CANCEL_TYPE{
		public static final Integer NORMAL = 672;//正常
		public static final Integer RENEW = 673;//恢复注销
		public static final Integer OLD_AGE = 153;//超龄注销
		public static final Integer PERSON_OUT = 154;//迁出注销
		public static final Integer DEATH = 155;//死亡注销
	}
	/**
	 * 妇女类别
	 * @author 黄静
	 *
	 */
	public static final class FW_KIND{
		public static final Integer FW = 668;//育龄妇女
		public static final Integer NOT_FW = 669;//非育龄妇女
	}
	/**
	 * 户口类别
	 * @author shally
	 *
	 */
	public static final class DOMICILE_TYPE{
		public static final Integer FIX = 663;//固定人口
		public static final Integer FLOW = 664;//流动人口
	}
	/**
	 * 证书注销情况
	 * @author 黄静
	 *
	 */
	public static final class CERT_STATUS{
		public static final Integer NORMAL = 726;//正常
		public static final Integer CANCEL = 727;//已注销
	}
	/**
	 * 计生证书状态
	 * @author 黄静
	 *
	 */
	public static final class CERT_TYPE{
		public static final Integer NORMAL = 728;//未变更
		public static final Integer CHANGED = 729;//已换证
		public static final Integer CANCEL = 730;//已废止
	}
	
	public static final class COMMON_PARAM{
		public static final Integer CURRENT_TOWN_ID = 26879;//当前镇ID
	}
	
	public static final class SEX{
		public static final Integer MALE = 1;//男
		public static final Integer FEMALE = 2;//女
		public static final Integer NOKNOW = 324;//未知性别
		public static final Integer NONOTIFY = 325;//未说明性别
	}
	
	public static final class MARRY_STATUS{
		public static final Integer NO = 176;//未婚
	}
}
