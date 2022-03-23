package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class Mobile implements Gadgets{

	@Override
	public String Show() {
		// TODO Auto-generated method stub
		return "mobile show method called..";
	}

}
