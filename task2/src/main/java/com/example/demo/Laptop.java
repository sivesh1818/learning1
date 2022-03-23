package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class Laptop implements Gadgets{

	@Override
	public String Show() {
		// TODO Auto-generated method stub
		return "Laptop show method called..";
	}
  
}
