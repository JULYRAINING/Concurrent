package com.safe.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * �̰߳�ȫ�ģ� �߲�������Ҳ��
 * @author TF
 *
 */
public class Singleton4 {
	private static Singleton4 instance;
	private static ReentrantLock lock = new ReentrantLock();
	private Singleton4(){
		
	}
	public static Singleton4 getInstance(){
		if(instance == null){
			lock.lock();
				if (instance == null) {
					instance = new Singleton4();
				}
				
			lock.unlock();
			
		}
		return instance;
	}
}
