package com.costa.hexagonal.application.ports.out;

import com.costa.hexagonal.application.core.domain.Customer;
import java.util.Optional;

public interface FindCustomerByIdOutPutPort {

    Optional<Customer> find(String id);

}
