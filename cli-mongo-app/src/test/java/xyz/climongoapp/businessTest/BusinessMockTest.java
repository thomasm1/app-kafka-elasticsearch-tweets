package xyz.climongoapp.businessTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.climongoapp.methods.BusinessImpl;
import xyz.climongoapp.repository.DataRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusinessMockTest {

	@InjectMocks
	BusinessImpl business;

	@Mock
	DataRepository dataServiceMock;

	@Test
	public void calculateSumUsingDataRepository_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataRepository());
	}

	@Test
	public void calculateSumUsingDataRepository_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataRepository());
	}

	@Test
	public void calculateSumUsingDataRepository_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumUsingDataRepository());
	}
}
