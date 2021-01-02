package com.tampro.springrest04.service;

public interface CustomerService {

	//using fixed rate
	public void add2DBJob();
	
	//using cron
	public void fetchDbJob();
	
	public void scheduleTaskWithFixedDelay() ;

    public void scheduleTaskWithInitialDelay();
    
     
    public void scheduleTaskWithCronExpression();
}
