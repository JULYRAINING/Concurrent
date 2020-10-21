package com.safe.singleton;

/**
 * 线程安全的， 高并发性能也高
 * @author TF
 *
 */
public class Singleton3 {
	private static Singleton3 instance;
	private static byte[] lock = new byte[1];
	private Singleton3(){
		
	}
	public static Singleton3 getInstance(){
		if(instance == null){
			synchronized (lock) {
				if (instance == null) {
					instance = new Singleton3();
				}
				
			}
			
		}
		return instance;
	}
}
