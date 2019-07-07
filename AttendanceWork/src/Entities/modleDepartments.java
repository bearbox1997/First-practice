package Entities;
/*
 * 部门表数据模型
 */
public class modleDepartments {
	
	private String dInnerId;
	private String dId;
	private String dName;
	private String dDuty;
	private String dSuper;
	private String dDesc;
	private String dLeader;
	
	public modleDepartments(String dInnerId, String dId, String dName, String dDuty, String dSuper, String dDesc,
			String dLeader) {
		super();
		this.dInnerId = dInnerId;
		this.dId = dId;
		this.dName = dName;
		this.dDuty = dDuty;
		this.dSuper = dSuper;
		this.dDesc = dDesc;
		this.dLeader = dLeader;
	}

	public String getdInnerId() {
		return dInnerId;
	}

	public void setdInnerId(String dInnerId) {
		this.dInnerId = dInnerId;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdDuty() {
		return dDuty;
	}

	public void setdDuty(String dDuty) {
		this.dDuty = dDuty;
	}

	public String getdSuper() {
		return dSuper;
	}

	public void setdSuper(String dSuper) {
		this.dSuper = dSuper;
	}

	public String getdDesc() {
		return dDesc;
	}

	public void setdDesc(String dDesc) {
		this.dDesc = dDesc;
	}

	public String getdLeader() {
		return dLeader;
	}

	public void setdLeader(String dLeader) {
		this.dLeader = dLeader;
	}

	@Override
	public String toString() {
		return "modleDepartments [dInnerId=" + dInnerId + ", dId=" + dId + ", dName=" + dName + ", dDuty=" + dDuty
				+ ", dSuper=" + dSuper + ", dDesc=" + dDesc + ", dLeader=" + dLeader + "]";
	}
	
	
	
}
