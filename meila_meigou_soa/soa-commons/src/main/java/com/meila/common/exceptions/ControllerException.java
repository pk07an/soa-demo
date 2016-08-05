package com.meila.common.exceptions;

/**
 * 控制层异常
 * 
 * @author hawk
 *
 */
public class ControllerException extends BaseException {
    private static final long serialVersionUID = 6729290586617990677L;

    public ControllerException(int code, String message) {
        super(code, message);
    }

    public ControllerException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
