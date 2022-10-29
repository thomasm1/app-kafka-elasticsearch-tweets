package xyz.climongoapp.dataRepositoryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.climongoapp.entity.Item;
import xyz.climongoapp.repository.ItemRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository repository;
	
	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
		assertEquals(3,items.size());
	}

	@Test
	public void testFindOne() {
		Item item = repository.findById(10001).get();
		
		assertEquals("Item1",item.getName());
	}

}
