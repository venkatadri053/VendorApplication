package com.app.util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class CommonUtil {
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * TO send Email with attachment
	 */
	public String sendEmail(String toAddr,String subject,String text,final CommonsMultipartFile cmf){
		String msg=null;
		try {
			MimeMessage message=mailSender.createMimeMessage();
			//use helper class to compose email
			MimeMessageHelper helper=new MimeMessageHelper(message, true);

			helper.setFrom("raghusirjava@gmail.com");

			helper.setTo(toAddr);
			helper.setSubject(subject);
			helper.setText(text);

			//add any attachements
			if(cmf!=null){
				helper.addAttachment(cmf.getOriginalFilename(), 
						new InputStreamSource() {

					public InputStream getInputStream() throws IOException {
						return cmf.getInputStream();
					}
				});
			}

			//click on send button
			mailSender.send(message);
			msg="(Email Sent)";
		} catch (Exception e) {
			e.printStackTrace();
			msg="(Email is not sent)";
		}
		return msg;
	}
	
	/**
	 *TO send Email without attachment 
	 */
	public String sendEmail(String toAddr,String subject,String text){
		return sendEmail(toAddr, subject, text, null);
	}

}
