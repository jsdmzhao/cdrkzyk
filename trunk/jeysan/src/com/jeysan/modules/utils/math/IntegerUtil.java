package com.jeysan.modules.utils.math;

import java.math.BigInteger;

public class IntegerUtil {
	public static Integer add(Integer... a){
		Integer r = 0;
		for(Integer d : a){
			if(d != null)
				r += d;
		}
		return r;
	}
	public static Integer sub(Integer a,Integer b){
		if(a == null)	a = 0;
		if(b == null)	b = 0;
		return a - b;
	}
	public static Integer mul(Integer a,Integer b){
		if(a == null)	a = 0;
		if(b == null)	b = 0;
		return a * b;
	}
	public static Integer div(Integer a,Integer b){
		if(a == null)	a = 0;
		if(b == null)	b = 0;
		return a / b;
	}
	
	public static Integer getIntegerFromBigInteger(Object o){
		if(o == null)
			return null;
		if(o instanceof BigInteger){
			return ((BigInteger)o).intValue();
		}
		return null;
	}
}