package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.dto.RawTokenDto;
import com.friendsofgroot.app.models.RawToken;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RawTokenMapper {
    RawToken toEntity(RawTokenDto rawTokenDto);

    RawTokenDto toDto(RawToken rawToken);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RawToken partialUpdate(RawTokenDto rawTokenDto, @MappingTarget RawToken rawToken);
}
