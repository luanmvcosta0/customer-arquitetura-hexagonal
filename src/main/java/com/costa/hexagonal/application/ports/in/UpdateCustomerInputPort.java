package com.costa.hexagonal.application.ports.in;

import com.costa.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
