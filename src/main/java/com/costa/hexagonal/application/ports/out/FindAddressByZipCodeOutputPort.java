package com.costa.hexagonal.application.ports.out;

import com.costa.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipcode);

}
