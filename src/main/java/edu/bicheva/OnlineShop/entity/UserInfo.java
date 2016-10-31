package edu.bicheva.OnlineShop.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserInfo{

	private String name;
	
	private Role role;
	
	private int accessLevel;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public int getAccessLevel() {
		return accessLevel;
	}
	

	public UserInfo() {
		super();
	}

	public UserInfo(String name, Role role, int accessLevel) {
		this.name = name;
		this.role = role;
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", role=" + role + ", accessLevel=" + accessLevel + "]";
	}
	
	
}
