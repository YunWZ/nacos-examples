package cn.com.yunweizhan.nacos.client.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/21 09:19
 */
@ConfigurationProperties(prefix = "example1")
public class ConfigExample1Properties {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static class User {
		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
