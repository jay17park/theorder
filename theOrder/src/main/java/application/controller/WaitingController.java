package application.controller;

import java.util.List;

import javax.security.auth.callback.ConfirmationCallback;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.dao.WatingDAO;
import application.vo.WatingVO;

@Controller
public class WaitingController {
	@Autowired
    private WatingDAO watingDAO;
	
	@RequestMapping(value="/waiting.do", method=RequestMethod.POST)
	public String doWaitingInfo(@RequestParam(value="waiting",defaultValue="1")String orderId, Model model) {
		
		System.out.println("orderId : " + orderId);
		model.addAttribute("orderId", orderId);
        return "menu";
	}
	@RequestMapping(value="/waitingStatus", method=RequestMethod.GET)
	public String doWaitingInfoList(Model model, HttpSession session) {
		
		//userId로 orderId, orderNo, shopId, orderDt추출
		String orderUserId = (String) session.getAttribute("userId");
		List<WatingVO> userOrderList = watingDAO.selectWaitingUserInfo(orderUserId);
		
		WatingVO inWatingVO = new WatingVO();
		String orderId = "";
		String orderDt = "";
		String shopId = "";

		if(userOrderList != null && userOrderList.size() > 0){
			
			orderId = userOrderList.get(0).getOrderId();
			orderDt = userOrderList.get(0).getOrderDt();
			shopId  = userOrderList.get(0).getShopId();
			
			inWatingVO.setOrderId(orderId);
			inWatingVO.setOrderDt(orderDt);
			inWatingVO.setShopId(shopId);
			
			//주문내역 조회
			List<WatingVO> waitingList = watingDAO.selectWaitingInfo(inWatingVO);
			
			if(waitingList != null && waitingList.size()>0)
			{
				for(int i=0; i<waitingList.size(); i++){
					String menuNm=waitingList.get(i).getMenuNm().replaceAll("\\s", "");

					waitingList.get(i).setMenuNm(menuNm);					
				}
/*				for(WatingVO waiting : waitingList)
				{
					System.out.println(waiting.toString());
				}*/
				
				if(waitingList.get(0).getOrderSnt() == 0){
					waitingList.get(0).setOrderSntNm("준비중 ");
				}else{
					waitingList.get(0).setOrderSntNm(waitingList.get(0).getOrderSnt()+" 건 ");
				}
				
				model.addAttribute("waiting", waitingList);
				
				return "waitingStatus";
			}else{
				return "error";
			}
			
		}else{
			return "error";
		}

		
	}
}
