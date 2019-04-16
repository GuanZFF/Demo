package pers.zhenfeng.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author Grow-Worm
 * @date 2019/04/15
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CountTask countTask = new CountTask(1, 100);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(countTask);
        Integer integer = submit.get();
        System.out.println(integer);
    }

    static class CountTask extends RecursiveTask<Integer> {

        private static final int COUNT_NUMBER = 3;

        private Integer sum = 0;

        private Integer start;

        private Integer end;

        public CountTask(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            if (end - start <= COUNT_NUMBER) {
                for (int i = start; i <= end; i++) {
                    sum = i + sum;
                }
            } else {
                Integer middle = (start + end) / 2;

                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle + 1, end);

                leftTask.fork();
                rightTask.fork();

                Integer leftValue = leftTask.join();
                Integer rightValue = rightTask.join();
                sum = leftValue + rightValue;
            }

            return sum;
        }

    }

}
