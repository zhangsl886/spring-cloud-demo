package cn.com.demo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringcloudZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZuulServerApplication.class, args);
	}
}
