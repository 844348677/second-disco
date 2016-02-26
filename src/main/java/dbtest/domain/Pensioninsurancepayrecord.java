package dbtest.domain;

import java.util.Date;

public class Pensioninsurancepayrecord {

	private long id;

	private String ReportId;

	private String PayArea;

	private String PayState;

	private String CancelPayReason;

	private Date InfoUpdateDate;

	private Date PayDate;

	private String CumulativePayMonths;

	private String PersonPayBase;

	private String ThisMonthPayAmount;

	private String Pensioninsurancepayrecord_WorkMonth;

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

	public String getPayArea() {
		return PayArea;
	}

	public void setPayArea(String payArea) {
		PayArea = payArea;
	}

	public String getPayState() {
		return PayState;
	}

	public void setPayState(String payState) {
		PayState = payState;
	}

	public String getCancelPayReason() {
		return CancelPayReason;
	}

	public void setCancelPayReason(String cancelPayReason) {
		CancelPayReason = cancelPayReason;
	}

	public Date getInfoUpdateDate() {
		return InfoUpdateDate;
	}

	public void setInfoUpdateDate(Date infoUpdateDate) {
		InfoUpdateDate = infoUpdateDate;
	}

	public Date getPayDate() {
		return PayDate;
	}

	public void setPayDate(Date payDate) {
		PayDate = payDate;
	}

	public String getCumulativePayMonths() {
		return CumulativePayMonths;
	}

	public void setCumulativePayMonths(String cumulativePayMonths) {
		CumulativePayMonths = cumulativePayMonths;
	}

	public String getPersonPayBase() {
		return PersonPayBase;
	}

	public void setPersonPayBase(String personPayBase) {
		PersonPayBase = personPayBase;
	}

	public String getThisMonthPayAmount() {
		return ThisMonthPayAmount;
	}

	public void setThisMonthPayAmount(String thisMonthPayAmount) {
		ThisMonthPayAmount = thisMonthPayAmount;
	}

	public String getPensioninsurancepayrecord_WorkMonth() {
		return Pensioninsurancepayrecord_WorkMonth;
	}

	public void setPensioninsurancepayrecord_WorkMonth(String pensioninsurancepayrecord_WorkMonth) {
		Pensioninsurancepayrecord_WorkMonth = pensioninsurancepayrecord_WorkMonth;
	}
	
}
