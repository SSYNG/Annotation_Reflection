package cn.ssy.test;

//class类的创建方式有哪些
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        //方式1：通过对象获得
        Class c1 = person.getClass();
        //方法2：Class.forname获得
        Class c2 = Class.forName("cn.ssy.test.Student");
        //方法3：通过类名.class获得
        Class c3 = Student.class;
        //通过子类 获得父类类型
        Class c4 = c1.getSuperclass(); //Person类
        Class c5 = c4.getSuperclass(); //Object类

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器(C/C++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);//装载了核心类库，存在，但是获取不到

        //获取当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("cn.ssy.test.Test04").getClassLoader();
        System.out.println(classLoader);
        //JDK内部类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader+"  object的类加载器");

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}

class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}