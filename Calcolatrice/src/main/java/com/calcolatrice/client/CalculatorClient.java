package com.calcolatrice.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soap.client.gen.Add;
import com.soap.client.gen.AddResponse;
import com.soap.client.gen.Multiply;
import com.soap.client.gen.MultiplyResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

    public AddResponse addResponse(Add addResult){
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",addResult,
                new SoapActionCallback("http://tempuri.org/Add"));
        return response;
    }
    
    public MultiplyResponse multiplyResponse(Multiply request){
        MultiplyResponse response= (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request
                , new SoapActionCallback("http://tempuri.org/Multiply"));
        return response;
    }

}

