package cn.com.yunweizhan.nacos.client.common.config;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/21 09:22
 */
@Configuration
@EnableConfigurationProperties(ConfigExample1Properties.class)
public class NacosClientAutoConfiguration {

	public static final ScheduledThreadPoolExecutor EXECUTOR = new ScheduledThreadPoolExecutor(1,
			r -> new Thread(r, "globel-thread"));

}
