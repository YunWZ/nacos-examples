package cn.com.yunweizhan.nacos.client.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosSpringCloudClientCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosSpringCloudClientCommonApplication.class, args);
	}

}
