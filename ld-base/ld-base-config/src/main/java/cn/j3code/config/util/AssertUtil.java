package cn.j3code.config.util;

import cn.j3code.config.exception.LdException;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 16:07
 **/
public class AssertUtil {

    /**
     * 条件是 true，抛出消息
     * @param expression
     * @param message
     */
    public static void isTrue(Boolean expression, String message) {
        if (expression) {
            throw new LdException(message);
        }
    }

    /**
     * 条件是 false，抛出消息
     * @param expression
     * @param message
     */
    public static void isFalse(Boolean expression, String message) {
        if (!expression) {
            throw new LdException(message);
        }
    }
}
