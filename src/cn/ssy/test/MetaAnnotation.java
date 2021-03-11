package cn.ssy.test;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;

//元注解
public class MetaAnnotation {
    @MyAnnotation
    public void test() {

    }

}

//@Target用于修饰注解，可以用value=ElementType.xxx，规定其作用范围
@Target(value = {ElementType.METHOD, ElementType.TYPE})

//Retention 表示注解在什么时候有效
/*runtime>class>sources
按生命周期来划分可分为3类：
1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在。*/
@Retention(value = RetentionPolicy.RUNTIME)

//Documented 表示是否将注解生成在JAVAdoc中
@Documented

//Inherited 表示子类可继承父类的注解
@Inherited

@interface MyAnnotation {

}