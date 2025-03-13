package com.costa.hexagonal.adapters.in.consumer;

import com.costa.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.costa.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.costa.hexagonal.application.ports.in.UpdateCustomerInPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInPutPort updateCustomerInPutPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "costa")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInPutPort.update(customer, customerMessage.getZipCode());
    }

}
