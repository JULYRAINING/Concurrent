package com.forkjoin;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Sum {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		multipThread();
		
		
//		singleThread();
		
	}
	
	private static void multipThread() throws InterruptedException, ExecutionException {
		System.out.println("begin");
		ComputeSum computeSum1 = new Sum().new ComputeSum(1, 5000000000L);
		ComputeSum computeSum2 = new Sum().new ComputeSum(5000000001L, 10000000000L);
		FutureTask<Long>task1 = new FutureTask<>(computeSum1);
		FutureTask<Long>task2 = new FutureTask<>(computeSum2);
		
		long begin = System.currentTimeMillis();
		new Thread(task1).start();
		new Thread(task2).start();
		
		System.out.println(task1.get()+task1.get());
		System.out.println("spend:"+String.valueOf(System.currentTimeMillis()-begin));
		
	}
	
	private static void singleThread() {
		System.out.println("begin");
		long begin = System.currentTimeMillis();
		long sum = 0;
		for(long i = 0; i <10000000000L; i++){
			sum += i;
		}
		System.out.println("spend:"+String.valueOf(System.currentTimeMillis()-begin));
		System.out.println("sum:"+sum);
	}
	
	class ComputeSum implements Callable<Long> {
		
		private long start;
		

		private long end;
		public ComputeSum(long start, long end) {
			
			this.start = start;
			this.end = end;
			
		}
		
		@Override
		public Long call() throws Exception {
			long sum = 0;
			for(long i = start; i<end; i++){
				sum += i;
			}
			
			return sum;
		}
	}
}
