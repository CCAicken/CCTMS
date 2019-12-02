package model;

/**
 * Tlinearrange entity. @author MyEclipse Persistence Tools
 */

public class Tlinearrange implements java.io.Serializable {

	// Fields

	private Integer laid;
	private Integer lid;
	private Integer daid;
	private String tthresho;
	private String remarks;

	// Constructors

	/** default constructor */
	public Tlinearrange() {
	}

	/** minimal constructor */
	public Tlinearrange(Integer lid, Integer daid, String tthresho) {
		this.lid = lid;
		this.daid = daid;
		this.tthresho = tthresho;
	}

	/** full constructor */
	public Tlinearrange(Integer lid, Integer daid, String tthresho,
			String remarks) {
		this.lid = lid;
		this.daid = daid;
		this.tthresho = tthresho;
		this.remarks = remarks;
	}

	// Property accessors

	public Integer getLaid() {
		return this.laid;
	}

	public void setLaid(Integer laid) {
		this.laid = laid;
	}

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getDaid() {
		return this.daid;
	}

	public void setDaid(Integer daid) {
		this.daid = daid;
	}

	public String getTthresho() {
		return this.tthresho;
	}

	public void setTthresho(String tthresho) {
		this.tthresho = tthresho;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}