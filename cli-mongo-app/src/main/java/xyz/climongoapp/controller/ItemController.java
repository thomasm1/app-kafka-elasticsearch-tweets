package xyz.climongoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.climongoapp.entity.Item;
import xyz.climongoapp.service.ItemBusinessService;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	
	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/get")
	public Item hardCodeItem() {

		return new Item(1, "ItemX", 10, 100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		Item item = businessService.retrieveHardcodedItem();
		
		return item;
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}
	
}
