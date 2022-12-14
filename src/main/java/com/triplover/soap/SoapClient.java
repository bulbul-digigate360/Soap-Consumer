package com.triplover.soap;


import com.triplover.soap.stub.GetBankResponseType;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class SoapClient extends WebServiceGatewaySupport {

    public GetBankResponseType getBank(String url, Object request){
        JAXBElement res = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url,request);
        return (GetBankResponseType) res.getValue();
    }
}
