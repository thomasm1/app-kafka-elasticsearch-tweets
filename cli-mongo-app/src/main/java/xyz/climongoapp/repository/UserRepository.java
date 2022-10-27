package xyz.climongoapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import xyz.climongoapp.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByUserName(String userName);

	User findByEmailAndUserName(String email, String userName);

	User findByUserNameOrEmail(String userName, String email);

	List<User> findByGroupsGroupsName(String deptname);

	List<User> findByCarsCarName (String subName);

	List<User> findByEmailIsLike (String email);

	List<User> findByUserNameStartsWith(String userName);

	List<User> findByGroupsId (String deptId);
}
