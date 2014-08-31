package com.otn.collector.huawei.delivery.exception;

public class AppException extends Exception{

	private static final long serialVersionUID = -250275108050898555L;

	public AppException(){
		
	}
	
	public AppException(String message){
		super(message);
	}
	
	public AppException(Throwable cause){
		super(cause);
	}
	
	public AppException(String message,Throwable cause){
		super(message,cause);
	}
}
