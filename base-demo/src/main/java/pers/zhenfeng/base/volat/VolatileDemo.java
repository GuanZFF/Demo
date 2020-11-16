package pers.zhenfeng.base.volat;

import com.sun.tools.attach.VirtualMachine;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author Grow-Worm
 * @date 2019/12/12
 */
public class VolatileDemo {

    private String t = "guanzhenfeng";

    public static void main(String[] args) throws Exception {

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();


        HotSpotVirtualMachine vm = (HotSpotVirtualMachine) VirtualMachine.attach(runtimeMXBean.getName().split("@")[0]);

        InputStream inputStream = vm.executeJCmd("GC.run");

    }

}
