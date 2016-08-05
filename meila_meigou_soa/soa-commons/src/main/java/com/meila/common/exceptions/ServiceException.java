package com.meila.common.exceptions;

/**
 * 服务层异常
 * 
 * @author hawk
 *
 */
public class ServiceException extends BaseException {
    private static final long serialVersionUID = -5371895613788381904L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int code, String message) {
        super(code, message);
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
