package model;


/**
 * TRoleSystemModel entity. @author MyEclipse Persistence Tools
 */

public class TRoleSystemModel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleid;
	private Integer sysid;
	private Boolean isedit;
	private String cteatedate;

	// Constructors

	/** default constructor */
	public TRoleSystemModel() {
	}

	/** full constructor */
	public TRoleSystemModel(Integer roleid, Integer sysid, Boolean isedit,
			String cteatedate) {
		this.roleid = roleid;
		this.sysid = sysid;
		this.isedit = isedit;
		this.cteatedate = cteatedate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getSysid() {
		return this.sysid;
	}

	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}

	public Boolean getIsedit() {
		return this.isedit;
	}

	public void setIsedit(Boolean isedit) {
		this.isedit = isedit;
	}

	public String getCteatedate() {
		return this.cteatedate;
	}

	public void setCteatedate(String cteatedate) {
		this.cteatedate = cteatedate;
	}

}