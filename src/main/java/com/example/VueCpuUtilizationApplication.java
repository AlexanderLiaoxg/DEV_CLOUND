package com.example;

import java.util.Timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.util_LXG.MachinStateTimerTask;
import com.example.util_LXG.RedisToMysqlTimerTask;

@SpringBootApplication
public class VueCpuUtilizationApplication {

	public static MachinStateTimerTask machineTimerTask = new MachinStateTimerTask();
	public static RedisToMysqlTimerTask redisToMysqlTimerTask = new RedisToMysqlTimerTask();
	
    public static void main(String[] args) {
    	Timer timer = new Timer();
    	timer.schedule(machineTimerTask, 0,2000);
    	//86400000一天
    	timer.schedule(redisToMysqlTimerTask, 60000);
        SpringApplication.run(VueCpuUtilizationApplication.class, args);
    }

}
