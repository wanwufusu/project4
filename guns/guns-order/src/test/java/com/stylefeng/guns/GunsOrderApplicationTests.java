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
		//orderService.isLegalSeat("1,2,3", "seats/cgs.json");
		OrderResponseVO<MoocOrder> moocOrderOrderResponseVO = orderService.buyTickets(1, "5,6,7", "一排一座", "alibaba");
		System.out.println(moocOrderOrderResponseVO);
	}


	@Test
	public void contextLoads() {
	}

}
