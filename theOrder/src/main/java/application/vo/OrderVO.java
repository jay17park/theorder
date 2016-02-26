package application.vo;

public class OrderVO {
	private int orderId;			//주문ID
	private int orderNo;			//주문번호
	private String orderDt;			//주문일시
	private int shopId;			//매장ID
	private String orderUserId;		//주문사용자ID
	private int orderAmtSum;		//주문금액합계
	private String orderSnt;		//주문건수
	private String togoYn;			//포장여부
	
	public String getTogoYn() {
		return togoYn;
	}
	public void setTogoYn(String togoYn) {
		this.togoYn = togoYn;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDt() {
		return orderDt;
	}
	public void setOrderDt(String orderDt) {
		this.orderDt = orderDt;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}
	public int getOrderAmtSum() {
		return orderAmtSum;
	}
	public void setOrderAmtSum(int orderAmtSum) {
		this.orderAmtSum = orderAmtSum;
	}
	
	public String getOrderSnt() {
		return orderSnt;
	}
	public void setOrderSnt(String orderSnt) {
		this.orderSnt = orderSnt;
	}
}
