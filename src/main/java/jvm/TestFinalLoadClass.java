package jvm;

/**
 * @Auther: wwh
 * @Date: 2019/10/4 18:25
 * @Description:
 *
 * 使用final定义后不会打印static
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上调用类并没有直接引用到定义常量的类  因此不会触发定义常量的类的初始化
 * 注意  这里是指将常量存放到了Mytest2的常量池中，之后test和 主类就没有任何关系了 甚至可以把test的class文件删除
 */
public class TestFinalLoadClass {
        public static void main(String[] args) {
            //只会打印MyParent
            System.out.println(test.str);
            //都会打印
            // System.out.println(MyChild1.str);
        }
}
class test {
    public  static final  String str = "hello world";
    static {
        System.out.println("MyParent1 static block ");
    }

}