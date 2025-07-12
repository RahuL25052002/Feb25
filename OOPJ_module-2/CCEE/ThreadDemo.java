class MyThread extends Thread {

    public void run() {
        try {
            // Print current thread info
            System.out.println("🔹 Running thread: " + Thread.currentThread().getName());
            
            // Yielding for other threads of same priority
            Thread.yield();

            // Sleeping for demonstration
            System.out.println("🔹 " + getName() + " is going to sleep...");
            Thread.sleep(1000);

            // Print alive status and state
            System.out.println("🔹 Is Alive: " + isAlive());
            System.out.println("🔹 State: " + getState());

        } catch (InterruptedException e) {
            System.out.println("🔹 Thread " + getName() + " interrupted.");
        }
    }
}

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("🔸 Current thread: " + Thread.currentThread().getName());

        // Create thread objects
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Set names
        t1.setName("Worker-1");
        t2.setName("Daemon-Worker");

        // Set priorities
        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.MIN_PRIORITY); // 1

        // Set daemon (must be before start())
        t2.setDaemon(true);

        // Check isDaemon()
        System.out.println("🔸 " + t1.getName() + " isDaemon: " + t1.isDaemon());
        System.out.println("🔸 " + t2.getName() + " isDaemon: " + t2.isDaemon());

        // Start threads
        t1.start();
        t2.start();

        // Wait for t1 to finish using join()
        t1.join();

        // After t1 completes
        System.out.println("🔸 " + t1.getName() + " has finished. Alive? " + t1.isAlive());

        // Show current thread state
        System.out.println("🔸 " + t1.getName() + " state: " + t1.getState());
        System.out.println("🔸 " + t2.getName() + " state: " + t2.getState());

        // Main thread sleep for clarity
        Thread.sleep(2000);

        // Print final states
        System.out.println("✅ Main thread: " + Thread.currentThread().getName() + " finished.");
    }
}

