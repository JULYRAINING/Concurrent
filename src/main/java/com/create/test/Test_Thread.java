package com.create.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

import com.create.AThread;
import com.create.CallableC;
import com.create.RunnableB;

public class Test_Thread {

	@Test
	public void test_Thread() throws InterruptedException{
		System.out.println("begin A");
		AThread thread = new AThread();
		thread.start();
		Thread.sleep(1000);
		System.out.println("start");
		thread.interrupt();
		System.out.println("interrupt");
		System.out.println("end A"); 
	}
	@Test
	public void test_Runnable(){
		RunnableB runnableB = new RunnableB();
		new Thread(runnableB, "B").start();
		System.out.println("begin B");
		System.out.println("end B");
	}
	@Test
	public void test_Callable() throws InterruptedException, ExecutionException{
		CallableC c = new CallableC();
		System.out.println("begin C");
		FutureTask<String> futureTask = new FutureTask<>(c);
		new Thread(futureTask, "C").start();
		System.out.println("return :"+futureTask.get());
		
		System.out.println("end C");
	}
}
