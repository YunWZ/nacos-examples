package cn.com.yunweizhan.nacosclientauthtest.config;

import java.util.Properties;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/28 15:18
 */
@AutoConfiguration
@EnableConfigurationProperties(NacosClientConfProperties.class)
public class NacosClientAutoconfiguration {

	@Bean
	public ConfigService nacosNamingService(NacosClientConfProperties properties) throws NacosException {
		return NacosFactory.createConfigService(createProperties(properties));
	}

	private Properties createProperties(NacosClientConfProperties properties) {
		Properties res = new Properties();
		res.put(PropertyKeyConst.USERNAME, properties.getUserName());
		res.put(PropertyKeyConst.PASSWORD, properties.getPasswd());
		res.put(PropertyKeyConst.SERVER_ADDR, properties.getServerAddr());
		res.put(PropertyKeyConst.NAMESPACE, properties.getNamespace());

		return res;
	}
}
