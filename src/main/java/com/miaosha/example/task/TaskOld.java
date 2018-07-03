package com.miaosha.example.task;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TaskOld {
    public static Random random =new Random();
    public  void  taskOne() throws InterruptedException {
        System.out.println("开始任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");

    }
    public  void  taskTow() throws InterruptedException {
        System.out.println("开始任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }
    public  void  taskThree() throws InterruptedException {
        System.out.println("开始任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");

    }


}
