package com.javaweb.demoexception.model;

import java.util.List;

public class ErrorResponseDTO {
    private String errorName;
    private List<String> detailError;

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public List<String> getDetailError() {
        return detailError;
    }

    public void setDetailError(List<String> detailError) {
        this.detailError = detailError;
    }
}
