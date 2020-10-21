package com.safe;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SafeThread {
	
	class ThreadA extends Thread{
		
		private Count count;
		public ThreadA(Count count){
			this.count = count;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			count.add();
		}
		
	}
	class Count{
		private byte[] lock = new byte[1];
		final ReentrantLock lock2 = new ReentrantLock();
		public int num = 0;
		public  void add(){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock2.lock();
			num += 1;
			System.out.println(Thread.currentThread().getName()+"-"+num);
			lock2.unlock();
			/*
			synchronized (lock) {
				num += 1;
				System.out.println(Thread.currentThread().getName()+"-"+num);
			}
			*/
			
			
		}
	}
	class Count1{
		private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		public void get(){
			readWriteLock.readLock().lock();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":read start");
			System.out.println(Thread.currentThread().getName()+":read");
			System.out.println(Thread.currentThread().getName()+":read end");
			readWriteLock.readLock().unlock();
		}
		public void put(){
			readWriteLock.writeLock().lock();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":write start");
			System.out.println(Thread.currentThread().getName()+":write");
			System.out.println(Thread.currentThread().getName()+": write end");
			readWriteLock.writeLock().unlock();
		}
	}

	public static void main(String[] args) {
		/*
		Count count = new SafeThread().new Count();
		for(int i = 0; i< 10; i++){
			Thread a = new SafeThread().new ThreadA(count);
			a.start();
		}*/
		
		final Count1 count = new SafeThread().new Count1();
		for(int i = 0; i<2; i++){
			new Thread(){
				public void run(){
					count.get();
				}
			}.start();
		}
		for(int i = 0; i<2; i++){
			new Thread(){
				public void run(){
					count.put();
				}
			}.start();
		}
	}
}
