package com.crudtienda.tienditaspring.model;

import lombok.Data;

@Data
public class ServiceResponse {
    private Boolean success;
    private String message;

    public ServiceResponse() {
    }

    public ServiceResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
