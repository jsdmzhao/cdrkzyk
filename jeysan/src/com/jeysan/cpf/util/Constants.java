package com.jeysan.cpf.util;

import org.apache.commons.lang.StringUtils;


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
		public static final Integer CHECK_1 = 187;//查一次
		public static final Integer CHECK_2 = 188;//查二次
		public static final Integer CHECK_3 = 189;//查三次
		public static final Integer CHECK_4 = 190;//查四次
	}
	/**
	 * 查环查孕状态
	 * @author 黄静
	 *
	 */
	public static final class DC_STATUS{
		public static final Integer CONFIRMED = 758;//已确定
		public static final Integer NO_CHECK = 759;//漏查
		public static final Integer CHECKED = 760;//已查
	}
	/**
	 * 查环查孕对象类型
	 * @author 黄静
	 */
	public static final class DC_OBJ_TYPE{
		public static final Integer DOT_161 = 161;// 上环
		public static final Integer DOT_162 = 162;// 药具
		public static final Integer DOT_163 = 163;// 皮埋
		public static final Integer DOT_164 = 164;// 其他避孕
		public static final Integer DOT_165 = 165;// 结扎不足一年	
		public static final Integer DOT_166 = 166;// 应落实未落实
		public static final Integer DOT_167 = 167;// 有指标待孕
	}
	/**
	 * 避孕节育措施
	 * @author 黄静
	 */
	public static final class METHOD{
		public static final Integer METHOD_201 = 201;// 男扎
		public static final Integer METHOD_202 = 202;// 女扎
		public static final Integer METHOD_203 = 203;// 上环
		public static final Integer METHOD_204 = 204;// 服注药
		public static final Integer METHOD_205 = 205;// 避孕套
		public static final Integer METHOD_206 = 206;// 外用药
		public static final Integer METHOD_207 = 207;// 皮埋	
		public static final Integer METHOD_208 = 208;// 未避孕
		public static final Integer METHOD_209 = 209;// 宫内节育器（IUD）
		public static final Integer METHOD_210 = 210;// 输卵管结扎
		public static final Integer METHOD_211 = 211;// 宫型含铜（IUD）
		public static final Integer METHOD_212 = 212;// 其他避孕法
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "男扎")!=-1){
				return METHOD_201;
			}else if(StringUtils.indexOf(status, "女扎")!=-1){
				return METHOD_202;
			}else if(StringUtils.indexOf(status, "上环")!=-1||StringUtils.indexOf(status, "放环")!=-1){
				return METHOD_203;
			}else if(StringUtils.indexOf(status, "服注药")!=-1){
				return METHOD_204;
			}else if(StringUtils.indexOf(status, "避孕套")!=-1){
				return METHOD_205;
			}else if(StringUtils.indexOf(status, "外用药")!=-1){
				return METHOD_206;
			}else if(StringUtils.indexOf(status, "皮埋")!=-1){
				return METHOD_207;
			}else if(StringUtils.indexOf(status, "未避孕")!=-1){
				return METHOD_208;
			}else if(StringUtils.indexOf(status, "宫内节育器")!=-1){
				return METHOD_209;
			}else if(StringUtils.indexOf(status, "输卵管结扎")!=-1){
				return METHOD_210;
			}else if(StringUtils.indexOf(status, "宫型含铜")!=-1){
				return METHOD_211;
			}else if(StringUtils.indexOf(status, "其他")!=-1){
				return METHOD_212;
			}else
				return METHOD_212;
		}
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
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "正常")!=-1){
				return NORMAL;
			}else if(StringUtils.indexOf(status, "恢复注销")!=-1){
				return RENEW;
			}else if(StringUtils.indexOf(status, "超龄注销")!=-1){
				return OLD_AGE;
			}else if(StringUtils.indexOf(status, "迁出注销")!=-1){
				return PERSON_OUT;
			}else if(StringUtils.indexOf(status, "死亡注销")!=-1){
				return DEATH;
			}else
				return NORMAL;
		}
	}
	/**
	 * 妇女类别
	 * @author 黄静
	 *
	 */
	public static final class FW_KIND{
		public static final Integer FW = 668;//育龄妇女
		public static final Integer NOT_FW = 669;//非育龄妇女
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "非育龄妇女")!=-1){
				return NOT_FW;
			}else if(StringUtils.indexOf(status, "育龄妇女")!=-1){
				return FW;
			}else
				return null;
		}
	}
	/**
	 * 户口类别
	 * @author shally
	 *
	 */
	public static final class DOMICILE_TYPE{
		public static final Integer FIX = 663;//固定人口
		public static final Integer FLOW = 664;//流动人口
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "固定")!=-1||StringUtils.indexOf(status, "户籍")!=-1){
				return FIX;
			}else if(StringUtils.indexOf(status, "流动")!=-1){
				return FLOW;
			}else
				return null;
		}
	}
	/**
	 * 政治面貌
	 * @author shally
	 * 665	49		党员			1
666	49		团员			2
667	49		群众			3

	 *
	 */
	public static final class PoliticalStatus{
		public static final Integer DANG = 665;//党员
		public static final Integer TUAN = 666;//团员
		public static final Integer QUAN = 667;//群众
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "党员")!=-1){
				return DANG;
			}else if(StringUtils.indexOf(status, "团员")!=-1){
				return TUAN;
			}else if(StringUtils.indexOf(status, "群众")!=-1){
				return QUAN;
			}else
				return QUAN;
		}
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
	
	
	//329	43	001	身份证			1
	/**
	 * 329	43	001	身份证			1
330	43	002	军官证			2
334	43	003	护照			3
335	43	004	户口簿			4
336	43	005	台港澳身份证			5
337	43	006	系统生成号码			6
338	43	007	国外证件号码			7
339	43	008	暂无证件号码			8
340	43	009	其他			9

	 */
	public static final class CARD_TYPE{
		public static final Integer CERT = 329;//身份证
		public static final Integer CERT_1 = 330;//军官证
		public static final Integer CERT_2 = 334;//护照
		public static final Integer CERT_3 = 335;//户口簿
		public static final Integer CERT_4 = 336;//台港澳身份证
		public static final Integer CERT_5 = 337;//系统生成号码
		public static final Integer CERT_6 = 338;//国外证件号码
		public static final Integer CERT_7 = 339;//暂无证件号码
		public static final Integer CERT_8 = 340;//其他
		public static Integer getStatusByLabel(String status){
			if(StringUtils.equals(status, "身份证")){
				return CERT;
			}else if(StringUtils.equals(status, "军官证")){
				return CERT_1;
			}else if(StringUtils.equals(status, "护照")){
				return CERT_2;
			}else if(StringUtils.equals(status, "户口簿")){
				return CERT_3;
			}else if(StringUtils.equals(status, "台港澳身份证")){
				return CERT_4;
			}else if(StringUtils.equals(status, "系统生成号码")){
				return CERT_5;
			}else if(StringUtils.equals(status, "国外证件号码")){
				return CERT_6;
			}else if(StringUtils.equals(status, "暂无证件号码")){
				return CERT_7;
			}else if(StringUtils.equals(status, "其他")){
				return CERT_8;
			}else
				return null;
		}
	}
	public static final class COMMON_PARAM{
		public static final Integer CURRENT_TOWN_ID = 26879;//当前镇ID
	}
	/**
	 * 304	40	001	家庭户户主
305	40	002	集体户户主
306	40	003	配偶
307	40	004	子
308	40	005	女
309	40	006	父亲
310	40	007	母亲
311	40	008	其他亲属
312	40	009	非亲属
326	40	010	孙子、孙女或外孙子、外孙女
327	40	011	祖父母或外祖父母
328	40	012	兄弟姐妹

	 */
	public static final class RELATION{
		public static final Integer RE_1 = 304;//家庭户户主
		public static final Integer RE_2 = 305;//集体户户主
		public static final Integer RE_3 = 306;//配偶
		public static final Integer RE_4 = 307;//子
		public static final Integer RE_5 = 308;//女
		public static final Integer RE_6 = 309;//父亲
		public static final Integer RE_7 = 310;//母亲
		public static final Integer RE_8 = 311;//其他亲属
		public static final Integer RE_9 = 312;//非亲属
		public static final Integer RE_10 = 326;//孙子、孙女或外孙子、外孙女
		public static final Integer RE_11 = 327;//祖父母或外祖父母
		public static final Integer RE_12 = 328;//兄弟姐妹
		public static Integer getStatusByLabel(String status){
			if(StringUtils.equals(status, "家庭户户主")||StringUtils.equals(status, "户主")){
				return RE_1;
			}else if(StringUtils.equals(status, "集体户户主")){
				return RE_2;
			}else if(StringUtils.equals(status, "配偶")){
				return RE_3;
			}else if(StringUtils.equals(status, "子")||StringUtils.equals(status, "长子")){
				return RE_4;
			}else if(StringUtils.equals(status, "女")){
				return RE_5;
			}else if(StringUtils.equals(status, "父亲")){
				return RE_6;
			}else if(StringUtils.equals(status, "母亲")){
				return RE_7;
			}else if(StringUtils.equals(status, "其他亲属")){
				return RE_8;
			}else if(StringUtils.equals(status, "非亲属")){
				return RE_9;
			}else if(StringUtils.equals(status, "孙子、孙女或外孙子、外孙女")||StringUtils.equals(status, "孙子")||StringUtils.equals(status, "孙女")||StringUtils.equals(status, "外孙子")||StringUtils.equals(status, "外孙女")){
				return RE_10;
			}else if(StringUtils.equals(status, "祖父母或外祖父母")){
				return RE_11;
			}else if(StringUtils.equals(status, "兄弟姐妹")){
				return RE_12;
			}else
				return null;
		}
	}
	
	/**
	 * 169	14	001	非农业			1
170	14	002	农业			2
171	14	003	军人			3
172	14	004	非转农			4
173	14	005	农转非			5
174	14	006	状态不明			6

	 * @author shally
	 *
	 */
	public static final class HOUSEHODE_KIND{
		public static final Integer HK_1 = 169;//非农业
		public static final Integer HK_2 = 170;//农业
		public static final Integer HK_3 = 171;//军人
		public static final Integer HK_4 = 172;//非转农
		public static final Integer HK_5 = 173;//农转非
		public static final Integer HK_6 = 174;//状态不明
		public static Integer getStatusByLabel(String status){
			if(StringUtils.equals(status, "非农业")||StringUtils.equals(status, "非农业户口/城镇居民")){
				return HK_1;
			}else if(StringUtils.equals(status, "农业")||StringUtils.equals(status, "农业户口/农村居民")){
				return HK_2;
			}else if(StringUtils.equals(status, "军人")){
				return HK_3;
			}else if(StringUtils.equals(status, "非转农")){
				return HK_4;
			}else if(StringUtils.equals(status, "农转非")){
				return HK_5;
			}else
				return HK_6;
		}
	}
	public static final class SEX{
		public static final Integer MALE = 1;//男
		public static final Integer FEMALE = 2;//女
		public static final Integer NOKNOW = 324;//未知性别
		public static final Integer NONOTIFY = 325;//未说明性别
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "男")!=-1){
				return MALE;
			}else if(StringUtils.indexOf(status, "女")!=-1){
				return FEMALE;
			}else if(StringUtils.indexOf(status, "未知")!=-1){
				return NOKNOW;
			}else if(StringUtils.indexOf(status, "未说明")!=-1){
				return NONOTIFY;
			}else
				return NOKNOW;
		}
	}
	/**
	 * 175	15	001	未婚			1
176	15	002	有偶			2
177	15	003	有效初婚			3
178	15	004	事实初婚			4
179	15	005	再婚			5
180	15	006	同居			6
181	15	007	复婚			7
182	15	008	离婚			8
183	15	009	丧偶			9
184	15	010	重婚			10
185	15	011	其他			11

	 * @author shally
	 *
	 */
	public static final class MARRY_STATUS{
		public static final Integer NO = 175;//未婚
		public static final Integer YES = 176;//有偶
		public static final Integer DESTROY = 182;//离婚
		public static final Integer MARRY_AGAIN = 179;//再婚
		public static final Integer MARRY_REPLY = 181;//复婚
		public static final Integer LOST_OTHER = 183;//丧偶
		public static final Integer MARRY_FIRST = 177;//初婚
		public static final Integer OTHER = 185;//其他
		public static Integer getStatusByLabel(String status){
			if(StringUtils.equals(status, "未婚")){
				return NO;
			}else if(StringUtils.equals(status, "有偶")){
				return YES;
			}else if(StringUtils.equals(status, "已婚")){
				return MARRY_FIRST;
			}else if(StringUtils.equals(status, "离婚")){
				return DESTROY;
			}else if(StringUtils.equals(status, "丧偶")){
				return LOST_OTHER;
			}else if(StringUtils.equals(status, "再婚")){
				return MARRY_AGAIN;
			}else if(StringUtils.equals(status, "复婚")){
				return MARRY_REPLY;
			}else if(StringUtils.equals(status, "初婚")){
				return MARRY_FIRST;
			}else
				return OTHER;
		}
	}
	/**
	 * 313	41	001	研究生及以上
314	41	002	大学本科
315	41	003	大学专科
316	41	004	中等职业
317	41	005	普通高级中学
318	41	006	初级中学
319	41	007	小学
320	41	008	其他
	 * @author shally
	 *
	 */
	public static final class DEGREE{
		public static final Integer D1 = 313;//研究生及以上
		public static final Integer D2 = 314;//大学本科
		public static final Integer D3 = 315;//大学专科
		public static final Integer D4 = 316;//中等职业
		public static final Integer D5 = 317;//普通高级中学
		public static final Integer D6 = 318;//初级中学
		public static final Integer D7 = 319;//小学
		public static final Integer OTHER = 320;//其他
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "研究生")!=-1||StringUtils.indexOf(status, "硕士")!=-1||StringUtils.indexOf(status, "博士")!=-1){
				return D1;
			}else if(StringUtils.indexOf(status, "本科")!=-1){
				return D2;
			}if(StringUtils.indexOf(status, "大学专科")!=-1||StringUtils.indexOf(status, "专科")!=-1||StringUtils.indexOf(status, "大专")!=-1){
				return D3;
			}if(StringUtils.indexOf(status, "中等职业")!=-1||StringUtils.indexOf(status, "中专")!=-1){
				return D4;
			}if(StringUtils.indexOf(status, "普通高级中学")!=-1||StringUtils.indexOf(status, "高中")!=-1){
				return D5;
			}if(StringUtils.indexOf(status, "初级中学")!=-1||StringUtils.indexOf(status, "初中")!=-1){
				return D6;
			}else if(StringUtils.indexOf(status, "小学")!=-1){
				return D7;
			}else
				return OTHER;
		}
	}
	
	public static final class KIND_SHIP{
		public static final Integer OWNER = 710;//亲生
		public static final Integer ADOPT = 711;//领养
		public static final Integer ADOPTION = 712;//过继
	}
	//计划生育奖励优待情况记录
	public static final class WOMAN_AWARD{
		public static final Integer AWARD1 = 699;//独生子女优待
		public static final Integer AWARD2 = 700;//农村养老保险
		public static final Integer AWARD3 = 766;//其他优待奖励
	}

	public static final class FIVE_PERIOD{
		public static final Integer PERIOD_1 = 225;//青春期
		public static final Integer PERIOD_2 = 226;//新婚期
		public static final Integer PERIOD_3 = 227;//孕产期
		public static final Integer PERIOD_4 = 228;//育儿期
		public static final Integer PERIOD_5 = 229;//更年期
	}
	
	public static final String UPLOAD_DIR = "/datafile";
	public static final class UPLOAD_FILE_TYPE{
		public static final Integer RULE1 = 1;//制度管理
		public static final Integer RULE2 = 2;//法律法规
		public static final Integer NOTICE = 3;//通知通报
		public static final Integer MAIL = 4;//邮件
	}
	
	/**
	 * 是否已读
	 * @author 黄静
	 *
	 */
	public static final class IsRead{
		public static final Integer YES = 778;//已读
		public static final Integer NO = 779;//未读
	}
	
	/**
	 * 是否已读
	 * @author 黄静
	 *
	 */
	public static final class IN_TYPE{
		public static final Integer FROM_PROVINCE_OUT = 659;//省外迁入
		public static final Integer FROM_CITY_OUT = 660;//市外迁入
		public static final Integer FROM_CITY_IN = 780;//市内迁入
	}
	/**
	 * 流动原因
	 * @author shally
	 *321	42	001	务工、经商			1
322	42	002	随同流动			2
323	42	003	其他			3

	 */
	public static final class IN_CAUSE{
		public static final Integer IN_CAUSE_1 = 321;//务工、经商
		public static final Integer IN_CAUSE_2 = 322;//随同流动
		public static final Integer IN_CAUSE_3 = 323;//其他
		public static Integer getStatusByLabel(String status){
			if(StringUtils.indexOf(status, "务工")!=-1||StringUtils.indexOf(status, "经商")!=-1){
				return IN_CAUSE_1;
			}else if(StringUtils.indexOf(status, "随同流动")!=-1){
				return IN_CAUSE_2;
			}else if(StringUtils.indexOf(status, "其他")!=-1){
				return IN_CAUSE_3;
			}else
				return IN_CAUSE_3;
		}
	}
	//怀孕结果
	public static final class CONCEPT_RESULT{
		public static final Integer SUCCESS = 691;//活产
		public static final Integer FAIL = 692;//流产
	}
	
	public static final class WORK_TYPE{
		public static final Integer IMPORT = 781;//导入
		public static final Integer CHECK = 782;//校验
	}
	
	public static final class OPERATOR_TYPE{
		public static final Integer ADD = 783;//增加
		public static final Integer UPDATE = 784;//修改
	}
	
	
	
	
}
