package net.ourdailytech.rest.mapper;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import net.ourdailytech.rest.models.Comment;
import net.ourdailytech.rest.models.PostEntity;
import net.ourdailytech.rest.models.dto.CommentDto;
import net.ourdailytech.rest.models.dto.PostEntityDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-07T17:33:49-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class PostEntityMapperImpl implements PostEntityMapper {

    @Override
    public PostEntity toEntity(PostEntityDto postEntityDto) {
        if ( postEntityDto == null ) {
            return null;
        }

        PostEntity.PostEntityBuilder postEntity = PostEntity.builder();

        postEntity.id( postEntityDto.getId() );
        postEntity.did( postEntityDto.getDid() );
        postEntity.date( postEntityDto.getDate() );
        postEntity.author( postEntityDto.getAuthor() );
        postEntity.monthOrder( postEntityDto.getMonthOrder() );
        postEntity.cat3( postEntityDto.getCat3() );
        postEntity.title( postEntityDto.getTitle() );
        postEntity.post( postEntityDto.getPost() );
        postEntity.blogcite( postEntityDto.getBlogcite() );
        postEntity.email( postEntityDto.getEmail() );
        postEntity.state( postEntityDto.getState() );
        postEntity.wordCount( postEntityDto.getWordCount() );
        postEntity.durationGoal( postEntityDto.getDurationGoal() );
        postEntity.comments( commentDtoSetToCommentSet( postEntityDto.getComments() ) );

        return postEntity.build();
    }

    @Override
    public PostEntityDto toDto(PostEntity postEntity) {
        if ( postEntity == null ) {
            return null;
        }

        PostEntityDto.PostEntityDtoBuilder postEntityDto = PostEntityDto.builder();

        if ( postEntity.getId() != null ) {
            postEntityDto.id( postEntity.getId() );
        }
        postEntityDto.did( postEntity.getDid() );
        postEntityDto.date( postEntity.getDate() );
        postEntityDto.author( postEntity.getAuthor() );
        postEntityDto.monthOrder( postEntity.getMonthOrder() );
        postEntityDto.cat3( postEntity.getCat3() );
        postEntityDto.title( postEntity.getTitle() );
        postEntityDto.post( postEntity.getPost() );
        postEntityDto.blogcite( postEntity.getBlogcite() );
        postEntityDto.email( postEntity.getEmail() );
        postEntityDto.state( postEntity.getState() );
        postEntityDto.wordCount( postEntity.getWordCount() );
        postEntityDto.durationGoal( postEntity.getDurationGoal() );
        postEntityDto.comments( commentSetToCommentDtoSet( postEntity.getComments() ) );

        return postEntityDto.build();
    }

    @Override
    public PostEntity partialUpdate(PostEntityDto postEntityDto, PostEntity postEntity) {
        if ( postEntityDto == null ) {
            return postEntity;
        }

        postEntity.setId( postEntityDto.getId() );
        if ( postEntityDto.getDid() != null ) {
            postEntity.setDid( postEntityDto.getDid() );
        }
        if ( postEntityDto.getDate() != null ) {
            postEntity.setDate( postEntityDto.getDate() );
        }
        if ( postEntityDto.getAuthor() != null ) {
            postEntity.setAuthor( postEntityDto.getAuthor() );
        }
        if ( postEntityDto.getMonthOrder() != null ) {
            postEntity.setMonthOrder( postEntityDto.getMonthOrder() );
        }
        if ( postEntityDto.getCat3() != null ) {
            postEntity.setCat3( postEntityDto.getCat3() );
        }
        if ( postEntityDto.getTitle() != null ) {
            postEntity.setTitle( postEntityDto.getTitle() );
        }
        if ( postEntityDto.getPost() != null ) {
            postEntity.setPost( postEntityDto.getPost() );
        }
        if ( postEntityDto.getBlogcite() != null ) {
            postEntity.setBlogcite( postEntityDto.getBlogcite() );
        }
        if ( postEntityDto.getEmail() != null ) {
            postEntity.setEmail( postEntityDto.getEmail() );
        }
        if ( postEntityDto.getState() != null ) {
            postEntity.setState( postEntityDto.getState() );
        }
        postEntity.setWordCount( postEntityDto.getWordCount() );
        postEntity.setDurationGoal( postEntityDto.getDurationGoal() );
        if ( postEntity.getComments() != null ) {
            Set<Comment> set = commentDtoSetToCommentSet( postEntityDto.getComments() );
            if ( set != null ) {
                postEntity.getComments().clear();
                postEntity.getComments().addAll( set );
            }
        }
        else {
            Set<Comment> set = commentDtoSetToCommentSet( postEntityDto.getComments() );
            if ( set != null ) {
                postEntity.setComments( set );
            }
        }

        return postEntity;
    }

    protected Comment commentDtoToComment(CommentDto commentDto) {
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

    protected Set<Comment> commentDtoSetToCommentSet(Set<CommentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Comment> set1 = new LinkedHashSet<Comment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CommentDto commentDto : set ) {
            set1.add( commentDtoToComment( commentDto ) );
        }

        return set1;
    }

    protected CommentDto commentToCommentDto(Comment comment) {
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

    protected Set<CommentDto> commentSetToCommentDtoSet(Set<Comment> set) {
        if ( set == null ) {
            return null;
        }

        Set<CommentDto> set1 = new LinkedHashSet<CommentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Comment comment : set ) {
            set1.add( commentToCommentDto( comment ) );
        }

        return set1;
    }
}
