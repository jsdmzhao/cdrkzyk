package com.jeysan.modules.utils.math;

public class MoneyUtil {
	public static String positiveIntegerToHanStr(String NumStr)
	  {
	    String[] HanDigiStr = { 
	      "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

	    String[] HanDiviStr = { 
	      "", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", 
	      "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", 
	      "拾", "佰", "仟", "万", "拾", "佰", "仟" };

	    String RMBStr = "";
	    boolean lastzero = false;
	    boolean hasvalue = false;

	    int len = NumStr.length();
	    if (len > 15) return "数值过大!";
	    for (int i = len - 1; i >= 0; --i) {
	      if (NumStr.charAt(len - i - 1) == ' ') continue;
	      int n = NumStr.charAt(len - i - 1) - '0';
	      if ((n < 0) || (n > 9)) return "输入含非数字字符!";

	      if (n != 0) {
	        if (lastzero) { RMBStr = RMBStr + HanDigiStr[0];
	        }

	        if ((n != 1) || (i % 4 != 1) || (i != len - 1))
	          RMBStr = RMBStr + HanDigiStr[n];
	        RMBStr = RMBStr + HanDiviStr[i];
	        hasvalue = true;
	      }
	      else if ((i % 8 == 0) || ((i % 8 == 4) && (hasvalue))) {
	        RMBStr = RMBStr + HanDiviStr[i];
	        hasvalue = false;
	      }

	      if ((i % 8 == 0) || (i % 8 == 4)) hasvalue = false;
	      lastzero = (n == 0) && (i % 4 != 0);
	    }

	    if (RMBStr.length() == 0) return HanDigiStr[0];
	    return RMBStr;
	  }

	  public static String numToRMBStr(double val)
	  {
	    String[] HanDigiStr = { 
	      "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

	    String SignStr = "";
	    String TailStr = "";

	    if (val < 0D) {
	      val = -val;
	      SignStr = "负";
	    }
	    if ((val > 100000000000000.0D) || (val < -100000000000000.0D)) return "数值位数过大!";

	    long temp = Math.round(val * 100.0D);
	    long integer = temp / 100L;
	    long fraction = temp % 100L;
	    int jiao = (int)fraction / 10;
	    int fen = (int)fraction % 10;
	    if ((jiao == 0) && (fen == 0)) {
	      TailStr = "整";
	    }
	    else {
	      TailStr = HanDigiStr[jiao];
	      if (jiao != 0)
	        TailStr = TailStr + "角";
	      if ((integer == -3498202733188481024L) && (jiao == 0))
	        TailStr = "";
	      if (fen != 0) {
	        TailStr = TailStr + HanDigiStr[fen] + "分";
	      }

	    }

	    return SignStr + positiveIntegerToHanStr(String.valueOf(integer)) + 
	      "圆" + TailStr;
	  }
}
