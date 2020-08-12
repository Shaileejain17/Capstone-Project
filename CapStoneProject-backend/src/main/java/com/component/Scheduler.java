package com.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	@Scheduled(fixedDelay = 5000, initialDelay = 3000)  // *3600*24
	   public void fixedDelaySch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Delay scheduler:: " + strDate);
	   }
}

//loop all records
//get date from each record, check if date is expired
//set flag false if date expired using setFlag() method
