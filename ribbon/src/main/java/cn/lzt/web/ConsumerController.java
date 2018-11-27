package cn.lzt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author luoyong
 * @date 2018-11-27下午 9:45
 */

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(@RequestParam Integer a,@RequestParam Integer b){
        //随机访问策略
        loadBalancerClient.choose("service-B");
        return restTemplate.getForEntity("http://service-B/add?a="+a+"&b="+b,String.class).getBody();
    }

}
