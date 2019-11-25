package model;

/**
 * Vdutyarrange entity. @author MyEclipse Persistence Tools
 */

public class Vdutyarrange implements java.io.Serializable {

	// Fields

		private Integer daid;
		private String userid;
		private Integer carid;
		private String carNum;
		private Boolean carStatus;
		private Boolean fanStatus;
		private String remarks;
		private String userName;
		private String sex;
		private String tel;
		private Boolean userStatus;

		// Constructors

		/** default constructor */
		public Vdutyarrange() {
		}

		/** minimal constructor */
		public Vdutyarrange(Integer daid, String userid, Integer carid,
				String carNum, Boolean carStatus, Boolean fanStatus,
				String userName, String sex, String tel, Boolean userStatus) {
			this.daid = daid;
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
		public Vdutyarrange(Integer daid, String userid, Integer carid,
				String carNum, Boolean carStatus, Boolean fanStatus,
				String remarks, String userName, String sex, String tel,
				Boolean userStatus) {
			this.daid = daid;
			this.userid = userid;
			this.carid = carid;
			this.carNum = carNum;
			this.carStatus = carStatus;
			this.fanStatus = fanStatus;
			this.remarks = remarks;
			this.userName = userName;
			this.sex = sex;
			this.tel = tel;
			this.userStatus = userStatus;
		}

		// Property accessors

		public Integer getDaid() {
			return this.daid;
		}

		public void setDaid(Integer daid) {
			this.daid = daid;
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

		public String getRemarks() {
			return this.remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
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