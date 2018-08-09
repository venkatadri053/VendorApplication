package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {

	private String genStr(int length){
		return UUID.randomUUID()
				.toString().replaceAll("-", "")
				.substring(0,length);

	}
	
	public String genPwd(){
		return genStr(6);
	}
	
	public String genToken(){
		return genStr(8);
	}
	
	
	
}
