package cn.lzt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luoyong
 * @date 2018-11-27下午 10:41
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceBApplication.class).web(true).run(args);
    }
}
