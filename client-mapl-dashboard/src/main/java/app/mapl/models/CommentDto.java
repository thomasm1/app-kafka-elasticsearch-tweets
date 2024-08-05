package app.mapl.models;

import app.mapl.dto.PostEntityDto;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Comment} entity
 */
@Data
public class CommentDto implements Serializable {
    private final long id;
    private final String name;
    private final String email;
    private final String body;
    private final PostEntityDto post;
}