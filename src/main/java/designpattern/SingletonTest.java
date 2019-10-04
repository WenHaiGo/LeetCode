package designpattern;

/**
 * @Auther: wwh
 * @Date: 2019/10/3 23:37
 * @Description:
 *
 * 什么是单例：就是采取一定的方法保证在整个软件系统中 对某个类只能存在一个对象实例  并且该类只提供一个取的其对象实例的方法
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.security.Signature;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

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
class SingletonHungryStaticConst {
    //1、构造器私有化  外面不可以new
    private SingletonHungryStaticConst(){

    }
    //2、本类内部构建对象实例
    private final static SingletonHungryStaticConst instance = new SingletonHungryStaticConst();
    //3、提供一个共有的静态方法，返回实例对象
    public static SingletonHungryStaticConst getInstance(){
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

//什么是懒加载呢  就是用到了才去创建 单线程下是对的，
class SingletonLazyUnsafe {
    //1、构造器私有化  外面不可以new
    private SingletonLazyUnsafe(){
        System.out.println("这是在构造方法中的一句话，用来验证产生了几个对象");
    }

    private static SingletonLazyUnsafe instance ;
    //2、 静态代码块中创建单例对象

    //3、提供一个共有的静态方法，返回实例对象
    public static SingletonLazyUnsafe getInstance(){
        if(instance==null){
            synchronized (SingletonLazyUnsafe.class){
                instance = new SingletonLazyUnsafe();
            }

        }
        return instance;
    }
}

//什么是懒加载呢  就是用到了才去创建 单线程下是对的，
class SingletonLazySafe {
    //1、构造器私有化  外面不可以new
    private SingletonLazySafe(){
        System.out.println("这是在构造方法中的一句话，用来验证产生了几个对象");
    }

    private static SingletonLazySafe instance ;
    //2、 静态代码块中创建单例对象

    //3、提供一个共有的静态方法，返回实例对象
    public static synchronized SingletonLazySafe getInstance(){
        if(instance==null){
            instance = new SingletonLazySafe();
        }
        return instance;
    }
}

//双重检查
class SingletonLazyDoubleCheck {
    //1、构造器私有化  外面不可以new
    private SingletonLazyDoubleCheck(){
        System.out.println("这是在构造方法中的一句话，用来验证产生了几个对象");
    }

    private static SingletonLazyDoubleCheck instance ;
    //2、 静态代码块中创建单例对象

    //3、提供一个共有的静态方法，返回实例对象
    public static synchronized SingletonLazyDoubleCheck getInstance(){
        if(instance==null){
            synchronized (SingletonLazyDoubleCheck.class){
                if(instance==null){
                    instance = new SingletonLazyDoubleCheck();
                }
            }
        }
        return instance;
    }
}


//静态内部类
class SingletonLazyStaticInner {
    //1、构造器私有化  外面不可以new
    private SingletonLazyStaticInner(){
        System.out.println("这是在构造方法中的一句话，用来验证产生了几个对象");
    }

    private static class  SingletonInner{
        private static final SingletonLazyStaticInner INSTANCE = new SingletonLazyStaticInner();
    }
    //3、提供一个共有的静态方法，返回实例对象
    public static synchronized SingletonLazyStaticInner getInstance(){

        return SingletonInner.INSTANCE;
    }
}



public class SingletonTest implements Runnable {
    // 请求总数
    public static int clientTotal = 100;
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;

   /*public static void main(String[] args) throws InterruptedException {

        //java中有四种线程池的用法
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量是控制并发的个数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        SingletonLazyUnsafe singletonLazy ;
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    //获取执行的许可   如果没有就等待
                    semaphore.acquire();
                    //singletonLazy = SingletonLazyUnsafe.getInstance();
                    SingletonLazyUnsafe.getInstance();
                    //System.out.println(Thread.currentThread().getName()+"  "+ SingletonLazyUnsafe.getInstance());
                    //释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

        System.out.println(count);
    }*/

    @Override
    public void run() {
        SingletonLazyStaticInner.getInstance() ;
    }



    public static void main(String[] args) {

        /*SingletonLazyUnsafe instance = SingletonLazyUnsafe.getInstance();
        SingletonLazyUnsafe instance2 = SingletonLazyUnsafe.getInstance();
        System.out.println(instance==instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());*/
        //以下代码可以测试懒汉式线程不安全，通过构造函数打印来看到底生成了几个对象
        for (int i = 0; i < 100; i++) {
            SingletonTest singletonTest = new SingletonTest();
            SingletonTest singletonTest2 = new SingletonTest();
            SingletonTest singletonTest3 = new SingletonTest();
            SingletonTest singletonTest4 = new SingletonTest();
            SingletonTest singletonTest5 = new SingletonTest();
            SingletonTest singletonTest6 = new SingletonTest();
            new Thread(singletonTest,"thread1").start();
            new Thread(singletonTest2,"thread2").start();
            new Thread(singletonTest3,"thread3").start();
            new Thread(singletonTest4,"thread4").start();
            new Thread(singletonTest5,"thread5").start();
            new Thread(singletonTest6,"thread6").start();
            new Thread(singletonTest2,"thread2").start();

        }

    }
}

