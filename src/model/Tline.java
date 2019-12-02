package model;

/**
 * Tline entity. @author MyEclipse Persistence Tools
 */

public class Tline implements java.io.Serializable {

	// Fields

	private Integer lid;
	private String taskname;
	private Boolean status;
	private String startpoint;
	private String endpoint;

	// Constructors

	/** default constructor */
	public Tline() {
	}

	/** full constructor */
	public Tline(String taskname, Boolean status, String startpoint,
			String endpoint) {
		this.taskname = taskname;
		this.status = status;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
	}

	// Property accessors

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getStartpoint() {
		return this.startpoint;
	}

	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}

	public String getEndpoint() {
		return this.endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}