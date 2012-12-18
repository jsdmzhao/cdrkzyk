package com.jeysan.modules.utils.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import com.jeysan.modules.utils.math.MoneyUtil;

public class DateUtil
{
  public static java.util.Date getNowUtilDate()
  {
    return new java.util.Date();
  }

  public static java.util.Date getEndofDate(java.util.Date date)
  {
    String dd = convertDateToString(date, "yyyy-MM-dd");
    return createUtilDate(dd + " 23:59:59");
  }

  public static java.util.Date getStartofDate(java.util.Date date)
  {
    String dd = convertDateToString(date, "yyyy-MM-dd");
    return createUtilDate(dd + " 00:00:00");
  }

  public static java.sql.Date getNowSqlDate()
  {
    return new java.sql.Date(System.currentTimeMillis());
  }

  public static Timestamp getNowTimestamp()
  {
    return new Timestamp(System.currentTimeMillis());
  }

  public static java.util.Date createUtilDate(int year, int month, int date, int hour, int minute, int second)
  {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month - 1, date, hour, minute, second);
    cal.set(14, 0);
    return new java.util.Date(cal.getTimeInMillis());
  }

  public static java.util.Date createUtilDate(int year, int month, int date)
  {
    return createUtilDate(year, month, date, 0, 0, 0);
  }

  public static java.sql.Date createSqlDate(int year, int month, int date, int hour, int minute, int second)
  {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month - 1, date, hour, minute, second);
    cal.set(14, 0);
    return new java.sql.Date(cal.getTimeInMillis());
  }

  public static java.sql.Date createSqlDate(int year, int month, int date)
  {
    return createSqlDate(year, month, date, 0, 0, 0);
  }

  public static String convertDateToString(java.util.Date date, String format)
  {
	  if(date == null)
		  return null;
    if ((format == null) || (format.length() == 0))
      format = "yyyy-MM-dd HH:mm:ss";
    DateFormat sf = new SimpleDateFormat(format);
    return sf.format(date);
  }

  public static String convertDateToString(java.util.Date date)
  {
    return convertDateToString(date, "yyyy-MM-dd HH:mm:ss");
  }

  public static Timestamp createTimestamp(String dateString)
  {
    try
    {
      if ((dateString == null) || (dateString.length() == 0))
        return null;
      Date tmpDate = createUtilDate(dateString);
      if (tmpDate != null)
        return new Timestamp(tmpDate.getTime());

      return Timestamp.valueOf(dateString);
    }
    catch (Exception ignored) {
    }
    return null;
  }

  public static java.sql.Date createSqlDate(String dateString)
  {
    try
    {
      if ((dateString == null) || (dateString.length() == 0))
        return null;
      Date tmpDate = createUtilDate(dateString);
      if (tmpDate != null)
        return new java.sql.Date(tmpDate.getTime());

      return java.sql.Date.valueOf(dateString);
    }
    catch (Exception tmpDate) {
    }
    return null;
  }

  public static java.sql.Date createSqlDate(String dateString, String pattern)
  {
    try
    {
      if ((dateString == null) || (dateString.length() == 0))
        return null;
      if ((pattern == null) || (pattern.length() == 0))
        return createSqlDate(dateString);
      SimpleDateFormat sf = new SimpleDateFormat(pattern.trim());
      java.util.Date tmpDate = sf.parse(dateString.trim());
      if (tmpDate != null)
      return new java.sql.Date(tmpDate.getTime());
    }
    catch (Exception sf)
    {
    }
    return null;
  }

  public static java.util.Date createUtilDate(String dateString, String pattern)
  {
    try
    {
      if ((dateString == null) || (dateString.length() == 0))
        return null;
      if ((pattern == null) || (pattern.length() == 0))
        return createUtilDate(dateString);
      SimpleDateFormat sf = new SimpleDateFormat(pattern.trim());
      return sf.parse(dateString.trim());
    }
    catch (Exception sf)
    {
    }
    return null;
  }

  public static java.util.Date createUtilDate(String dateString)
  {
    try
    {
      if ((dateString == null) || (dateString.length() == 0))
        return null;
      String pattern = "";
      dateString = dateString.trim();
      if (dateString.length() == 10) {
        if (dateString.indexOf("/") != -1) {
          pattern = "yyyy/MM/dd";}
        if (dateString.indexOf("-") != -1) {
          pattern = "yyyy-MM-dd";
        }
      }
      if (dateString.length() == 19)
        if (dateString.indexOf("/") != -1)
          pattern = "yyyy-MM-dd HH:mm:ss";
        else if (dateString.indexOf("-") != -1)
          pattern = "yyyy-MM-dd HH:mm:ss";
      else if (dateString.length() == 8)
        pattern = "yyyyMMdd";

     DateFormat sf = new SimpleDateFormat(pattern);
      return sf.parse(dateString.trim());
    }
    catch (Exception pattern)
    {
    }
    return null;
  }

  public static Calendar convertDateToCalendar(java.util.Date date)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
  }

  public static Timestamp convertCalendarToTimes(Calendar cal)
  {
    return new Timestamp(cal.getTimeInMillis());
  }

  public static java.util.Date convertCalendarToUtilDate(Calendar cal)
  {
    return new java.util.Date(cal.getTimeInMillis());
  }

  public static java.sql.Date convertCalendarToSqlDate(Calendar cal)
  {
    return new java.sql.Date(cal.getTimeInMillis());
  }

  public static int getYear(java.util.Date date)
  {
    return convertDateToCalendar(date).get(1);
  }

  public static int getMonth(java.util.Date date)
  {
    return (convertDateToCalendar(date).get(2) + 1);
  }

  public static int getDayOfMonth(java.util.Date date)
  {
    return convertDateToCalendar(date).get(5);
  }

  public static int getHour(java.util.Date date)
  {
    return convertDateToCalendar(date).get(11);
  }

  public static int getMinute(java.util.Date date)
  {
    return convertDateToCalendar(date).get(12);
  }

  public static int getSecond(java.util.Date date)
  {
    return convertDateToCalendar(date).get(13);
  }

  public static int getMillisecond(java.util.Date date)
  {
    return convertDateToCalendar(date).get(14);
  }

  public static long getMilliseconds(java.util.Date date)
  {
    return date.getTime();
  }

  public static int getDayOfWeek(java.util.Date date)
  {
    return convertDateToCalendar(date).get(7);
  }

  public static java.util.Date dateAdd(String addpart, java.util.Date times, int addnum)
  {
    Calendar cal = convertDateToCalendar(times);
    if ("y".equals(addpart)) {
      cal.add(1, addnum);
    }
    else if ("M".equals(addpart)) {
      cal.add(2, addnum);
    }
    else if ("d".equals(addpart)) {
      cal.add(5, addnum);
    }
    else if ("H".equals(addpart)) {
      cal.add(10, addnum);
    }
    else if ("m".equals(addpart)) {
      cal.add(12, addnum);
    }
    else if ("s".equals(addpart)) {
      cal.add(13, addnum);
    }
    else
      return null;

    return convertCalendarToTimes(cal);
  }

  public static Timestamp dateAdd(int addpart, java.util.Date times, int addnum) {
    Calendar cal = convertDateToCalendar(times);
    cal.add(addpart, addnum);
    return convertCalendarToTimes(cal);
  }

  public static boolean isLeapYear(java.util.Date date)
  {
    return isLeapYear(getYear(date));
  }

  public static boolean isLeapYear(int year)
  {
    GregorianCalendar cal = new GregorianCalendar();
    return cal.isLeapYear(year);
  }

  public static Timestamp formatAsTimestamp(java.util.Date time)
  {
    return new Timestamp(formatAsUtilDate(time).getTime());
  }

  public static java.util.Date getLastDayOfMonth(int year, int month) {
    if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))
      return createTimestamp(year, month, 31);

    if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
      return createTimestamp(year, month, 30);

    if (month == 2) {
      if (isLeapyear(year)) {
        return createUtilDate(year, month, 29);
      }

      return createUtilDate(year, month, 28);
    }

    return null;
  }

  public static java.util.Date getLastDayOfMonth(java.util.Date date)
  {
    return getLastDayOfMonth(getYear(date), getMonth(date));
  }

  public static boolean isLeapyear(java.util.Date ts) {
    Calendar cal = Calendar.getInstance();
    boolean booleanleapYear = ((GregorianCalendar)cal).isLeapYear(getYear(ts));
    return booleanleapYear;
  }

  public static java.util.Date formatAsUtilDate(java.util.Date date)
  {
    Calendar cd = Calendar.getInstance();
    cd.setTime(date);
    cd.set(11, 0);
    cd.set(12, 0);
    cd.set(13, 0);
    cd.set(14, 0);
    return cd.getTime();
  }

  public static java.sql.Date formatAsSqlDate(java.sql.Date date)
  {
    return new java.sql.Date(formatAsUtilDate(date).getTime());
  }

  public static java.util.Date getNowDate()
  {
    Calendar cal = Calendar.getInstance();
    cal.set(cal.get(1), cal.get(2), cal.get(5), 0, 0, 0);
    cal.set(14, 0);
    return convertCalToTs(cal);
  }

  public static java.sql.Date getTodayDate()
  {
    Calendar c = Calendar.getInstance();
    java.sql.Date now = new java.sql.Date(c.getTimeInMillis());
    return now;
  }

  public static Timestamp getNowTime()
  {
    return new Timestamp(System.currentTimeMillis());
  }

  public static Timestamp convertCalToTs(Calendar calendar)
  {
    return new Timestamp(calendar.getTime().getTime());
  }

  public static java.util.Date convertTsToDt(Timestamp ts)
  {
    return new java.util.Date(ts.getTime());
  }

  public static Timestamp convertDtToTs(java.util.Date dt)
  {
    return new Timestamp(dt.getTime());
  }

  public static Timestamp createTimestamp(int year, int month, int date)
  {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month - 1, date, 0, 0, 0);
    cal.set(14, 0);
    return convertCalToTs(cal);
  }

  public static Timestamp createTimestampBySplit(String str, String splitStr)
  {
    if ((str == null) || (str.trim().length() < 1))
      return null;

    if ("".equals(splitStr))
      splitStr = "-";

    if (str.lastIndexOf(" ") != -1)
      str = str.substring(0, 10);
    try {
      StringTokenizer st = new StringTokenizer(str, splitStr);
      int year = Integer.parseInt(st.nextToken());
      int month = Integer.parseInt(st.nextToken());
      int date = Integer.parseInt(st.nextToken());
      return createTimestamp(year, month, date); } catch (Exception e) {
    }
    return null;
  }

  public static int getYear(Timestamp ts)
  {
    return convertTsToCal(ts).get(1);
  }

  public static int getMonth(Timestamp ts)
  {
    return (convertTsToCal(ts).get(2) + 1);
  }

  public static int getDate(Timestamp ts)
  {
    return convertTsToCal(ts).get(5);
  }

  public static int getHour(Timestamp ts)
  {
    return convertTsToCal(ts).get(11);
  }

  public static int getMinute(Timestamp ts)
  {
    return convertTsToCal(ts).get(12);
  }

  public static int getSecond(Timestamp ts)
  {
    return convertTsToCal(ts).get(13);
  }

  public static int getMillisecond(Timestamp ts)
  {
    return convertTsToCal(ts).get(14);
  }

  public static long getMilliseconds(Timestamp ts)
  {
    return ts.getTime();
  }

  public static int getDay(Timestamp ts)
  {
    return convertTsToCal(ts).get(7);
  }

  public static String getStrDay(Timestamp ts)
  {
    if (ts == null) return null;
    int day = getDay(ts);
    String weekDay = "";
    switch (day)
    {
    case 1:
      weekDay = "星期天";
      break;
    case 2:
      weekDay = "星期一";
      break;
    case 3:
      weekDay = "星期二";
      break;
    case 4:
      weekDay = "星期三";
      break;
    case 5:
      weekDay = "星期四";
      break;
    case 6:
      weekDay = "星期五";
      break;
    case 7:
      weekDay = "星期六";
      break;
    default:
      weekDay = "";
    }

    return weekDay;
  }

  public static Timestamp dateAdd(String addpart, Timestamp ts, int addnum)
  {
    Calendar cal = Calendar.getInstance();
    cal = convertTsToCal(ts);
    if ("yy".equals(addpart))
      cal.add(1, addnum);
    else if ("mm".equals(addpart))
      cal.add(2, addnum);
    else if ("dd".equals(addpart))
      cal.add(5, addnum);
    else if ("hh".equals(addpart))
      cal.add(10, addnum);
    else if ("mi".equals(addpart))
      cal.add(12, addnum);
    else if ("ss".equals(addpart))
      cal.add(13, addnum);
    else
      return null;

    return convertCalToTs(cal);
  }
  
  public static int dateDiff(String diffpart, Date d1, Date d2){
	  Timestamp ts1 = new Timestamp(d1.getTime());
	  Timestamp ts2 = new Timestamp(d2.getTime());
	  return dateDiff(diffpart, ts1, ts2);
  }

  public static int dateDiff(String diffpart, Timestamp ts1, Timestamp ts2)
  {
    if ((ts1 == null) || (ts2 == null)) {
      return -1;
    }

    java.util.Date date1 = null;
    java.util.Date date2 = null;

    date1 = new java.util.Date(ts1.getTime());
    date2 = new java.util.Date(ts2.getTime());

    Calendar cal1 = null;
    Calendar cal2 = null;

    cal1 = Calendar.getInstance();
    cal2 = Calendar.getInstance();

    cal1.setTime(date1);
    long ldate1 = date1.getTime() + cal1.get(15) + cal1.get(16);

    cal2.setTime(date2);
    long ldate2 = date2.getTime() + cal2.get(15) + cal2.get(16);

    int hr1 = (int)(ldate1 / 3600000L);
    int hr2 = (int)(ldate2 / 3600000L);

    int days1 = hr1 / 24;
    int days2 = hr2 / 24;

    int dateDiff = days2 - days1;
    int weekOffset = (cal2.get(7) - cal1.get(7) < 0) ? 1 : 0;
    int weekDiff = dateDiff / 7 + weekOffset;
    int yearDiff = cal2.get(1) - cal1.get(1);
    int monthDiff = yearDiff * 12 + cal2.get(2) - cal1.get(2);

    if ("YEAR".equals(diffpart))
      return yearDiff;
    if ("MONTH".equals(diffpart))
      return monthDiff;
    if ("DATE".equals(diffpart))
      return dateDiff;
    if ("WEEK".equals(diffpart))
      return weekDiff;

    return dateDiff;
  }

  public static boolean isLeapyear(Timestamp ts)
  {
    Calendar cal = Calendar.getInstance();
    boolean booleanleapYear = ((GregorianCalendar)cal).isLeapYear(getYear(ts));
    return booleanleapYear;
  }

  public static boolean isLeapyear(int year)
  {
    Calendar cal = Calendar.getInstance();
    boolean booleanleapYear = ((GregorianCalendar)cal).isLeapYear(year);
    return booleanleapYear;
  }

  public static boolean isMatchDate(int year, int month, int date, Timestamp ts)
  {
    int year1 = getYear(ts);
    int month1 = getMonth(ts);
    int date1 = getDay(ts);

    if ((year != -1) && (year != year1))
      return false;

    if ((month != -1) && (month != month1)) {
      return false;
    }

    return ((date == -1) || (date == date1));
  }

  public static Timestamp getFirstDayOfMonth(String year, String month)
  {
    if ((year == null) || (month == null))
      return null;

    int y = Integer.valueOf(year).intValue();
    int m = Integer.valueOf(month).intValue();

    return createTimestamp(y, m, 1);
  }

  public static Timestamp getLastDayOfMonth(String year, String month)
  {
    if ((year == null) || (month == null))
      return null;

    int y = Integer.valueOf(year).intValue();
    int m = Integer.valueOf(month).intValue();

    if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12))
      return createTimestamp(y, m, 31);
    if ((m == 4) || (m == 6) || (m == 9) || (m == 11))
      return createTimestamp(y, m, 30);
    if (m == 2) {
      if (isLeapyear(y))
        return createTimestamp(y, m, 29);

      return createTimestamp(y, m, 28);
    }

    return null;
  }

  public static boolean isWorkday(Timestamp ts)
  {
    int month = getMonth(ts);
    int date = getDate(ts);
    int day = getDay(ts);

    if ((day == 1) || (day == 7)) {
      return false;
    }

    if ((month == 1) && (1 <= date) && (date <= 3)) {
      return false;
    }

    if ((month == 5) && (1 <= date) && (date <= 7)) {
      return false;
    }

    return ((month != 10) || (1 > date) || (date > 7));
  }

  public static Timestamp formatToDate(Timestamp ts)
  {
    Calendar cd = Calendar.getInstance();
    cd.setTimeInMillis(ts.getTime());
    cd.set(11, 0);
    cd.set(12, 0);
    cd.set(13, 0);
    cd.set(14, 0);
    return new Timestamp(cd.getTime().getTime());
  }

  public static java.util.Date formatToDate(java.util.Date dt)
  {
    Calendar cd = Calendar.getInstance();
    cd.setTime(dt);
    cd.set(11, 0);
    cd.set(12, 0);
    cd.set(13, 0);
    cd.set(14, 0);
    return cd.getTime();
  }

  public static java.sql.Date formatToDate(java.sql.Date dt)
  {
    Calendar cd = Calendar.getInstance();
    cd.setTimeInMillis(dt.getTime());
    cd.set(11, 0);
    cd.set(12, 0);
    cd.set(13, 0);
    cd.set(14, 0);
    return new java.sql.Date(cd.getTime().getTime());
  }

  public static String formatDateToCn(Timestamp ts)
  {
    if (ts == null)
      return "";
    int year = getYear(ts);
    int month = getMonth(ts);
    int date = getDate(ts);

    String[] hanDigiStr = { 
      "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾" };

    String cnDate = "";

    String tempYear = String.valueOf(year);
    String tempMonth = String.valueOf(month);
    String tempDate = String.valueOf(date);

    if (tempYear.length() != 4)
      return "";

    for (int i = 0; i < tempYear.length(); ++i)
      cnDate = cnDate + hanDigiStr[new Integer(tempYear.substring(i, i + 1)).intValue()];

    cnDate = cnDate + "年";

    if ((month < 1) || (month > 12) || (date < 1) || (date > 31))
      return "";

    cnDate = cnDate + MoneyUtil.positiveIntegerToHanStr(tempMonth);
    cnDate = cnDate + "月";
    cnDate = cnDate + MoneyUtil.positiveIntegerToHanStr(tempDate);
    cnDate = cnDate + "日";

    return cnDate;
  }

  public static Calendar convertTsToCal(Timestamp ts)
  {
    Calendar cald = Calendar.getInstance();
    cald.setTime(new java.util.Date(ts.getTime()));
    return cald;
  }

  public static String convertTsToStr(Timestamp ts)
  {
    if (ts != null)
      return ts.toString().substring(0, 10);
    return "";
  }

  public static String convertTsToStrWithSecs(Timestamp ts)
  {
    if (ts != null)
      return ts.toString().substring(0, 19);
    return "";
  }

  public static String convertTsToStrWithDayOfWeek(Timestamp ts)
  {
    if (ts != null)
      return ts.toString().substring(0, 10) + " " + getStrDay(ts);
    return "";
  }

  public static Timestamp createTimestamp(int year, int month, int date, int hour, int minute, int second)
  {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month - 1, date, hour, minute, second);
    cal.set(14, 0);
    cal.set(9, 0);
    return convertCalToTs(cal);
  }

  public static Timestamp createTimestamp(String str, String splitStr)
  {
    if ((str == null) || (str.trim().length() < 1))
      return null;

    if ("".equals(splitStr))
      splitStr = "-";

    if (str.lastIndexOf(" ") != -1)
      str = str.substring(0, 10);
    try {
      StringTokenizer st = new StringTokenizer(str, splitStr);
      int year = Integer.parseInt(st.nextToken());
      int month = Integer.parseInt(st.nextToken());
      int date = Integer.parseInt(st.nextToken());
      return createTimestamp(year, month, date); } catch (Exception e) {
    }
    return null;
  }

  public static void main(String[] args)
  {
    //System.out.println(formatDateToCn(getNowTime()));
    System.out.println(createUtilDate("08:04","HH:mm").getTime());
    System.out.println(createUtilDate("08:05","HH:mm").getTime());
  }
}