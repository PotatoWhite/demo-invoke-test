/*
 * DemoService.java 2021. 06. 13
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.demoInvokeCheck;

import org.springframework.stereotype.Service;

/**
 * @author dongju.paek
 */
@Service
public class DemoService {

	public String getHello() {
		return "Hello";

	}
}