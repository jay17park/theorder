package application.vo;

public class MenuVO {
	private int menuId;			//메뉴ID
	private String menuNm;			//메뉴명
	private int menuAmt;			//메뉴금액
	private String iceOptUseYn;		//얼음옵션사용여부
	private String shotOptUseYn;	//샷옵션사용여부
	private int showNo;				//메뉴표시순서
	private String menuMngCd;		//메뉴관리코드		
	public int getShowNo() {
		return showNo;
	}
	public void setShowNo(int showNo) {
		this.showNo = showNo;
	}
	public String getMenuMngCd() {
		return menuMngCd;
	}
	public void setMenuMngCd(String menuMngCd) {
		this.menuMngCd = menuMngCd;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public int getMenuAmt() {
		return menuAmt;
	}
	public void setMenuAmt(int menuAmt) {
		this.menuAmt = menuAmt;
	}
	public String getIceOptUseYn() {
		return iceOptUseYn;
	}
	public void setIceOptUseYn(String iceOptUseYn) {
		this.iceOptUseYn = iceOptUseYn;
	}
	public String getShotOptUseYn() {
		return shotOptUseYn;
	}
	public void setShotOptUseYn(String shotOptUseYn) {
		this.shotOptUseYn = shotOptUseYn;
	}
	}
