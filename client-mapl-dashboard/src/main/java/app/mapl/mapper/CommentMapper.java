package app.mapl.mapper;

import app.mapl.models.dto.PostEntityDto;
import app.mapl.models.Comment;
import app.mapl.models.dto.CommentDto;
import app.mapl.models.PostEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentMapper {
    Comment toEntity(CommentDto commentDto);

    CommentDto toDto(Comment comment);
    PostEntity map(PostEntityDto value);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Comment partialUpdate(CommentDto commentDto, @MappingTarget Comment comment);
}