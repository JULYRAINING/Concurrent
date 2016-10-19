package com.create;

public class ThreadLocal_Impl {
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			
			return 0;
		}
		
	};
	public ThreadLocal<Integer> getThreadLocal(){
		return seqNum;
	}
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		ThreadLocal_Impl sn = new ThreadLocal_Impl();
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	private static class TestClient extends Thread{

		private ThreadLocal_Impl sn;
		public  TestClient(ThreadLocal_Impl sn) {
			this.sn = sn;
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			for(int i = 0; i<3; i++){
				System.out.println("thread["+Thread.currentThread().getName()+"]--sn["
						+ sn.getNextNum()+"]");
			}
			sn.getThreadLocal().remove();
		}
		
	}
}
