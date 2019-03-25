package pers.zhenfeng.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Grow-Worm
 * @date 2019/03/21
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture<Void> run = future.thenRun(() -> System.out.println("FutureDemo.run"));

        run.get();
    }

}
