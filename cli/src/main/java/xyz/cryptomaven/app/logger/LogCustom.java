package xyz.cryptomaven.app.logger;

import xyz.cryptomaven.app.constants.Cmds;

public class LogCustom {

	public static void logger() {
		System.out.println(Cmds.NOW_LOGGING);
		logCheck();
		CliLogger.getInstance().always();

	}
	public static void info() {
		CliLogger.getInstance().atInfo();
	}
	public static void logCheck() {
		CliLogger.getInstance().info("Program Started");
		 
		try {
			int x = 1/0;
		} catch (ArithmeticException e) {
			CliLogger.getInstance().error("System Logger Check: "+ e.getMessage());
		}
		CliLogger.getInstance().info("Program ended");
	}
		

}
