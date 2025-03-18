package xyz.cryptomaven.rest.services;

import xyz.cryptomaven.rest.models.dto.AddressDto;

import java.util.List;

public interface AddressesService {
  AddressDto createAddress(AddressDto addr);

  AddressDto getAddress(Long id);


  List<AddressDto> getAllAddresses();

  AddressDto updateAddress(AddressDto change);

  boolean deleteAddress(Long id);
}


