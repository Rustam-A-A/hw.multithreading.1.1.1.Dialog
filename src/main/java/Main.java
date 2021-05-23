import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final int THREAD_NUMBER = 4;
        int coreCount = Runtime.getRuntime().availableProcessors();
        final ExecutorService threadPool = Executors.newFixedThreadPool(coreCount);

        List <Callable<Integer>> callables = new ArrayList<>();

        for (int i = 0; i < THREAD_NUMBER; i++){
            final Callable<Integer> myCallable =new MyCallable();
            callables.add(myCallable);
        }

        System.out.println("\n Метод invokeAll()");
        List<Future<Integer>> resultAll = threadPool.invokeAll(callables);

        System.out.println("\n Метод invokeAny()");
        Integer resultAny = threadPool.invokeAny(callables);

        threadPool.shutdown();
    }
}
