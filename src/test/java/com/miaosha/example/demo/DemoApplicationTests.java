package com.miaosha.example.demo;

import com.miaosha.example.task.Task;
import com.miaosha.example.task.TaskOld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private TaskOld taskOld;
	@Autowired
	private Task task;
	@Test
	public void contextLoads() throws Exception {
		taskOld.taskOne();
		taskOld.taskTow();
		taskOld.taskThree();
		long start = System.currentTimeMillis();
		Future<String> task1 = task.taskOne();
		Future<String> task2 = task.taskTwo();
		Future<String> task3= task.taskThree();
		while (true){
			if(task1.isDone() && task2.isDone() && task3.isDone()){
				break;
			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

}
