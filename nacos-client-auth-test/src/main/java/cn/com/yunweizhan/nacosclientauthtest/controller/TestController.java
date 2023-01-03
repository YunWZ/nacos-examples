package cn.com.yunweizhan.nacosclientauthtest.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/28 16:04
 */
@RestController
@RequestMapping("/test")
public class TestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	private volatile boolean shutdown = false;
	//	private static final int THREAD_NUMS = Runtime.getRuntime().availableProcessors() - 2;
	private static final int THREAD_NUMS = 1;
	private ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMS);

	@Autowired
	private ConfigService configService;

	@GetMapping("/start")
	public void startTest() throws NacosException {
		shutdown = false;
		String config = configService.getConfig("config-example-1", "DEFAULT_GROUP", 10000L);
		if (StringUtils.hasText(config)) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("获取配置为:{}", config);
			}
		}
		else {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("获取不到配置");
			}
		}
/*		for (int i = 0; i < THREAD_NUMS; i++) {
			executor.submit(() -> {
				try {
					while (!shutdown) {
						String config = configService.getConfig("config-example-1", "DEFAULT_GROUP", 10000L);
						if (StringUtils.hasText(config)) {
							if (LOGGER.isInfoEnabled()) {
								LOGGER.info("获取配置为:{}", config);
							}
						}
						else {
							if (LOGGER.isErrorEnabled()) {
								LOGGER.error("获取不到配置");
							}
							break;
						}
					}
				}
				catch (NacosException e) {
					LOGGER.error("请求服务端失败", e);
				}
			});
		}*/
	}

	@GetMapping("/stop")
	public void stopTest() {
		shutdown = true;
	}
}
