package app.mapl.dto;

import app.mapl.models.PostEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

/**
 * A DTO for the {@link PostEntity} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntityDto implements Serializable {
    private long id;
    private String did;
    private String date;
    private String author;
    private String monthOrder;
    private String cat3;

    @NotEmpty
//    @Size(min = 10, message="Post title should have at least 10 characters")
    private String title;

    @NotEmpty
    private String post;
    private String blogcite;

    private String username;

    private Long categoryId;

//    private Set<CommentDto> comments;
}