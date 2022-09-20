package logger;

public class LogGround {

	public static void main(String[] args) {
		
	}

	public static void logger() {
		Project0Logger.logger.info("Program Started");
//		int num;
 
//		Project0Logger.logger.warn("'num' is not used....");
		try {
			int x = 1/10;
		} catch (ArithmeticException e) {
			Project0Logger.logger.error( e.getMessage());
		}
		Project0Logger.logger.info("Program ended");
		
	}

}
