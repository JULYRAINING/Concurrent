package com.create.test;

import com.create.ExceptionHandlerThreadB;

public class MathException_Test {
	public static void main(String[] args) {
		int a = 0;
		
		Thread aThread = Thread.currentThread();
		aThread.setUncaughtExceptionHandler(new ExceptionHandlerThreadB());
		System.out.println(6/a);
		 
				
	}
}
