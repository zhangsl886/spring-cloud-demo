package cn.com.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.demo.service.api.RemoteClient;

@RestController
public class TestController {
    @Autowired
    private RemoteClient remoteClient;
    @Autowired
    private DiscoveryClient client;
    @RequestMapping("/testFeign")
    public String test() {
    	System.out.println("host:"+client.getLocalServiceInstance().getHost()+"   -----port:"+client.getLocalServiceInstance().getPort());
        
        return remoteClient.test();
    }
}