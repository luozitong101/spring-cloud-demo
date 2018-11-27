package cn.lzt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author luoyong
 * @date 2018-11-27下午 11:04
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }
}
