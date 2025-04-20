package xyz.cryptomaven.rest.services;

import xyz.cryptomaven.rest.models.dto.AddressDto;

import java.util.List;
import java.util.Optional;

public interface AddressesService {
  AddressDto createAddress(AddressDto addr);

  Optional<AddressDto> getAddress(Long id);


  List<AddressDto> getAllAddresses();

  AddressDto updateAddress(AddressDto change);

  boolean deleteAddress(Long id);
}


