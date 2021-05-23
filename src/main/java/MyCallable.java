import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer>, Runnable {

    final int SIZE = 6;
    static Integer count = 0;

    @Override
    public void run(){
    }

    @Override
    public Integer call() throws Exception {
        final int INTERVAL = 2500;

        try {
            for (int i = 0; i < SIZE; i++) {
                System.out.println(Thread.currentThread().getName() + " Привет из потока! ");
                count++;
                Thread.sleep(INTERVAL);
            }
        } catch (InterruptedException err){
            err.printStackTrace();
        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        System.out.println("Всего сообщений " + count);
        return count;
    }
}
