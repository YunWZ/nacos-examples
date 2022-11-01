package cn.com.yunweizhan.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Weizhan▪Yun
 * @date 2022/9/13 11:01
 */
@RestController
public class AuthController {
	@PostMapping("/login")
	public boolean login() {
		System.out.println("received a login request.");
		return true;
	}
}
