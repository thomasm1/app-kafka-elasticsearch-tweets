package net.ourdailytech.rest.repositories;

import net.ourdailytech.rest.models.PostEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "post", path = "role")
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByCategoryId(Long categoryId);

	PostEntity pattern = PostEntity.builder()
			.id(0L) // Provide appropriate values
			.did("")
			.date("")
			.author("")
			.monthOrder("")
			.cat3("")
			.title("")
			.post("")
			.blogcite("")
			.email("")
			.category(null)
			.comments(new HashSet<>())
			.build();

	Example<PostEntity> lenient = Example.of(pattern, ExampleMatcher.matchingAll().withIgnoreCase());
//	posts.findAll(lenient, PageRequest.of(0, 10, Sort.by("id").descending()));

	Example<PostEntity> strict = Example.of(pattern);
//	posts.findall(strict);

//	Page<PostEntity> pageByCat3(String cat3, Pageable pageable);
//	Slice<PostEntity> sliceByCat3(String cat3, Pageable pageable);
	List<Optional<PostEntity>> findByCat3(String cat3);
	Optional<PostEntity> findFirstByCat3(String cat3);
	Optional<PostEntity> findByDate(String date);

	Page<PostEntity> findAllByEmail(Pageable pageable, String email);

	Page<PostEntity> findAll(Pageable pageable);

	Optional<PostEntity> findByDid(String did);
	List<PostEntity> findByEmail(String username);

//	@Query("SELECT p FROM PostEntity p WHERE p.username = ?1")
//	@Query("SELECT CONCAT(p.title, ' ', p.post) FROM PostEntity p WHERE p.username = ?1")
//	@Query("SELECT CONCAT(p.username, '\n',  a.name, ' ',a.email) " +
//			"FROM PostEntity p "+
//			"JOIN p.author AS a"+
//			"WHERE a.name LIKE :#{#alias == null || #alias.isEmpty() ? '%' : #alias}")
//		List<PostEntity> findByAuthor(String alias);



}
