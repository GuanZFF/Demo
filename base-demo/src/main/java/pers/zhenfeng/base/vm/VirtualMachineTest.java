package pers.zhenfeng.base.vm;

import com.sun.tools.attach.VirtualMachine;
import sun.tools.attach.HotSpotVirtualMachine;

import java.lang.management.ManagementFactory;

/**
 * @author Grow-Worm
 * @date 2020/06/19
 */
public class VirtualMachineTest {

    public static void main(String[] args) throws Exception {

        System.out.println(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax());

        HotSpotVirtualMachine hotSpotVirtualMachine = (HotSpotVirtualMachine) VirtualMachine.attach(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);


        System.out.println(hotSpotVirtualMachine.executeJCmd("GC.run"));
    }

}
