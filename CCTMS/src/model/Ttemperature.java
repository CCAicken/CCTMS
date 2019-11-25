package model;


/**
 * Ttemperature entity. @author MyEclipse Persistence Tools
 */

public class Ttemperature implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String realtimet;
	private Integer laid;
	private String createTime;
	private Integer order;

	// Constructors

	/** default constructor */
	public Ttemperature() {
	}

	/** minimal constructor */
	public Ttemperature(String realtimet, Integer laid) {
		this.realtimet = realtimet;
		this.laid = laid;
	}

	/** full constructor */
	public Ttemperature(String realtimet, Integer laid, String createTime,
			Integer order) {
		this.realtimet = realtimet;
		this.laid = laid;
		this.createTime = createTime;
		this.order = order;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getRealtimet() {
		return this.realtimet;
	}

	public void setRealtimet(String realtimet) {
		this.realtimet = realtimet;
	}

	public Integer getLaid() {
		return this.laid;
	}

	public void setLaid(Integer laid) {
		this.laid = laid;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}