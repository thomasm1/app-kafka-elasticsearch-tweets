package systemAdmin;

import org.junit.Test; 
import static org.junit.Assert.*;

import org.junit.Before;

//AdminLotState nov26 = new AdminLotState(date, carLotCount);
//nov26.getCarCount(); 

public class AdminLotStateTest {

private AdminLotState nov28;

	@Before 
	public void setup()  { 
    	nov28 = new AdminLotState("11/28", 10);  
	}

    @Test
    public void getCarCount() { 
		int carCount =  nov28.getCarCount(); 
		System.out.println("nov 28 inventory ORIGINAL getCarCount: " + carCount);
    }
    
    @Test
    public void addCar() { 
		int carCount =  nov28.addCar(2);  
		System.out.println("nov 28 inventory addCar(2): " + carCount);
		
    }

    @Test
    public void removeCar() { 
		int carCount =  nov28.removeCar(3, true); // # if purchased
		System.out.println("nov 28 inventory removeCar(3, true): " + carCount);
    }

    @Test
    public void dummyTestFail() {
//    	assertEquals(20,21);
    	assertEquals(20,20);
    }
}