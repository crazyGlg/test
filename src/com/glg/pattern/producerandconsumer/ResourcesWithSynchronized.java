package com.glg.pattern.producerandconsumer;

import java.util.concurrent.TimeUnit;

/*
 * 使用Synchronized和wait、notify实现生产者消费者模式
 *
 * */
public class ResourcesWithSynchronized {

    //共享资源：生产和消费数字
    int num = 0;

    //资源池中实际存储的数据个数
    private int count = 0;

    //资源池中允许存放的资源数目
    private int capacity = 5;

    //作为锁
    Object lock = new Object();


    public void product() throws InterruptedException {
        //使用代码块，精确加锁，且synchronized会自动释放锁
        synchronized (lock) {
            //1.判断什么时候等待
            if (count == capacity) {//当实际元素数量达到总容量时，生产阻塞等待
                lock.wait();
            }
            //2.干活
            num++;
            count++;
            System.out.println(Thread.currentThread().getName() +
                    "生产了一个数字" + num + "，资源池剩余数据个数：" + count);

            //3.干完后后通知唤醒  消费者来消费
            lock.notifyAll();//唤醒其他所有线程，让他们竞争锁
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            if (count == 0) {
                lock.wait();
            }
            num--;
            count--;
            System.out.println(Thread.currentThread().getName() +
                    "消费了一个数字" + num + "，资源池剩余数据个数：" + count);

            //3.干完后后通知唤醒  生产者
            lock.notifyAll();//唤醒其他所有线程，让他们竞争锁
        }
    }

    public static void main(String[] args) {
        ResourcesWithSynchronized resources = new ResourcesWithSynchronized();
        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    resources.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者").start();

        //消费者
        new Thread(() -> {
            //让生产者先 生产数据
            for (int i = 1; i <= 10; i++) {//消费10轮，
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    resources.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者1").start();

        new Thread(() -> {
            //让生产者先 生产数据
            for (int i = 1; i <= 10; i++) {//消费10轮，
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    resources.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者2").start();
    }
}
