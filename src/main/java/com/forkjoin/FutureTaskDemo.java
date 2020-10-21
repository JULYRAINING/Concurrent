package com.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
	public static void main(String[] args) {
		ExecutorService service=Executors.newSingleThreadExecutor();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("Done");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		
		
		try {
			
		
			FutureTask<Integer> futureTask1 = new FutureTask<Integer>(runnable, 22);
			service.execute(futureTask1);
			FutureTask<Integer> futureTask2 = new FutureTask<Integer>(runnable, futureTask1.get());
			service.execute(futureTask2);
			System.out.println("futureTask1:"+futureTask1.get());
			System.out.println("futureTask2:"+futureTask2.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
