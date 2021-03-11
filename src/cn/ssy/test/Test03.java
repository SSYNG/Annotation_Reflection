package cn.ssy.test;

//反射
//object类中 的public final Class getClass()
//返回类型是Class 这个类是Java反射的源头，实际上所谓反射从发
//程序的运行结果来看也很好理解，即：可以通过对象反射求出类名称
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException{
        //通过反射获取类的class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中
        Class c1 = Class.forName("cn.ssy.test.Test03");
        System.out.println(c1);
    }

}
//实体类
class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}