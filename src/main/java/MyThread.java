public class MyThread extends Thread implements Runnable {
    final int INTERVAL = 2500;

    @Override
    public void run() {
        try {
            while (! isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " Привет из потока! ");
                Thread.sleep(INTERVAL);
            }
        } catch (InterruptedException err){
            return;
        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
    }
}
