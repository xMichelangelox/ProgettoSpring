package com.calcolatrice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.calcolatrice.client.CalculatorClient;
 
@Configuration 
public class CalculatorConfig { 

    @Value("${WSDL.ClientEndpoint}")
    private String clientEndpoint;
 
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.client.gen");
        return marshaller;
    }

    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller){
        CalculatorClient client = new CalculatorClient();
        client.setDefaultUri(clientEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}