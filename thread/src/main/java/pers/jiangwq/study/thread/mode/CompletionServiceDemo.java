package pers.jiangwq.study.thread.mode;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <class说明>：适用于并发执行，先完成先执行的场景
 *
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/16
 */
public class CompletionServiceDemo {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    // 创建线程池
    ExecutorService executor =
        Executors.newFixedThreadPool(3);
    // 创建CompletionService
    CompletionService<Integer> cs = new
        ExecutorCompletionService<>(executor);
    // 异步向电商S1询价
    cs.submit(()->getPriceByS1());
    // 异步向电商S2询价
    cs.submit(()->getPriceByS2());
    // 异步向电商S3询价
    cs.submit(()->getPriceByS3());
    // 将询价结果异步保存到数据库
    for (int i=0; i<3; i++) {
      Integer r = cs.take().get();
      executor.execute(()->save(r));
    }

  }

  private static void save(Integer integer) {
    System.out.println(integer);
  }

  private static int getPriceByS3() {
    return 3;
  }

  private static int getPriceByS2() {
    return 2;
  }

  private static int getPriceByS1() throws InterruptedException {
    Thread.sleep(5000);
    return 1;
  }
}
