package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CoDecUtil {
	/**
	 * Converts readable to unreadble str
	 * @param normalStr
	 * @return encodedStr
	 */
	public String doEncode(String normalStr){
		byte[] arr=Base64.encodeBase64(normalStr.getBytes());
		return new String(arr);
	}
	/***
	 * Converts unreadble to readble
	 * @param encStr
	 * @return normal Str
	 */
	public String doDecode(String encStr){
		byte[] arr=Base64.decodeBase64(encStr.getBytes());
		return new String(arr);
	}
	
	
	
}
