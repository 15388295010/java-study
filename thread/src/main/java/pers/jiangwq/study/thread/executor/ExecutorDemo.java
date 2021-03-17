package pers.jiangwq.study.thread.executor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <class说明>：
 *
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/15
 */
public class ExecutorDemo {

  public static void main(String[] args) {
    /**
    corePoolSize：表示线程池保有的最小线程数。有些项目很闲，但是也不能把人都撤了，至少要留
    corePoolSize个人坚守阵地。
    maximumPoolSize：表示线程池创建的最大线程数。当项目很忙时，就需要加人，但是也不能无限制地
    加，最多就加到maximumPoolSize个人。当项目闲下来时，就要撤人了，最多能撤到corePoolSize个人。
    keepAliveTime	&	unit：上面提到项目根据忙闲来增减人员，那在编程世界里，如何定义忙和闲呢？很简
    单，一个线程如果在一段时间内，都没有执行任务，说明很闲，keepAliveTime	和	unit	就是用来定义这
    个“一段时间”的参数。也就是说，如果一个线程空闲了keepAliveTime	&	unit这么久，而且线程池
    的线程数大于	corePoolSize	，那么这个空闲的线程就要被回收了。
    workQueue：工作队列，和上面示例代码的工作队列同义。
    threadFactory：通过这个参数你可以自定义如何创建线程，例如你可以给线程指定一个有意义的名字。
    handler：通过这个参数你可以自定义任务的拒绝策略。如果线程池中所有的线程都在忙碌，并且工作队
    列也满了（前提是工作队列是有界队列），那么此时提交任务，线程池就会拒绝接收。至于拒绝的策略，
    你可以通过handler这个参数来指定。ThreadPoolExecutor已经提供了以下4种策略。
    CallerRunsPolicy：提交任务的线程自己去执行该任务。
    AbortPolicy：默认的拒绝策略，会throws	RejectedExecutionException。
    DiscardPolicy：直接丢弃任务，没有任何异常抛出。
    DiscardOldestPolicy：丢弃最老的任务，其实就是把最早进入工作队列的任务丢弃，然后把新任务加入
    到工作队列。
     */
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.HOURS,
        new LinkedBlockingQueue<>(10), (ThreadFactory) runnable -> null,
        new ThreadPoolExecutor.CallerRunsPolicy());
  }

}
