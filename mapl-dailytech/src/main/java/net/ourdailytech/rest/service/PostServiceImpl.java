package net.ourdailytech.rest.service;

import net.ourdailytech.rest.exception.ResourceNotFoundException;
import net.ourdailytech.rest.mapper.PostEntityMapper;
import net.ourdailytech.rest.models.Category;
import net.ourdailytech.rest.models.PostEntity;
import net.ourdailytech.rest.models.User;
import net.ourdailytech.rest.models.dto.PostEntityDto;
import net.ourdailytech.rest.models.dto.PostEntityResponse;
import net.ourdailytech.rest.repositories.CategoryRepository;
import net.ourdailytech.rest.repositories.PostRepository;
import net.ourdailytech.rest.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository pr;
//	public PostServiceImpl(PostRepository postRepository) {
//		this.pr = postRepository;
	// this.catRepository = catRepository;
//	}

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	private PostEntityMapper postEntityMapper;

	@Override
	public PostEntityDto createPost(PostEntityDto postEntityDto) {
		Category cat = categoryRepository.findById(postEntityDto.getCategoryId()).orElseThrow(
				() -> new ResourceNotFoundException("Category", "id", Long.toString(postEntityDto.getCategoryId())));
		System.out.println("cat: " + postEntityDto.getCategoryId());
		PostEntity postEntity = postEntityMapper.toEntity(postEntityDto);
		postEntity.setCategory(cat);
		PostEntity newPostEntity = pr.save(postEntity);

		PostEntityDto postResponse = postEntityMapper.toDto(newPostEntity);
		return postResponse;
	}
	@Override
	public PostEntityResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<PostEntity> posts = pr.findAll(pageable);

		// get content for page object
		List<PostEntity> listOfPosts = posts.getContent();
		List<PostEntityDto> content= listOfPosts.stream().map(post -> postEntityMapper.toDto(post)).collect(Collectors.toList());

		PostEntityResponse postResponse = new PostEntityResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return postResponse;
	}
	@Override
	public PostEntityResponse getAllPostsByUsername(int pageNo, int pageSize, String sortBy, String sortDir, String email) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<PostEntity> posts = pr.findAllByEmail(pageable, email);

		// get content for page object
		List<PostEntity> listOfPosts = posts.getContent();

		List<PostEntityDto> content= listOfPosts.stream().map(post -> postEntityMapper.toDto(post)).collect(Collectors.toList());

		PostEntityResponse postResponse = new PostEntityResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return postResponse;
	}

	@Override
	public PostEntityResponse getAllPostsByEmail(int pageNo, int pageSize, String sortBy, String sortDir, String email) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Optional<User> u = Optional.ofNullable(usersRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "email", email)));
		String usernameFromEmail = u.get().getUsername();
		Page<PostEntity> posts = pr.findAllByEmail(pageable, usernameFromEmail);

		// get content for page object
		List<PostEntity> listOfPosts = posts.getContent();

		List<PostEntityDto> content= listOfPosts.stream().map(post -> postEntityMapper.toDto(post)).collect(Collectors.toList());

		PostEntityResponse postResponse = new PostEntityResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return postResponse;
	}

	@Override
	public PostEntityDto getPostById(long id) {
		PostEntity post = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("PostEntity", "id", Long.toString(id)));
		return postEntityMapper.toDto(post);
 	}

	@Override
	public PostEntityDto getPostByDid(String did) {
		PostEntity post = pr.findByDid(did).orElseThrow(() -> new ResourceNotFoundException("PostEntity", "did", did));
		return postEntityMapper.toDto(post);
	}


	/**
	 * @param categoryId
	 * @return
	 */
	@Override
	public List<PostEntityDto> getPostsByCategoryId(long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(
				() -> new ResourceNotFoundException("Category", "id", Long.toString(categoryId)));
		List<PostEntity> posts = pr.findByCategoryId(categoryId);
		return posts.stream().map(post -> postEntityMapper.toDto(post)).collect(Collectors.toList());
	}

	@Override
	public PostEntityDto updatePost(PostEntityDto postDto, long id) {
		Category cat = categoryRepository.findById(postDto.getCategoryId()).orElseThrow(
				() -> new ResourceNotFoundException("Category", "id", Long.toString(postDto.getCategoryId())));
		System.out.println("cat: " + postDto.getCategoryId());


		// get post by id from the database
		PostEntity postOld = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", Long.toString(id)));

		postOld.setDid(postDto.getDid());
		postOld.setPost(postDto.getPost());
		postOld.setTitle(postDto.getTitle());
		postOld.setAuthor(postDto.getAuthor());
		postOld.setCat3(postDto.getCat3());
		postOld.setMonthOrder(postDto.getMonthOrder());
		postOld.setBlogcite(postDto.getBlogcite());
		postOld.setCategory(cat);
		System.out.println("cat: " + cat.toString());

		PostEntity updatedPost = pr.save(postOld);
		return postEntityMapper.toDto(updatedPost);
	}
	@Override
	public boolean deletePostById(long id) {
		// get post by id from the database
		try {
			PostEntity post = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", Long.toString(id)));
			pr.delete(post);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}


}
