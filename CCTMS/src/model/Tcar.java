package model;

/**
 * Tcar entity. @author MyEclipse Persistence Tools
 */

public class Tcar implements java.io.Serializable {

	// Fields

	private Integer carId;
	private String carNum;
	private Boolean status;
	private Boolean fanStatus;
	private String remarks;

	// Constructors

	/** default constructor */
	public Tcar() {
	}

	/** minimal constructor */
	public Tcar(String carNum, Boolean status, Boolean fanStatus) {
		this.carNum = carNum;
		this.status = status;
		this.fanStatus = fanStatus;
	}

	/** full constructor */
	public Tcar(String carNum, Boolean status, Boolean fanStatus, String remarks) {
		this.carNum = carNum;
		this.status = status;
		this.fanStatus = fanStatus;
		this.remarks = remarks;
	}

	// Property accessors

	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarNum() {
		return this.carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getFanStatus() {
		return this.fanStatus;
	}

	public void setFanStatus(Boolean fanStatus) {
		this.fanStatus = fanStatus;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}