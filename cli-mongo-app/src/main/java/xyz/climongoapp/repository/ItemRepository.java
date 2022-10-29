package xyz.climongoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.climongoapp.entity.Item;

public interface ItemRepository extends MongoRepository<Item, Integer>{

};
