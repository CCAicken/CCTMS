package model;


/**
 * TSystemLog entity. @author MyEclipse Persistence Tools
 */

public class TSystemLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String opertype;
	private String description;
	private String opermethod;
	private String requestip;
	private String exceptioncode;
	private String exceptiondetail;
	private String params;
	private String createdate;
	private String createby;

	// Constructors

	/** default constructor */
	public TSystemLog() {
	}

	/** minimal constructor */
	public TSystemLog(String createdate) {
		this.createdate = createdate;
	}

	/** full constructor */
	public TSystemLog(String opertype, String description, String opermethod,
			String requestip, String exceptioncode, String exceptiondetail,
			String params, String createdate, String createby) {
		this.opertype = opertype;
		this.description = description;
		this.opermethod = opermethod;
		this.requestip = requestip;
		this.exceptioncode = exceptioncode;
		this.exceptiondetail = exceptiondetail;
		this.params = params;
		this.createdate = createdate;
		this.createby = createby;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpertype() {
		return this.opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpermethod() {
		return this.opermethod;
	}

	public void setOpermethod(String opermethod) {
		this.opermethod = opermethod;
	}

	public String getRequestip() {
		return this.requestip;
	}

	public void setRequestip(String requestip) {
		this.requestip = requestip;
	}

	public String getExceptioncode() {
		return this.exceptioncode;
	}

	public void setExceptioncode(String exceptioncode) {
		this.exceptioncode = exceptioncode;
	}

	public String getExceptiondetail() {
		return this.exceptiondetail;
	}

	public void setExceptiondetail(String exceptiondetail) {
		this.exceptiondetail = exceptiondetail;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

}