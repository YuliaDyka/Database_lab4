package com.api.exception;

import java.sql.SQLException;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String info) {
        super(info);
    }
}
