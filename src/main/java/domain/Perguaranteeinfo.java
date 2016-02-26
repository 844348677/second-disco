package domain;

import java.util.Date;

public class Perguaranteeinfo {

	private long id;

	private String ReportId;

	private String Perguaranteeinfo_No;

	private String GuarLoanIssuingAgency;

	private String GuarLoanContractAmount;

	private Date GuarLoanIssueDate;

	private Date GuarLoanDueDate;

	private String GuarAmount;

	private String GuarLoanPrincipalAmount;

	private Date SettlementDate;

	private String Perguaranteeinfo_GuarLoanFiveclasscode;

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

	public String getPerguaranteeinfo_No() {
		return Perguaranteeinfo_No;
	}

	public void setPerguaranteeinfo_No(String perguaranteeinfo_No) {
		Perguaranteeinfo_No = perguaranteeinfo_No;
	}

	public String getGuarLoanIssuingAgency() {
		return GuarLoanIssuingAgency;
	}

	public void setGuarLoanIssuingAgency(String guarLoanIssuingAgency) {
		GuarLoanIssuingAgency = guarLoanIssuingAgency;
	}

	public String getGuarLoanContractAmount() {
		return GuarLoanContractAmount;
	}

	public void setGuarLoanContractAmount(String guarLoanContractAmount) {
		GuarLoanContractAmount = guarLoanContractAmount;
	}

	public Date getGuarLoanIssueDate() {
		return GuarLoanIssueDate;
	}

	public void setGuarLoanIssueDate(Date guarLoanIssueDate) {
		GuarLoanIssueDate = guarLoanIssueDate;
	}

	public Date getGuarLoanDueDate() {
		return GuarLoanDueDate;
	}

	public void setGuarLoanDueDate(Date guarLoanDueDate) {
		GuarLoanDueDate = guarLoanDueDate;
	}

	public String getGuarAmount() {
		return GuarAmount;
	}

	public void setGuarAmount(String guarAmount) {
		GuarAmount = guarAmount;
	}

	public String getGuarLoanPrincipalAmount() {
		return GuarLoanPrincipalAmount;
	}

	public void setGuarLoanPrincipalAmount(String guarLoanPrincipalAmount) {
		GuarLoanPrincipalAmount = guarLoanPrincipalAmount;
	}

	public Date getSettlementDate() {
		return SettlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		SettlementDate = settlementDate;
	}

	public String getPerguaranteeinfo_GuarLoanFiveclasscode() {
		return Perguaranteeinfo_GuarLoanFiveclasscode;
	}

	public void setPerguaranteeinfo_GuarLoanFiveclasscode(String perguaranteeinfo_GuarLoanFiveclasscode) {
		Perguaranteeinfo_GuarLoanFiveclasscode = perguaranteeinfo_GuarLoanFiveclasscode;
	}
	
	
}
