package cn.ssy.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test02 {

    @MyAnnotation2(name = "ssy", age = 22,wife={"侯风贤","路阳峰"})
    public void test() {

    }

    @MyAnnotation3("侯风贤小老婆")
    public void test2(){

    }
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    //注解的参数：参数类型 + 参数名();
    String name() default ""; //default:默认值

    int age() default 0;

    int id() default -1; //默认值为-1，代表不存在

    String[] wife() default {"侯风贤","路阳峰"};
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    //注解的参数：参数类型 + 参数名();
    //注解只有一个值时，命名为value，填参数时可省略，直接填
    String value() default ""; //default:默认值
}