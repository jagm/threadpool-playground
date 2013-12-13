package pl.jagm.threadpool;


public class App {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        VerboseThreadPoolExecutor pool = new VerboseThreadPoolExecutor(3, 10);
        pool.logMetrics("App start");

        for (int i = 0; i < 5; ++i) {
            System.out.println("Adding thread #" + i);
            pool.execute(new MyThread(i));
        }

        pool.logMetrics("App stop");
        pool.shutdown();
    }

}
