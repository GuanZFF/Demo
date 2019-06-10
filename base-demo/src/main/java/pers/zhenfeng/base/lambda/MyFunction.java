package pers.zhenfeng.base.lambda;

/**
 * @author Grow-Worm
 * @date 2019/05/16
 */
@FunctionalInterface
public interface MyFunction<T, R> {

    R run(T t);

    default R printRun(T t, MyFunction<T, R> function) {

        System.out.println(t);

        return function.run(t);
    }

}
