package cn.com.yunweizhan.nacosclientauthtest.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.*;

/**
 * @author Weizhan▪Yun
 * @date 2022/12/28 14:57
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {
	private NamingService namingService;

	private Instance instance;

	NacosController(ObjectProvider<NamingService> namingService) {
		this.namingService = namingService.getIfAvailable();

		instance = createInstance();
	}

	private Instance createInstance() {
		Instance result = new Instance();
		result.setIp("127.0.0.1");
//		result.setServiceName();

		return result;
	}

	@PutMapping("/naming/register")
	public boolean register() {
		try {
			namingService.registerInstance("nacos-client-springboot-3.0", instance);
		}
		catch (NacosException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@DeleteMapping("/naming/unregister")
	public boolean unregister() {
		try {
			namingService.deregisterInstance("nacos-client-springboot-3.0", instance);
		}
		catch (NacosException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@GetMapping("/naming/shutdown")
	public boolean shutdown() {
		try {
			namingService.shutDown();
		}
		catch (NacosException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
