package com.hyb.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

public class test {

    @Test
    public void test1() throws Exception{
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        for (Robot robot : serviceLoader) {
            robot.sayHello();
        }
    }

    @Test
    public void sayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
