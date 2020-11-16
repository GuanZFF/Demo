package pers.zhenfeng.base.instrucmentation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.security.ProtectionDomain;

/**
 * @author Grow-Worm
 * @date 2020/06/19
 */
public class MyAgent {


    public static void premain(Instrumentation instrumentation, String[] args) {
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {


                return new byte[0];
            }
        });
    }


    public static void agentmain(Instrumentation instrumentation, String[] args) {
        Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
        for (Class allLoadedClass : allLoadedClasses) {

        }

        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        classLoadingMXBean.getLoadedClassCount();
    }

}
