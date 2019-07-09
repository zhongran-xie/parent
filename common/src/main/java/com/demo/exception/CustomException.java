package com.demo.exception;

public class CustomException extends RuntimeException { 
     
	private static final long serialVersionUID = -2544887188576477703L;

	// 提供无参数的构造方法
	  public CustomException() { 
	  } 
	 
	  // 提供一个有参数的构造方法，可自动生成
	  public CustomException(String message) { 
		super(message);// 把参数传递给Throwable的带String参数的构造方法 
	  } 
}
