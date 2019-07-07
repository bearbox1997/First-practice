package Entities;

import java.sql.Time;
/*
 * 班次表数据模型
 */
public class modleClasses {
	
	private String cInnerId;
	private String cId;
	private String cName;
	private Time cTimeStart;
	private Time cTimeEnd;
	
	public modleClasses(String cInnerId, String cId, String cName, Time cTimeStart, Time cTimeEnd) {
		super();
		this.cInnerId = cInnerId;
		this.cId = cId;
		this.cName = cName;
		this.cTimeStart = cTimeStart;
		this.cTimeEnd = cTimeEnd;
	}

	public String getcInnerId() {
		return cInnerId;
	}

	public void setcInnerId(String cInnerId) {
		this.cInnerId = cInnerId;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Time getcTimeStart() {
		return cTimeStart;
	}

	public void setcTimeStart(Time cTimeStart) {
		this.cTimeStart = cTimeStart;
	}

	public Time getcTimeEnd() {
		return cTimeEnd;
	}

	public void setcTimeEnd(Time cTimeEnd) {
		this.cTimeEnd = cTimeEnd;
	}

	@Override
	public String toString() {
		return "modleClasses [cInnerId=" + cInnerId + ", cId=" + cId + ", cName=" + cName + ", cTimeStart=" + cTimeStart
				+ ", cTimeEnd=" + cTimeEnd + "]";
	}
	
	
	
}
