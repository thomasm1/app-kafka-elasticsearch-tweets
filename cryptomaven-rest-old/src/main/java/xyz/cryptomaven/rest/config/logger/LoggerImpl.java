package xyz.cryptomaven.rest.config.logger;

import xyz.cryptomaven.rest.util.constants.Cmds;
import org.slf4j.Logger;
import org.slf4j.Marker;

import static java.lang.Thread.sleep;

public class LoggerImpl implements Logger {

	public static void loggerInstance(String[] ...msg)   {
		logErrorCheck();
		loggerInfo();
		CliLogger.getInstance().always();
		System.out.println(Cmds.NOW_LOGGING+ msg[0]);
		System.out.println(Cmds.LOGGING_AT+System.nanoTime());

	}
	public static void loggerInfo() {
		CliLogger.getInstance().atInfo();
	}
	public static void logErrorCheck() {
		CliLogger.getInstance().info("Program Started");

		try {
			int x = 1/0;
		} catch (ArithmeticException e) {
			CliLogger.getInstance().error("System Logger Check: "+ e.getMessage());
		}
		CliLogger.getInstance().info("Program ended");
	}


	public static LoggerImpl getInstance() {
		return new LoggerImpl();
	}

	/**
	 * @return
	 */
	@Override
	public String getName() {
		return "LogCustom";
	}

	/**
	 * @return
	 */
	@Override
	public boolean isTraceEnabled() {
		return false;
	}

	/**
	 * @param s
	 */
	@Override
	public void trace(String s) {

	}

	/**
	 * @param s
	 * @param o
	 */
	@Override
	public void trace(String s, Object o) {

	}

	/**
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void trace(String s, Object o, Object o1) {

	}

	/**
	 * @param s
	 * @param objects
	 */
	@Override
	public void trace(String s, Object... objects) {

	}

	/**
	 * @param s
	 * @param throwable
	 */
	@Override
	public void trace(String s, Throwable throwable) {

	}

	/**
	 * @param marker
	 * @return
	 */
	@Override
	public boolean isTraceEnabled(Marker marker) {
		return false;
	}

	/**
	 * @param marker
	 * @param s
	 */
	@Override
	public void trace(Marker marker, String s) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 */
	@Override
	public void trace(Marker marker, String s, Object o) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void trace(Marker marker, String s, Object o, Object o1) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param objects
	 */
	@Override
	public void trace(Marker marker, String s, Object... objects) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param throwable
	 */
	@Override
	public void trace(Marker marker, String s, Throwable throwable) {

	}

	/**
	 * @return
	 */
	@Override
	public boolean isDebugEnabled() {
		return false;
	}

	/**
	 * @param s
	 */
	@Override
	public void debug(String s) {

	}

	/**
	 * @param s
	 * @param o
	 */
	@Override
	public void debug(String s, Object o) {

	}

	/**
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void debug(String s, Object o, Object o1) {

	}

	/**
	 * @param s
	 * @param objects
	 */
	@Override
	public void debug(String s, Object... objects) {

	}

	/**
	 * @param s
	 * @param throwable
	 */
	@Override
	public void debug(String s, Throwable throwable) {

	}

	/**
	 * @param marker
	 * @return
	 */
	@Override
	public boolean isDebugEnabled(Marker marker) {
		return false;
	}

	/**
	 * @param marker
	 * @param s
	 */
	@Override
	public void debug(Marker marker, String s) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 */
	@Override
	public void debug(Marker marker, String s, Object o) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void debug(Marker marker, String s, Object o, Object o1) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param objects
	 */
	@Override
	public void debug(Marker marker, String s, Object... objects) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param throwable
	 */
	@Override
	public void debug(Marker marker, String s, Throwable throwable) {

	}

	/**
	 * @return
	 */
	@Override
	public boolean isInfoEnabled() {
		return false;
	}

	/**
	 * @param s
	 */
	@Override
	public void info(String s) {

	}

	/**
	 * @param s
	 * @param o
	 */
	@Override
	public void info(String s, Object o) {

	}

	/**
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void info(String s, Object o, Object o1) {

	}

	/**
	 * @param s
	 * @param objects
	 */
	@Override
	public void info(String s, Object... objects) {

	}

	/**
	 * @param s
	 * @param throwable
	 */
	@Override
	public void info(String s, Throwable throwable) {

	}

	/**
	 * @param marker
	 * @return
	 */
	@Override
	public boolean isInfoEnabled(Marker marker) {
		return false;
	}

	/**
	 * @param marker
	 * @param s
	 */
	@Override
	public void info(Marker marker, String s) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 */
	@Override
	public void info(Marker marker, String s, Object o) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void info(Marker marker, String s, Object o, Object o1) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param objects
	 */
	@Override
	public void info(Marker marker, String s, Object... objects) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param throwable
	 */
	@Override
	public void info(Marker marker, String s, Throwable throwable) {

	}

	/**
	 * @return
	 */
	@Override
	public boolean isWarnEnabled() {
		return false;
	}

	/**
	 * @param s
	 */
	@Override
	public void warn(String s) {

	}

	/**
	 * @param s
	 * @param o
	 */
	@Override
	public void warn(String s, Object o) {

	}

	/**
	 * @param s
	 * @param objects
	 */
	@Override
	public void warn(String s, Object... objects) {

	}

	/**
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void warn(String s, Object o, Object o1) {

	}

	/**
	 * @param s
	 * @param throwable
	 */
	@Override
	public void warn(String s, Throwable throwable) {

	}

	/**
	 * @param marker
	 * @return
	 */
	@Override
	public boolean isWarnEnabled(Marker marker) {
		return false;
	}

	/**
	 * @param marker
	 * @param s
	 */
	@Override
	public void warn(Marker marker, String s) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 */
	@Override
	public void warn(Marker marker, String s, Object o) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void warn(Marker marker, String s, Object o, Object o1) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param objects
	 */
	@Override
	public void warn(Marker marker, String s, Object... objects) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param throwable
	 */
	@Override
	public void warn(Marker marker, String s, Throwable throwable) {

	}

	/**
	 * @return
	 */
	@Override
	public boolean isErrorEnabled() {
		return false;
	}

	/**
	 * @param s
	 */
	@Override
	public void error(String s) {

	}

	/**
	 * @param s
	 * @param o
	 */
	@Override
	public void error(String s, Object o) {

	}

	/**
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void error(String s, Object o, Object o1) {

	}

	/**
	 * @param s
	 * @param objects
	 */
	@Override
	public void error(String s, Object... objects) {

	}

	/**
	 * @param s
	 * @param throwable
	 */
	@Override
	public void error(String s, Throwable throwable) {

	}

	/**
	 * @param marker
	 * @return
	 */
	@Override
	public boolean isErrorEnabled(Marker marker) {
		return false;
	}

	/**
	 * @param marker
	 * @param s
	 */
	@Override
	public void error(Marker marker, String s) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 */
	@Override
	public void error(Marker marker, String s, Object o) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param o
	 * @param o1
	 */
	@Override
	public void error(Marker marker, String s, Object o, Object o1) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param objects
	 */
	@Override
	public void error(Marker marker, String s, Object... objects) {

	}

	/**
	 * @param marker
	 * @param s
	 * @param throwable
	 */
	@Override
	public void error(Marker marker, String s, Throwable throwable) {

	}
}
