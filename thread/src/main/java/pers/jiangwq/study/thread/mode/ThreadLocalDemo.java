package pers.jiangwq.study.thread.mode;

/**
 * <class说明>：线程本地化。没有共享，就没有伤害
 * ThreadLocal并没有存储数据，而是保存再Thread中，这样可以防止内存泄漏，设计上也更容易理解
 * 使用时注意ThreadLocal存在内存泄漏(ThreadLocal是弱引用，但是value依然是强引用)，需要手动执行.remove方法
 * ThreadLocal无法在其子线程中继承，可以使用InheritableThreadLocal作为替代方案
 * InheritableThreadLocal在线程池中使用依然会存在问题，TransmittableThreadLocal可以解决该问题
 * @author jiangwq
 * @version 1.0.0
 * @date 2021/3/17
 */
public class ThreadLocalDemo {

}
