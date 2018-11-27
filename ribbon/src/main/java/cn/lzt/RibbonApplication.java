package cn.lzt;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author luoyong
 * @date 2018-11-27下午 9:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonApplication {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 配置负载均衡策略 和配置文件对应
     * @return
     */
    @Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonApplication.class).web(true).run(args);
    }

}


