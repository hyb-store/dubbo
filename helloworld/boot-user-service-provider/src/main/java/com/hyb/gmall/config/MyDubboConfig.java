package com.hyb.gmall.config;

import com.hyb.gmall.service.UserService;
import org.apache.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class MyDubboConfig {

    //1、指定当前服务/应用的名字（同样的服务名字相同，不要和别的服务同名）
    //<dubbo:application name="user-service-provider"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig () {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    //2、指定注册中心的位置
    // <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig () {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    //3、指定通信规则（通信协议？通信端口）用dubbo协议在20880端口暴露服务
    // <dubbo:protocol name="dubbo" port="20882"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig () {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20882);
        return protocolConfig;
    }

    //  <!-- 4、暴露服务 ref：指向服务的真正的实现对象 -->
   // <dubbo:service interface="com.hyb.gmall.service.UserService" ref="userServiceImpl" timeout="1000" version="0.0.0">
   //     <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>
   // </dubbo:service>
    @Bean
    public ServiceConfig<UserService> serviceConfig (UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        //userServiceServiceConfig.setInterface("com.hyb.gmall.service.UserService");
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("0.0.0");
        serviceConfig.setTimeout(1000);

        //配置每一个method信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        //将method配置关联到service配置中
        ArrayList<MethodConfig> methodConfigs = new ArrayList<>();
        serviceConfig.setMethods(methodConfigs);
        return serviceConfig;
    }

}
