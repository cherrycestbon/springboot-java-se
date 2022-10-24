package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void threadPoolExecutor() {
        //创建一个线程池对象
        /**
         * 参数信息：
         * int corePoolSize     核心线程大小
         * int maximumPoolSize  线程池最大容量大小
         * long keepAliveTime   线程空闲时，线程存活的时间
         * TimeUnit unit        时间单位
         * BlockingQueue<Runnable> workQueue  任务队列。一个阻塞队列
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10));
        //另外一种写法,与上述本质为一致：
        //ExecutorService pool = Executors.newFixedThreadPool(4);

        //执行任务
        for (int i = 0; i < 10; i++) {
            int index = i;
            pool.execute(() -> System.out.println("i:" + index + "execute!"));
        }
        //关闭线程池
        pool.shutdown();
    }

    @Test
    void threadPoolExecutor2() {
        System.out.println("0000");
    }
}
