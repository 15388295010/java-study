package pers.jiangwq.study.thread.mode;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * <class说明>： 任务模型： 并行、聚合、批量、分治
 * ForkJoin：解决分治问题
 *
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/16
 */
public class ForkJoinDemo {

  public static void main(String[] args) {
    //创建分治任务线程池
    ForkJoinPool fjp =
        new ForkJoinPool(4);
    //创建分治任务
    Fibonacci fib =
        new Fibonacci(30);
    //启动分治任务
    Integer result =
        fjp.invoke(fib);
    //输出结果
    System.out.println(result);
  }

  //递归任务
  static class Fibonacci extends
      RecursiveTask<Integer> {

    final int n;

    Fibonacci(int n) {
      this.n = n;
    }

    protected Integer compute() {
      if (n <= 1) {
        return n;
      }
      Fibonacci f1 =
          new Fibonacci(n - 1);
      //创建⼦任务
      f1.fork();
      Fibonacci f2 =
          new Fibonacci(n - 2);
      //等待⼦任务结果，并合并结果
      return f2.compute() + f1.join();
    }
  }
}
