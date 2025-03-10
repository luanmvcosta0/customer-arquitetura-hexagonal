package com.costa.hexagonal.application.core.usecase;

import com.costa.hexagonal.application.core.domain.Customer;
import com.costa.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.costa.hexagonal.application.ports.out.InsertCustomerOutPutPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;

    private final InsertCustomerOutPutPort insertCustomerOutPutPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
            InsertCustomerOutPutPort insertCustomerOutPutPort) {
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
    }

    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
    }

}
