package com.costa.hexagonal.adapters.out.client.mapper;

import com.costa.hexagonal.adapters.out.client.response.AddressResponse;
import com.costa.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
