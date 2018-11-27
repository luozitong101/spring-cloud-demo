package cn.lzt.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luoyong
 * @date 2018-11-27下午 10:07
 */
@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/**",method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b, HttpServletRequest request){
        System.out.println(request.getRequestURL());
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add,host:"+serviceInstance.getHost()+",service_id:"+serviceInstance.getServiceId()+",result:"+r);

        return "From service-B,Result is "+r+"\nPort:"+serviceInstance.getPort()+",instance:service-B2";
    }
}
