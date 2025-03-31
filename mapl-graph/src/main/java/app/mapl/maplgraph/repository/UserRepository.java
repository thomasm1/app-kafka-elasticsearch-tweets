package app.mapl.maplgraph.repository;
 

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.mapl.maplgraph.entity.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

	List<User> findByName(String name);
	
	List<User> findByNameAndUserType(String name, Integer userType);
	
	List<User> findByNameOrUserType(String name, Integer userType);
	
	List<User> findByUserTypeIn(List<Integer> list);
	
	@Query("match (st:User) where st.name = $name and "
			+ "st.user_type = $user_type return st")
	List<User> getByNameAndUserType(String name, 
			@Param("user_type") Integer userType);
	
	List<User> findByNameLike(String name);
	
	List<User> findByNameStartsWith(String name);
	
	
}
