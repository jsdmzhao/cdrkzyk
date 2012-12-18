package com.jeysan.modules.utils.math;
import java.math.BigDecimal;

public class BigDecimalUtil
{
  private static final int DEF_DIV_SCALE = 10;

  public static BigDecimal add(BigDecimal v1, BigDecimal v2)
  {
    if (v1 == null)
      v1 = new BigDecimal(0);
    if (v2 == null)
      v2 = new BigDecimal(0);
    return v1.add(v2);
  }

  public static BigDecimal add(BigDecimal[] v)
  {
    BigDecimal r = new BigDecimal(0);
    if (v == null)
      return r;
    for (int i = 0; i < v.length; ++i)
      if (v[i] != null)
        r = r.add(v[i]);

    return r;
  }

  public static BigDecimal sub(BigDecimal v1, BigDecimal v2)
  {
    if (v1 == null)
      v1 = new BigDecimal(0);
    if (v2 == null)
      v2 = new BigDecimal(0);
    return v1.subtract(v2);
  }

  public static BigDecimal sub(BigDecimal[] v1, BigDecimal[] v2)
  {
    BigDecimal r = new BigDecimal(0);
    if (v1 == null)
      return r;
    if (v2 == null)
      return r;
    return sub(add(v1), add(v2));
  }

  public static BigDecimal mul(BigDecimal v1, BigDecimal v2)
  {
    if (v1 == null)
      v1 = new BigDecimal(0);
    if (v2 == null)
      v2 = new BigDecimal(0);
    return v1.multiply(v2);
  }

  public static BigDecimal mul(BigDecimal[] v)
  {
    BigDecimal r = new BigDecimal(0);
    if (v == null)
      return r;
    for (int i = 0; i < v.length; ++i)
      if (v[i] != null)
        r = r.multiply(v[i]);
      else
        return r;

    return r;
  }

  public static BigDecimal div(BigDecimal v1, BigDecimal v2)
  {
    if (v1 == null)
      v1 = new BigDecimal(0);
    if (v2 == null)
      return new BigDecimal(0);
    return div(v1, v2, 10);
  }

  public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale)
  {
    if (scale < 0)
      throw new IllegalArgumentException(
        "The scale must be a positive integer or zero");

    if (v1 == null)
      v1 = new BigDecimal(0);
    if (v2 == null)
      return new BigDecimal(0);
    return v1.divide(v2, scale, 4);
  }

  public static BigDecimal round(BigDecimal v, int scale)
  {
    if (v == null)
      v = new BigDecimal(0);
    if (scale < 0)
      throw new IllegalArgumentException(
        "The scale must be a positive integer or zero");

    BigDecimal one = new BigDecimal("1");
    return v.divide(one, scale, 4);
  }
  public static BigDecimal round(String v, int scale)
  {
    return round(new BigDecimal(v),scale);
  }
  public static void main(String[] argv){
	  System.out.println(round(new BigDecimal("87843.23467"),4));
  }
  
  public static BigDecimal compare(BigDecimal v1, BigDecimal v2)
  {
    if (v1 == null)
      v1 = new BigDecimal(0);
    if (v2 == null)
      v2 = new BigDecimal(0);
    return v1.doubleValue()>v2.doubleValue()?v1:v2;
  }
}