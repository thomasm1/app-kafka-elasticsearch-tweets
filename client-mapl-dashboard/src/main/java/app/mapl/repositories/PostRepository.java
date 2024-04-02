package app.mapl.repositories;

import app.mapl.models.Category;
import app.mapl.models.PostEntity;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="post", path="post")
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByCategoryId(Long categoryId);



	PostEntity pattern = new PostEntity(
			0L,
			"did",
			"date",
			"author",
			"cat3",
			"title",
			"post",
			"blogcite",
			"username",
			new Category(),
			new HashSet<>()
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

	Page<PostEntity> findAllByUsername(Pageable pageable, String username);

	Page<PostEntity> findAll(Pageable pageable);

	Optional<PostEntity> findByDid(String did);
	List<PostEntity> findByUsername(String username);

//	@Query("SELECT p FROM PostEntity p WHERE p.username = ?1")
	@Query("SELECT CONCAT(p.title, ' ', p.post) FROM PostEntity p WHERE p.username = ?1")
		List<PostEntity> findByAuthor(String alias);

	@Query("SELECT p FROM PostEntity p WHERE " +
			"p.title LIKE CONCAT('%',:query, '%')" +
			"Or p.post LIKE CONCAT('%',:query, '%')" +
			"Or p.blogcite LIKE CONCAT('%', :query, '%')")
    List<PostEntity> searchPostEntitiesBy(  String query);

	@Query(value = "SELECT * FROM POST_ENTITY p WHERE " +
			"p.title LIKE CONCAT('%',:query, '%')" +
			"Or p.post LIKE CONCAT('%',:query, '%')" +
			"Or p.blogcite LIKE CONCAT('%', :query, '%')", nativeQuery = true)
	List<PostEntity> searchPostEntitiesBySQL(String query);

	PostEntity.SimplePost findSimplyByTitle(String title);



}
