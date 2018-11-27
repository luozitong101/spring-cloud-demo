package cn.lzt.web;

import cn.lzt.web.base.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoyong
 * @date 2018-11-27下午 11:27
 */
@RestController
public class HystrixController {


    @Autowired
    HystrixService service;

    @RequestMapping(value = "/hystrix")
    public String compute(@RequestParam Integer a,@RequestParam Integer b){

        return service.computeNum(a,b);
    }

}
