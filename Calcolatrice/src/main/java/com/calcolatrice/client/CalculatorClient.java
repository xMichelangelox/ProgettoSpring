package com.calcolatrice.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soap.client.gen.Add;
import com.soap.client.gen.AddResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

    public AddResponse addResponse(Add addResult){
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",addResult,
                new SoapActionCallback("http://tempuri.org/Add"));
        return response;
    }

}

