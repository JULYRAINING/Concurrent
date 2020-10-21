package com.block;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.PUBLIC_MEMBER;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		int count = 1000;
		final BlockingQueue<String>bq = new ArrayBlockingQueue<>(count);
		LinkedBlockingQueue a;
		for(int i = 0; i<count; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						String log;
						try {
							log = bq.take();
							parseLog(log);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}).start();
		}
		for(int i = 0; i<count; i++){
			String log = (i+1)+ "--->";
			try {
				bq.put(log);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void parseLog(String log) {
		System.out.println(log + System.currentTimeMillis());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
