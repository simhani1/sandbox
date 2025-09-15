package com.multimodule.api.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client/v1")
@RestController
public class ClientControllerV1 {

	@GetMapping("/test")
	public String test() {
		return "client test";
	}
}
