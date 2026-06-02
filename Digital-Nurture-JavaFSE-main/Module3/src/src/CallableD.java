import java.util.concurrent.*;

public class CallableD {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        Callable<Integer> task1 =
                () -> 100;

        Callable<Integer> task2 =
                () -> 200;

        Callable<Integer> task3 =
                () -> 300;

        Future<Integer> f1 =
                executor.submit(task1);

        Future<Integer> f2 =
                executor.submit(task2);

        Future<Integer> f3 =
                executor.submit(task3);

        System.out.println(
                "Result 1 = " +
                        f1.get()
        );

        System.out.println(
                "Result 2 = " +
                        f2.get()
        );

        System.out.println(
                "Result 3 = " +
                        f3.get()
        );

        executor.shutdown();
    }
}