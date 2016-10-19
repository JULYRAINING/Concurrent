package com.create.test;

import com.create.ExceptionHandlerThreadB;

public class HandlerThreadException_Test {
	public static void main(String[] args) {
		Thread a = new HandlerThreadException_Test().new ThreadA();
		a.setUncaughtExceptionHandler(new ExceptionHandlerThreadB());
		a.start();
	}
	
	
	class ThreadA extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			int a = Integer.parseInt("yyy");
		}
		
	}
}
