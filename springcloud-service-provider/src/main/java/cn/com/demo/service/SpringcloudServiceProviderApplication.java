package cn.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringcloudServiceProviderApplication {

	@Autowired
    private EurekaClient client;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceProviderApplication.class, args);
	}
	
	@RequestMapping("/info")
    public String test() {
        return "test";
    }

    @RequestMapping("/test")
    public String testClient() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("service-provider", false);
        return instanceInfo.getHomePageUrl();
    }
}
