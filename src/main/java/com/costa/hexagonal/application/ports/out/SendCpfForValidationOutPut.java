package com.costa.hexagonal.application.ports.out;

public interface SendCpfForValidationOutPut {

    void send(String cpf);

}
