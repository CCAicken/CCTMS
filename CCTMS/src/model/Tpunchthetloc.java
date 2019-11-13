package model;

/**
 * Tpunchthetloc entity. @author MyEclipse Persistence Tools
 */

public class Tpunchthetloc implements java.io.Serializable {

	// Fields

	private Integer pttid;
	private String sitename;
	private String xcoordinate;
	private String ycoordinate;
	private Integer lid;

	// Constructors

	/** default constructor */
	public Tpunchthetloc() {
	}

	/** full constructor */
	public Tpunchthetloc(String sitename, String xcoordinate,
			String ycoordinate, Integer lid) {
		this.sitename = sitename;
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.lid = lid;
	}

	// Property accessors

	public Integer getPttid() {
		return this.pttid;
	}

	public void setPttid(Integer pttid) {
		this.pttid = pttid;
	}

	public String getSitename() {
		return this.sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getXcoordinate() {
		return this.xcoordinate;
	}

	public void setXcoordinate(String xcoordinate) {
		this.xcoordinate = xcoordinate;
	}

	public String getYcoordinate() {
		return this.ycoordinate;
	}

	public void setYcoordinate(String ycoordinate) {
		this.ycoordinate = ycoordinate;
	}

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

}