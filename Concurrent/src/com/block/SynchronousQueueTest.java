package com.block;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
	public static void main(String[] args) {
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		
		final SynchronousQueue<String>synchronousQueue = new SynchronousQueue<>();
		final Semaphore semaphore = new Semaphore(1);
		
		for(int i = 0; i<10; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						semaphore.acquire();
					
					String input = synchronousQueue.take();
					String output = TestDo.doSome(input);
					System.out.println(Thread.currentThread().getName() + ":" + output);
					semaphore.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
					).start();
		}
		for(int i = 0; i<10; i++){
			String input = i + "";
			try {
				synchronousQueue.put(input);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static class TestDo{
		public static String doSome(String input){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String output = input + ":" + (System.currentTimeMillis() / 1000);
			return output;
		}
	}
}
