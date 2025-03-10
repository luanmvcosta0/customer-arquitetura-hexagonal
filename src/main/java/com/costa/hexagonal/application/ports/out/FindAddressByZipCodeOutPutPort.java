package com.costa.hexagonal.application.ports.out;

import com.costa.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPutPort {

    Address find(String zipCode);

}
