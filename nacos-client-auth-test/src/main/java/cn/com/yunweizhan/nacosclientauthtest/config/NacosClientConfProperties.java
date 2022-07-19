package cn.com.yunweizhan.nacosclientauthtest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/28 15:19
 */
@ConfigurationProperties(prefix = "nacos")
public class NacosClientConfProperties {
	private String userName;
	private String passwd;

	private String serverAddr;

	private String namespace;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getServerAddr() {
		return serverAddr;
	}

	public void setServerAddr(String serverAddr) {
		this.serverAddr = serverAddr;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
