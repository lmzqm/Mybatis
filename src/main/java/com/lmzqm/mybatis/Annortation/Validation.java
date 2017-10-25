package com.lmzqm.mybatis.Annortation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lmzqm on 2017/9/21.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Validation {

    /**
     * 是否为空 为true表示不能为空，false 表示可以为空
     * @return
     */
    boolean notNull() default false;

    /**
     * 是否为固定的Integer值
     * @return
     */
    int[] fixedInteger() default {};

    /**
     * 最小值
     * @return
     */
    int min() default -1;

    /**
     * 最大值
     * @return
     */
    int max() default -1;
}
