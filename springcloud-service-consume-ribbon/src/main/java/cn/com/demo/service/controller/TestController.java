package cn.com.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient client;
    
    @HystrixCommand(fallbackMethod = "helloError")
    @RequestMapping("/test")
    public String test() {
    	System.out.println("host:"+client.getLocalServiceInstance().getHost()+"   -----port:"+client.getLocalServiceInstance().getPort());
        return restTemplate.getForEntity("http://service-provider/test", String.class).getBody();
    }
    
    public String helloError(){
        return "hello error~";
    }
}
