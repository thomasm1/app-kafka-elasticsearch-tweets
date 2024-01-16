package app.mapl.controllers;

import app.mapl.dto.PostEntityDto;
import app.mapl.dto.PostEntityResponse;

import app.mapl.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.mapl.util.constants.*;

import java.util.List;

@RequestMapping(path = PostEntityController.API_POSTS)
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class PostEntityController {
    public static final String ID = "/{id}";
    private static final Logger log = LoggerFactory.getLogger(PostEntityController.class);
    public static final String API_POSTS = "/api/posts";
    public static final String USERNAME_USERNAME = "/username/{username}";
    public static final String ID_ID = "/id/{id}";
    public static final String DATE_DID = "/date/{did}";
    public static final String CATEGORY_CATEGORY_ID = "/category/{categoryId}";

    private final PostService postService;

    @PostMapping("")
    public ResponseEntity<PostEntityDto> createPost(@RequestBody PostEntityDto postEntityDto){
        return new ResponseEntity<>(postService.createPost(postEntityDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public PostEntityResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = Datum.DEFAULT_PAGE_NUMBER,  required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Datum.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue =  Datum.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Datum.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping(USERNAME_USERNAME)
    public PostEntityResponse getAllPostsByUsername(
            @RequestParam(value = "pageNo", defaultValue = Datum.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Datum.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue =  Datum.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Datum.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @PathVariable String username
    ){
        return postService.getAllPostsByUsername(pageNo, pageSize, sortBy, sortDir, username);
    }

    @GetMapping(ID_ID)
    public ResponseEntity<PostEntityDto> getPostById(@PathVariable(name = "id") long id){
        ResponseEntity resp= ResponseEntity.ok(postService.getPostById(id).orElseThrow(NullPointerException::new));
        log.info("GET POSTENTITY/129: "+id+"__RESP: "+resp.getBody().toString()+"\n_____");
        return resp;
    }

    @GetMapping(DATE_DID)
    public ResponseEntity<PostEntityDto> getPostByDid(@PathVariable(name = "did") String did){
        return ResponseEntity.ok(postService.getPostByDid(did).orElseThrow(NullPointerException::new));

    }

    @GetMapping(CATEGORY_CATEGORY_ID)
    public ResponseEntity<List<PostEntityDto>> getPostsByCategoryId(@PathVariable( "categoryId") long categoryId){
        List<PostEntityDto> postEntityDtoList = (List<PostEntityDto>) postService.getPostsByCategoryId(categoryId);
        return ResponseEntity.ok(postEntityDtoList);
    }
    @GetMapping("/search")
    public ResponseEntity<PostEntityResponse> searchPosts(@RequestParam("query") String query){
        PostEntityResponse postEntityResponse =  postService.searchPostEntities(query);
        return ResponseEntity.ok(postEntityResponse);
    }
    @PutMapping(ID)
    public ResponseEntity<PostEntityDto> updatePost(@RequestBody PostEntityDto postEntityDto, @PathVariable(name = "id") long id){
        PostEntityDto postResponse = postService.updatePost(postEntityDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

@DeleteMapping(ID)
public ResponseEntity<Boolean> deletePostById(@PathVariable(name = "id") long id){
    try {
        postService.deletePostById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

}
