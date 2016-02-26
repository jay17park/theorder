package application.vo;

public class OrderMenuRltVO {
	private int orderMenuRltId;		//주문메뉴관계ID		
	private int orderId;				//주문ID
	private int menuId;				//메뉴ID
	private int orderQty;			//주문수량
	private int orderAmt;			//주문금액
	private String iceOpt;				//얼음옵션
	private String shotOpt;				//샷옵션
	public int getOrderMenuRltId() {
		return orderMenuRltId;
	}
	public void setOrderMenuRltId(int orderMenuRltId) {
		this.orderMenuRltId = orderMenuRltId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderMenuRltVO other = (OrderMenuRltVO) obj;
		if (iceOpt == null) {
			if (other.iceOpt != null)
				return false;
		} else if (!iceOpt.equals(other.iceOpt))
			return false;
		if (menuId != other.menuId)
			return false;
		if (shotOpt == null) {
			if (other.shotOpt != null)
				return false;
		} else if (!shotOpt.equals(other.shotOpt))
			return false;
		return true;
	}
	public OrderMenuRltVO() {
		super();
		this.orderQty = 1;
	}
	
	
}
