package Entities;

import java.util.Date;
 /*
  * 考勤表数据模型
  */

public class modleCheckReports {

	
	
	private String chInnerId;
	private String chId;
	private String chName;
	private Date chTimeStart;
	private Date chTimeEnd;
	private String chMark;
	
	public modleCheckReports(String chInnerId, String chId, String chName, Date chTimeStart, Date chTimeEnd,
			String chMark) {
		super();
		this.chInnerId = chInnerId;
		this.chId = chId;
		this.chName = chName;
		this.chTimeStart = chTimeStart;
		this.chTimeEnd = chTimeEnd;
		this.chMark = chMark;
	}

	public String getChInnerId() {
		return chInnerId;
	}

	public void setChInnerId(String chInnerId) {
		this.chInnerId = chInnerId;
	}

	public String getChId() {
		return chId;
	}

	public void setChId(String chId) {
		this.chId = chId;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public Date getChTimeStart() {
		return chTimeStart;
	}

	public void setChTimeStart(Date chTimeStart) {
		this.chTimeStart = chTimeStart;
	}

	public Date getChTimeEnd() {
		return chTimeEnd;
	}

	public void setChTimeEnd(Date chTimeEnd) {
		this.chTimeEnd = chTimeEnd;
	}

	public String getChMark() {
		return chMark;
	}

	public void setChMark(String chMark) {
		this.chMark = chMark;
	}

	@Override
	public String toString() {
		return "modleCheckReports [chInnerId=" + chInnerId + ", chId=" + chId + ", chName=" + chName + ", chTimeStart="
				+ chTimeStart + ", chTimeEnd=" + chTimeEnd + ", chMark=" + chMark + "]";
	}
	
	
	
	
	
}
