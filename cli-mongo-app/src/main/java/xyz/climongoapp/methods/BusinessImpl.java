package xyz.climongoapp.methods;

import xyz.climongoapp.repository.DataRepository;

public class BusinessImpl {
	private DataRepository dataRepository;
	public void setDataRepository(DataRepository dataRepository) {

		this.dataRepository = dataRepository;
	}
	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value:data) {
			sum += value;
		}
		return sum;
		//Functional Style
		//return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	public int calculateSumUsingDataRepository() {
		int sum = 0;
		int[] data = dataRepository.retrieveAllData();
		for(int value:data) {
			sum += value;
		}
		
		//dataService.storeSum(sum);
		return sum;
		//Functional Style
		//return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

}
