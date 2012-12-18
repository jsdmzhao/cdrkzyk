package com.jeysan.modules.utils.object;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.rmi.UnexpectedException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jeysan.modules.utils.date.DateUtil;

import freemarker.template.utility.StringUtil;

public class DataBeanUtil
{
  public static Object subPropertesCopy(String objName, Object target, HttpServletRequest request)
  {
    HttpServletRequest source = request;
    PropertyDescriptor[] targetpropertyDescriptor = (PropertyDescriptor[])null;
    Class targetCls = target.getClass();
    try
    {
      targetpropertyDescriptor =
        Introspector.getBeanInfo(targetCls, Object.class).getPropertyDescriptors
        ();
    }
    catch (Exception localException1) {
    }
    for (int i = 0; i < targetpropertyDescriptor.length; ++i) {
      Class clsType = targetpropertyDescriptor[i].getPropertyType();
      String clsName = targetpropertyDescriptor[i].getName();
      Method set = targetpropertyDescriptor[i].getWriteMethod();
      try
      {
        Object fieldValue = null;
        if (set != null) {
        Class[] paraType = set.getParameterTypes();
        String value = (source.getParameter(objName + "." + clsName) == null) ? null : source.getParameter(objName + "." + clsName).trim();
        if (value != null) {
            if (value.toString().length() > 0) {
        if (paraType[0].toString().equals("class java.lang.String")) {
          fieldValue = value;
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.lang.Long")) {
          fieldValue = new Long(value);
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.lang.Integer")) {
          fieldValue = new Integer(value);
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.lang.Double")) {
          fieldValue = new Double(value);
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.util.Date")) {
          fieldValue = DateUtil.createUtilDate(value);
          if ((value != null) && (value.length() > 0) && (fieldValue == null))
            fieldValue = new Date(value);

          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.math.BigDecimal")) {
        	fieldValue = new BigDecimal(value);
            set.invoke(target, new Object[] { fieldValue });
          }
        if (paraType[0].toString().equals("class java.sql.Timestamp")) {
          fieldValue = DateUtil.createTimestamp(value, "-");
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("int")) {
          fieldValue = Integer.valueOf(Integer.parseInt(value));
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("long")) {
          fieldValue = Long.valueOf(Long.parseLong(value));
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("double")) {
          fieldValue = Double.valueOf(Double.parseDouble(value));
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class [Ljava.lang.String;")) {
          String[] t = source.getParameterValues(objName + "." + clsName);
          set.invoke(target, new Object[] { t });
        }
        if (paraType[0].toString().equals("class [Ljava.lang.Long;")) {
          String[] t = source.getParameterValues(objName + "." + clsName);
          Long[] s = new Long[t.length];
          for (int j = 0; j < s.length; ++j)
            s[j] = new Long(t[j]);

          set.invoke(target, new Object[] { s });
        }
        if (paraType[0].toString().equals("class [Ljava.lang.Double;")) {
          String[] t = source.getParameterValues(objName + "." + clsName);
          Double[] s = new Double[t.length];
          for (int j = 0; j < s.length; ++j)
            s[j] = new Double(t[j]);

          set.invoke(target, new Object[] { s });
        }
        if (paraType[0].toString().equals("class [J")) {
          String[] t = source.getParameterValues(objName + "." + clsName);
          long[] s = new long[t.length];
          for (int j = 0; j < s.length; ++j)
            s[j] = Long.parseLong(t[j]);

          set.invoke(target, new Object[] { s });
        }
        if (paraType[0].toString().equals("class [I")) {
          String[] t = source.getParameterValues(objName + "." + clsName);
          int[] s = new int[t.length];
          for (int j = 0; j < s.length; ++j)
            s[j] = Integer.parseInt(t[j]);

          set.invoke(target, new Object[] { s });
        }      }}
        if (paraType[0].toString().equals("class [D")){
        String[] t = source.getParameterValues(objName + "." + clsName);
        double[] s = new double[t.length];
        for (int j = 0; j < s.length; ++j)
          s[j] = Double.parseDouble(t[j]);

        set.invoke(target, new Object[] { s });
        }
      }    }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }

  public static Object copyProperty(Object parent, HttpServletRequest request)
  {
    HttpServletRequest source = request;
    Class parentCls = parent.getClass();
    PropertyDescriptor[] parentpropertyDescriptor = (PropertyDescriptor[])null;
    try
    {
      parentpropertyDescriptor =
        Introspector.getBeanInfo(parentCls, Object.class).getPropertyDescriptors
        ();
    }
    catch (Exception localException)
    {
    }

    String objName = "";

    for (int i = 0; i < parentpropertyDescriptor.length; ++i) {
      Class clsType = parentpropertyDescriptor[i].getPropertyType();
      Method set = parentpropertyDescriptor[i].getWriteMethod();
      Object fieldValue = null;
      objName = parentpropertyDescriptor[i].getName();
      if (set == null) continue;
      try {
        String strValue;
        String[] t;
        int j;
        if ("class java.lang.String".equals(clsType.toString()))
        {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();

          if (("sort".equals(objName)) && (strValue == null))
          {
            set.invoke(parent, new Object[] { strValue });
          }
          if (("dir".equals(objName)) && (strValue == null)) {
            set.invoke(parent, new Object[] { strValue });
          }
          else {
            if (strValue != null && strValue.length() > 0)
                set.invoke(parent, new Object[] { strValue });
          }
        }
        if ("class java.lang.Double".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (strValue != null && strValue.length() > 0){
              fieldValue = new Double(strValue);
              set.invoke(parent, new Object[] { fieldValue });
          }
        }
        if ("class java.math.BigDecimal".equals(clsType.toString())) {
            strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
            if (strValue != null && strValue.length() > 0){
                fieldValue = new BigDecimal(strValue);
                set.invoke(parent, new Object[] { fieldValue });
            }
          }
        if ("class java.lang.Integer".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (strValue != null && strValue.length() > 0){
          fieldValue = new Integer(strValue);
          set.invoke(parent, new Object[] { fieldValue });   }
        }
        if ("class java.lang.Long".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (strValue != null && strValue.length() > 0){
          fieldValue = new Long(strValue);
          set.invoke(parent, new Object[] { fieldValue });    }
        }
        if ("class java.util.Date".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (strValue != null && strValue.length() > 0){
          fieldValue = DateUtil.createUtilDate(strValue);
          if (fieldValue == null)
            fieldValue  = new Date(strValue);
          set.invoke(parent, new Object[] { fieldValue });
          }
        }
        if ("class java.sql.Timestamp".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (strValue != null && strValue.length() > 0){
          fieldValue = DateUtil.createTimestamp(strValue, "-");
          set.invoke(parent, new Object[] { fieldValue });    }
        }
        if ("int".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (("start".equals(objName)) && (strValue == null))
          {
            set.invoke(parent, new Object[] { Integer.valueOf(0) });
          }
          if (("limit".equals(objName)) && (strValue == null)) {
            set.invoke(parent, new Object[] { Integer.valueOf(20) });
          }
          else {
            if (strValue != null && strValue.length() > 0){
            fieldValue = Integer.valueOf(Integer.parseInt(strValue));
            set.invoke(parent, new Object[] { fieldValue }); }
          }
        }
        if ("long".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (strValue != null && strValue.length() > 0){
          fieldValue = Long.valueOf(Long.parseLong(strValue));
          set.invoke(parent, new Object[] { fieldValue });     }
        }
        if ("double".equals(clsType.toString())) {
          strValue = (source.getParameter(objName) == null) ? null : source.getParameter(objName).trim();
          if (strValue != null && strValue.length() > 0){
          fieldValue = Double.valueOf(Double.parseDouble(strValue));
          set.invoke(parent, new Object[] { fieldValue });    }
        }
        if (clsType.toString().equals("class [Ljava.lang.String;")) {
          t = source.getParameterValues(objName);
          set.invoke(parent, new Object[] { t });
        }
        if (clsType.toString().equals("class [Ljava.lang.Long;")) {
          t = source.getParameterValues(objName);
          Long[] s = new Long[t.length];
          for (j = 0; j < s.length; ++j)
            s[j] = new Long(t[j]);

          set.invoke(parent, new Object[] { s });
        }
        if (clsType.toString().equals("class [Ljava.lang.Double;")) {
          t = source.getParameterValues(objName);
          Double[] s = new Double[t.length];
          for (j = 0; j < s.length; ++j)
            s[j] = new Double(t[j]);

          set.invoke(parent, new Object[] { s });
        }
        if (clsType.toString().equals("class [J")) {
          t = source.getParameterValues(objName);
          long[] s = new long[t.length];
          for (j = 0; j < s.length; ++j)
            s[j] = Long.parseLong(t[j]);

          set.invoke(parent, new Object[] { s });
        }
        if (clsType.toString().equals("class [I")) {
          t = source.getParameterValues(objName);
          int[] s = new int[t.length];
          for (j = 0; j < s.length; ++j)
            s[j] = Integer.parseInt(t[j]);

          set.invoke(parent, new Object[] { s });
        }
        if (clsType.toString().equals("class [D")) {
          t = source.getParameterValues(objName);
          double[] s = new double[t.length];
          for (j = 0; j < s.length; ++j)
            s[j] = Double.parseDouble(t[j]);

          set.invoke(parent, new Object[] { s });
        }

        if (parentpropertyDescriptor[i].getReadMethod() != null){
        Object target = parentpropertyDescriptor[i].getReadMethod().invoke(parent, new Object[0]);
        subPropertesCopy(objName, target, request);   }
      }
      catch (Exception target)
      {
      }

    }

    return null;
  }

  public static Object copyProperty(Object parent, Object to, HttpServletRequest request)
  {
    Class clsType;
    HttpServletRequest source = request;
    Object target = to;
    Class targetCls = target.getClass();
    Class parentCls = parent.getClass();
    PropertyDescriptor[] targetpropertyDescriptor = (PropertyDescriptor[])null;
    PropertyDescriptor[] parentpropertyDescriptor = (PropertyDescriptor[])null;
    try
    {
      parentpropertyDescriptor =
        Introspector.getBeanInfo(parentCls, Object.class).getPropertyDescriptors
        ();

      targetpropertyDescriptor =
        Introspector.getBeanInfo(targetCls, Object.class).getPropertyDescriptors
        ();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    String objName = "";

    for (int i = 0; i < parentpropertyDescriptor.length; ++i) {
      clsType = parentpropertyDescriptor[i].getPropertyType();
      if (targetCls.equals(clsType))
        objName = parentpropertyDescriptor[i].getName();

    }

    for (int i = 0; i < targetpropertyDescriptor.length; ++i) {
      clsType = targetpropertyDescriptor[i].getPropertyType();
      String clsName = targetpropertyDescriptor[i].getName();
      Method set = targetpropertyDescriptor[i].getWriteMethod();
      try
      {
        Object fieldValue = null;
        if (set != null){
        Class[] paraType = set.getParameterTypes();
        String value = (source.getParameter(objName + "." + clsName) == null) ? null : source.getParameter(objName + "." + clsName).trim();
        if (value != null){
        if (paraType[0].toString().equals("class java.lang.String")) {
          fieldValue = value;
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.lang.Long")) {
          fieldValue = new Long(value);
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.lang.Double")) {
          fieldValue = new Double(value);
          set.invoke(target, new Object[] { fieldValue });
        }
        if (paraType[0].toString().equals("class java.math.BigDecimal")) {
            fieldValue = new BigDecimal(value);
            set.invoke(target, new Object[] { fieldValue });
          }
        if (paraType[0].toString().equals("class java.util.Date")) {
          fieldValue = DateUtil.createUtilDate(value);
          set.invoke(target, new Object[] { fieldValue });
        }

        if (paraType[0].toString().equals("class java.sql.Timestamp")){
        fieldValue = DateUtil.createTimestamp(value, "-");
        set.invoke(target, new Object[] { fieldValue });
      } }}}
      catch (Exception e)
      {
        e.printStackTrace();
      }

    }

    return to;
  }

  public static Object instantiate(Class former, Object from)
  {
    try
    {
      return copyProperty(former.newInstance(), from, true);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public static Object copyProperty(Object to, Object from)
  {
    return copyProperty(to, from, false, true);
  }

  public static Object copyProperty(Object to, Object from, boolean copynull) {
    return copyProperty(to, from, copynull, true);
  }

  public static Object copyProperty(Object to, Object from, boolean copynull, boolean copCol)
	{
		Object source = from;
		Object target = to;
		Class sourceCls = source.getClass();
		Class targetCls = target.getClass();
		PropertyDescriptor sourcepropertyDescriptor[] = (PropertyDescriptor[])null;
		PropertyDescriptor targetpropertyDescriptor[] = (PropertyDescriptor[])null;
		try
		{
			sourcepropertyDescriptor = Introspector.getBeanInfo(sourceCls, Object.class).getPropertyDescriptors();
			targetpropertyDescriptor = Introspector.getBeanInfo(targetCls, Object.class).getPropertyDescriptors();
		}
		catch (Exception exception) { }
		for (int i = 0; i < sourcepropertyDescriptor.length; i++)
		{
			Method get = sourcepropertyDescriptor[i].getReadMethod();
			Object value = null;
			try
			{
				value = get.invoke(source, new Object[0]);
			}
			catch (Exception exception1) { }
			if ((value != null || copynull) && (copCol || !(value instanceof Collection)))
			{
				for (int j = 0; j < targetpropertyDescriptor.length; j++)
					if (sourcepropertyDescriptor[i].getName().equals(targetpropertyDescriptor[j].getName()))
					{
						Method set = targetpropertyDescriptor[j].getWriteMethod();
						try
						{
							Object fieldValue = null;
							Class paraType[] = set.getParameterTypes();
							if (test(paraType[0]))
							{
								if (paraType[0].toString().equals("class java.lang.String") && (value instanceof Timestamp))
									fieldValue = DateUtil.convertTsToStr((Timestamp)value);
								else
								if (paraType[0].toString().equals("class java.sql.Timestamp") && (value instanceof String))
									fieldValue = DateUtil.createTimestamp((String)value, "-");
								else
									fieldValue = value;
								set.invoke(target, new Object[] {
									fieldValue
								});
							}
						}
						catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}

			}
		}

		return to;
	}

  private static boolean test(Class class1)
  {
    if (class1.equals(String.class)) return true;
    if (class1.equals(Boolean.class)) return true;
    if (class1.equals(Short.class)) return true;
    if (class1.equals(Long.class)) return true;
    if (class1.equals(Double.class)) return true;
    if (class1.equals(Float.class)) return true;
    if (class1.equals(Integer.class)) return true;
    if (class1.equals(BigDecimal.class)) return true;
    if (class1.equals(Date.class)) return true;
    if (class1.equals(Date.class)) return true;
    if (class1.equals(Timestamp.class)) return true;
    if (class1.equals(Number.class)) return true;

    if (class1.equals(Long.TYPE)) return true;
    if (class1.equals(Double.TYPE)) return true;
    if (class1.equals(Integer.TYPE)) return true;
    if (class1.equals(Float.TYPE)) return true;
    if (class1.equals(Boolean.TYPE)) return true;
    return (class1.equals(Short.TYPE));
  }

  public static Collection getPropertyNames(Class clz)
  {
    Collection names = new ArrayList();
    try {
      PropertyDescriptor dropertyDescriptors[] =
        Introspector.getBeanInfo(clz, Object.class).getPropertyDescriptors
        ();
      for (int i = 0; i < dropertyDescriptors.length; ++i)
        names.add(dropertyDescriptors[i].getName());
    }
    catch (java.beans.IntrospectionException dropertyDescriptors) {
    }
    return names;
  }



  public static Object instantiate(Class former, ResultSet rs)
    throws Exception
  {
    Object v;
    try
    {
      v = former.newInstance();
      return initProperty(v, rs);
    } catch (Exception ex) {
    }
    return null;
  }

  public static Object initProperty(Object to, ResultSet from)
		throws Exception
	{
		if (from == null || to == null)
			return to;
		Object v = to;
		Class cls = to.getClass();
		Class aParam[] = (Class[])null;
		Method aMtds[] = (Method[])null;
		Method mtd = null;
		String sMtdName = null;
		String sFieldName = null;
		try
		{
			aMtds = cls.getMethods();
			for (int i = 0; i < aMtds.length; i++)
			{
				sMtdName = aMtds[i].getName();
				if (sMtdName.length() > 3 && "set".equals(sMtdName.substring(0, 3)))
				{
					aParam = aMtds[i].getParameterTypes();
					if (aParam.length == 1)
					{
						sFieldName = toColumnName(sMtdName.substring(3));
						if (Class.forName("java.lang.String").equals(aParam[0]))
							try
							{
								mtd = cls.getMethod(sMtdName, aParam);
								String aArg = from.getString(sFieldName);
								mtd.invoke(v, new Object[] {
									aArg
								});
							}
							catch (Throwable throwable) { }
						else
						if (Class.forName("java.math.BigDecimal").equals(aParam[0]))
							try
							{
								mtd = cls.getMethod(sMtdName, aParam);
								BigDecimal aArg = from.getBigDecimal(sFieldName);
								mtd.invoke(v, new Object[] {
									aArg
								});
							}
							catch (Throwable throwable1) { }
						else
						if (Class.forName("java.lang.Long").equals(aParam[0]))
							try
							{
								mtd = cls.getMethod(sMtdName, aParam);
								Long aArg = Long.parseLong(from.getString(sFieldName));
								mtd.invoke(v, new Object[] {
									aArg
								});
							}
							catch (Throwable throwable2) { }
						else
						if (Class.forName("java.lang.Double").equals(aParam[0]))
							try
							{
								mtd = cls.getMethod(sMtdName, aParam);
								Double aArg = Double.parseDouble(from.getString(sFieldName));
								mtd.invoke(v, new Object[] {
									aArg
								});
							}
							catch (Throwable throwable3) { }
						else
						if (Class.forName("java.sql.Timestamp").equals(aParam[0]))
							try
							{
								mtd = cls.getMethod(sMtdName, aParam);
								Timestamp arg = from.getTimestamp(sFieldName);
								mtd.invoke(v, new Object[] {
									arg
								});
							}
							catch (Throwable throwable4) { }
					}
				}
			}

		}
		catch (Exception e)
		{
			throw new Exception("initProperty broken.");
		}
		return v;
	}

  public static Collection instantiateList(Class former, ResultSet rs)
    throws Exception
  {
    ArrayList list = new ArrayList();
    try {
      do
        instantiate(former, rs);
      while (
        rs.next());
    }
    catch (SQLException localSQLException) {
    }
    return list;
  }

  public static String toColumnName(String str)
  {
    if (str == null)
      return null;
    if (str.length() <= 1)
      return str.toLowerCase();
    String name = "";
    String src = str;
    String tmp = src.substring(0, 1);
    String tmpLower = tmp.toLowerCase();
    src = src.substring(1);
    name = name.concat(tmpLower);
    try {
      while (src.length() > 0) {
        tmp = src.substring(0, 1);
        tmpLower = tmp.toLowerCase();
        src = src.substring(1);
        if (!(tmp.equals(tmpLower))) {
          name = name.concat("_").concat(tmpLower);
        }
        else
          name = name.concat(tmpLower);
      }
    }
    catch (Exception e)
    {
      return "";
    }
    return name;
  }

  public static void main(String[] args)
  {
  }
}