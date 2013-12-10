package pl.jagm.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class VerboseThreadPoolExecutor extends ThreadPoolExecutor {

    public VerboseThreadPoolExecutor(int maximumPoolSize) {
        super(1, maximumPoolSize, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1));
    }
}
