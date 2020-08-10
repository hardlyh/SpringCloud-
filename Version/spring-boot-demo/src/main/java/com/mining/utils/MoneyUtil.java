package com.mining.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class MoneyUtil {
	
	    /**
	     * 提供精确加法计算的add方法
	     * @param value1 被加数
	     * @param value2 加数
	     * @return 两个参数的和
	     */
	    public static double add(double value1,double value2){
	        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
	        BigDecimal b2 = new BigDecimal(String.valueOf(value2));
	        return b1.add(b2).doubleValue();
	    }
	    
	    /**
	     * 提供精确加法计算的add方法
	     * @param value1 被加数
	     * @param value2 加数
	     * @return 两个参数的和
	     */
	    public static String add(String value1,String value2){
	    	BigDecimal b1 = new BigDecimal(value1);
	    	BigDecimal b2 = new BigDecimal(value2);
	    	return b1.add(b2).toString();
	    }
	    
	    /**
	     * 提供精确减法运算的sub方法
	     * @param value1 被减数
	     * @param value2 减数
	     * @return 两个参数的差
	     */
	    public static double sub(double value1,double value2){
	        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
	        BigDecimal b2 = new BigDecimal(String.valueOf(value2));
	        return b1.subtract(b2).doubleValue();
	    }
	    
	    /**
	     * 提供精确减法运算的sub方法
	     * @param value1 被减数
	     * @param value2 减数
	     * @return 两个参数的差
	     */
	    public static String sub(String value1,String value2){
	        BigDecimal b1 = new BigDecimal(value1);
	        BigDecimal b2 = new BigDecimal(value2);
	        return b1.subtract(b2).toString();
	    }
	    
	    /**
	     * 提供精确乘法运算的mul方法
	     * @param value1 被乘数
	     * @param value2 乘数
	     * @return 两个参数的积
	     */
	    public static double mul(double value1, double value2){
	        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
	        BigDecimal b2 = new BigDecimal(String.valueOf(value2));
	        return b1.multiply(b2).doubleValue();
	    }
	    
	    /**
	     * 提供精确乘法运算的mul方法
	     * @param value1 被乘数
	     * @param value2 乘数
	     * @return 两个参数的积
	     */
	    public static String mul(String value1, String value2){
	        BigDecimal b1 = new BigDecimal(value1);
	        BigDecimal b2 = new BigDecimal(value2);
	        return doubleTrans2(b1.multiply(b2).doubleValue()); 
	    }
	    
		public static String mulDecimal(String a,String b) {
			BigDecimal bigDecimal = new BigDecimal(a);
			BigDecimal bigDecimal2 = new BigDecimal(b);
			return bigDecimal.multiply(bigDecimal2).toString();
		}
	    
	    /**
	     * 提供精确的除法运算方法div
	     * @param value1 被除数
	     * @param value2 除数
	     * @param scale 精确范围
	     * @return 两个参数的商
	     * @throws IllegalAccessException
	     */
	    public static double div(double value1,double value2,int scale) throws IllegalAccessException{
	        //如果精确范围小于0，抛出异常信息
	        if(scale<0){         
	            throw new IllegalAccessException("精确度不能小于0");
	        }
	        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
	        BigDecimal b2 = new BigDecimal(String.valueOf(value2));
	        return b1.divide(b2,scale, BigDecimal.ROUND_HALF_UP).doubleValue();    
	    }
	    
	    /**
	     * 提供精确的除法运算方法div
	     * @param value1 被除数
	     * @param value2 除数
	     * @param scale 精确范围
	     * @return 两个参数的商
	     * @throws IllegalAccessException
	     */
	    public static String div(String value1,String value2,int scale) throws IllegalAccessException{
	    	//如果精确范围小于0，抛出异常信息
	    	if(scale<0){         
	    		throw new IllegalAccessException("精确度不能小于0");
	    	}
	    	BigDecimal b1 = new BigDecimal(value1);
	    	BigDecimal b2 = new BigDecimal(value2);
	    	return b1.divide(b2,scale, BigDecimal.ROUND_HALF_UP).toString(); 
	    }
	    
	    
	    /**
	     * 手续费计算，手续费不能低于0.01
	     * @param value1  分为单位
	     * @param value2 费率
	     * @return  不小于0.01元的手续费
	     */
	    public static double fee (double value1,double value2){
	    	BigDecimal b1 = new BigDecimal(String.valueOf(value1));
	        BigDecimal b2 = new BigDecimal(String.valueOf(value2));
	        return (b1.multiply(b2).doubleValue()/100)<0.01?0.01:(b1.multiply(b2).doubleValue()/100);
	    }
	    
	    /*
		 * 判断是否为整数
		 * 
		 * @param str 传入的字符串
		 * 
		 * @return 是整数返回true,否则返回false
		 */
		public static boolean isInteger(String str) {
			Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
			return pattern.matcher(str).matches();
		}
		
		/**
		 * 如果小数点后为零显示整数否则保留
		 * @param num
		 * @return
		 */
		public static String doubleTrans2(double num){
			
			if(Math.round(num) - num == 0){
				return String.valueOf((long)num);
			}
			return String.valueOf(num);
		}
	    
	    public static void main(String[] args) throws IllegalAccessException{
	    	System.out.println(doubleTrans2(mul(0.01, 100)));
	    }

		public static String intToMoneyString(int moneyInFen) {
			double moneyInYuan = (double) moneyInFen / 100;
			String str = String.valueOf(moneyInYuan);
			return str;
		}
}
