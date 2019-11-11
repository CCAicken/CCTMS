package model;


/**
 * VRoleSystemModel entity. @author MyEclipse Persistence Tools
 */

public class VRoleSystemModel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleid;
	private Integer sysid;
	private Boolean isedit;
	private String cteatedate;
	private String name;
	private String chinesename;
	private String navurl;
	private Integer deepth;
	private Integer parentid;
	private Integer displayorder;
	private String imageurl;
	private Boolean isdelete;
	private String rolename;
	private String description;

	// Constructors

	/** default constructor */
	public VRoleSystemModel() {
	}

	/** minimal constructor */
	public VRoleSystemModel(Integer id, Integer roleid, Integer sysid,
			Boolean isedit, String cteatedate, String rolename) {
		this.id = id;
		this.roleid = roleid;
		this.sysid = sysid;
		this.isedit = isedit;
		this.cteatedate = cteatedate;
		this.rolename = rolename;
	}

	/** full constructor */
	public VRoleSystemModel(Integer id, Integer roleid, Integer sysid,
			Boolean isedit, String cteatedate, String name, String chinesename,
			String navurl, Integer deepth, Integer parentid,
			Integer displayorder, String imageurl, Boolean isdelete,
			String rolename, String description) {
		this.id = id;
		this.roleid = roleid;
		this.sysid = sysid;
		this.isedit = isedit;
		this.cteatedate = cteatedate;
		this.name = name;
		this.chinesename = chinesename;
		this.navurl = navurl;
		this.deepth = deepth;
		this.parentid = parentid;
		this.displayorder = displayorder;
		this.imageurl = imageurl;
		this.isdelete = isdelete;
		this.rolename = rolename;
		this.description = description;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChinesename() {
		return this.chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getNavurl() {
		return this.navurl;
	}

	public void setNavurl(String navurl) {
		this.navurl = navurl;
	}

	public Integer getDeepth() {
		return this.deepth;
	}

	public void setDeepth(Integer deepth) {
		this.deepth = deepth;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}