package cn.j3code.config.exception;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-30 17:54
 **/
public class BldException extends RuntimeException{
    public BldException() {
    }
    public BldException(String message, Object... args) {
        super(String.format(message, args));
    }

    public BldException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

    public BldException(Throwable cause) {
        super(cause);
    }
}
