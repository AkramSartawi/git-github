package com.exalt.usecase.exception;

public class GeneralException  extends RuntimeException {
    private  EnumError error;

    public GeneralException( EnumError error) {
        super(error.getMessage());
        this.error = error;
    }

    public GeneralException( Throwable cause, EnumError error) {
        super(error.getMessage(), cause);
        this.error = error;
    }

    public EnumError getError() {
        return error;
    }

    public void setError(EnumError error) {
        this.error = error;
    }
}
