package Entities;

/*
 * 员工表数据模型
 */
public class modleEmployees {
	
	private String eEmpId;
	private String eId;
	private String eName;
	private String eSex;
	private int eAge;
	private String eNation;
	private String eDeptId;
	
//	隐藏的属性
	private String eIdNum;
	private String ePhoneNum;
	private String eEmerContact;
	private String eEmerContactPhoneNum;
	private String ePersDesc;
	private int eSalary;
	
	public modleEmployees(String eEmpId, String eId, String eName, int eAge,String eIdNum,
			int eSalary,String ePhoneNum, String eEmerContact, String eEmerContactPhoneNum,
			 String ePersDesc, String eSex,  String eNation, String eDeptId) {
		super();
		this.eEmpId = eEmpId;
		this.eId = eId;
		this.eName = eName;
		this.eSex = eSex;
		this.eAge = eAge;
		this.eNation = eNation;
		this.eDeptId = eDeptId;
		this.eIdNum = eIdNum;
		this.ePhoneNum = ePhoneNum;
		this.eEmerContact = eEmerContact;
		this.eEmerContactPhoneNum = eEmerContactPhoneNum;
		this.ePersDesc = ePersDesc;
		this.eSalary = eSalary;
	}

	public String geteEmpId() {
		return eEmpId;
	}

	public void seteEmpId(String eEmpId) {
		this.eEmpId = eEmpId;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteSex() {
		return eSex;
	}

	public void seteSex(String eSex) {
		this.eSex = eSex;
	}

	public int geteAge() {
		return eAge;
	}

	public void seteAge(int eAge) {
		this.eAge = eAge;
	}

	public String geteNation() {
		return eNation;
	}

	public void seteNation(String eNation) {
		this.eNation = eNation;
	}

	public String geteDeptId() {
		return eDeptId;
	}

	public void seteDeptId(String eDeptId) {
		this.eDeptId = eDeptId;
	}

	public String geteIdNum() {
		return eIdNum;
	}

	public void seteIdNum(String eIdNum) {
		this.eIdNum = eIdNum;
	}

	public String getePhoneNum() {
		return ePhoneNum;
	}

	public void setePhoneNum(String ePhoneNum) {
		this.ePhoneNum = ePhoneNum;
	}

	public String geteEmerContact() {
		return eEmerContact;
	}

	public void seteEmerContact(String eEmerContact) {
		this.eEmerContact = eEmerContact;
	}

	public String geteEmerContactPhoneNum() {
		return eEmerContactPhoneNum;
	}

	public void seteEmerContactPhoneNum(String eEmerContactPhoneNum) {
		this.eEmerContactPhoneNum = eEmerContactPhoneNum;
	}

	public String getePersDesc() {
		return ePersDesc;
	}

	public void setePersDesc(String ePersDesc) {
		this.ePersDesc = ePersDesc;
	}

	public int geteSalary() {
		return eSalary;
	}

	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}

	@Override
	public String toString() {
		return "modleEmployees [eEmpId=" + eEmpId + ", eId=" + eId + ", eName=" + eName + ", eSex=" + eSex + ", eAge="
				+ eAge + ", eNation=" + eNation + ", eDeptId=" + eDeptId + ", eIdNum=" + eIdNum + ", ePhoneNum="
				+ ePhoneNum + ", eEmerContact=" + eEmerContact + ", eEmerContactPhoneNum=" + eEmerContactPhoneNum
				+ ", ePersDesc=" + ePersDesc + ", eSalary=" + eSalary + "]";
	}
	
	
	
	
}
