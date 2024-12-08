package app.mapl.service;

import app.mapl.models.dto.AddressDto;
import app.mapl.mapper.AddressMapper;
import app.mapl.models.Address;

import app.mapl.repositories.AddressesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressesServiceImpl implements AddressesService {
    private static final Logger log = LoggerFactory.getLogger(AddressesServiceImpl.class);
    private final AddressesRepository addressesRepository;
    private final AddressMapper addressMapper;

    public AddressesServiceImpl(AddressesRepository addressesRepository, AddressMapper addressMapper) {
        this.addressesRepository = addressesRepository;
        this.addressMapper = addressMapper;
    }


    @Override
    public AddressDto createAddress(AddressDto addrDto) {
        Address address = addressMapper.toEntity(addrDto);

        if (address != null && (address.getChainId() == 0)) {
            address.setChainId(addrDto.getChainId());
        }
        if (address != null && (address.getEmail() == null || address.getEmail() == "")) {
            address.setEmail(addrDto.getEmail());
        }
        Address newAddress = addressesRepository.save(address);
        AddressDto newAddressDto = addressMapper.toDto(newAddress);
        return newAddressDto;
    }

    @Override
    public AddressDto getAddress(int id) {
        try {
            Address address = addressesRepository.findById(id).get();
            return addressMapper.toDto(address);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<AddressDto> getAllAddresses() {

        List<Address> adds = addressesRepository.findAll();
        List<AddressDto> addressDtos = adds.stream().map(addressMapper::toDto).collect(Collectors.toList());
        return addressDtos;
    }

    @Override
    public Optional<AddressDto> updateAddress(Integer id, AddressDto change) {

        try {
//             addUpdate = addressMapper.addressDtoToAddress(change);
            Address existingUpdate = addressesRepository.findById(change.getId()).get();
            existingUpdate.setDescription(change.getDescription() != null ? change.getDescription() : existingUpdate.getDescription());
            existingUpdate.setIconUrl(change.getIconUrl() != null ? change.getIconUrl() : existingUpdate.getIconUrl());
//            existingUpdate.setUser(change.getUserDto() != null ? change.getUserDto() : existingUpdate.getUser());
            existingUpdate.setChain(change.getChain() != null ? change.getChain() : existingUpdate.getChain());
            existingUpdate.setEmail(change.getEmail()   != null ? change.getEmail() : existingUpdate.getEmail());
            existingUpdate.setBlockExplorerUrl(change.getBlockExplorerUrl()     != null ? change.getBlockExplorerUrl() : existingUpdate.getBlockExplorerUrl());
            existingUpdate.setChainId(change.getChainId() != 0 ? change.getChainId() : existingUpdate.getChainId());
//            addUpdate.setNftAddress(change.getNftAddress());

            Address newAddress = addressesRepository.save(existingUpdate);

            return Optional.ofNullable(addressMapper.toDto(newAddress));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void patchAddressById(Integer addressesId, AddressDto addresses) {

    }

    @Override
    public boolean deleteAddress(int id) {
        try {
            addressesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param email
     * @return
     */
    @Override
    public List<AddressDto> getAddressesByEmail(String email) {

        List<Address> adds = addressesRepository.getAddressesByEmail(email);
        List<AddressDto> addressDtos = adds.stream().map(addressMapper::toDto).collect(Collectors.toList());
        return addressDtos;
    }


}
