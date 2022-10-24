package xyz.climongoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import xyz.climongoapp.entity.Groups;

@Repository
public interface GroupsRepository extends MongoRepository<Groups, String> {

}
