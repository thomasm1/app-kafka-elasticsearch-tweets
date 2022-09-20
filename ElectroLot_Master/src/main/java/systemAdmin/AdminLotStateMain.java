package systemAdmin;

//import systemAdmin.AdminLotState;

public class AdminLotStateMain {

	public static void main(String[] args) {
		   System.out.println("The Admin UI application is running ...");
		   String date = "nov";
		   int carLotCount = 3;
		   
		   AdminLotState nov26 = new AdminLotState(date, carLotCount);
		   nov26.getCarCount(); 
			
	}
 
}
