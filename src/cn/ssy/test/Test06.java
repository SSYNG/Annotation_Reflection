package cn.ssy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//通过反射，动态的创建对象
public class Test06 {
    public static void main(String[] args) throws Exception{
        //获得class对象
        Class c1 = Class.forName("cn.ssy.test.User");
        //创造一个对象
        User user = (User)c1.newInstance();//调用了无参构造器
        System.out.println(user);
        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("侯风贤",01,18);
        System.out.println(user2);
        //通过反射调用方法
        User user3 = (User)c1.newInstance();
        //获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke激活方法，
        // 第一个参数传递已实例化的对象。
        // 第二个参数设置方法的值
        setName.invoke(user3,"路路");
        System.out.println(user3.getName());

        //通过反射操作属性
        //User的几个属性都是private，不能直接操作
        User user4  = (User)c1.newInstance();//获得对象
        Field name = c1.getDeclaredField("name");//获得对象的属性
        name.setAccessible(true);//关闭权限检查才能设置
        name.set(user4,"路阳峰");//设置属性值
        System.out.println(user4.getName());
    }

}
