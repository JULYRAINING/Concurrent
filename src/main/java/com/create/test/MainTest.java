package com.create.test;

import com.create.AThread;

public class MainTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("begin A");
		AThread thread = new AThread();
		thread.start();
		Thread.sleep(1000);
		System.out.println("start");
		thread.interrupt();
		System.out.println("interrupt");
		System.out.println("end A");
	}
}
