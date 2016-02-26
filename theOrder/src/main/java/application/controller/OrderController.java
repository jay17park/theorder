package application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.service.OrderService;
import application.vo.OrderInfrVO;

import com.google.gson.Gson;


@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	/**
	 * 주문시 주문 및 결제정보 처리
	 * 1. 주문정보처리
	 * 2. 결제정보처리
	 * 
	 * @param orderMenuVO
	 * @return
	 */
	@RequestMapping(value = "/order", method=RequestMethod.POST)
	//public String createOrder(@RequestBody OrderInfrVO orderInfrVO, HttpSession session) {
	public String createOrder(@RequestParam(value="jsonData", defaultValue="{default:default}")String jsonData, HttpSession session){
		
		// JSON to VO
		OrderInfrVO orderInfrVO = new OrderInfrVO();
		Gson gson = new Gson();
		orderInfrVO = gson.fromJson(jsonData, OrderInfrVO.class);
		
		if(null == (String)session.getAttribute("shopId")) {
			return "redirect:cafe";
		}
		
		orderInfrVO.setShopId(Integer.parseInt((String)session.getAttribute("shopId")));
		orderInfrVO.setUserId((String)session.getAttribute("userId"));
		
		// 주문정보처리
		orderService.processOrderInfr(orderInfrVO);
		
		// 결제정보처리
		
		return "redirect:waitingStatus";
	}
}
