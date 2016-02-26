package dbtest.domain;

import java.util.Date;

public class Identityinfo {
	
	private long id;

	private String ReportId;

	private String MaritalStatus;

	private String Degree;

	private String Identityinfo_Gender;

	private String Identityinfo_Education;

	private Date Identityinfo_DateOfBirth;

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

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getDegree() {
		return Degree;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}

	public String getIdentityinfo_Gender() {
		return Identityinfo_Gender;
	}

	public void setIdentityinfo_Gender(String identityinfo_Gender) {
		Identityinfo_Gender = identityinfo_Gender;
	}

	public String getIdentityinfo_Education() {
		return Identityinfo_Education;
	}

	public void setIdentityinfo_Education(String identityinfo_Education) {
		Identityinfo_Education = identityinfo_Education;
	}

	public Date getIdentityinfo_DateOfBirth() {
		return Identityinfo_DateOfBirth;
	}

	public void setIdentityinfo_DateOfBirth(Date identityinfo_DateOfBirth) {
		Identityinfo_DateOfBirth = identityinfo_DateOfBirth;
	}

	
}
