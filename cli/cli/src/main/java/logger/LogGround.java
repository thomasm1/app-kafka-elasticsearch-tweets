package logger;

public class LogGround {

	public static void main(String[] args) {
		
	}

	public static void logger() {
		CliLogger.logger.info("Program Started");
 
		try {
			int x = 1/10;
		} catch (ArithmeticException e) {
			CliLogger.logger.error( e.getMessage());
		}
		CliLogger.logger.info("Program ended");
		
	}

}
