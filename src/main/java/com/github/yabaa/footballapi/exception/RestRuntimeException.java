package com.github.yabaa.footballapi.exception;

import java.util.stream.Stream;

public abstract class RestRuntimeException extends RuntimeException {

    private final String returnCode;
    private final Object[] args;

    RestRuntimeException(String returnCode, String message) {
        super(message);
        this.returnCode = returnCode;
        this.args = new Object[]{};
    }

    RestRuntimeException(String returnCode, String message, Object[] args) {
        super(message);
        this.returnCode = returnCode;
        this.args = args.clone();
    }

    public String getReturnCode() {
        return returnCode;
    }

    public Object[] getArgs() {
        return Stream.of(args).toArray();
    }

}
