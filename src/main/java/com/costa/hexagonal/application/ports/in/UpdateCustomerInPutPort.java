package com.costa.hexagonal.application.ports.in;

import com.costa.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInPutPort {

    void update(Customer customer, String zipCode);

}
