package com.sidbi.vdf.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    private String error;
    private String code;
    private String message;
}
