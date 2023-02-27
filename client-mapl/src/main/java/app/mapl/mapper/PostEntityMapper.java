package app.mapl.mapper;

import app.mapl.dto.PostEntityDto;
import app.mapl.models.PostEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostEntityMapper {
    PostEntity toEntity(PostEntityDto postEntityDto);

    PostEntityDto toDto(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostEntityDto postEntityDto, @MappingTarget PostEntity postEntity);

    PostEntityDto PostEntityToPostEntityDTO(PostEntity postByUsernameAndId);

    List<PostEntity> PostEntitysToPostEntityDTOs(List<PostEntity> allPostsByUsername);

    PostEntity PostEntityDTOToPostEntity(PostEntityDto postEntityDto);


//    List<PostEntity> PostEntityDTOsToPostEntitys(List<PostEntityDto> postEntityDtos);

}