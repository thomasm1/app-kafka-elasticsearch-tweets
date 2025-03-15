package net.ourdailytech.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import net.ourdailytech.rest.util.constants.Constant;
import net.ourdailytech.rest.mapper.PostEntityMapper;
import net.ourdailytech.rest.models.dto.PostEntityDto;
import net.ourdailytech.rest.models.dto.PostEntityResponse;
import net.ourdailytech.rest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = Constant.API_POSTS)
@CrossOrigin(origins = "*")
@RestController
public class PostEntityController {

    @Autowired
    private PostService postService;

	@Autowired
	private PostEntityMapper postEntityMapper;

    @Operation(
            summary = "Create a new post",
            description = "Create a new post"
    )
    @ApiResponse(responseCode = "201", description = "Post created")
    @SecurityRequirement(
            name = "Bearer Authentication"
    )
   //  @PreAuthorize("hasRole({'ADMIN', 'USER'})")
    @PostMapping({"", "/"})
    public ResponseEntity<PostEntityDto> createPost(@RequestBody PostEntityDto postEntityDto){
        return new ResponseEntity<>(postService.createPost(postEntityDto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get all posts",
            description = "Get all posts"
    )
    @ApiResponse(responseCode = "200", description = "Posts retrieved")
    @GetMapping("")
    public ResponseEntity<PostEntityResponse>  getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = Constant.DEFAULT_PAGE_NUMBER,  required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue =  Constant.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constant.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        PostEntityResponse resp =  postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
        if (resp.getContent().isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
    }
    @Operation(
            summary = "Get all posts by username",
            description = "Get all posts by username"
    )
    @ApiResponse(responseCode = "200", description = "Posts retrieved")
    @GetMapping({"/username/{username}","/username/{username}/"})
    public  ResponseEntity<PostEntityResponse>  getAllPostsByUsername(
            @RequestParam(value = "pageNo", defaultValue = Constant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue =  Constant.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constant.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @PathVariable String username
    ){
        PostEntityResponse resp = postService.getAllPostsByUsername(pageNo, pageSize, sortBy, sortDir, username);
        if (resp.getContent().isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
    }

    @Operation(
            summary = "Get all posts by email",
            description = "Get all posts by email"
    )
    @ApiResponse(responseCode = "200", description = "Posts retrieved")
    @GetMapping({"/email/{email}","/email/{email}/"})
    public  ResponseEntity<PostEntityResponse>  getAllPostsByEmail(
            @RequestParam(value = "pageNo", defaultValue = Constant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue =  Constant.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constant.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @PathVariable String email
    ){
        PostEntityResponse resp = postService.getAllPostsByEmail(pageNo, pageSize, sortBy, sortDir, email);
        if (resp.getContent().isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
    }

    @Operation(
            summary = "Get all posts by date",
            description = "Get all posts by date"
    )
    @ApiResponse(responseCode = "200", description = "Posts retrieved")
    @GetMapping("/date/{did}")
    public ResponseEntity<PostEntityDto> getPostByDid(@PathVariable(name = "did") String did){
        return ResponseEntity.ok(postService.getPostByDid(did));
    }

    @Operation(
            summary = "Get all posts by category",
            description = "Get all posts by category"
    )
    @ApiResponse(responseCode = "200", description = "Posts retrieved")
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<PostEntityDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostEntityDto>> getPostsByCategoryId(@PathVariable( "categoryId") long categoryId){
        List<PostEntityDto> postEntityDtoList = (List<PostEntityDto>) postService.getPostsByCategoryId(categoryId);
        return ResponseEntity.ok(postEntityDtoList);
    }

    @Operation(
            summary = "Get all posts by title",
            description = "Get all posts by title"
    )
    @ApiResponse(responseCode = "200", description = "Posts retrieved")
    @SecurityRequirement(
            name = "Bearer Authentication"
    )
   //  @PreAuthorize("hasRole({'ADMIN', 'USER'})")
    @PutMapping("/{id}")
    public ResponseEntity<PostEntityDto> updatePost(@RequestBody PostEntityDto postEntityDto, @PathVariable(name = "id") long id){
        PostEntityDto postResponse = postService.updatePost(postEntityDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete a post",
            description = "Delete a post"
    )
    @ApiResponse(responseCode = "200", description = "Post deleted")
    @SecurityRequirement(
            name = "Bearer Authentication"
    )
   //  @PreAuthorize("hasRole({'ADMIN', 'USER'})")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePostById(@PathVariable(name = "id") long id){
        try {
            postService.deletePostById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}
