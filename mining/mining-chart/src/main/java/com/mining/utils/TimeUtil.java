package com.mining.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author liyh@one
 * @time 2018年5月30日
 * @Description 时间工具类
 */
public class TimeUtil {

	public static String dataFormatStr1 = "yyyy-MM-dd HH:mm:ss";
	public static String dataFormatStr2 = "yyyyMMdd";
	public static String dataFormatStr3 = "yyyy-MM-dd";
	public static String dataFormatStr4 = "HHmm";
    public static String dataFormatStr5 = "yyyy/MM/dd HH:mm:ss";
    public static String dataFormatStr6 = "yyyyMMddHHmmss";
    
	/**
	* @Description: 获取当前时间的字符串 
	*/
	public static String getNowDateStr(int tag) {
		SimpleDateFormat dateFormat = null;
		if (tag == 1)
			dateFormat = new SimpleDateFormat(dataFormatStr1);
		else if (tag == 2)
			dateFormat = new SimpleDateFormat(dataFormatStr2);
		else if (tag == 3)
			dateFormat = new SimpleDateFormat(dataFormatStr3);
		else if (tag == 4)
			dateFormat = new SimpleDateFormat(dataFormatStr4);

		String dateStr = dateFormat.format(new Date());
		return dateStr;
	}

	/**
	* @Description: 将yyyyMMdd 的样式转化为 yyyy-MM-dd
	* @return 
	*/
	public static String format1(String timeStr) {
		String y = timeStr.substring(0, 4);
		String m = timeStr.substring(4, 6);
		String d = timeStr.substring(6, 8);
		return y + "-" + m + "-" + d;
	}

	/**
	* @Description: 将 yyyy-MM-dd 的样式转化为 yyyyMMdd
	* @return 
	*/
	public static String format2(String timeStr) {
		String[] split = timeStr.split("-");
		return split[0] + split[1] + split[2];
	}

	/**
	* @Description: 获取昨天和今天日期字符串
	* @return [0] yyyyMMdd(last)  [1] yyyyMMdd  [2] yyyy-MM-dd(last)  [3] yyyy-MM-dd
	*/
	public static String[] getLastDateStrArr() {
		String[] arr = new String[4];
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date time = cal.getTime();
		String latStr1 = new SimpleDateFormat(dataFormatStr2).format(time);
		String latStr2 = new SimpleDateFormat(dataFormatStr3).format(time);

		String nowStr1 = new SimpleDateFormat(dataFormatStr2).format(new Date());
		String nowStr2 = new SimpleDateFormat(dataFormatStr3).format(new Date());

		arr[0] = latStr1;
		arr[1] = nowStr1;
		arr[2] = latStr2;
		arr[3] = nowStr2;
		return arr;
	}

	/**
	 * 获取到两个时间段内包含的具体时间 
	 * @param cntDateBeg
	 * @param cntDateEnd
	 * @return
	 */
	public static List<String> divicesDate(String cntDateBeg, String cntDateEnd) {
		List<String> list = new ArrayList<String>();
		String[] dateBegs = cntDateBeg.split("-");
		String[] dateEnds = cntDateEnd.split("-");
		Calendar start = Calendar.getInstance();
		start.set(Integer.valueOf(dateBegs[0]), Integer.valueOf(dateBegs[1]) - 1, Integer.valueOf(dateBegs[2]));
		Long startTIme = start.getTimeInMillis();
		Calendar end = Calendar.getInstance();
		end.set(Integer.valueOf(dateEnds[0]), Integer.valueOf(dateEnds[1]) - 1, Integer.valueOf(dateEnds[2]));
		Long endTime = end.getTimeInMillis();
		Long oneDay = 1000 * 60 * 60 * 24l;
		Long time = startTIme;
		while (time <= endTime) {
			Date d = new Date(time);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			time += oneDay;
			list.add(df.format(d));
		}
		return list;
	}

	/** 
	
	* 获得指定日期的后一天
	
	 * @param specifiedDay 
	
	* @return 
	
	*/
	public static String getSpecifiedDayAfter(String specifiedDay) {

		Calendar c = Calendar.getInstance();

		Date date = null;

		try {

			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);

		} catch (Exception e) {

			e.printStackTrace();

		}

		c.setTime(date);

		int day = c.get(Calendar.DATE);

		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

		return dayAfter;

	}

	/** * 获得指定日期的前一天 *
	
	 @param specifiedDay 
	
	* @return 
	
	* @throws Exception */
	public static String getSpecifiedDayBefore(String specifiedDay) {

		Calendar c = Calendar.getInstance();

		Date date = null;

		try {

			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);

		} catch (Exception e) {

			e.printStackTrace();

		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);

		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

		return dayBefore;

	}

	/**
	* @Description: 计算指定月份的开始时间和结束时间
	* @param yearStr 年
	* @param month 月
	* @return 20180101 20180131
	*/
	public static String[] getMonthStartAndEnd(String yearStr, String month) {
		String[] day31 = new String[] { "1", "3", "5", "7", "8", "10", "12" };
		String[] day30 = new String[] { "4", "6", "9", "11" };
		int year = Integer.parseInt(yearStr);

		if (Integer.parseInt(month) > 12) {
			return null;
		}
		String[] result = new String[2];
		result[0] = yearStr + month + "01";
		// 计算是否是闰年
		if (month.equals("2")) {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				result[1] = yearStr + month + "29";
			} else {
				result[1] = yearStr + month + "28";
			}
		} else if (month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")) {
			result[1] = yearStr + month + "31";
		} else {
			result[1] = yearStr + month + "30";
		}
		return result;
	}

	/**
	* @Description: 获取当前天数往后num天的列表
	* @param num
	* @return 
	*/
	public static List<String> getLateNumberDate(int num) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		String nowDate = df.format(c.getTime()); // 当前时间
		c.add(Calendar.DATE, num);
		String lateDate = df.format(c.getTime()); // 往后n天的时间

		List<String> divicesDate = divicesDate(nowDate, lateDate); // 开始时间和结束时间之间相隔的时间列表
		return divicesDate;
	}

	/**
	* @Description: 获取指定天数往后num天的列表
	* @param num
	* @return 
	 * @throws ParseException 
	*/
	public static List<String> getLateNumberDate(String date, int num) throws ParseException {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = df.parse(date);
		c.setTime(parse);
		c.add(Calendar.DATE, num);
		String lateDate = df.format(c.getTime()); // 往后n天的时间

		List<String> divicesDate = divicesDate(date, lateDate); // 开始时间和结束时间之间相隔的时间列表
		return divicesDate;
	}

	public static void main(String[] args) {
		try {
		 String nowDateStr = getNowDateStr(1);
		 System.out.println(nowDateStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	* 日期转星期(周一)
	* 
	* @param datetime
	* @return
	*/
	public static String dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	* 日期转星期(1)
	* 
	* @param datetime
	* @return
	*/
	public static String dateToWeek2(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	* @Description: HH:MM:SS -> HHMM
	* @param timeStr
	* @return 
	*/
	public static String format3(String timeStr) {
		String[] split = timeStr.split(":");
		return split[0] + split[1];
	}
	
	/** 
	
	* 获得指定日期的后i天
	 * @param specifiedDay 
	* @return 
	*/
	public static String getSpecifiedDay(String specifiedDay, int i) {

		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + i);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}
	
/** 
	
	* 获得指定日期的后i天
	 * @param specifiedDay 
	* @return 
	*/
	public static String getBeforeDay(String specifiedDay, int i) {

		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - i);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}
	
    /**
    * @Description: 将传递进来的日期格式字符串转化为对应的Date类型
    * @param dateStr 日期字符串
    * @param tag 格式标志
    * @return
    * @throws ParseException 
    */
    public static Date stringToDate(String dateStr, int tag) throws ParseException {
        SimpleDateFormat dateFormat = null;
        if (tag == 1)
            dateFormat = new SimpleDateFormat(dataFormatStr1);
        else if (tag == 2)
            dateFormat = new SimpleDateFormat(dataFormatStr2);
        else if (tag == 3)
            dateFormat = new SimpleDateFormat(dataFormatStr3);
        else if (tag == 4)
            dateFormat = new SimpleDateFormat(dataFormatStr4);
        else if (tag == 5)
            dateFormat = new SimpleDateFormat(dataFormatStr5);

        Date date = dateFormat.parse(dateStr);
        return date;
    }
    
	/**
	* @Description: 获取指定时间的年份
	* @param date
	* @return 
	*/
	public static String getStringByDateToYear(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy");
		String format = sf.format(date);
		return format;
	}
}
