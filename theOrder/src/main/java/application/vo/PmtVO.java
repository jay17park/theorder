package application.vo;

public class PmtVO {
	private int orderId;		//주문ID
	private int pmtAmt;		//결제금액
	private String pmtUserId;	//결제사용자ID

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPmtAmt() {
		return pmtAmt;
	}
	public void setPmtAmt(int pmtAmt) {
		this.pmtAmt = pmtAmt;
	}
	public String getPmtUserId() {
		return pmtUserId;
	}
	public void setPmtUserId(String pmtUserId) {
		this.pmtUserId = pmtUserId;
	}
	
}
