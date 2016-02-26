package dbtest.domain;

import java.util.Date;

public class Resideinfo {
	private long id;

	private String ReportId;

	private String NO;

	private String Resideinfo_ResideStatus;

	private Date Resideinfo_InfoUpdateDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReportId() {
		return ReportId;
	}

	public void setReportId(String reportId) {
		ReportId = reportId;
	}

	public String getNO() {
		return NO;
	}

	public void setNO(String nO) {
		NO = nO;
	}

	public String getResideinfo_ResideStatus() {
		return Resideinfo_ResideStatus;
	}

	public void setResideinfo_ResideStatus(String resideinfo_ResideStatus) {
		Resideinfo_ResideStatus = resideinfo_ResideStatus;
	}

	public Date getResideinfo_InfoUpdateDate() {
		return Resideinfo_InfoUpdateDate;
	}

	public void setResideinfo_InfoUpdateDate(Date resideinfo_InfoUpdateDate) {
		Resideinfo_InfoUpdateDate = resideinfo_InfoUpdateDate;
	}
	
	
}
