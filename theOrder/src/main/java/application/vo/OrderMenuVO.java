package application.vo;

public class OrderMenuVO {
	private int menuId;					//메뉴ID
	private String iceOpt;				//얼음옵션
	private String shotOpt;				//샷옵션
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
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
	public String toString() {
		return "OrderMenuVO [menuId=" + menuId + ", iceOpt=" + iceOpt
				+ ", shotOpt=" + shotOpt + "]";
	}
	
	
}
