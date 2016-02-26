package application.vo;

import java.util.List;

public class OrderInfrVO {

	private int orderAmtSum;
	private String userId;
	private int shopId;
	private String togoYn;				//포장여부
	public String getTogoYn() {
		return togoYn;
	}
	public void setTogoYn(String togoYn) {
		this.togoYn = togoYn;
	}
	private List <OrderMenuVO> orderMenuVOList;
	
	public int getOrderAmtSum() {
		return orderAmtSum;
	}
	public void setOrderAmtSum(int orderAmtSum) {
		this.orderAmtSum = orderAmtSum;
	}
	public List<OrderMenuVO> getOrderMenuVOList() {
		return orderMenuVOList;
	}
	public void setOrderMenuVOList(List<OrderMenuVO> orderMenuVOList) {
		this.orderMenuVOList = orderMenuVOList;
	}
	
	public int getShopId() {
		return shopId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	@Override
	public String toString() {
		return "OrderInfrVO [OrderAmtSum=" + orderAmtSum + ", orderMenuVOList="
				+ orderMenuVOList + "]";
	}
}
