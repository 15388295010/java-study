package pers.jiangwq.study.thread.lock;

import java.util.concurrent.Semaphore;

/**
 * <class说明>：信号量实现限流器
 * 为何还需要Semaphore？可以允许多个线程访问一个临界区。
 *
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/8
 */
public class SemaphoreDemo {
  static int count;
  // 初始化信号量
  static final Semaphore s
      = new Semaphore(1);
  // 用信号量保证互斥
  static void addOne() throws InterruptedException {
    s.acquire();
    try {
      count+=1;
    } finally {
      s.release();
    }
  }

}
