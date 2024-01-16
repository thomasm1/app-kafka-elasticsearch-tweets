package app.mapl.service;

import app.mapl.dto.PostEntityDto;
import app.mapl.dto.PostEntityResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PostService {
	public PostEntityDto createPost(PostEntityDto postEntityDto);

	public PostEntityResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
	public PostEntityResponse getAllPostsByUsername(int pageNo, int pageSize, String sortBy, String sortDir, String username);

	public Optional<PostEntityDto> getPostById(long id);
	public Optional<PostEntityDto>  getPostByDid(String did);


	public PostEntityDto updatePost(PostEntityDto change, long id);
//	public boolean deletePost(PostEntityDto post);
	public boolean deletePostById(long id);

    Object getPostsByCategoryId(long categoryId);

	// SEARCH
	PostEntityResponse searchPostEntities(int pageNo, int pageSize, String sortBy, String sortDir, String query);
	PostEntityResponse searchPostEntities(String query);

	PostEntityResponse searchPostEntitiesSQL(String query);
}
