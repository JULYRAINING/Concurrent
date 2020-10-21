package com.block.test;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Student implements Delayed{
	
	private String name;
	private long submitTime;
	private long workTime;
	
	
	
	public Student(String name, long submitTime){
		this.name = name;
		this.workTime = submitTime;
		this.submitTime = TimeUnit.NANOSECONDS.convert(submitTime, TimeUnit.MILLISECONDS) + System.nanoTime();
		System.out.println(this.name + "���� ��ʱ" + workTime);
	}
	
	public String getName(){
		return this.name + " ������ʱ" + workTime;
	}

	
	
	@Override
	public int compareTo(Delayed o) {
		Student that = (Student) o;
		return (submitTime > that.submitTime) ? 1:(submitTime < that.submitTime?-1:0);
		
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(submitTime - System.nanoTime(), unit.NANOSECONDS);
	}

}
