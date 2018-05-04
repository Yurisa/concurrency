package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample1 {

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();
        
         final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
//            log.info("这仅仅是打印数字{}", threadNum);
            exec.execute(() -> {
                try{
                   semaphore.acquire(3); //获取一个许可
                  test(threadNum);
                  semaphore.release(3); //释放一个许可
                }catch(Exception e){
                    log.error("exception", e);
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        Thread.sleep(100);
        log.info("{}", threadNum);
        Thread.sleep(100);
    }
}
