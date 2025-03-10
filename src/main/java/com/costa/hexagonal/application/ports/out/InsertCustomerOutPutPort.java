package com.costa.hexagonal.application.ports.out;

import com.costa.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutPutPort {

    void insert(Customer customer);

}
