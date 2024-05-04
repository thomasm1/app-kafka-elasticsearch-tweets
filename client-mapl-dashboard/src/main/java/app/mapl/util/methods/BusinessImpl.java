package app.mapl.util.methods;

import app.mapl.models.PostEntity;
import app.mapl.repositories.PostRepository;

import java.util.List;

public class BusinessImpl {
	private PostRepository dataRepository;
	public void setDataRepository(PostRepository dataRepository) {

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
	
	public int calculateSumUsingDataRepository(PostEntity post) {
		int sum = 0;
		List<PostEntity> data = dataRepository.findByEmailIgnoreCase("email2");
		for(PostEntity d: data) {
			sum += Integer.valueOf(Math.toIntExact(d.getId()));
		}
		
		//dataService.storeSum(sum);
		return sum;
		//Functional Style
		//return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

}
