package com.lmzqm.mybatis.Annortation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lmzqm on 2017/8/3.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {

    /**
     * 注解中成员的类型是受限的
     * 合法的类型包括基本的数据类型，String,Class，Annotation,Enumeration等
     *
     * 2.如果注解只有一个成员，那么这个成员的必须取名为Vlaue()，在使用时可以忽略成员名和赋值号（=）
     *
     * 3.注解可以没有成员，没有成员的注解成为标识注解
     *
     * 元注解：是给注解进行注解，可以为注解的注解
     *  @Target 主要是讨论这个注解的作用域 ElementType是这个注解作用的列表，METHOD 是方法的声明除此之外还有
     *  CONSTRUCTOR （构造方法声明） FIELD (字段声明) LOCAL VARIABLE (局部变量声明) METHOD（方法声明） PACKAGE (包声明) TYPE (类接口)
     *
     *  @Retention 是它的生命周期 RUNTIME 就是运行时存在的，可以通过反射读取
     *  SOURCE 只在源代码显示，编译时丢失 CLASS 编译时记录到Class中，运行时忽略 RUNTIME 运行时存在，可以通过反射读取
     *
     *  @Inherited是一个标识性的元注解，它运行子注解继承它
     *
     *  @Documented 生成javaDoc时包含注解
     *
     *  使用自定义注解
     *    使用注解的语法：
     *    @<注解名>（<成员名1>=<成员值1>，<c成员名2>=<成员值>）
     *
     *    @Description(desc="i am color",author="boy",age=18)
     *    public String Color(){
     *        return "red";
     *    }
     *
     *    这里的Description是我们刚才在自定义注解语法要求里面定义的注解，然后我们可以给它的每一个成员变脸赋值，注意数据类型。
     *    值得注意的是，因为我们前面定义的作用域是方法和类的接口上，我们这个注解在Color方法上使用时没有问题的
     *
     *    解析注解：
     *      首先类的注解
     *      Class c = Class.forName("com.test.Child");
     *      boolean isExist = c.isAnnotationP
     *
     *     Class c = Class.forName("com.lmzqm.mybatis");
    boolean isExist = c.isAnnotationPresent(Authorization.class);
    if (isExist){
    Authorization authorization = (Authorization) c.getAnnotation(Authorization.class);

    }

    Method[] ms =  c.getMethods();
    for (Method m :ms){
    Annotation[] as =  m.getAnnotations();
    for (Annotation a : as){
    if (a instanceof Authorization){
    Authorization author = (Authorization)a;
    }
    }
    boolean isExist1 = m.isAnnotationPresent(Authorization.class);
    if (isExist1){
    Authorization authorization = (Authorization) m.getAnnotation(Authorization.class);

    }

    }
     *
     */


}
