package cn.lzt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luoyong
 * @date 2018-11-28上午 9:27
 */
@EnableDiscoveryClient
@SpringBootApplication
public class A_application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(A_application.class).web(true).run(args);
    }
}
