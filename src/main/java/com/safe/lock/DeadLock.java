package com.safe.lock;

public class DeadLock {
	class Count{
		private byte[] lock1 = new byte[1];
		private byte[] lock2 = new byte[1];
		public int num = 0;
		public void add(){
			synchronized (lock1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock2) {
					num += 1;
				}
				System.out.println(Thread.currentThread().getName()+"-"+num);
			}
		}
		public void lookMethod(){
			synchronized (lock2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock1) {
					num += 1;
				}
				System.out.println(Thread.currentThread().getName()+"-"+num);
			}
		}
	}

	class ThreadA extends Thread{
		private Count count;
		public ThreadA(Count count){
			this.count = count;
		}
		public void run(){
			count.lookMethod();
		}
	}
	
	class ThreadB extends Thread{
		private Count count;
		public ThreadB(Count count){
			this.count = count;
		}
		public void run(){
			count.add();
		}
	}

	public static void main(String[] args) {
		Count count = new DeadLock().new Count();
		
		ThreadA a = new DeadLock().new ThreadA(count);
		a.setName("thread_A");
		a.start();
		ThreadB b = new DeadLock().new ThreadB(count);
		b.setName("thread_B");
		b.start();
	}
	
}
