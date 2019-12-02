package model;


/**
 * TcheckRecord entity. @author MyEclipse Persistence Tools
 */

public class TcheckRecord implements java.io.Serializable {

	// Fields

	private Integer cirid;
	private Integer linepid;
	private String xcoordinate;
	private String ycoordinate;
	private String clocktime;

	// Constructors

	/** default constructor */
	public TcheckRecord() {
	}

	/** minimal constructor */
	public TcheckRecord(Integer linepid, String xcoordinate, String ycoordinate) {
		this.linepid = linepid;
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
	}

	/** full constructor */
	public TcheckRecord(Integer linepid, String xcoordinate,
			String ycoordinate, String clocktime) {
		this.linepid = linepid;
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.clocktime = clocktime;
	}

	// Property accessors

	public Integer getCirid() {
		return this.cirid;
	}

	public void setCirid(Integer cirid) {
		this.cirid = cirid;
	}

	public Integer getLinepid() {
		return this.linepid;
	}

	public void setLinepid(Integer linepid) {
		this.linepid = linepid;
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

	public String getClocktime() {
		return this.clocktime;
	}

	public void setClocktime(String clocktime) {
		this.clocktime = clocktime;
	}

}