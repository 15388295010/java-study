package pers.jiangwq.study.thread.lock;

/**
 * <class说明>：CyclicBarrier 适用于循环执行同一件事情，且那件事情里的步骤也是异步执行的，并且还具有依赖关系
 * CountDownLatch不能重置数量，不适合这种循环的场景
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/11
 */
public class CyclicBarrierDemo {
/* 伪代码
  // 订单队列
  Vector<P> pos;
  // 派送单队列
  Vector<D> dos;
  // 执⾏回调的线程池
  Executor executor =
      Executors.newFixedThreadPool(1);
  final CyclicBarrier barrier =
      new CyclicBarrier(2, ()->{
        executor.execute(()->check());
      });
  void check(){
    P p = pos.remove(0);
    D d = dos.remove(0);
// 执⾏对账操作
    diff = check(p, d);
// 差异写⼊差异库
    save(diff);
  }
  void checkAll(){
// 循环查询订单库
    Thread T1 = new Thread(()->{
      while(存在未对账订单){
// 查询订单库
        pos.add(getPOrders());
// 等待
        barrier.await();
      }
    }
        T1.start();
// 循环查询运单库
    Thread T2 = new Thread(()->{
      while(存在未对账订单){
// 查询运单库
        dos.add(getDOrders());
// 等待
        barrier.await();
      }
    }
        T2.start();
  }
*/

}
