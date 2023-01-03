package cn.com.yunweizhan.nacosclientauthtest.controller;

import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Weizhan▪Yun
 * @date 2022/12/25 14:15
 */
@RestController
@RequestMapping("/hello")
public class HiController {
	private ConfigService configService;

	HiController(ObjectProvider<ConfigService> configService) {
		this.configService = configService.getIfAvailable();
	}

	@GetMapping("/config")
	public String config() throws NacosException {
		String config = configService.getConfig("config-example-1", "DEFAULT_GROUP", 10000L);
		return config;
	}

}
