package cn.com.yunweizhan.authplugin.client;

import java.util.Properties;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.plugin.auth.api.LoginIdentityContext;
import com.alibaba.nacos.plugin.auth.api.RequestResource;
import com.alibaba.nacos.plugin.auth.spi.client.AbstractClientAuthService;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/19 23:23
 */
public class MyClientAuthPlugin extends AbstractClientAuthService {
	/**
	 * login(request) to service and get response.
	 *
	 * @param properties login auth information.
	 * @return boolean whether login success.
	 */
	@Override
	public Boolean login(Properties properties) {

		return true;
	}

	/**
	 * get login identity context.
	 *
	 * @param resource resource for this request, some of plugin implementation will use this resource to generate their
	 *                 identity context. If no need to use can ignore it.
	 * @return LoginIdentityContext this plugin loginIdentityContext.
	 */
	@Override
	public LoginIdentityContext getLoginIdentityContext(RequestResource resource) {
		LoginIdentityContext loginIdentityContext = new LoginIdentityContext();
		loginIdentityContext.setParameter("my-username", "ywz-read1");
		loginIdentityContext.setParameter("my-passwd", "read1123");
		return loginIdentityContext;
	}

	@Override
	public void shutdown() throws NacosException {

	}
}
