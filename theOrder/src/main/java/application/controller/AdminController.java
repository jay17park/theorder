package application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.dao.AdminDAO;
import application.service.AdminService;
import application.vo.AdminOrderVO;
import application.vo.AdminVO;
import application.vo.UserVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminDAO adminDAO;
	
	/**
	 * 주문목록조회(카페직원화면)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String getOrderList(Model model) {
		// TODO : shopID 하드코딩 수정
		List<AdminOrderVO> orderListOrigin = adminService.getOrderList("1");
		
		List<AdminVO> orderList = new ArrayList<AdminVO>();
		
		AdminVO vo = null;
		List<AdminOrderVO> adminOrderList = null;
		for(AdminOrderVO orderVo : orderListOrigin){

			if(vo == null || vo.getOrderNo() != orderVo.getOrderNo())
			{
				if(vo != null)
				{
					vo.setAdminOrderList(adminOrderList);
					orderList.add(vo);
				}
				
				vo = new AdminVO();
				vo.setOrderAmtSum(orderVo.getOrderAmtSum());
				vo.setOrderNo(orderVo.getOrderNo());
				vo.setUserId(orderVo.getUserId());
				vo.setUserNm(orderVo.getUserNm());
				adminOrderList = new ArrayList<AdminOrderVO>();
			}
			
			adminOrderList.add(orderVo);
		}
		vo.setAdminOrderList(adminOrderList);
		orderList.add(vo);
		
		model.addAttribute("orderList", orderList);
		return "admin";
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.POST)
	public String completeOrder(int orderNo,Model model) {

		String regId = adminDAO.selectUser(orderNo);
		adminDAO.updateVO(orderNo);

		if(null != regId || !"".equals(regId))
		{
			GcmServer.push(regId);
		}
		
		// TODO : shopID 하드코딩 수정
		List<AdminOrderVO> orderListOrigin = adminService.getOrderList("1");
		
		List<AdminVO> orderList = new ArrayList<AdminVO>();
		
		AdminVO vo = null;
		List<AdminOrderVO> adminOrderList = null;
		for(AdminOrderVO orderVo : orderListOrigin){

			if(vo == null || vo.getOrderNo() != orderVo.getOrderNo())
			{
				if(vo != null)
				{
					vo.setAdminOrderList(adminOrderList);
					orderList.add(vo);
				}
				
				vo = new AdminVO();
				vo.setOrderAmtSum(orderVo.getOrderAmtSum());
				vo.setOrderNo(orderVo.getOrderNo());
				vo.setUserId(orderVo.getUserId());
				vo.setUserNm(orderVo.getUserNm());
				adminOrderList = new ArrayList<AdminOrderVO>();
			}
			
			adminOrderList.add(orderVo);
		}
		vo.setAdminOrderList(adminOrderList);
		orderList.add(vo);
		
		model.addAttribute("orderList", orderList);
		return "admin";
	}
	
	
}
