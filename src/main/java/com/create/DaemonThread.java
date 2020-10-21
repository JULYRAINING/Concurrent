package com.create;

import javax.swing.DebugGraphics;

/**
 *  ÿª§œﬂ≥Ã
 * @author raining
 *
 */
public class DaemonThread {
	
	public static void main(String[] args) {
		Thread a = new DaemonThread().new Thread_A();
		Thread b = new DaemonThread().new Thread_B();
		
		a.setDaemon(true);
		
		b.start();
		
		a.start();
		
		
	}
	
	class Thread_A extends Thread{

		@Override
		public void run() {
			
			super.run();
			
	 		for(int i = 0; i< 1000; i++){
				System.out.println("A"+i);
			}
		}
		
	}
	class Thread_B extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			for(int i = 0; i< 5; i++){
				System.out.println("B"+i);
			}
			
		}
		
	}
}
