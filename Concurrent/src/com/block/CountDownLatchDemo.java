package com.block;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch latch  = new CountDownLatch(3);
		
		Worker worker1 = new Worker("Jack", latch);
		Worker worker2 = new Worker("Rose", latch);
		Worker worker3 = new Worker("Json", latch);
		
		worker1.start();
		worker2.start();
		worker3.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Thread end.");
		
	}
	static class Worker extends Thread{
		
		private String workerName;
		private CountDownLatch latch;
		
		public Worker(String workerName, CountDownLatch latch){
			this.workerName = workerName;
			this.latch = latch;
		}
		public void run(){
			try {
			System.out.println("Worker:"+workerName+" is begin");
			Thread.sleep(1000L);
			
			System.out.println("Worker:"+workerName+" is end");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		}
	}
}
