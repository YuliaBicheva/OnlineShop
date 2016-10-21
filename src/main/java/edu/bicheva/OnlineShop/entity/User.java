package edu.bicheva.OnlineShop.entity;

public class User extends BaseEntity {

	private static final long serialVersionUID = -8331573076458119567L;

	private String fName;
	
	private String lName;
	
	private String mName;
	
	private Address postAddress;
	
	private String email;
	
	private String phone;
	
	private String login;
	
	private Role role;
	
	private UserStatus status;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Address getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(Address postAddress) {
		this.postAddress = postAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	
}
