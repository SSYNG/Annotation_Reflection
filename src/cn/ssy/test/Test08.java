package cn.ssy.test;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//通过反射操作注解
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("cn.ssy.test.Student2");

        //通过反射获得类的注解
        Annotation[] annotations = c1.getAnnotations();
        System.out.println(annotations);

        //获得注解的value的值
        Tablessy tablessy = (Tablessy)c1.getAnnotation(Tablessy.class);
        String value = tablessy.value();
        System.out.println(value);
        //获得类属性的注解
        Field f = c1.getDeclaredField("name");
        Fieldssy annotation = f.getAnnotation(Fieldssy.class);
        System.out.println(annotation);
        //指定参数
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Tablessy("db_wife")
class Student2 {
    @Fieldssy(columnName = "db_id", type = "int", length = 10)
    private int id;
    @Fieldssy(columnName = "db_age", type = "int", length = 3)
    private int age;
    @Fieldssy(columnName = "db_name", type = "varchar", length = 10)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


//自定义类注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablessy {
    String value();
}

//自定义属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldssy {
    String columnName();

    String type();

    int length();
}