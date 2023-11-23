package app.mapl.mapper;

import app.mapl.dto.BookmarkDto;
import app.mapl.models.Bookmark;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookmarkMapper {
    Bookmark toEntity(BookmarkDto bookmarkDto);

    BookmarkDto toDto(Bookmark bookmark);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bookmark partialUpdate(BookmarkDto bookmarkDto, @MappingTarget Bookmark bookmark);
}