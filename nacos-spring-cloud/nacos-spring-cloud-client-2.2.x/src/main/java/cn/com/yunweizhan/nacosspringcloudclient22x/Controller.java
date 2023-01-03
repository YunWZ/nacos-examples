package cn.com.yunweizhan.nacosspringcloudclient22x;


import com.alibaba.nacos.client.utils.EnvUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Weizhan▪Yun
 * @date 2022/8/21 14:57
 */
@RestController
public class Controller {
	@Autowired
	private ConfigProperties configProperties;
/*	private NamingService namingService;

	@GetMapping("/instances")
	public List<Instance> list() throws NacosException {
		return namingService.getAllInstances("nacos-client");
	}*/

	@GetMapping("username")
	public String username() {
//		return configProperties.getUserName();
	}
}
