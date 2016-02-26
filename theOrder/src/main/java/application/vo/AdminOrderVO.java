package application.vo;

public class AdminOrderVO {
	private int orderNo;	// 주문번호
	private String userId;	// 사용자ID
	private String userNm;	// 사용자명
	private String menuNm;	// 메뉴명
	private String iceOpt;	// 얼음옵션
	private String shotOpt;	// 샷추가옵션
	private int orderQty;	// 주문수량
	private int orderAmt;	// 주문금액(메뉴별)
	private int orderAmtSum;	// 주문금액합계

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

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getIceOpt() {
		return iceOpt;
	}

	public void setIceOpt(String iceOpt) {
		this.iceOpt = iceOpt;
	}

	public String getShotOpt() {
		return shotOpt;
	}

	public void setShotOpt(String shotOpt) {
		this.shotOpt = shotOpt;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public int getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(int orderAmt) {
		this.orderAmt = orderAmt;
	}

	public int getOrderAmtSum() {
		return orderAmtSum;
	}

	public void setOrderAmtSum(int orderAmtSum) {
		this.orderAmtSum = orderAmtSum;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	} 
}
