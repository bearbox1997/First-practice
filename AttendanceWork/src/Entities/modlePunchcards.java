package Entities;
/*
 * 打卡表数据模型
 */
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;

public class modlePunchcards {
	
	private String pInnerId;
	private String pId;
	private String pName;
	private Date pDateTime;
	
	public modlePunchcards(String pInnerId, String pId, String pName, Date pDateTime) {
		super();
		this.pInnerId = pInnerId;
		this.pId = pId;
		this.pName = pName;
		this.pDateTime = pDateTime;
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

	public Date getpDateTime() {
		return pDateTime;
	}

	public void setpDateTime(Date pDateTime) {
		this.pDateTime = pDateTime;
	}

	@Override
	public String toString() {
		return "modlePunchcards [pInnerId=" + pInnerId + ", pId=" + pId + ", pName=" + pName + ", pDateTime="
				+ pDateTime + "]";
	}
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		Date pDateTime = new Date();
//		String pattern = "yyyy-MM-dd HH:mm:ss";
//		SimpleDateFormat sdf= new SimpleDateFormat(pattern);
//		String datestr=sdf.format(pDateTime);
//		System.out.println(datestr);
//	}
//	
	
}
