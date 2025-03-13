package com.costa.hexagonal.application.core.usecase;

import com.costa.hexagonal.application.core.domain.Customer;
import com.costa.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.costa.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.costa.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import com.costa.hexagonal.application.ports.out.SendCpfForValidationOutPut;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;

    private final InsertCustomerOutPutPort insertCustomerOutPutPort;

    private final SendCpfForValidationOutPut sendCpfForValidationOutPut;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
            InsertCustomerOutPutPort insertCustomerOutPutPort, SendCpfForValidationOutPut sendCpfForValidationOutPut) {
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
        this.sendCpfForValidationOutPut = sendCpfForValidationOutPut;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
        sendCpfForValidationOutPut.send(customer.getCpf());
    }

}
