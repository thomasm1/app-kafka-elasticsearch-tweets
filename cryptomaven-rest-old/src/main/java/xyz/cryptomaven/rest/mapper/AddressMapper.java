package xyz.cryptomaven.rest.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import xyz.cryptomaven.rest.models.Address;
import xyz.cryptomaven.rest.models.dto.AddressDto;

@Mapper(componentModel = "spring",uses= {UserMapper.class})
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "userDto", target = "user")
    Address addressDtoToAddress(AddressDto addressDto);

    @InheritInverseConfiguration
    AddressDto addressToAddressDto(Address address);

}
