package pers.zhenfeng.dubbo.util;

import com.alibaba.dubbo.rpc.cluster.Merger;

/**
 * @author Grow-Worm
 * @date 2019/03/12
 */
public class StringMerger implements Merger<String> {

    @Override
    public String merge(String... items) {
        StringBuilder result = new StringBuilder();
        for (String item : items) {
            result.append(item).append(" - ");
        }
        return result.toString();
    }

}
