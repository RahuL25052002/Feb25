import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // Create a fixed thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit a Callable task returning an Integer result
        Future<Integer> future = executor.submit(() -> {
            // Simulate some computation or delay
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task interrupted");
                return null;
            }
            return 42;
        });

        // Retrieve and print the result from the Future
        try {
            Integer result = future.get();  // This blocks until the computation is done
            System.out.println("Future result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Properly shut down the executor service
        executor.shutdown();
    }

}

