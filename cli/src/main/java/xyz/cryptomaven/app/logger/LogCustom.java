package xyz.cryptomaven.app.logger;

public class LogCustom {

	public static void main(String[] args) {
		
	}

	public static void logger() {
		CliLogger.getInstance().always();
		logCheck();
		System.out.println("lOG custom logging");

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
