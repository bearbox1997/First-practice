package Entities;
/*
 * 岗位表数据模型
 */
public class modleJobs {

	private String jInnerId;
	private String jId;
	private String jName;
	private String jDesc;
	private String jParent;
	private String jSuper;
	private String jType;
	
	public modleJobs(String jInnerId, String jId, String jName, String jDesc, String jParent, String jSuper,
			String jType) {
		super();
		this.jInnerId = jInnerId;
		this.jId = jId;
		this.jName = jName;
		this.jDesc = jDesc;
		this.jParent = jParent;
		this.jSuper = jSuper;
		this.jType = jType;
	}

	public String getjInnerId() {
		return jInnerId;
	}

	public void setjInnerId(String jInnerId) {
		this.jInnerId = jInnerId;
	}

	public String getjId() {
		return jId;
	}

	public void setjId(String jId) {
		this.jId = jId;
	}

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	public String getjDesc() {
		return jDesc;
	}

	public void setjDesc(String jDesc) {
		this.jDesc = jDesc;
	}

	public String getjParent() {
		return jParent;
	}

	public void setjParent(String jParent) {
		this.jParent = jParent;
	}

	public String getjSuper() {
		return jSuper;
	}

	public void setjSuper(String jSuper) {
		this.jSuper = jSuper;
	}

	public String getjType() {
		return jType;
	}

	public void setjType(String jType) {
		this.jType = jType;
	}

	@Override
	public String toString() {
		return "modleJobs [jInnerId=" + jInnerId + ", jId=" + jId + ", jName=" + jName + ", jDesc=" + jDesc
				+ ", jParent=" + jParent + ", jSuper=" + jSuper + ", jType=" + jType + "]";
	}
	
	


}
