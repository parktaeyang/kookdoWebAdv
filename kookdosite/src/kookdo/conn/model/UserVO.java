package kookdo.conn.model;

public class UserVO {
	
	
	private String userId;
	private String password;
	private String type;
	private String company;
	private String address;
	private String email;
	private String mobile;
	private String tel;
	
	public UserVO(String userId, String password, String type, String company, String address, String email, String mobile, String tel) {
		super();
		this.userId = userId;
		this.password = password;
		this.type = type;
		this.company = company;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.tel = tel;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", type=" + type + ", company=" + company +
				", address=" + address + ", email=" + email + ", mobile=" + mobile + ", tel=" + tel + " ]";
	}

}
