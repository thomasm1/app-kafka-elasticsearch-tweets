package net.ourdailytech.rest.models.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import net.ourdailytech.rest.models.Category;
import net.ourdailytech.rest.models.Comment;
import net.ourdailytech.rest.models.PostEntity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link PostEntity} entity
 */
@Getter
@Setter
@Builder
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

    private String email;


    private String state;
    private int wordCount;
    private int durationGoal;
    private Long categoryId;
    private Set<CommentDto> comments;
}