package model;


/**
 * TAdminUser entity. @author MyEclipse Persistence Tools
 */

public class TAdminUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String tel;
	private String pwd;
	private Integer roleid;
	private String username;
	private String sex;
	private String lastlogindate;

	// Constructors

	/** default constructor */
	public TAdminUser() {
	}

	/** minimal constructor */
	public TAdminUser(String userid, String tel, String pwd, Integer roleid,
			String username) {
		this.userid = userid;
		this.tel = tel;
		this.pwd = pwd;
		this.roleid = roleid;
		this.username = username;
	}

	/** full constructor */
	public TAdminUser(String userid, String tel, String pwd, Integer roleid,
			String username, String sex, String lastlogindate) {
		this.userid = userid;
		this.tel = tel;
		this.pwd = pwd;
		this.roleid = roleid;
		this.username = username;
		this.sex = sex;
		this.lastlogindate = lastlogindate;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLastlogindate() {
		return this.lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

}