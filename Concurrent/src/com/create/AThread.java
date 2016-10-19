package com.create;

import java.text.BreakIterator;

public class AThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		boolean stop = false;
		while (!stop) {
			System.out.println(System.currentTimeMillis());
			long time = System.currentTimeMillis();
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				break;
			}
			/*
			while (System.currentTimeMillis() - time <500) {
				
			}
			if(Thread.currentThread().isInterrupted()){
				Thread.currentThread();
				break;
			}	
			*/	
		}
		
		
			
		
		System.out.println("I'm ThreadA");
	}

}
