package com.costa.hexagonal.adapters.out;

import com.costa.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.costa.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.costa.hexagonal.application.core.domain.Address;
import com.costa.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPutPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse  = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
