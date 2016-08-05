package com.meila.common.exceptions;

/**
 * 数据层异常
 * 
 * @author hawk
 *
 */
public class DaoException extends BaseException {
    private static final long serialVersionUID = -5371895613788381904L;

    public DaoException(int code, String message) {
        super(code, message);
    }

    public DaoException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
