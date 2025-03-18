package net.ourdailytech.rest.mapper;

import net.ourdailytech.rest.models.PostEntity;
import net.ourdailytech.rest.models.dto.PostEntityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostEntityMapper {
    PostEntity toEntity(PostEntityDto postEntityDto);

    PostEntityDto toDto(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostEntityDto postEntityDto, @MappingTarget PostEntity postEntity);
//
//    PostEntityDto PostEntityToPostEntityDTO(PostEntity postByUsernameAndId);
//
//    List<PostEntity> PostEntitysToPostEntityDTOs(List<PostEntity> allPostsByUsername);
//
//    PostEntity PostEntityDTOToPostEntity(PostEntityDto postEntityDto);
//
//
////    List<PostEntity> PostEntityDTOsToPostEntitys(List<PostEntityDto> postEntityDtos);

}