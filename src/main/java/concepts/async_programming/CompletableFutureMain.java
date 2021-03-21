package concepts.async_programming;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a
 * means of writing non-blocking code by running a task on a separate thread
 * than the main application thread and notifying the main thread about its progress,
 * completion or failure.
 * <p>
 * This way, your main thread does not block/wait for the completion of
 * the task and it can execute other tasks in parallel.
 * <p>
 * Having this kind of parallelism greatly improves the performance of your programs.
 */
@Slf4j
public class CompletableFutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureMain completableFutureMain = new CompletableFutureMain();

        completableFutureMain.manualComplete();
        completableFutureMain.voidAsyncRun();
        completableFutureMain.stringAsyncRun();

    }

    /**
     * manually completing future task
     */
    private void manualComplete() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Future's Result");
        try {
            //this will run forever if "complete" method is not called above
            String result = completableFuture.get();
            log.info("result: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * If you want to run some background task asynchronously and don’t want to return anything from the task,
     * then you can use CompletableFuture.runAsync() method.
     * It takes a Runnable object and returns CompletableFuture<Void>.
     */
    private void voidAsyncRun() throws ExecutionException, InterruptedException {
        //useful when dont need to return anything
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("long running async process in new thread that returns nothing");
        });
        // Block and wait for the future to complete
        completableFuture.get();
        log.info("execution completed.");
    }

    private void stringAsyncRun() throws ExecutionException, InterruptedException {
        CompletableFuture<String> myName = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Gagan Mani";
        })
                .thenApply(name -> name + ", you are awesome !")
                .thenApplyAsync(greeting -> greeting + ", welcome to Seattle !");
        //Gagan Mani, you are awesome !, welcome to Seattle !

        // Block and get the result of the Future
        String result = myName.get();
        log.info("result: " + result);
    }
}
