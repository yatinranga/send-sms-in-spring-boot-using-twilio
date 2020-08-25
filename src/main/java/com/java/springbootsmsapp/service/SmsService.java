package com.java.springbootsmsapp.service;

import org.springframework.util.MultiValueMap;

import com.java.springbootsmsapp.view.SmsRequest;

public interface SmsService {

	void send(SmsRequest request);

	void receive(MultiValueMap<String, String> map);

}
