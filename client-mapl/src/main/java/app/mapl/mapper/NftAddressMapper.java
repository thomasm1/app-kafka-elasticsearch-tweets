package app.mapl.mapper;

import app.mapl.dto.NftAddressDto;
import app.mapl.models.NftAddress;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NftAddressMapper {
    NftAddress toEntity(NftAddressDto nftAddressDto);

    NftAddressDto toDto(NftAddress nftAddress);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NftAddress partialUpdate(NftAddressDto nftAddressDto, @MappingTarget NftAddress nftAddress);
}