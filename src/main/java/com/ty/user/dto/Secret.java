package com.ty.user.dto;

public class Secret {
	private int userid;
	private String name;
	private String key;
	private String password;
	private String descrption;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	
	@Override
	public String toString() {
		return "Secret [userid=" + userid + ", name=" + name + ", key=" + key + ", password=" + password
				+ ", descrption=" + descrption + "]";
	}
	
	

}
