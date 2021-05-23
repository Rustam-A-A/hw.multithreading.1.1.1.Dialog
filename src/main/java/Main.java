public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int THREAD_NUMBER = 4;
        final int TIME_TO_SLEEP = 15000;

        Runnable myRunnable = new MyThread();
        ThreadGroup threadGroup = new ThreadGroup("main group");

        for (int i = 0; i < THREAD_NUMBER; i++){
            final Thread thread = new Thread(threadGroup, myRunnable);
            thread.setName("thread #" + i);
            thread.start();
        }

        Thread.sleep(TIME_TO_SLEEP);
        threadGroup.interrupt();
    }
}
