package com.app.custom_Excep;

@SuppressWarnings("serial")
public class MyCustomException extends RuntimeException{
	public MyCustomException(String msg) {
		super(msg);
	}
}
