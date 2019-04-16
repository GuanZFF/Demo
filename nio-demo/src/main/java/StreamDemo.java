import java.util.stream.Stream;

/**
 * @author Grow-Worm
 * @date 2019/04/13
 */
public class StreamDemo {

    public static void main(String[] args) {

        int count = 0;

        long time = 0;

        System.out.println("CPU核心数：" + Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();

            Stream.of(1, 2, 3, 4).parallel().map(item -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return item;
            }).reduce(Integer::sum).orElse(0);

            long endTime = System.currentTimeMillis();

            count++;
            time = time + endTime - startTime;

            System.out.println("第" + count + "次 耗时：" + (endTime - startTime));
        }

        System.out.println("平均耗时：" + time / count);

    }

}
