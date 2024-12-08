package app.mapl.service;

import app.mapl.models.dto.AddressDto;

import java.util.List;
import java.util.Optional;

public interface AddressesService {
    public AddressDto createAddress(AddressDto addr);

    public AddressDto getAddress(int id);

    public List<AddressDto> getAllAddresses();

    public Optional<AddressDto> updateAddress(Integer id, AddressDto change);

    public boolean deleteAddress(int id);

    List<AddressDto> getAddressesByEmail(String email);

    void patchAddressById(Integer addressesId, AddressDto addresses);

}
