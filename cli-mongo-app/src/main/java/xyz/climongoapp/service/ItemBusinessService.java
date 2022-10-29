package xyz.climongoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.climongoapp.entity.Item;
import xyz.climongoapp.repository.ItemRepository;

import java.util.List;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	public Item retrieveHardcodedItem() {

		return new Item(1, "ITEM-HARC-CODED-SERVICE", 10, 100);
	}
	
	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;	
	}
	
}
