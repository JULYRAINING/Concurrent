package com.block;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new TotalTask());
		BillTask billTask1 = new BillTask("1", barrier);
		BillTask billTask2 = new BillTask("2", barrier);
		BillTask billTask3 = new BillTask("3", barrier);
		
		billTask1.start();
		billTask2.start();
		billTask3.start();
		System.out.println("Main Thread End");
		
	}

	static class TotalTask extends Thread {
		public void run() {
			System.out.println("All thread have been finished");
		}
	}

	static class BillTask extends Thread {
		private String billName;
		private CyclicBarrier barrier;

		public BillTask(String billName, CyclicBarrier barrier) {

			this.billName = billName;
			this.barrier = barrier;
		}

		public void run() {
			try {
			System.out.println(billName+"ģ�鿪ʼ����");
			
				Thread.sleep(1000L);
			
			System.out.println(billName+"ģ���������");
			barrier.await();
			System.out.println("ȫ��������ɺ󣬲ſ�ʼ��������");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
