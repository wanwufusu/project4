package com.stylefeng.guns;

import com.stylefeng.guns.order.GunsOrderApplication;
import com.stylefeng.guns.order.common.persistence.model.MoocOrder;
import com.stylefeng.guns.order.common.persistence.model.OrderResponseVO;
import com.stylefeng.guns.order.common.persistence.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GunsOrderApplication.class)
@EnableAutoConfiguration
public class GunsOrderApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	public void MyTest(){
/*		OrderResponseVO<List<MoocOrder>> admin = orderService.getOrderInfo(1, 5, "admin");
		System.out.println(admin);*/
		orderService.isIllegalSeat("123");
	}


	@Test
	public void contextLoads() {
	}

}
