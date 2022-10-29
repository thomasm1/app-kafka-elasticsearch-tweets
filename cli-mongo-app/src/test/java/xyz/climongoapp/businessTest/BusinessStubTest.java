package xyz.climongoapp.businessTest;

import org.junit.jupiter.api.Test;
import xyz.climongoapp.methods.BusinessImpl;
import xyz.climongoapp.repository.DataRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataRepositoryStub implements DataRepository {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}

	@Override
	public int retrieveSpecificData() {
		return 0;
	}
}

class DataRepositoryEmptyStub implements DataRepository {
	@Override
	public int[] retrieveAllData() {
		return new int[] { };
	}

	@Override
	public int retrieveSpecificData() {
		return 0;
	}
}

class DataRepositoryOneElementStub implements DataRepository {
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
	public void calculateSumUsingDataRepository_basic() {
		BusinessImpl business = new BusinessImpl();
		business.setDataRepository(new DataRepositoryStub());
		int actualResult = business.calculateSumUsingDataRepository();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataRepository_empty() {
		BusinessImpl business = new BusinessImpl();
		business.setDataRepository(new DataRepositoryEmptyStub());
		int actualResult = business.calculateSumUsingDataRepository();//new int[] {}
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataRepository_oneValue() {
		BusinessImpl business = new BusinessImpl();
		business.setDataRepository(new DataRepositoryOneElementStub());
		int actualResult = business.calculateSumUsingDataRepository();//new int[] { 5 }
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
