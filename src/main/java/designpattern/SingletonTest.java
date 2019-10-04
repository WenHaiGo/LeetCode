package designpattern;

/**
 * @Auther: wwh
 * @Date: 2019/10/3 23:37
 * @Description:
 *
 * 什么是单例：就是采取一定的方法保证在整个软件系统中 对某个类只能存在一个对象实例  并且该类只提供一个取的其对象实例的方法
 */
public class SingletonTest {
    public static void main(String[] args) {
        SingletonHungryStaticBlock instance = SingletonHungryStaticBlock.getInstance();
        SingletonHungryStaticBlock instance2 = SingletonHungryStaticBlock.getInstance();
        System.out.println(instance==instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

/**
 *
 * @date: 2019/10/4 19:00
 * @param: * @param null:
 * @return: * @return: null
 * @author: wwh
 * @Description:
 *  * 优点：在类装载的时候就完成实例化，
 *  * todo 避免了线程同步的问题
 *  * 缺点： 在类装载的时候就完成实例化 没有达到lazy  loading的效果 如果从始到终都从未使用过这个实例  则会造成内存的浪费
 *  * 结论 单例模式是可用的，可能会造成内存浪费
 */
class SingletonHungry {
    //1、构造器私有化  外面不可以new
    private SingletonHungry(){

    }
    //2、本类内部构建对象实例
    private final static SingletonHungry instance = new SingletonHungry();
    //3、提供一个共有的静态方法，返回实例对象
    public static SingletonHungry getInstance(){
        return instance;
    }
}

class SingletonHungryStaticBlock {
    //1、构造器私有化  外面不可以new
    private SingletonHungryStaticBlock(){
    }

    private static SingletonHungryStaticBlock instance ;
    //2、 静态代码块中创建单例对象
    static {
        instance = new SingletonHungryStaticBlock();
    }
    //3、提供一个共有的静态方法，返回实例对象
    public static SingletonHungryStaticBlock getInstance(){
        return instance;
    }
}

