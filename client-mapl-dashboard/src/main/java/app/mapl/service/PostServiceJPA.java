package app.mapl.service;

import app.mapl.dto.PostEntityDto;
import app.mapl.dto.PostEntityResponse;
import app.mapl.mapper.PostEntityMapper;
import app.mapl.models.Category;
import app.mapl.models.PostEntity;
import app.mapl.repositories.CategoryRepository;
import  app.mapl.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import app.mapl.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class PostServiceJPA implements PostService {

	private final PostRepository pr;

	private final CategoryRepository categoryRepository;

	private final PostEntityMapper postEntityMapper;

	@Override
	public PostEntityDto createPost(PostEntityDto postEntityDto) {
		Category cat = categoryRepository.findById(postEntityDto.getCategoryId()).orElseThrow(
				() -> new ResourceNotFoundException("Category", "id", Long.toString(postEntityDto.getCategoryId())));
		System.out.println("cat: " + postEntityDto.getCategoryId());
		PostEntity postEntity = postEntityMapper.PostEntityDTOToPostEntity(postEntityDto);
		postEntity.setCategory(cat);
		PostEntity newPostEntity = pr.save(postEntity);

		PostEntityDto postResponse = postEntityMapper.PostEntityToPostEntityDTO(newPostEntity);
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
		List<PostEntityDto> content= listOfPosts.stream().map(post -> postEntityMapper.PostEntityToPostEntityDTO(post)).collect(Collectors.toList());

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

		List<PostEntityDto> content= listOfPosts.stream().map(post -> postEntityMapper.PostEntityToPostEntityDTO(post)).collect(Collectors.toList());

		PostEntityResponse postResponse = new PostEntityResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return postResponse;
	}
//	@Override
//	public List<PostEntityDto> getAllPostsByUsername(String username) {
//		try {
//			return (List<PostEntityDto>) pr.findAllByUsername(username) ;
//		} catch (Exception e) {
//			return null;
//		}
//	}
	@Override
	public Optional<PostEntityDto> getPostById(long id) {
		PostEntity post = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("PostEntity", "id", Long.toString(id)));
		return Optional.ofNullable(postEntityMapper.PostEntityToPostEntityDTO(post));
 	}

	@Override
	public Optional<PostEntityDto>  getPostByDid(String did) {
		PostEntity post = pr.findByDid(did).orElseThrow(() -> new ResourceNotFoundException("PostEntity", "did", did));
		return Optional.ofNullable(postEntityMapper.PostEntityToPostEntityDTO(post));
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
		return posts.stream().map(post -> postEntityMapper.PostEntityToPostEntityDTO(post)).collect(Collectors.toList());
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
		postOld.setBlogcite(postDto.getBlogcite());
		postOld.setCategory(cat);
		System.out.println("cat: " + cat.toString());

		PostEntity updatedPost = pr.save(postOld);
		return postEntityMapper.PostEntityToPostEntityDTO(updatedPost);
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
