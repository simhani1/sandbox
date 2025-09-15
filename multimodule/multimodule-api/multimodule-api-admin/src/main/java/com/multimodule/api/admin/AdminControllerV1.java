package com.multimodule.api.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/v1")
@RestController
public class AdminControllerV1 {

	@GetMapping("/test")
	public String test() {
		return "admin test";
	}
}
