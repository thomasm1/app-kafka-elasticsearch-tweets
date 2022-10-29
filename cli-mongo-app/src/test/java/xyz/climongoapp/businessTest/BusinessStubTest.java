package xyz.climongoapp.businessTest;

import org.junit.jupiter.api.Test;
import xyz.climongoapp.methods.BusinessImpl;
import xyz.climongoapp.repository.DataRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceStub implements DataRepository {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}

	@Override
	public int retrieveSpecificData() {
		return 0;
	}
}

class DataServiceEmptyStub implements DataRepository {
	@Override
	public int[] retrieveAllData() {
		return new int[] { };
	}

	@Override
	public int retrieveSpecificData() {
		return 0;
	}
}

class DataServiceOneElementStub implements DataRepository {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 5 };
	}

	@Override
	public int retrieveSpecificData() {
		return 0;
	}
}

public class BusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();//new int[] {}
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();//new int[] { 5 }
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
