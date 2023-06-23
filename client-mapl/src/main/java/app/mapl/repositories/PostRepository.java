package app.mapl.repositories;

import app.mapl.models.PostEntity;
import org.springframework.data.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//public interface PostRepository extends JpaRepository<PostEntity, Long> {
public interface PostRepository extends CrudRepository<PostEntity, Long> {
	List<PostEntity> findByCategoryId(Long categoryId);



	PostEntity pattern = new PostEntity(
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null
	);
	Example<PostEntity> lenient = Example.of(pattern, ExampleMatcher.matchingAll().withIgnoreCase());
//	posts.findAll(lenient, PageRequest.of(0, 10, Sort.by("id").descending()));

	Example<PostEntity> strict = Example.of(pattern);
//	posts.findall(strict);

//	Page<PostEntity> pageByCat3(String cat3, Pageable pageable);
//	Slice<PostEntity> sliceByCat3(String cat3, Pageable pageable);
	List<Optional<PostEntity>> findByCat3(String cat3);
	Optional<PostEntity> findFirstByCat3(String cat3);
	Optional<PostEntity> findByDate(String date);
 46tg b  ujy 
	Page<PostEntity> findAllByUsername(Pageable pageable, String username);

	Page<PostEntity> findAll(Pageable pageable);

	Optional<PostEntity> findByDid(String did);
	List<PostEntity> findByUsername(String username);

//	@Query("SELECT p FROM PostEntity p WHERE p.username = ?1")
//	@Query("SELECT CONCAT(p.title, ' ', p.post) FROM PostEntity p WHERE p.username = ?1")
//	@Query("SELECT CONCAT(p.username, '\n',  a.name, ' ',a.email) " +
//			"FROM PostEntity p "+
//			"JOIN p.author AS a"+
//			"WHERE a.name LIKE :#{#alias == null || #alias.isEmpty() ? '%' : #alias}")
//		List<PostEntity> findByAuthor(String alias);

	PostEntity.SimplePost findSimplyByTitle(String title);

}
