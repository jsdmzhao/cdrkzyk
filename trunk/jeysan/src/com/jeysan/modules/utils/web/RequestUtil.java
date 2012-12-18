package com.jeysan.modules.utils.web;

import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;

import javax.servlet.ServletRequest;

import com.jeysan.modules.utils.date.DateUtil;

public final class RequestUtil
{
  public static String convertJISEncoding(String target)
  {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    if (target == null) return null;
    String paramString = target.trim();

    for (int loop = 0; loop < paramString.length(); ++loop) {
      int i = paramString.charAt(loop);
      bos.write(i);
    }
    String convertedString = null;
    try {
      convertedString = new String(bos.toByteArray(), "JISAutoDetect");
    } catch (java.io.UnsupportedEncodingException i) {
    }
    return convertedString;
  }

  public static int getIntParameter(ServletRequest request, String paramName, int defaultNum)
  {
    String temp = request.getParameter(paramName);
    if ((temp != null) && (!(temp.equals("")))) {
      int num = defaultNum;
      try {
        num = Integer.parseInt(temp);
      } catch (Exception localException) {
      }
      return num;
    }

    return defaultNum;
  }

  public static long getLongParameter(ServletRequest request, String paramName, long defaultNum)
  {
    String temp = request.getParameter(paramName);
    if ((temp != null) && (!(temp.equals("")))) {
      long num = defaultNum;
      try {
        num = Integer.parseInt(temp);
      } catch (Exception localException) {
      }
      return num;
    }

    return defaultNum;
  }

  public static String getStringParameter(ServletRequest request, String paramName)
  {
    String temp = request.getParameter(paramName);
    if (temp == null)
      return "";

    if (temp.trim().equals("")) {
      return "";
    }

    temp = temp.trim();
    return temp;
  }

  public static char getCharParameter(ServletRequest request, String paramName, char defaultChar)
  {
    String temp = request.getParameter(paramName);
    if ((temp != null) && (!(temp.equals("")))) {
      char chr = defaultChar;
      try {
        chr = temp.charAt(0);
      } catch (Exception localException) {
      }
      return chr;
    }

    return defaultChar;
  }

  public static float getFloatParameter(ServletRequest request, String paramName, float defaultNum)
  {
    String temp = request.getParameter(paramName);
    if ((temp != null) && (!(temp.equals("")))) {
      float num = defaultNum;
      try {
        num = Float.parseFloat(temp);
      } catch (Exception localException) {
      }
      return num;
    }

    return defaultNum;
  }

  public static double getDoubleParameter(ServletRequest request, String paramName, double defaultNum)
  {
    String temp = request.getParameter(paramName);
    if ((temp != null) && (!(temp.equals("")))) {
      double num = defaultNum;
      try {
        num = Double.parseDouble(temp);
      } catch (Exception localException) {
      }
      return num;
    }

    return defaultNum;
  }

  public static String[] getStringArrayWithSplit(ServletRequest request, String paramName, String splitStr)
  {
    String temp = request.getParameter(paramName);
    if ((temp != null) && (temp.trim().length() > 0))
      try {
        return temp.split(splitStr);
      }
      catch (Exception ex) {
        ex.printStackTrace();
        return new String[0];
      }

    return new String[0];
  }

  public static Long[] getLongArray(ServletRequest request, String paramName)
  {
    String[] temp = request.getParameterValues(paramName);
    if ((temp != null) && (temp.length > 0)) {
      Long[] array = new Long[temp.length];
      for (int i = 0; i < temp.length; ++i)
        array[i] = new Long(temp[i]);

      return array;
    }

    return null;
  }

  public static Long[] objectArrayToLong(Object[] temp)
  {
    if ((temp != null) && (temp.length > 0)) {
      Long[] array = new Long[temp.length];
      for (int i = 0; i < temp.length; ++i)
        array[i] = new Long(String.valueOf(temp[i]));

      return array;
    }

    return null;
  }

  public static String[] objectArrayToString(Object[] temp)
  {
    if ((temp != null) && (temp.length > 0)) {
      String[] array = new String[temp.length];
      for (int i = 0; i < temp.length; ++i)
        array[i] = String.valueOf(temp[i]);

      return array;
    }

    return null;
  }

  public static Long[] stringArrayToLong(String[] temp)
  {
    if ((temp != null) && (temp.length > 0)) {
      Long[] array = new Long[temp.length];
      for (int i = 0; i < temp.length; ++i)
        array[i] = new Long(temp[i]);

      return array;
    }

    return null;
  }

  public static String[] longArrayToString(Long[] temp)
  {
    if ((temp != null) && (temp.length > 0)) {
      String[] array = new String[temp.length];
      for (int i = 0; i < temp.length; ++i)
        array[i] = temp[i].toString();

      return array;
    }

    return null;
  }

  public static String getUrlStringParameter(ServletRequest request, String paramName)
  {
    String temp = request.getParameter(paramName);
    if (temp == null)
      return "";

    if (temp.trim().equals("")) {
      return "";
    }

    temp = temp.trim();
    return temp;
  }

  public static Timestamp getTimestampParameter(ServletRequest request, String paramName)
  {
    String temp = request.getParameter(paramName);
    if (temp.indexOf("-") > 0)
      return DateUtil.createTimestamp(temp, "-");
    if (temp.indexOf("/") > 0)
      return DateUtil.createTimestamp(temp, "/");

    return null;
  }

  public static String replace(String str, String target, String with)
  {
    if (str == null)
      return null;

    if (str == "")
      return "";

    if ((target == null) || (target.equals("")))
      return str;

    if (with == null)
      with = "";

    int len = target.length();
    int pos = str.indexOf(target);
    if (pos == -1) {
      return str;
    }

    return str.substring(0, pos) + with + 
      replace(str.substring(pos + len), target, with);
  }

  public static String replaceContentToHtml(String str)
  {
    str = replace(str, ">", "&gt;");
    str = replace(str, "<", "&lt;");
    str = replace(str, "\n", "<br>");
    str = replace(str, "\t", "&nbsp;&nbsp;");
    str = replace(str, "[url", "<a href");
    str = replace(str, "[/url]", "</a>");
    str = replace(str, "[img", "<img");
    str = replace(str, "]", ">");
    return str;
  }

  public static String replaceContentToTextarea(String str) {
    str = replace(str, "<br>", "\n");
    str = replace(str, "&nbsp;&nbsp;", "\t");
    str = replace(str, "<a href", "[url");
    str = replace(str, "</a>", "[/url]");
    str = replace(str, "<img", "[img");
    str = replace(str, ">", "]");
    str = replace(str, "&gt;", ">");
    str = replace(str, "&lt;", "<");
    return str;
  }

  public static boolean arrayContains(Object[] temp, Object obj)
  {
    if ((temp != null) && (temp.length > 0) && (obj != null)) {
      for (int i = 0; i < temp.length; ++i)
        if (obj.equals(temp[i]))
          return true;


      return false;
    }

    return false;
  }
  
  public static void setAttribute(ServletRequest request, String paramName){
	  request.setAttribute(paramName, request.getParameter(paramName));
  }
}