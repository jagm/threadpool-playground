package pl.jagm.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class VerboseThreadPoolExecutor extends ThreadPoolExecutor {

    public VerboseThreadPoolExecutor(int maximumPoolSize, int queueSize) {
        super(maximumPoolSize, maximumPoolSize, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(queueSize));
    }

    @Override
    public void execute(final Runnable command) {
        logMetrics("In execute - before");
        super.execute(new Runnable() {
            @Override
            public void run() {
                logMetrics("In Runnable - before");
                command.run();
                logMetrics("In Runnable - after");
            }
        });
        logMetrics("In execute - after");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        logMetrics("After execute");
        super.afterExecute(r, t);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        logMetrics("Before execute");
        super.beforeExecute(t, r);
    }

    public void logMetrics(String name) {
        System.out.println(
                String.format("[%s] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                        name,
                        getPoolSize(),
                        getCorePoolSize(),
                        getActiveCount(),
                        getCompletedTaskCount(),
                        getTaskCount(),
                        isShutdown(),
                        isTerminated()));
    }


}
