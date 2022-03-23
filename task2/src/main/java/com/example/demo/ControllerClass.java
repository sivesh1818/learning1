package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {

	
	//public Gadgets gadgets;
	  
	@Autowired //(required=false)
	public Laptop laptop;   ////  Field Injection
	
	 //@Autowired
    //public ControllerClass(Gadgets gadgets) {   /////////   Constructor injection
     //this.gadgets = gadgets;
    	 
     //}
	 
	// @Autowired
	// public void SetGadget(@Qualifier("mobile")Gadgets gadgets){      ////////  Setter Injection
	  // this.gadgets=gadgets;
	 
    //}
	
	 
	 @GetMapping
	 public String getGadget() {
		 //String sa=gadgets.Show();
		 String s=laptop.Show();
		//return sa;
		return s;
		 
	 }
	
}
