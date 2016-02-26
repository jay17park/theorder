package application.vo;

public class ShopVO {
	private Integer shopId;		//매장ID
	private String shopNm;		//매장명
	private Integer totalQty;	//남은주문수량
	private Integer orderCnt;	//남은주문건수
	
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopNm() {
		return shopNm;
	}
	public void setShopNm(String shopNm) {
		this.shopNm = shopNm;
	}
	public Integer getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}
	
	
	public Integer getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(Integer orderCnt) {
		this.orderCnt = orderCnt;
	}
	@Override
	public String toString() {
		return "ShopVO [shopId=" + shopId + ", shopNm=" + shopNm
				+ ", totalQty=" + totalQty + ", orderCnt=" + orderCnt + "]";
	}
	
	
}
