package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.AdminDAO;
import application.vo.AdminOrderVO;

@Service
public class AdminService {
	
	@Autowired
	AdminDAO adminDAO;

	/**
	 * 주문목록조회(카페직원화면)
	 * @param shopId 카페ID
	 * @return List<AdminVO> 주문목록 List
	 */
	public List<AdminOrderVO> getOrderList(String shopId) {
		return adminDAO.getOrderList(shopId);
	}
	
}
