package application.vo;

public class UserVO {
	private String userId;		//사용자ID
	private String password;	//패스워드
	private String userNm;		//사용자명
	private String userRegId;	//reg ID
	private int cnt;			//존재여부(0,1)
	public UserVO() {
		
	}
	public UserVO(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getUserRegId() {
		return userRegId;
	}
	public void setUserRegId(String userRegId) {
		this.userRegId = userRegId;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", password=" + password + ", userNm=" + userNm + ", userRegId=" + userRegId
				+ ", cnt=" + cnt + "]";
	}
	
	
}
