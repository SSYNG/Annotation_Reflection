package cn.ssy.test;

public class Test {
    int a;
    int b;
    public void Test(){
        System.out.println("无参构造");
    }
    public  void Test(int a,int b){
        this.a=a;
        this.b=b;
        System.out.println("有参构造"+a+b);
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.Test();
        t.Test(3,5);
    }
}
