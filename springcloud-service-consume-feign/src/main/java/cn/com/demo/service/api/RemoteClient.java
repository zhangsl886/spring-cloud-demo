package cn.com.demo.service.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-provider2")
public interface RemoteClient {
    @RequestMapping(method = RequestMethod.GET, value = "/testFeign")
    String test();
}