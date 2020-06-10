package com.example.demospringwork1.helloWorld;

public class HelloWorldBean{
	
	private String message;
	
	
    public HelloWorldBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  HelloWorldBean(String message){
	this.message =message;
	
	}

	

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}
}