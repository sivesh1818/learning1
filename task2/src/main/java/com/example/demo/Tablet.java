package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Tablet implements Gadgets{

	@Override
	public String Show() {
		// TODO Auto-generated method stub
		return "Tablet show method called";
	}
	

}
