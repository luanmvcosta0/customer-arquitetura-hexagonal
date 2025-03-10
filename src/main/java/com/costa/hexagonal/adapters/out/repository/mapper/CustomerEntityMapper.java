package com.costa.hexagonal.adapters.out.repository.mapper;

import com.costa.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.costa.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

}
