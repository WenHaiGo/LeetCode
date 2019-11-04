import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: wwh
 * @Date: 2019/10/4 19:52
 * @Description:
 */

public class Test {
    // 请求总数
    public static int clientTotal = 50000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        //java中有四种线程池的用法
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量是控制并发的个数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    //获取执行的许可   如果没有就等待
                    semaphore.acquire();

                    //释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                }
                countDownLatch.countDown();
            });

            System.out.println("------"+count);
        }
        countDownLatch.await();
        executorService.shutdown();

        System.out.println(count);
    }

    private static  void add() {
        count++;
    }
}