package com.tampro.springrest04.actuator;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//tạo thêm components cho actuator health
//components này check Internet Connection 

@Component
public class InternetHealthMetrics implements HealthIndicator {
	//Atuator cho phép ta theo dõi, giám sát ứng dụng, thu thập số liệu,
	//lưu lượng truy cập hay trạng thái cơ sở dữ liệu, v.v. mà không cần thêm bất kỳ dòng code nào
	//Một khi project của ta được cấu hình Spring Actuator 
	//thì mặc định ta sẽ có sẵn 16 endpoint để quản lý và theo dõi ứng dụng của ta. 
	//src :https://viblo.asia/p/spring-boot-actuator-GrLZDp2BZk0
	
	@Override
	public Health health() {
		// TODO Auto-generated method stub
		Health health = null;
		health = checkInternet() == true ? Health.up().withDetail("success code", "Active Internet Connection").build()
										 : Health.down().withDetail("error code", "InActive Internet Connection").build();
		return health;
	}
	
	private boolean checkInternet() {
		boolean flag = false;
		try {
			URL url = new URL("https://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		return flag;
	}

}
