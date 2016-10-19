package com.safe.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic利用cpu来比较交换 CAS: Compare And Swap
 * 非阻塞算法：noblocking algorithms
 * @author TF
 *
 */
public class Atomic {
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(0);
		
		System.out.println(ai.get());
		
		System.out.println(ai.getAndSet(5));
		
		System.out.println(ai.getAndIncrement());
		
		System.out.println(ai.getAndDecrement());
		
		System.out.println(ai.getAndAdd(10));
		
		System.out.println(ai.get());
	}
}
