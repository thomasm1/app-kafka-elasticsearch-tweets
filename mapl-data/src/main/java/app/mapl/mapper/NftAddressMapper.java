package app.mapl.mapper;

import app.mapl.models.dto.NftAddressDto;
import app.mapl.models.NftAddress;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {RawTokenMapper.class, NftMapper.class})
public interface NftAddressMapper {
    NftAddress toEntity(NftAddressDto nftAddressDto);

    NftAddressDto toDto(NftAddress nftAddress);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NftAddress partialUpdate(NftAddressDto nftAddressDto, @MappingTarget NftAddress nftAddress);

    @AfterMapping
    default void linkRawTokens(@MappingTarget NftAddress nftAddress) {
        nftAddress.getRawTokens().forEach(rawToken -> rawToken.setNftAddress(nftAddress));
    }

//    @AfterMapping
//    default void linkNfts(@MappingTarget NftAddress nftAddress) {
//        nftAddress.getNfts().forEach(nft -> nft.setNftAddress(nftAddress));
//    }
}
