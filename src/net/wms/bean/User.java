package net.wms.bean;

public class User {
	private Integer id;
	private String username; 
	private String userpwd;
	private String flag;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getuserpwd() {
		return userpwd;
	}
	public void setuserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
