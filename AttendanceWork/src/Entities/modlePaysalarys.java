package Entities;
/*
 * 派薪单数据模型
 */
import java.util.Date;

public class modlePaysalarys {
	private String pInnerId;
	private String pId;
	private String pName;
	private int pSalary;
	private Date pTimeStart;
	private Date pTimeEnd;
	private int pHours;
	
	public modlePaysalarys(String pInnerId, String pId, String pName, int pSalary, Date pTimeStart, Date pTimeEnd,
			int pHours) {
		super();
		this.pInnerId = pInnerId;
		this.pId = pId;
		this.pName = pName;
		this.pSalary = pSalary;
		this.pTimeStart = pTimeStart;
		this.pTimeEnd = pTimeEnd;
		this.pHours = pHours;
	}

	public String getpInnerId() {
		return pInnerId;
	}

	public void setpInnerId(String pInnerId) {
		this.pInnerId = pInnerId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpSalary() {
		return pSalary;
	}

	public void setpSalary(int pSalary) {
		this.pSalary = pSalary;
	}

	public Date getpTimeStart() {
		return pTimeStart;
	}

	public void setpTimeStart(Date pTimeStart) {
		this.pTimeStart = pTimeStart;
	}

	public Date getpTimeEnd() {
		return pTimeEnd;
	}

	public void setpTimeEnd(Date pTimeEnd) {
		this.pTimeEnd = pTimeEnd;
	}

	public int getpHours() {
		return pHours;
	}

	public void setpHours(int pHours) {
		this.pHours = pHours;
	}

	@Override
	public String toString() {
		return "modlePaysalarys [pInnerId=" + pInnerId + ", pId=" + pId + ", pName=" + pName + ", pSalary=" + pSalary
				+ ", pTimeStart=" + pTimeStart + ", pTimeEnd=" + pTimeEnd + ", pHours=" + pHours + "]";
	}
	
	
	
}
