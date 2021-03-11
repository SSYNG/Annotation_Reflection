package cn.ssy.test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test07 {
    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method01 = Test07.class.getMethod("test01", Map.class, List.class);
        //得到方法后，通过方法获得泛型的参数类型
        Type[] genericParameterTypes = method01.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            //打印出来的是Map和List
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                //判断是否为结构化参数类型
                //强转
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }

        }
        Method method02 = Test07.class.getMethod("test01", null);
        Type genericReturnType = method02.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            //判断是否为返回值类型
            //强转
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}
