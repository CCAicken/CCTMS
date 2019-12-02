package model;

/**
 * Vpunchthetloc entity. @author MyEclipse Persistence Tools
 */

public class Vpunchthetloc implements java.io.Serializable {

	// Fields

		private Integer pttid;
		private String sitename;
		private String xcoordinate;
		private String ycoordinate;
		private Integer lid;
		private String taskname;
		private Boolean status;
		private String startpoint;
		private String endpoint;

		// Constructors

		/** default constructor */
		public Vpunchthetloc() {
		}

		/** full constructor */
		public Vpunchthetloc(Integer pttid, String sitename, String xcoordinate,
				String ycoordinate, Integer lid, String taskname, Boolean status,
				String startpoint, String endpoint) {
			this.pttid = pttid;
			this.sitename = sitename;
			this.xcoordinate = xcoordinate;
			this.ycoordinate = ycoordinate;
			this.lid = lid;
			this.taskname = taskname;
			this.status = status;
			this.startpoint = startpoint;
			this.endpoint = endpoint;
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

		public String getTaskname() {
			return this.taskname;
		}

		public void setTaskname(String taskname) {
			this.taskname = taskname;
		}

		public Boolean getStatus() {
			return this.status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
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

}