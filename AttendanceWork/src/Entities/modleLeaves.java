package Entities;

import java.util.Date;
/*
 * 请假表数据模型
 */
public class modleLeaves {
	

	private String qInnerId;
	private String qId;
	private String qName;
	private Date qTimeStart;
	private Date qTimeEnd;
	private String qDesc;
	
	public modleLeaves(String qInnerId, String qId, String qName, Date qTimeStart, Date qTimeEnd, String qDesc) {
		super();
		this.qInnerId = qInnerId;
		this.qId = qId;
		this.qName = qName;
		this.qTimeStart = qTimeStart;
		this.qTimeEnd = qTimeEnd;
		this.qDesc = qDesc;
	}

	public String getqInnerId() {
		return qInnerId;
	}

	public void setqInnerId(String qInnerId) {
		this.qInnerId = qInnerId;
	}

	public String getqId() {
		return qId;
	}

	public void setqId(String qId) {
		this.qId = qId;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public Date getqTimeStart() {
		return qTimeStart;
	}

	public void setqTimeStart(Date qTimeStart) {
		this.qTimeStart = qTimeStart;
	}

	public Date getqTimeEnd() {
		return qTimeEnd;
	}

	public void setqTimeEnd(Date qTimeEnd) {
		this.qTimeEnd = qTimeEnd;
	}

	public String getqDesc() {
		return qDesc;
	}

	public void setqDesc(String qDesc) {
		this.qDesc = qDesc;
	}

	@Override
	public String toString() {
		return "modleLeaves [qInnerId=" + qInnerId + ", qId=" + qId + ", qName=" + qName + ", qTimeStart=" + qTimeStart
				+ ", qTimeEnd=" + qTimeEnd + ", qDesc=" + qDesc + "]";
	}
	

}
