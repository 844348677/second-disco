package domain;

/**
 * 征信报告id报表。主键是id，征信包报告id是reportId，对应数据库表为report_id
 * @author liuh
 *
 */
public class ReportId {

	private Long id;
	
	private String reportId;
	

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public String getReportId(){
		return reportId;
	}
	
	public void setReportId(String reportId){
		this.reportId = reportId;
	}
	
	
}
