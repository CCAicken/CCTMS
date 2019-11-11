package model;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */

public class Tuser implements java.io.Serializable {

	// Fields

	private String userid;
	private String pwd;
	private String userName;
	private String sex;
	private String tel;
	private Boolean status;

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** full constructor */
	public Tuser(String userid, String pwd, String userName, String sex,
			String tel, Boolean status) {
		this.userid = userid;
		this.pwd = pwd;
		this.userName = userName;
		this.sex = sex;
		this.tel = tel;
		this.status = status;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}