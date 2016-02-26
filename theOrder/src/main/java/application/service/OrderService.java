package application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.OrderDAO;
import application.dao.OrderMenuRltDAO;
import application.dao.PmtDAO;
import application.vo.OrderInfrVO;
import application.vo.OrderMenuRltVO;
import application.vo.OrderMenuVO;
import application.vo.OrderVO;
import application.vo.PmtVO;

@Service
public class OrderService {

	@Autowired
	OrderMenuRltDAO orderMenuRltDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	PmtDAO pmtDAO;
	
	
	/**
	 * 주문정보처리
	 * 
	 * @param orderInfrVO
	 * @return
	 */
	public String processOrderInfr(OrderInfrVO orderInfrVO) {
		
		// 주문번호생성
		int newOrderNo = orderDAO.getNewOrderNo();	
		// 주문, 결제 생성
		this.createOrder(newOrderNo, orderInfrVO);
		// 주문-메뉴관계 생성
		this.createOrderMenuRlt(newOrderNo, orderInfrVO);
		
		// TODO : 결과처리
		return null;
	}

	/**
	 * 주문생성
	 * 1. 주문 생성
	 * 2. 주문-메뉴관계 생성
	 * 
	 * @param MenuList 화면에서 주문한 음료 List
	 * @return 결과코드???
	 */
	private int createOrder(int newOrderNo, OrderInfrVO orderInfrVO) {
		/*
		 *  주문 생성
		 */
		OrderVO newOrderVO = new OrderVO();
		
		newOrderVO.setOrderNo(newOrderNo);
		newOrderVO.setOrderAmtSum(orderInfrVO.getOrderAmtSum());
		newOrderVO.setTogoYn(orderInfrVO.getTogoYn());
		
		newOrderVO.setOrderUserId(orderInfrVO.getUserId());
		newOrderVO.setShopId(orderInfrVO.getShopId());
		
		int resultCnt1 = orderDAO.insertVO(newOrderVO);
		
		
		/*
		 *  결제 생성
		 */
		PmtVO newPmtVO = new PmtVO(); 
		
		int orderId = orderDAO.getOrderId(newOrderNo, orderInfrVO.getShopId());
		newPmtVO.setOrderId(orderId);
		newPmtVO.setPmtAmt(orderInfrVO.getOrderAmtSum());
		
		newPmtVO.setPmtUserId(orderInfrVO.getUserId());		// 결재사용자ID
		
		
		int resultCnt2 = pmtDAO.insertVO(newPmtVO);
		
		
		int result = 0;
		if ( resultCnt1 == 0 || resultCnt2 == 0 ) {
			result = 1;
		} 		
		
		return result;
	}

	/**
	 * 주문-메뉴관계 생성
	 * 
	 * @param orderInfrVO
	 */
	private int[] createOrderMenuRlt(int orderNo, OrderInfrVO orderInfrVO) {
		/*
		 *  주문-메뉴관계 생성
		 */
		List<OrderMenuRltVO> orderMenuRltVOList = new ArrayList<OrderMenuRltVO>();

		
		OrderMenuRltVO vo = null;
		
		
		// 화면에서 입력받은 음료 List를 주문-메뉴관계 테이블 레코드 형식으로 변경
		// 중복되는 메뉴는 레코드1건만 생성후 건수에 +1		
		List<OrderMenuVO> menuList = orderInfrVO.getOrderMenuVOList();
		
		for (OrderMenuVO menu : menuList) {
			vo = new OrderMenuRltVO();

			vo.setMenuId(menu.getMenuId());
			vo.setIceOpt(menu.getIceOpt());
			vo.setShotOpt(menu.getShotOpt());
			
			int orderId = orderDAO.getOrderId(orderNo, orderInfrVO.getShopId());
			
			vo.setOrderId(orderId);

			boolean isInVOList = false;
			OrderMenuRltVO addingVo = null;
			
			
			for (OrderMenuRltVO innerMenuRlt : orderMenuRltVOList) {
				if (innerMenuRlt.equals(vo)) {
					isInVOList = true;
					addingVo = innerMenuRlt;
					break;
				} 
			}
			
			if (isInVOList) {
				addingVo.setOrderQty(addingVo.getOrderQty() + 1);
			} else {
				orderMenuRltVOList.add(vo);
			}
			
		}
		System.out.println(orderMenuRltVOList.toString());
		
		
		int[] result  = orderMenuRltDAO.insert(orderMenuRltVOList);

		System.out.println(Arrays.toString(result));
		
		return result;
	}
}
