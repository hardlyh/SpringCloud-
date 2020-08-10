package com.mining.utils;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LogUtil {

	private static boolean isTest = true;

	private static Logger logger = Logger.getLogger(LogUtil.class);

	private static int port = getTomcatPort();
	/**
	 * 给log添加类名、方法名、行号前缀
	 * 
	 * @return
	 */
	private static String addLogPrefix(String info,String groupById) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final int num = 3;
		String classNames[] = stackTrace[num].getClassName().split("[.]");
		String className = classNames[classNames.length - 1];
		info = className + "." + stackTrace[num].getMethodName() + "() L" + stackTrace[num].getLineNumber() + " "
				+ info;
		Thread t = Thread.currentThread();
		info = "@@"+groupById+"@@"+"Thread" + t.getId() + " " + info;
		return info;
	}
	
	public static void debug(String info) {
		String logInfo = addLogPrefix(info);
		// System.out.println(logInfo);
		logger.debug(logInfo + " " + info);
	}

	public static void debug(String info, Throwable e) {
		String logInfo = addLogPrefix(info);
		e.printStackTrace();
		logger.debug(logInfo);
	}

	public static void info(String info) {
		String logInfo = addLogPrefix(info);
		// System.out.println(logInfo + " " + info);
		if(info.length() > 2000) {
			info = info.substring(0,2000);
		}
		logger.info(logInfo);
	}

	/**
	 * 
	 * @param pre
	 * @param info
	 */
	public static void info(String pre, String info) {
		// System.out.println(logInfo);
		logger.info(pre + " " + info);
	}

	public static void info(String info, Throwable e) {
		String logInfo = addLogPrefix(info);
		e.printStackTrace();
		logger.info(logInfo);
	}

	public static void warn(String info) {
		String logInfo = addLogPrefix(info);
		// System.out.println(logInfo);
		logger.warn(logInfo);
	}

	public static void warn(String info, Throwable e) {
		e.printStackTrace();
		String logInfo = addLogPrefix(info);
		logger.warn(logInfo);
	}

	public static void error(String info) {
		String logInfo = addLogPrefix(info);
		System.err.println(logInfo);
		logger.error(logInfo);
//		commonLog(5, logInfo);
	}

	public static void error(String info, Throwable e) {
		String logInfo = addLogPrefix(info);
		e.printStackTrace();
		logger.error(logInfo);
		logger.error(e.toString());
//		commonLog(5, logInfo);
	}


	
	private static String addLogPrefix(String info) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final int num = 3;
		String classNames[] = stackTrace[num].getClassName().split("[.]");
		String className = classNames[classNames.length - 1];
		info = className + "." + stackTrace[num].getMethodName() + "() L" + stackTrace[num].getLineNumber() + " "
				+ info;
		Thread t = Thread.currentThread();
		info = "Thread" + t.getId() + " " + info;
		return info;
	}

	

	/**
	 * 获取tomcat端口号
	 * 
	 * @return 端口号
	 */
	public static int getTomcatPort() {
		MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
		Set<ObjectName> objectNames = null;
		try {
			objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
					Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		}
		if (objectNames.iterator().hasNext()) {
			String port = objectNames.iterator().next().getKeyProperty("port");
			return Integer.valueOf(port);
		}
		return 0;
	}


	public static void isTest(boolean isTest) {
		if (LogUtil.isTest != isTest) {
			LogUtil.isTest = isTest;
		}
	}
}
