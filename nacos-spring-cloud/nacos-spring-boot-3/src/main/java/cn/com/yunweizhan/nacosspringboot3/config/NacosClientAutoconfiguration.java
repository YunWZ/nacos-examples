package cn.com.yunweizhan.nacosspringboot3.config;

import java.util.Properties;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/28 15:18
 */
@AutoConfiguration
@EnableConfigurationProperties(NacosClientConfProperties.class)
public class NacosClientAutoconfiguration implements EnvironmentAware {

	private Environment env;

	@Bean
	public ConfigService nacosConfigService(NacosClientConfProperties properties) throws NacosException {
		return NacosFactory.createConfigService(createProperties(properties));
	}

	@Bean
	public NamingService nacosNamingService(NacosClientConfProperties properties) throws NacosException {
		return NacosFactory.createNamingService(createProperties(properties));
	}

	private Properties createProperties(NacosClientConfProperties properties) {
		Properties res = new Properties();
		res.put(PropertyKeyConst.USERNAME, properties.getUserName());
		res.put(PropertyKeyConst.PASSWORD, properties.getPasswd());
		res.put(PropertyKeyConst.SERVER_ADDR, properties.getServerAddr());
//		res.put(GrpcConstants.GRPC_CHANNEL_KEEP_ALIVE_TIMEOUT, env.getProperty(GrpcConstants.GRPC_CHANNEL_KEEP_ALIVE_TIMEOUT, Long.class));
//		res.put(GrpcConstants.GRPC_CHANNEL_KEEP_ALIVE_TIME, env.getProperty(GrpcConstants.GRPC_CHANNEL_KEEP_ALIVE_TIME, Long.class));
//		res.put(PropertyKeyConst.NAMESPACE, properties.getNamespace());

		return res;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}
}
