package com.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTashDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		CountTask task = new ForkJoinTashDemo().new CountTask(1, 5);
		Future<Long>result = forkJoinPool.submit(task);
		System.out.println("1-5最终相加的结果："+result.get());
		
		CountTask task2 = new ForkJoinTashDemo().new CountTask(1, 10000000000L);
		
		System.out.println("begin");
		long begin = System.currentTimeMillis();
		
		Future<Long>result2 = forkJoinPool.submit(task2);
		System.out.println("1-100最终相加的结果："+result2.get());
		System.out.println("spend:"+String.valueOf(System.currentTimeMillis()-begin));
		
		
		
		
		
		System.out.println("Thread Main End");
		
	}
	
	class CountTask extends RecursiveTask<Long>{

		
		private static final long serialVersionUID = 1L;

		private static final long splitSize = 20000l;
		
		private long start;
		private long end;

		
		
		public CountTask(long start, long end) {
			
			this.start = start;
			this.end = end;
		}



		@Override
		protected Long compute() {
			long sum = 0;
			boolean canCompute = (end - start)<splitSize;
			if(canCompute){
				for(long i =start; i<end; i++){
					sum = sum +i;
				}
			}else {
				long middle = (start + end)/2;
				CountTask firstTask = new CountTask(start, middle);
				CountTask secondTask = new CountTask(middle, end);
				firstTask.fork();
				secondTask.fork();
				
				long firstResult = firstTask.join();
				long secondResult = secondTask.join();
				
				sum = firstResult + secondResult;
				
			}
			return sum;
		}
		
	}
}
