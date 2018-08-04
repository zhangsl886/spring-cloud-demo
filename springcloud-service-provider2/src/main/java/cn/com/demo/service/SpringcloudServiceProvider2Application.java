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
public class SpringcloudServiceProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceProvider2Application.class, args);
	}
	
	@Autowired
    private EurekaClient client;
	
	@RequestMapping("/info")
    public String test() {
        return "test";
    }

    @RequestMapping("/testFeign")
    public String testClient() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("service-provider2", false);
        return instanceInfo.getHomePageUrl();
    }
}
