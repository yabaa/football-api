package com.github.yabaa.footballapi.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
public class NotFoundException extends RestRuntimeException {

    private static final String ERROR_CODE = "404";

    public NotFoundException(NotFoundErrorType errorType, Object[] args) {
        super(ERROR_CODE, errorType.getDescription(args));
    }
}
