package model;

/**
 * TabnormalRecord entity. @author MyEclipse Persistence Tools
 */

public class TabnormalRecord implements java.io.Serializable {

	// Fields

	private Integer arid;
	private String imageurl;
	private String voiceurl;
	private String voideurl;
	private String txtcontent;

	// Constructors

	/** default constructor */
	public TabnormalRecord() {
	}

	/** full constructor */
	public TabnormalRecord(String imageurl, String voiceurl, String voideurl,
			String txtcontent) {
		this.imageurl = imageurl;
		this.voiceurl = voiceurl;
		this.voideurl = voideurl;
		this.txtcontent = txtcontent;
	}

	// Property accessors

	public Integer getArid() {
		return this.arid;
	}

	public void setArid(Integer arid) {
		this.arid = arid;
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

}