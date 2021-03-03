package pers.jiangwq.study.thread.waitnotify;

/**
 * <class说明>：实现三个线程依次循环打印1000 - 1
 * synchronized版本
 *
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/2/26
 */
public class Demo1 implements Runnable{

  //保证是同一把锁
  private final static Object lock = new Object();

  private static int printCount = 1000;

  // 线程编号
  private int no;

  public Demo1(int no){
    this.no = no;
  }

  public void run() {
    while (printCount > 0) {
      synchronized (lock) {
        // 这个while可以保证被唤醒的线程
        while (printCount % 4 != no && printCount > 0) {
          try {
            // wait可以让线程在此等待并释放锁
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (printCount > 0) {
          System.out.println(no + ":" + printCount);
          printCount--;
          // 处理完成唤醒等待中的线程, 不是百分之百确定请不要用notify方法，只会唤醒一个线程
          lock.notifyAll();
        }
      }
    }
    System.out.println("end");
  }

  public static void main(String[] args) {
    for (int x = 0; x<4;x++) {
      Thread t = new Thread(new Demo1(x));
      t.start();
    }
  }

}
