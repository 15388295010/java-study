package pers.jiangwq.study.thread.waitnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <class说明>：利用Lock,condition实现生产者消费者
 *
 * Lock相较于关键字synchronize的优势
 // 支持中断的 API
 void lockInterruptibly() throws InterruptedException;
 // 支持超时的 API
 boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
 // 支持非阻塞获取锁的 API
 boolean tryLock();

 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/3
 */
public class LockAndCondition {
  public static int resource = 0;

  public static final Lock lock = new ReentrantLock(true);

  public static Condition noResource = lock.newCondition();

  public static Condition hasResource = lock.newCondition();

  public static class Producer implements Runnable {

    public void run() {
      try{
        lock.lock();
        while (resource > 0) {
          try {
            noResource.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        // 生产数据
        resource ++;
        hasResource.signalAll();
        System.out.println("生产：" + resource);
      }finally {
        lock.unlock();
      }
    }
  }

  public static class Consumer implements Runnable{

    public void run() {
      try{
        lock.lock();
        while (resource == 0) {
          try {
            hasResource.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        // 消费数据
        resource --;
        noResource.signalAll();
        System.out.println("消费：" + resource);
      }finally {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) {
    for (int x = 0; x< 100;x++) {
      new Thread(new Producer()).start();
    }
    for (int x = 0; x< 100;x++) {
      new Thread(new Consumer()).start();
    }
  }

}
