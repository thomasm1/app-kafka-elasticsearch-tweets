package xyz.climongoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import xyz.climongoapp.entity.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

}
