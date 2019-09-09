package pers.zhenfeng.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author Grow-Worm
 * @date 2019/09/04
 */
public class BloomFilterDemo {

    public static void main(String[] args) {
        BloomFilter<byte[]> bloomFilter = BloomFilter.create(Funnels.byteArrayFunnel(), 2);
        bloomFilter.put("1234".getBytes());

        bloomFilter.put("3213".getBytes());

        System.out.println(bloomFilter.test("123".getBytes()));
    }

}
