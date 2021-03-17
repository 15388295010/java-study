package pers.jiangwq.study.thread.mode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <class说明>：
 * 适用场景：多个线程同步处理任务，并且存在依赖关系
 *
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/15
 */
public class FutureDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Callable callable = new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        return null;
      }
    };
    FutureTask ft = new FutureTask(callable);
    new Thread(ft).start();
    Object result = ft.get();
  }

}
