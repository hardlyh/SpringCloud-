package log;

import org.apache.log4j.Logger;

public class LogUtil {

	private static boolean isTest = true;

	private static Logger logger = Logger.getLogger(LogUtil.class);

	public static void debug(String info) {
		String logInfo = addLogPrefix(info);
		logger.debug(logInfo + " " + info);
	}

	public static void debug(String info, Throwable e) {
		String logInfo = addLogPrefix(info);
		e.printStackTrace();
		logger.debug(logInfo);
	}

	public static void info(String info) {
		String logInfo = addLogPrefix(info);
		logger.info(logInfo);
	}

	/**
	 * 
	 * @param pre
	 * @param info
	 */
	public static void info(String pre, String info) {
		logger.info(pre + " " + info);
	}

	public static void info(String info, Throwable e) {
		String logInfo = addLogPrefix(info);
		e.printStackTrace();
		logger.info(logInfo);
	}

	public static void warn(String info) {
		String logInfo = addLogPrefix(info);
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
	}

	public static void error(String info, Throwable e) {
		String logInfo = addLogPrefix(info);
		e.printStackTrace();
		logger.error(logInfo);
		logger.error(e.toString());
	}

	/**
	 * 给log添加类名、方法名、行号前缀
	 *
	 * @return
	 */
	private static String addLogPrefix(String info) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final int num = 3;
		String classNames[] = stackTrace[num].getClassName().split("[.]");
		String className = classNames[classNames.length - 1];
		info = className + "." + stackTrace[num].getMethodName() + "() L" + stackTrace[num].getLineNumber() + " " + info;
		Thread t = Thread.currentThread();
		info = "Thread" + t.getId() + " " + info;
		return info;
	}
}
