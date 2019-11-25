package model;

/**
 * Vlinearrange entity. @author MyEclipse Persistence Tools
 */

public class Vlinearrange implements java.io.Serializable {

	// Fields

		private Integer laid;
		private Integer lid;
		private String tthresho;
		private String lineRemarks;
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
		private Integer daid;

		// Constructors

		/** default constructor */
		public Vlinearrange() {
		}

		/** minimal constructor */
		public Vlinearrange(Integer laid, Integer lid, String tthresho,
				String taskname, Boolean lineStatus, String startpoint,
				String endpoint, String userid, Integer carid, String carNum,
				Boolean carStatus, Boolean fanStatus, String userName, String sex,
				String tel, Boolean userStatus, Integer daid) {
			this.laid = laid;
			this.lid = lid;
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
			this.daid = daid;
		}

		/** full constructor */
		public Vlinearrange(Integer laid, Integer lid, String tthresho,
				String lineRemarks, String taskname, Boolean lineStatus,
				String startpoint, String endpoint, String userid, Integer carid,
				String carNum, Boolean carStatus, Boolean fanStatus,
				String carRemarks, String userName, String sex, String tel,
				Boolean userStatus, Integer daid) {
			this.laid = laid;
			this.lid = lid;
			this.tthresho = tthresho;
			this.lineRemarks = lineRemarks;
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
			this.daid = daid;
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

		public String getTthresho() {
			return this.tthresho;
		}

		public void setTthresho(String tthresho) {
			this.tthresho = tthresho;
		}

		public String getLineRemarks() {
			return this.lineRemarks;
		}

		public void setLineRemarks(String lineRemarks) {
			this.lineRemarks = lineRemarks;
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

		public Integer getDaid() {
			return this.daid;
		}

		public void setDaid(Integer daid) {
			this.daid = daid;
		}
}