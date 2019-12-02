package model;

/**
 * TrealTimePosition entity. @author MyEclipse Persistence Tools
 */

public class TrealTimePosition implements java.io.Serializable {

	// Fields

	private Integer rtpid;
	private String xcoordinate;
	private String ycoordinate;
	private Integer order;
	private Integer laid;

	// Constructors

	/** default constructor */
	public TrealTimePosition() {
	}

	/** minimal constructor */
	public TrealTimePosition(String xcoordinate, String ycoordinate,
			Integer laid) {
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.laid = laid;
	}

	/** full constructor */
	public TrealTimePosition(String xcoordinate, String ycoordinate,
			Integer order, Integer laid) {
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.order = order;
		this.laid = laid;
	}

	// Property accessors

	public Integer getRtpid() {
		return this.rtpid;
	}

	public void setRtpid(Integer rtpid) {
		this.rtpid = rtpid;
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

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getLaid() {
		return this.laid;
	}

	public void setLaid(Integer laid) {
		this.laid = laid;
	}

}