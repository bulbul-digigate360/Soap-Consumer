package com.triplover.soap.controller;

import com.triplover.soap.SoapClient;
import com.triplover.soap.stub.DetailsType;
import com.triplover.soap.stub.GetBankResponseType;
import com.triplover.soap.stub.GetBankType;
import com.triplover.soap.stub.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BlzController {


    @Autowired
    private SoapClient soapClient;

    @GetMapping
    public DetailsType sum(@RequestParam String code){
        ObjectFactory objectFactory = new ObjectFactory();

        GetBankType type = new GetBankType();
        type.setBlz(code);

        GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService?wsdl",objectFactory.createGetBank(type));
        return response.getDetails();
    }



}
