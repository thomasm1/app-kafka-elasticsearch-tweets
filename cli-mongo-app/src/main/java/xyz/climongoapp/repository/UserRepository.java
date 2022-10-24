package xyz.climongoapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import xyz.climongoapp.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByName(String name);
	
	User findByEmailAndName (String email, String name);
	
	User findByNameOrEmail (String name, String email);
	
	List<User> findByGroupsGroupsName(String deptname);
	
	List<User> findByCarsCarName (String subName);
	
	List<User> findByEmailIsLike (String email);
	
	List<User> findByNameStartsWith (String name);
	
	List<User> findByGroupsId (String deptId);
}
