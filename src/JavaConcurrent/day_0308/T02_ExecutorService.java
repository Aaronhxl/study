package JavaConcurrent.day_0308;

/**
 * ExecutorService接口中有意思的是定义了以下桑额submit方法：下面的都是该接口的实现类
 *
 * <T> Future<T>
 *  submit(Callable<T> task)
 *           提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future。
 *  Future<?> submit(Runnable task)
 *           提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
 * <T> Future<T>
 *  submit(Runnable task, T result)
 *           提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
 */
public class T02_ExecutorService {
}
