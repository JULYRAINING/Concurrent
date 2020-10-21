package com.block.test;

import java.util.concurrent.DelayQueue;

public class DelayQueueTest {
	
	public static void main(String[] args) {
		final DelayQueue<Student>bQueue = new DelayQueue<>();
		for(int i = 0; i< 5; i++){
			Student student = new Student("Ñ§Éú" + i, Math.round(Math.random()*10+1));
			bQueue.put(student);
		}
		System.out.println("bQueue.peek()"+bQueue.peek().getName());
	}
}
