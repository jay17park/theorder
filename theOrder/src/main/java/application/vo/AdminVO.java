package application.vo;

import java.util.List;

public class AdminVO {
	private int orderNo;
	private int orderAmtSum;
	private String userId;
	private String userNm;
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderAmtSum() {
		return orderAmtSum;
	}

	public void setOrderAmtSum(int orderAmtSum) {
		this.orderAmtSum = orderAmtSum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	private List<AdminOrderVO> adminOrderList;

	public List<AdminOrderVO> getAdminOrderList() {
		return adminOrderList;
	}

	public void setAdminOrderList(List<AdminOrderVO> adminOrderList) {
		this.adminOrderList = adminOrderList;
	}
	
	
}
