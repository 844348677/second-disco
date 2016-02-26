package domain;

import java.util.Date;

public class Occupationinfo {

	private long id;

	private String ReportId;

	private String Occupation;

	private String CompanyType;

	private String Position;

	private String PostTitle;

	private Date Occupationinfo_InfoUpdateDate;

	private String Occupationinfo_NoEmploy;

	private String Occupationinfo_EmployedYear;
	
	private String 职业信息工作单位;
	
	private String 职业信息单位地址;

	public String get职业信息工作单位() {
		return 职业信息工作单位;
	}

	public void set职业信息工作单位(String 职业信息工作单位) {
		this.职业信息工作单位 = 职业信息工作单位;
	}

	public String get职业信息单位地址() {
		return 职业信息单位地址;
	}

	public void set职业信息单位地址(String 职业信息单位地址) {
		this.职业信息单位地址 = 职业信息单位地址;
	}

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

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getCompanyType() {
		return CompanyType;
	}

	public void setCompanyType(String companyType) {
		CompanyType = companyType;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getPostTitle() {
		return PostTitle;
	}

	public void setPostTitle(String postTitle) {
		PostTitle = postTitle;
	}

	public Date getOccupationinfo_InfoUpdateDate() {
		return Occupationinfo_InfoUpdateDate;
	}

	public void setOccupationinfo_InfoUpdateDate(Date occupationinfo_InfoUpdateDate) {
		Occupationinfo_InfoUpdateDate = occupationinfo_InfoUpdateDate;
	}

	public String getOccupationinfo_NoEmploy() {
		return Occupationinfo_NoEmploy;
	}

	public void setOccupationinfo_NoEmploy(String occupationinfo_NoEmploy) {
		Occupationinfo_NoEmploy = occupationinfo_NoEmploy;
	}

	public String getOccupationinfo_EmployedYear() {
		return Occupationinfo_EmployedYear;
	}

	public void setOccupationinfo_EmployedYear(String occupationinfo_EmployedYear) {
		Occupationinfo_EmployedYear = occupationinfo_EmployedYear;
	}
	
}
