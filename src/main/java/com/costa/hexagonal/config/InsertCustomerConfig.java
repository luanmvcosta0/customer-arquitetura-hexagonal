package com.costa.hexagonal.config;

import com.costa.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.costa.hexagonal.adapters.out.InsertCustomerAdapter;
import com.costa.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.costa.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }

}
