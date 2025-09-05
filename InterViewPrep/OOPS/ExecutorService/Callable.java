import java.util.*;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        // Step 1: Create a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Step 2: Define Callable tasks (simulate API calls)
        Callable<String> api1 = () -> {
            Thread.sleep(2000); // simulate network delay
            return "API-1 Response";
        };

        Callable<String> api2 = () -> {
            Thread.sleep(3000);
            return "API-2 Response";
        };

        Callable<String> api3 = () -> {
            Thread.sleep(1000);
            return "API-3 Response";
        };

        // Step 3: Submit tasks and get Futures
        List<Future<String>> futures = new ArrayList<>();
        futures.add(executor.submit(api1));
        futures.add(executor.submit(api2));
        futures.add(executor.submit(api3));

        // Step 4: Collect results
        System.out.println("Fetching data from APIs in parallel...");

        for (Future<String> future : futures) {
            try {
                // .get() waits until result is available
                String result = future.get();
                System.out.println("Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Step 5: Shutdown executor
        executor.shutdown();
    }
}

