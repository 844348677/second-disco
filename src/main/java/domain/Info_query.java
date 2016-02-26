package domain;

public class Info_query {

	private long id;

	private String APPL_ID;

	private String 信贷审批明细查询原因;

	private String query_date;

	private String query_no;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAPPL_ID() {
		return APPL_ID;
	}

	public void setAPPL_ID(String aPPL_ID) {
		APPL_ID = aPPL_ID;
	}

	public String get信贷审批明细查询原因() {
		return 信贷审批明细查询原因;
	}

	public void set信贷审批明细查询原因(String 信贷审批明细查询原因) {
		this.信贷审批明细查询原因 = 信贷审批明细查询原因;
	}

	public String getQuery_date() {
		return query_date;
	}

	public void setQuery_date(String query_date) {
		this.query_date = query_date;
	}

	public String getQuery_no() {
		return query_no;
	}

	public void setQuery_no(String query_no) {
		this.query_no = query_no;
	}
	
	
}
