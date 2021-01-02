package com.tampro.springrest04.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tampro.springrest04.model.Customer;
import com.tampro.springrest04.repository.CustomerRepository;
import com.tampro.springrest04.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepo;
	
	private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	//Khoảng cách thời gian giữa các lần chạy method (fixedRate)
	//Khoảng cách thời gian giữa các lần chạy hoàn thành method (fixedDelay)
	//Thời gian delay cho lần đầu tiên chạy method (initialDelay)
	//Cron chạy method (cron)
	//Cũng vẫn yêu cầu gửi mail, nhưng bạn muốn gửi vào 12h thứ 6 hàng tuần, hoặc 23h59 ngày cuối tháng .v.v.v.
	//Những thứ bên trên kia là ko đủ. Vậy bạn hãy nghĩ tới cron
	
	//src : https://viblo.asia/p/scheduling-task-trong-spring-boot-yMnKMy2QK7P
	@Override
	@Scheduled(fixedRate = 5000) // sau 5s sẽ được gọi // cứ đúng 5s là gọi tiếp ko cần bik ở trong hàm xong chưa
	public void add2DBJob() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
			Customer customer = new Customer();
			customer.setName("user" + new Random().nextInt(374483));
			customerRepo.save(customer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("add service call in "+new Date().toString());
	}


	@Override
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchDbJob() {
		// TODO Auto-generated method stub
		List<Customer> list = customerRepo.findAll();
		System.out.println("fetch service call in "+new Date().toString());
		System.out.println("no of record fetched :"+ list.size());
		logger.info("users : {}",list);
	}


	@Override
	@Scheduled(fixedDelay = 3000) // khoản cách là 3s . sau đó phải đợi trong hàm thực thi thì mới tiếp tục
	public void scheduleTaskWithFixedDelay() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("send emailo producers to inform quantity sold items");
	}


	@Override
	@Scheduled(fixedRate = 3000, initialDelay = 10000)
	//sau khi deploy thì phải đợi 1 khoản thời gian là  initialDelay thì hàm mới được thực thi
	// sau đó mỗi 3000set sẽ gọi tiếp
	public void scheduleTaskWithInitialDelay() {
		// TODO Auto-generated method stub
		logger.info("Using initialDelay send  ");
	}


	@Override
	@Scheduled(cron = "15 * * * * ?") // 15 giây mỗi phút
	public void scheduleTaskWithCronExpression() {
		// TODO Auto-generated method stub
		logger.info(" 15s mỗi phút");
	}
 

}
