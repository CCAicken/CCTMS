package model;

/**
 * VrealTimePosition entity. @author MyEclipse Persistence Tools
 */

public class VrealTimePosition implements java.io.Serializable {

	// Fields

	private Integer rtpid;
	private String xcoordinate;
	private String ycoordinate;
	private Integer order;
	private Integer laid;
	private Integer lid;
	private Integer daid;
	private String tthresho;
	private String lineAremarks;
	private String taskname;
	private Boolean lineStatus;
	private String startpoint;
	private String endpoint;
	private String userid;
	private Integer carid;
	private String carNum;
	private Boolean carStatus;
	private Boolean fanStatus;
	private String carRemarks;
	private String userName;
	private String sex;
	private String tel;
	private Boolean userStatus;

	// Constructors

	/** default constructor */
	public VrealTimePosition() {
	}

	/** minimal constructor */
	public VrealTimePosition(Integer rtpid, String xcoordinate,
			String ycoordinate, Integer laid, Integer lid, Integer daid,
			String tthresho, String taskname, Boolean lineStatus,
			String startpoint, String endpoint, String userid, Integer carid,
			String carNum, Boolean carStatus, Boolean fanStatus,
			String userName, String sex, String tel, Boolean userStatus) {
		this.rtpid = rtpid;
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.laid = laid;
		this.lid = lid;
		this.daid = daid;
		this.tthresho = tthresho;
		this.taskname = taskname;
		this.lineStatus = lineStatus;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.userid = userid;
		this.carid = carid;
		this.carNum = carNum;
		this.carStatus = carStatus;
		this.fanStatus = fanStatus;
		this.userName = userName;
		this.sex = sex;
		this.tel = tel;
		this.userStatus = userStatus;
	}

	/** full constructor */
	public VrealTimePosition(Integer rtpid, String xcoordinate,
			String ycoordinate, Integer order, Integer laid, Integer lid,
			Integer daid, String tthresho, String lineAremarks,
			String taskname, Boolean lineStatus, String startpoint,
			String endpoint, String userid, Integer carid, String carNum,
			Boolean carStatus, Boolean fanStatus, String carRemarks,
			String userName, String sex, String tel, Boolean userStatus) {
		this.rtpid = rtpid;
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.order = order;
		this.laid = laid;
		this.lid = lid;
		this.daid = daid;
		this.tthresho = tthresho;
		this.lineAremarks = lineAremarks;
		this.taskname = taskname;
		this.lineStatus = lineStatus;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.userid = userid;
		this.carid = carid;
		this.carNum = carNum;
		this.carStatus = carStatus;
		this.fanStatus = fanStatus;
		this.carRemarks = carRemarks;
		this.userName = userName;
		this.sex = sex;
		this.tel = tel;
		this.userStatus = userStatus;
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

	public String getLineAremarks() {
		return this.lineAremarks;
	}

	public void setLineAremarks(String lineAremarks) {
		this.lineAremarks = lineAremarks;
	}

	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public Boolean getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(Boolean lineStatus) {
		this.lineStatus = lineStatus;
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

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getCarid() {
		return this.carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public String getCarNum() {
		return this.carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Boolean getCarStatus() {
		return this.carStatus;
	}

	public void setCarStatus(Boolean carStatus) {
		this.carStatus = carStatus;
	}

	public Boolean getFanStatus() {
		return this.fanStatus;
	}

	public void setFanStatus(Boolean fanStatus) {
		this.fanStatus = fanStatus;
	}

	public String getCarRemarks() {
		return this.carRemarks;
	}

	public void setCarRemarks(String carRemarks) {
		this.carRemarks = carRemarks;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Boolean getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

}