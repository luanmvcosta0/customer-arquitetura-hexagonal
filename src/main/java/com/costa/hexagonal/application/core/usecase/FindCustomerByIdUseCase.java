package com.costa.hexagonal.application.core.usecase;

import com.costa.hexagonal.application.core.domain.Customer;
import com.costa.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.costa.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutPutPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
