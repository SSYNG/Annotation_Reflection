package cn.ssy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获取类的信息
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c1 = Class.forName("cn.ssy.test.User");

        //实例化，从实例找到包名+类名
        User user = new User();
        c1 = user.getClass();

        //类名（包名路径+类名）
        System.out.println(c1.getName());
        //简单名（仅类名）
        System.out.println(c1.getSimpleName());

        //获得类属性
        System.out.println("---------------");
        Field[] fields = c1.getFields(); //只能找到public属性
        fields  = c1.getDeclaredFields();//找到全部属性
        for (Field field :fields){
            System.out.println(field);
        }

        //获得指定属性
        try {
            Field name = c1.getDeclaredField("name");
            System.out.println("获得指定属性: "+name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        //获得类的方法
        //1.获得本类及其父类的全部public方法
        System.out.println("---------------");
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("本类所有public方法："+method);
        }
        //2.获得本类的所有方法
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法："+declaredMethod);
        }

        //3.获得指定的方法
        //因为考虑到重载，所以需要填参数
        Method getName = c1.getMethod("getName",null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println("无参方法："+getName);
        System.out.println("有参方法："+setName);

        //4.获得指定的构造器
        System.out.println("=================");
        //获得public构造器方法
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("public构造器: "+constructor);
        }
        //获得全部的构造器方法
        constructors  =c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("全部的构造器: "+constructor);
        }
        //获得指定的构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定构造器: "+declaredConstructor);
    }
}
