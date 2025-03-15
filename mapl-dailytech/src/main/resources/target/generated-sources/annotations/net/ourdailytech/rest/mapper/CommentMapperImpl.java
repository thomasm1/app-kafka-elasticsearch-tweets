package net.ourdailytech.rest.mapper;

import javax.annotation.processing.Generated;
import net.ourdailytech.rest.models.Comment;
import net.ourdailytech.rest.models.dto.CommentDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-07T17:33:49-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment toEntity(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment.CommentBuilder comment = Comment.builder();

        comment.id( commentDto.getId() );
        comment.name( commentDto.getName() );
        comment.email( commentDto.getEmail() );
        comment.body( commentDto.getBody() );

        return comment.build();
    }

    @Override
    public CommentDto toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto.CommentDtoBuilder commentDto = CommentDto.builder();

        if ( comment.getId() != null ) {
            commentDto.id( comment.getId() );
        }
        commentDto.name( comment.getName() );
        commentDto.email( comment.getEmail() );
        commentDto.body( comment.getBody() );

        return commentDto.build();
    }

    @Override
    public Comment partialUpdate(CommentDto commentDto, Comment comment) {
        if ( commentDto == null ) {
            return comment;
        }

        comment.setId( commentDto.getId() );
        if ( commentDto.getName() != null ) {
            comment.setName( commentDto.getName() );
        }
        if ( commentDto.getEmail() != null ) {
            comment.setEmail( commentDto.getEmail() );
        }
        if ( commentDto.getBody() != null ) {
            comment.setBody( commentDto.getBody() );
        }

        return comment;
    }
}
