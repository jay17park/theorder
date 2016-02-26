package application.vo;

public class WatingVO {
	private String orderId;			//주문ID
	private String orderNo;			//주문번호
	private String orderDt;			//주문일시
	private String shopId;			//매장ID
	private String shopNm;			//매장명
	private String orderUserId;		//주문사용자ID
	private String menuNm;			//메뉴명

	private String shotOptNm;		//샷옵션명
	private String iceOptNm;		//얼음옵션명
	private String orderSntNm;	//주문0건일경우
	
	private int orderAmtSum;		//주문금액합계
	private int orderSnt;			//주문건수
	private int orderQty;			//메뉴별수량
	private int orderQtyAll;		//주문메뉴총수량
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDt() {
		return orderDt;
	}
	public void setOrderDt(String orderDt) {
		this.orderDt = orderDt;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
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
	
	public int getOrderSnt() {
		return orderSnt;
	}
	public void setOrderSnt(int orderSnt) {
		this.orderSnt = orderSnt;
	}
	
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	public int getOrderQtyAll() {
		return orderQtyAll;
	}
	public void setOrderQtyAll(int orderQtyAll) {
		this.orderQtyAll = orderQtyAll;
	}
	
	public String getShopNm() {
		return shopNm;
	}
	public void setShopNm(String shopNm) {
		this.shopNm = shopNm;
	}

	public String getIceOptNm() {
		return iceOptNm;
	}
	public void setIceOptNm(String iceOptNm) {
		this.iceOptNm = iceOptNm;
	}
	
	public String getShotOptNm() {
		return shotOptNm;
	}
	public void setShotOptNm(String shotOptNm) {
		this.shotOptNm = shotOptNm;
	}
	
	public String getOrderSntNm() {
		return orderSntNm;
	}
	public void setOrderSntNm(String orderSntNm) {
		this.orderSntNm = orderSntNm;
	}
}
