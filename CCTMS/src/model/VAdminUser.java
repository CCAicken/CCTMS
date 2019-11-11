package model;

/**
 * VAdminUser entity. @author MyEclipse Persistence Tools
 */

public class VAdminUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String tel;
	private String pwd;
	private Integer roleid;
	private String username;
	private String sex;
	private String lastlogindate;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public VAdminUser() {
	}

	/** minimal constructor */
	public VAdminUser(String userid, String tel, String pwd, Integer roleid,
			String username, String name) {
		this.userid = userid;
		this.tel = tel;
		this.pwd = pwd;
		this.roleid = roleid;
		this.username = username;
		this.name = name;
	}

	/** full constructor */
	public VAdminUser(String userid, String tel, String pwd, Integer roleid,
			String username, String sex, String lastlogindate, String name,
			String description) {
		this.userid = userid;
		this.tel = tel;
		this.pwd = pwd;
		this.roleid = roleid;
		this.username = username;
		this.sex = sex;
		this.lastlogindate = lastlogindate;
		this.name = name;
		this.description = description;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}