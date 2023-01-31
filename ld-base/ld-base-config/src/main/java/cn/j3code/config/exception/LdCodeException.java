package cn.j3code.config.exception;

import cn.j3code.config.vo.FailInfo;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:08
 **/
public class LdCodeException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public LdCodeException() {
    }

    public LdCodeException(Integer code, String message, Object... args) {
        super(String.format(message, args));
        this.code = code;
    }

    public LdCodeException(String message, Object... args) {
        super(String.format(message, args));
        this.code = FailInfo.DEFAULT_CODE;
    }

    public LdCodeException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
        this.code = FailInfo.DEFAULT_CODE;
    }

    public LdCodeException(Throwable cause) {
        super(cause);
        this.code = FailInfo.DEFAULT_CODE;
    }

}
