package domain;

import java.util.Date;

public class Pboc_loan_stypes {
	
	private long id;

	private String ReportId;

	private String loan_num;

	private String SpecTraType;

	private String SpecTraDetailed;

	private Date SpecTraDate;

	private String Pboc_loan_stypes_SpecTraAmount;

	private String Pboc_loan_stypes_SpecTraChanMonthNum;

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

	public String getLoan_num() {
		return loan_num;
	}

	public void setLoan_num(String loan_num) {
		this.loan_num = loan_num;
	}

	public String getSpecTraType() {
		return SpecTraType;
	}

	public void setSpecTraType(String specTraType) {
		SpecTraType = specTraType;
	}

	public String getSpecTraDetailed() {
		return SpecTraDetailed;
	}

	public void setSpecTraDetailed(String specTraDetailed) {
		SpecTraDetailed = specTraDetailed;
	}

	public Date getSpecTraDate() {
		return SpecTraDate;
	}

	public void setSpecTraDate(Date specTraDate) {
		SpecTraDate = specTraDate;
	}

	public String getPboc_loan_stypes_SpecTraAmount() {
		return Pboc_loan_stypes_SpecTraAmount;
	}

	public void setPboc_loan_stypes_SpecTraAmount(String pboc_loan_stypes_SpecTraAmount) {
		Pboc_loan_stypes_SpecTraAmount = pboc_loan_stypes_SpecTraAmount;
	}

	public String getPboc_loan_stypes_SpecTraChanMonthNum() {
		return Pboc_loan_stypes_SpecTraChanMonthNum;
	}

	public void setPboc_loan_stypes_SpecTraChanMonthNum(String pboc_loan_stypes_SpecTraChanMonthNum) {
		Pboc_loan_stypes_SpecTraChanMonthNum = pboc_loan_stypes_SpecTraChanMonthNum;
	}
	
	
}
