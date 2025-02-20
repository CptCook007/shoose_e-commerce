package com.vipin.shoose.service;

import com.vipin.shoose.dto.AddressDto;
import com.vipin.shoose.model.Address;
import com.vipin.shoose.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserService userService;
    @Override
    public void save(AddressDto addressDto) {
      try {
          Address address=new Address();
          address.setFullName(addressDto.getFullName());
          address.setPhoneNumber(addressDto.getPhoneNumber());
          address.setBuildingName(addressDto.getBuildingName());
          address.setStreetName(addressDto.getStreetName());
          address.setCity(addressDto.getCity());
          address.setState(addressDto.getState());
          address.setPostalCode(addressDto.getPostalCode());
          address.setUser(userService.getCurrentUser());
          addressRepository.save(address);
      }catch (Exception e){
          throw  new RuntimeException("address not saved");
      }

    }

    @Override
    public List<Address> getCurrentUserAddresses() {
        return addressRepository.findByUser(userService.getCurrentUser());

    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public void editAddress(Long addressId,AddressDto addressDto) {
        try {
           Address address= addressRepository.findByAddressId(addressId);
            if(!Objects.equals(addressDto.getFullName(), "")){
                address.setFullName(addressDto.getFullName());
            }
            if (!Objects.equals(addressDto.getBuildingName(),"")){
                address.setBuildingName(addressDto.getBuildingName());
            }
            if (!Objects.equals(addressDto.getStreetName(),"")){
                address.setStreetName(addressDto.getStreetName());
            }
            if (!Objects.equals(addressDto.getCity(),"")){
                address.setCity(addressDto.getCity());
            }
            if (!Objects.equals(addressDto.getState(),"")){
                address.setState(addressDto.getState());
            }
            if (!Objects.equals(addressDto.getPostalCode(),"")){
                address.setPostalCode(addressDto.getPostalCode());
            }
            addressRepository.save(address);
        }catch (Exception e){
            throw new RuntimeException("address not found");
        }


    }
}
