package com.java.springbootsmsapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.java.springbootsmsapp.service.SmsService;
import com.java.springbootsmsapp.view.SmsRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServiceImpl implements SmsService {

	private final String ACCOUNT_SID = "ACa9f21740b90ff25d28e3c7a24973d68c";

	private final String AUTH_TOKEN = "c1eb522adaf0a2e6d0e98ab1dfe356e4";

	private final String FROM_NUMBER = "+18644044984";

	@Override
	public void send(SmsRequest request) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message
				.creator(new PhoneNumber(request.getTo()), new PhoneNumber(FROM_NUMBER), request.getMessage()).create();

		System.out.println("here is my id :" + message.getSid());

	}

	@Override
	public void receive(MultiValueMap<String, String> map) {
		// TODO Auto-generated method stub

	}
}
