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
        while (printCount % 4 != no && printCount > 0) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (printCount > 0) {
          System.out.println(no + ":" + printCount);
          printCount--;
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
