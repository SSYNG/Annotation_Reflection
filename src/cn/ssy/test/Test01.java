package cn.ssy.test;

import java.util.ArrayList;
import java.util.List;

//三个内置注解
public class Test01 extends  Object{
    public static void main(String[] args) {

    }
    //方法重写
    @Override
    public String toString(){
        return super.toString();
    }
    //已过时的，不推荐使用的
    @Deprecated
    public static void test(){
        System.out.println("牛逼");
    }
    //压制警告：参数：all（所有警告）unchecked（未检查）Deprecated弃用
    @SuppressWarnings("all")
    public void test1(){
        List list = new ArrayList();
    }

}
