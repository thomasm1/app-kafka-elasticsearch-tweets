package xyz.cryptomaven.rest.services;


import org.springframework.transaction.annotation.Transactional;
import xyz.cryptomaven.rest.mapper.ChainMapper;
import xyz.cryptomaven.rest.mapper.CoinMapper;
import xyz.cryptomaven.rest.models.Coin;
import xyz.cryptomaven.rest.models.dto.AddressDto;
import xyz.cryptomaven.rest.mapper.AddressMapper;
import xyz.cryptomaven.rest.models.Address;

import xyz.cryptomaven.rest.models.dto.ChainDto;
import xyz.cryptomaven.rest.models.dto.CoinDto;
import xyz.cryptomaven.rest.repositories.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressesServiceImpl implements AddressesService {

    @Autowired
    private AddressesRepository addressesRepository;
    @Autowired
    private AddressMapper addressMapper;

  @Autowired
  private ChainMapper chainMapper;
  @Autowired
  private CoinMapper coinMapper;

  @Override
    public AddressDto createAddress(AddressDto addrDto) {
        Address address = addressMapper.addressDtoToAddress(addrDto);

//        if (address != null && (address.getChains().isEmpty())) {
//            address.setChains(addrDto.getChains());
//        }
        if (address != null && (address.getOwner() == null || address.getOwner().isEmpty())) {
            address.setOwner(addrDto.getEmail());
        }
      assert address != null;
      Address newAddress = addressesRepository.save(address);
        AddressDto newAddressDto = addressMapper.addressToAddressDto(newAddress);
        return newAddressDto;
    }



    @Transactional(readOnly=true)
    @Override
    public Optional<AddressDto> getAddress(Long id) {
       try {
              Address address = addressesRepository.findById(id).get();
                return Optional.ofNullable(addressMapper.addressToAddressDto(address));
       } catch (Exception e) {
           return Optional.empty();
       }
    }


    @Transactional(readOnly=true)
    @Override
    public List<AddressDto> getAllAddresses() {

        List<Address> adds = addressesRepository.findAll();
        List<AddressDto> addressDtos = adds.stream().map(addressMapper::addressToAddressDto).collect(Collectors.toList());

        return addressDtos;
    }

    @Override
    public AddressDto updateAddress(AddressDto change) {
     try {
         Address addUpdate = addressMapper.addressDtoToAddress(change);
       addUpdate= addressesRepository.findById( change.getId()).get();
       addUpdate.setDescription(change.getDescription());
       addUpdate.setIconUrl(change.getIconUrl());
//       addUpdate.setUser(change.getUser());
       addUpdate.setOwner(change.getOwner());
       addUpdate.setBlockExplorerUrl(change.getBlockExplorerUrl());
       addUpdate.setNftAddress(change.getNftAddress());
       Address newAddress = addressesRepository.save(addUpdate);
       addUpdate.setCoins(  coinMapper.toEntities( change.getCoins()));

       addUpdate.setChains( chainMapper.toEntities(  change.getChains()));

         return addressMapper.addressToAddressDto(newAddress);
     } catch (Exception e) {
         return null;
     }
    }

    @Override
    public boolean deleteAddress(Long id) {
          try {
                addressesRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
    }

}
