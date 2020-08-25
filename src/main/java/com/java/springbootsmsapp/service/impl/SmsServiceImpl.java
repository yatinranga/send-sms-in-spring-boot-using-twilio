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

	private final String ACCOUNT_SID = "enter your account sid from twilio console";

	private final String AUTH_TOKEN = "enter your auth token from twilio console";

	private final String FROM_NUMBER = "enter your number with country code assigned to you from twilio console";

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
