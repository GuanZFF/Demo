package pers.zhenfeng.base.monitor;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;

/**
 * @author Grow-Worm
 * @date 2019/12/11
 */
public class CpuMonitorDemo {

    @Test
    public void cpuTest() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        com.sun.management.OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) operatingSystemMXBean;

        System.out.println(bean.getSystemCpuLoad());

        System.out.println(bean.getProcessCpuLoad());

        System.out.println(bean.getSystemLoadAverage());

        System.out.println(bean.getTotalPhysicalMemorySize() / (1024 * 1024 * 1024));

        System.out.println(bean.getCommittedVirtualMemorySize());

        System.out.println(bean.getName());
    }


    @Test
    public void memoryTest() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println(heapMemoryUsage.toString());
    }


}
