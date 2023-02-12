package cn.j3code.common.annotation;

import java.lang.annotation.*;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-09 21:22
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DistributedLock {

    String key() default "distributedLock";

    long expiredTime() default 30L;

    int maxToRenewNum() default 30;

}
