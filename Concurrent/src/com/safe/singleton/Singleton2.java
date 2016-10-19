package com.safe.singleton;

/**
 * 线程安全的， 但是高并发性能低
 * @author TF
 *
 */
public class Singleton2 {
	private static Singleton2 instance;
	private Singleton2(){
		
	}
	public static synchronized Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
}
