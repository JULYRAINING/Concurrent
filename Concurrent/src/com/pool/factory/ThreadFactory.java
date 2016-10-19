package com.pool.factory;

public interface ThreadFactory {
	Thread newThread(Runnable r);
}
