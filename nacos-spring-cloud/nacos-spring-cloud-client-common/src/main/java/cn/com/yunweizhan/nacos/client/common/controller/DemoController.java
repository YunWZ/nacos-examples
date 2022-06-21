package cn.com.yunweizhan.nacos.client.common.controller;

import javax.annotation.Resource;

import cn.com.yunweizhan.nacos.client.common.config.ConfigExample1Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/21 09:23
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private ConfigExample1Properties configExample1Properties;

	@GetMapping("/user")
	public ConfigExample1Properties.User userInfo(){
		return configExample1Properties.getUser();
	}
}
