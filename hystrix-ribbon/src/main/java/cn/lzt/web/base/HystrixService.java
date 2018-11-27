package cn.lzt.web.base;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @author luoyong
 * @date 2018-11-27下午 11:28
 */
@Service
public class HystrixService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixService.class);
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String computeNum(@RequestParam Integer a,@RequestParam Integer b){

       return restTemplate.getForObject("http://service-B/add?a="+a+"&b="+b,String.class);
    }

    public String error(@RequestParam Integer a,@RequestParam Integer b){
        LOGGER.info("异常发生进入fallback 方法");
        return "出错了,服务被降级,服务快速失败";
    }
}
