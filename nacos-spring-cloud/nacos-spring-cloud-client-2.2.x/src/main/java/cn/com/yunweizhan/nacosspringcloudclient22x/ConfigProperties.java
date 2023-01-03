package cn.com.yunweizhan.nacosspringcloudclient22x;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;

/**
 * @author Weizhan▪Yun
 * @date 2022/12/14 16:42
 */
@ConfigurationProperties
@RefreshScope
public class ConfigProperties {
	@Value("${user.name}")
	private String userName;

	String getUserName() {
		return userName;
	}

	void setUserName(String userName) {
		this.userName = userName;
	}
}
