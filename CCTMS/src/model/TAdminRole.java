package model;

/**
 * TAdminRole entity. @author MyEclipse Persistence Tools
 */

public class TAdminRole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public TAdminRole() {
	}

	/** minimal constructor */
	public TAdminRole(String name) {
		this.name = name;
	}

	/** full constructor */
	public TAdminRole(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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