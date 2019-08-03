package ink.cyz.learn.multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 计算密集型线程池测试
 */
public class ComputingIntensiveTest {
    final static ThreadPoolExecutor computeExecutor ;
    final static List<Callable<Long>> computeTasks;
    final static int task_count = 5000;
    static {
        computeExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        computeTasks = new ArrayList<>(task_count);
        for (int i = 0; i < task_count; i++) {
            computeTasks.add(new ComputeTask());
        }
    }

    static class ComputeTask implements java.util.concurrent.Callable<Long> {

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = 0; i < 50_0000; i++) {
                sum+= i;
            }
            return sum;
        }
    }

    private static void testExecutor(ExecutorService executorService,
                                     List<Callable<Object>> tasks) throws InterruptedException {
        long start = System.currentTimeMillis();
        executorService.invokeAll(tasks);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) throws InterruptedException {
        int processorsCount = Runtime.getRuntime().availableProcessors();
        System.out.println(processorsCount);
        computeExecutor.invokeAll(computeTasks);
    }

}
