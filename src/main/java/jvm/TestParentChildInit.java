package jvm;

/**
 * @Auther: wwh
 * @Date: 2019/10/4 00:24
 * @Description:
 *
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时  要求其父类全部都已初始化完毕了
 */
public class TestParentChildInit {
    public static void main(String[] args) {
        //只会打印MyParent
        System.out.println(MyChild1.str);
        //都会打印
        System.out.println(MyChild1.str);
    }
}

class MyParent1 {
    public static String str = "hello world";
    static {
        System.out.println("MyParent1 static block ");
    }

}


class MyChild1 extends MyParent1 {
    public static String str2 = "hello world";

    static {
        System.out.println("MyChild1 static block");
    }
}
