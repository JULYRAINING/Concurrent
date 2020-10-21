package com.create;

import java.util.concurrent.Callable;

public class CallableC implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("I'm CallableC");
		return "C";
	}

}
