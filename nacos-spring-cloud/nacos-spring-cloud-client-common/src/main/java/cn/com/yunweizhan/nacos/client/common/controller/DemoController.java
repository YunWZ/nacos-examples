package cn.com.yunweizhan.nacos.client.common.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	public ConfigExample1Properties.User userInfo() {
		return configExample1Properties.getUser();
	}

	public static void main(String[] args) {
		Set<Integer> nums = new HashSet<>();
		for (int i = 0; i < 20; i++) {
			nums.add(i+1);
		}
		int count = 3;

		Iterator<Integer> iterator = nums.iterator();
		while (count > 0 && iterator.hasNext()) {
			Integer num = iterator.next();
			if ((num & 1) == 0) {
				iterator.remove();
				count--;
			}
		}

		System.out.println("retain size: " + nums.size() + "ele: " + nums);

	}
}
