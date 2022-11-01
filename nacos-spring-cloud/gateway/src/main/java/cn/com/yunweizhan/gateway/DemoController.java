package cn.com.yunweizhan.gateway;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Weizhan▪Yun
 * @date 2022/9/13 11:03
 */
@RestController
public class DemoController {
	private WebClient webClient;

	DemoController(WebClient webClient) {
		this.webClient = webClient;
	}

	@GetMapping("auth")
	public Mono<Boolean> auth(){
		return webClient.post().
	}
}
