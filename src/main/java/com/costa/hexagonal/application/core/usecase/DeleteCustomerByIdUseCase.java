package com.costa.hexagonal.application.core.usecase;

import com.costa.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.costa.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.costa.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(final String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }

}
