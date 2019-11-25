package model;

/**
 * Vabnormalrr entity. @author MyEclipse Persistence Tools
 */

public class Vabnormalrr implements java.io.Serializable {

	// Fields

		private Integer alid;
		private Integer arid;
		private Integer lrid;
		private String imageurl;
		private String voiceurl;
		private String voideurl;
		private String txtcontent;
		private Integer lid;
		private Integer daid;
		private String tthresho;
		private String lineArrangeRemarks;
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
		public Vabnormalrr() {
		}

		/** minimal constructor */
		public Vabnormalrr(Integer alid, Integer arid, Integer lrid, Integer lid,
				Integer daid, String tthresho, String taskname, Boolean lineStatus,
				String startpoint, String endpoint, String userid, Integer carid,
				String carNum, Boolean carStatus, Boolean fanStatus,
				String userName, String sex, String tel, Boolean userStatus) {
			this.alid = alid;
			this.arid = arid;
			this.lrid = lrid;
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
		public Vabnormalrr(Integer alid, Integer arid, Integer lrid,
				String imageurl, String voiceurl, String voideurl,
				String txtcontent, Integer lid, Integer daid, String tthresho,
				String lineArrangeRemarks, String taskname, Boolean lineStatus,
				String startpoint, String endpoint, String userid, Integer carid,
				String carNum, Boolean carStatus, Boolean fanStatus,
				String carRemarks, String userName, String sex, String tel,
				Boolean userStatus) {
			this.alid = alid;
			this.arid = arid;
			this.lrid = lrid;
			this.imageurl = imageurl;
			this.voiceurl = voiceurl;
			this.voideurl = voideurl;
			this.txtcontent = txtcontent;
			this.lid = lid;
			this.daid = daid;
			this.tthresho = tthresho;
			this.lineArrangeRemarks = lineArrangeRemarks;
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

		public Integer getAlid() {
			return this.alid;
		}

		public void setAlid(Integer alid) {
			this.alid = alid;
		}

		public Integer getArid() {
			return this.arid;
		}

		public void setArid(Integer arid) {
			this.arid = arid;
		}

		public Integer getLrid() {
			return this.lrid;
		}

		public void setLrid(Integer lrid) {
			this.lrid = lrid;
		}

		public String getImageurl() {
			return this.imageurl;
		}

		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}

		public String getVoiceurl() {
			return this.voiceurl;
		}

		public void setVoiceurl(String voiceurl) {
			this.voiceurl = voiceurl;
		}

		public String getVoideurl() {
			return this.voideurl;
		}

		public void setVoideurl(String voideurl) {
			this.voideurl = voideurl;
		}

		public String getTxtcontent() {
			return this.txtcontent;
		}

		public void setTxtcontent(String txtcontent) {
			this.txtcontent = txtcontent;
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

		public String getLineArrangeRemarks() {
			return this.lineArrangeRemarks;
		}

		public void setLineArrangeRemarks(String lineArrangeRemarks) {
			this.lineArrangeRemarks = lineArrangeRemarks;
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