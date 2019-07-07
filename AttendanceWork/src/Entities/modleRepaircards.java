package Entities;

import java.util.Date;
/*
 * 补卡表数据模型
 */
public class modleRepaircards {
	

	private String rrInnerId;
	private String rrId;
	private String rrName;
	private Date rrDateTime;
	private String rrDesc;
	
	public modleRepaircards(String rrInnerId, String rrId, String rrName, Date rrDateTime, String rrDesc) {
		super();
		this.rrInnerId = rrInnerId;
		this.rrId = rrId;
		this.rrName = rrName;
		this.rrDateTime = rrDateTime;
		this.rrDesc = rrDesc;
	}

	public String getRrInnerId() {
		return rrInnerId;
	}

	public void setRrInnerId(String rrInnerId) {
		this.rrInnerId = rrInnerId;
	}

	public String getRrId() {
		return rrId;
	}

	public void setRrId(String rrId) {
		this.rrId = rrId;
	}

	public String getRrName() {
		return rrName;
	}

	public void setRrName(String rrName) {
		this.rrName = rrName;
	}

	public Date getRrDateTime() {
		return rrDateTime;
	}

	public void setRrDateTime(Date rrDateTime) {
		this.rrDateTime = rrDateTime;
	}

	public String getRrDesc() {
		return rrDesc;
	}

	public void setRrDesc(String rrDesc) {
		this.rrDesc = rrDesc;
	}

	@Override
	public String toString() {
		return "modleRepaircards [rrInnerId=" + rrInnerId + ", rrId=" + rrId + ", rrName=" + rrName + ", rrDateTime="
				+ rrDateTime + ", rrDesc=" + rrDesc + "]";
	}
	
	
	
}
