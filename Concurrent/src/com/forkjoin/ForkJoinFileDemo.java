package com.forkjoin;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFileDemo {
	public static void main(String[] args) {
		
		Integer count = new ForkJoinPool().invoke(new ForkJoinFileDemo().new CountingTask(Paths.get("e:/")));
		System.out.println("ÎÄ¼þ¿‚”µÁ¿£º"+ count);
	}
	
	class CountingTask extends RecursiveTask<Integer>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Path dir;

		public CountingTask(Path dir) {
			
			this.dir = dir;
		}

		@Override
		protected Integer compute() {
			int count = 0;
			List<CountingTask>subTasks = new ArrayList<>();
			DirectoryStream<Path> directoryStream;
			try {
				directoryStream = Files.newDirectoryStream(dir);
				for(Path subPath: directoryStream){
					if(Files.isDirectory(subPath, LinkOption.NOFOLLOW_LINKS)){
						
						
						subTasks.add(new CountingTask(subPath));
					}else {
						if(subPath.getFileName().toString().endsWith(".jpg")){
							System.out.println(subPath.getFileName());
						}
						count++;
					}
				}
				
				if(!subTasks.isEmpty()){
					for(CountingTask subTask : invokeAll(subTasks)){
						count += subTask.join();
					}
				}
				
				
				
			} catch (IOException e) {
				return 0;
			}
			
			return count;
		}
		
	}
}
