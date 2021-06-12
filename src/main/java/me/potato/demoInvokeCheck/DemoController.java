/*
 * DemoController.java 2021. 06. 13
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.demoInvokeCheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * @author dongju.paek
 */
@RequiredArgsConstructor
@RestController
public class DemoController {

	private final DemoService service;

	@GetMapping("/hello")
	public String hello() {
		return service.getHello();
	}
}