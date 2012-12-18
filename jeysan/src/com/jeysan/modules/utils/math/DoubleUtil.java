package com.jeysan.modules.utils.math;
public class DoubleUtil {
	public static Double add(Double... a){
		Double r = 0d;
		for(Double d : a){
			if(d != null)
				r += d;
		}
		return r;
	}
	public static Double sub(Double a,Double b){
		if(a == null)	a = 0d;
		if(b == null)	b = 0d;
		return a - b;
	}
	public static Double mul(Double a,Double b){
		if(a == null)	a = 0d;
		if(b == null)	b = 0d;
		return a * b;
	}
	public static Double div(Double a,Double b){
		if(a == null)	a = 0d;
		if(b == null || b == 0d){
			return 0d;
		}
		return a / b;
	}
	public static Double div(Integer a,Integer b){
		if(a == null)	a = 0;
		if(b == null || b == 0){
			return 0d;
		}
		return new Double(a) / new Double(b);
	}
}
