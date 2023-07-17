package com.agrotis.agrotis.property;

import com.agrotis.property.dtos.request.CreatePropertyRequest;

public class Stubs {

    public static CreatePropertyRequest mockCreateRequest() {
        CreatePropertyRequest createPropertyRequest = new CreatePropertyRequest();
        createPropertyRequest.setName("Agrotis 1");
        createPropertyRequest.setCnpj("08562685000171");
        return createPropertyRequest;
    }
}
