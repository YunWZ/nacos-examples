package cn.com.yunweizhan.nacos.client.common.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/21 09:22
 */
@Configuration
@EnableConfigurationProperties(ConfigExample1Properties.class)
public class NacosClientAutoConfiguration {
}
