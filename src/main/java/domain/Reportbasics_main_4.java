package domain;

import java.util.Date;

/**
 * 征信报告自填写内容表
 * @author liuh
 *
 */
public class Reportbasics_main_4 {
/*	
	*//**
	 * oa_status:什么属性我也不知道，拒绝、同意、逾期 
	 *//*
	private String oaStatus;
	
	*//**
	 * APPL_ID:征信报告自填写表id 
	 *//*
	private String applId;
	
	*//**
	 * oa_loan_amt:oa_result为同意时都有数据，拒绝是为空
	 *//*
	private String oaLoanAmt;
	
	*//**
	 * oa_result:同意、拒绝
	 *//*
	private String  oaResult;
	
	*//**
	 * oa_opinion:拒绝都是因为什么原因拒绝的
	 *//*
	private String oaOpinion;
	
	*//**
	 * 客户类别:自雇受薪
	 *//*
	private String customerType;    
	
	*//**
	 * 保密与否:Y　N (空值)
	 *//*
	private String secrecy;
	
	*//**
	 * 车辆购买贷款总额: 数值 0 空
	 *//*
	private String vehiclePurchaseLoan;*/
	
	private long id;

	private String oa_status;

	private String APPL_ID;

	private String oa_loan_amt;

	private String oa_result;

	private String oa_opinion;

	private String 客户类别;

	private String 保密与否;

	private String 车辆购买贷款总额;

	private String 车辆购买方式;

	private String 车辆月付贷款;

	private String 贷款产品;

	private String 贷款用途;

	private String 单位人数;

	private String 房产购买总额;

	private String 房产月付贷款;

	private String 放款金额;

	private String 放款期限;

	private String 个体经营类型;

	private String 工资发放方式;

	private String 雇员人数;

	private String 行业;

	private String 婚姻状况;

	private String 教育程度;

	private String 经营场所所有;

	private String 经营场所月供金额;

	private String 经营场所月租金额;

	private String 居住地址省份城市;

	private String 每月房租;

	private String 年龄;

	private String 商品房及商铺数目;

	private String 申请额度;

	private String 申请期限;

	private String 同住人数;

	private String 现单位起始工作年数;

	private String 现住址起始居住年数;

	private String 小孩是否在深圳;

	private String 性别;

	private String 月均营业额;

	private String 月收入;

	private String 自有物业类型;

	private String 居住年数;

	private String 居住月数;

	private String 按揭;

	private String ReportId;

	private Date ReportTime;

	private String 贷款发放日期;

	private String 贷款到期日期;

	private String CUST_ID;

	private String 每月支薪日;

	private String Reportbasics_main_4_PRVT_QUARTER_INT;

	private String Reportbasics_main_4_oa_housetype;

	private String Reportbasics_main_4_PRVT_LAST_QUARTER_INT;

	private Date Reportbasics_main_4_appl_date;

	private String Reportbasics_main_4_PRVT_BAL;

	private String Reportbasics_main_4_PUBLIC_LAST_QUARTER_INT;

	private String Reportbasics_main_4_oa_maritalstatus;

	private String Reportbasics_main_4_oa_appl_amt;

	private String Reportbasics_main_4_city;

	private String Reportbasics_main_4_PUBLIC_QUARTER_INT;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOa_status() {
		return oa_status;
	}

	public void setOa_status(String oa_status) {
		this.oa_status = oa_status;
	}

	public String getAPPL_ID() {
		return APPL_ID;
	}

	public void setAPPL_ID(String aPPL_ID) {
		APPL_ID = aPPL_ID;
	}

	public String getOa_loan_amt() {
		return oa_loan_amt;
	}

	public void setOa_loan_amt(String oa_loan_amt) {
		this.oa_loan_amt = oa_loan_amt;
	}

	public String getOa_result() {
		return oa_result;
	}

	public void setOa_result(String oa_result) {
		this.oa_result = oa_result;
	}

	public String getOa_opinion() {
		return oa_opinion;
	}

	public void setOa_opinion(String oa_opinion) {
		this.oa_opinion = oa_opinion;
	}

	public String get客户类别() {
		return 客户类别;
	}

	public void set客户类别(String 客户类别) {
		this.客户类别 = 客户类别;
	}

	public String get保密与否() {
		return 保密与否;
	}

	public void set保密与否(String 保密与否) {
		this.保密与否 = 保密与否;
	}

	public String get车辆购买贷款总额() {
		return 车辆购买贷款总额;
	}

	public void set车辆购买贷款总额(String 车辆购买贷款总额) {
		this.车辆购买贷款总额 = 车辆购买贷款总额;
	}

	public String get车辆购买方式() {
		return 车辆购买方式;
	}

	public void set车辆购买方式(String 车辆购买方式) {
		this.车辆购买方式 = 车辆购买方式;
	}

	public String get车辆月付贷款() {
		return 车辆月付贷款;
	}

	public void set车辆月付贷款(String 车辆月付贷款) {
		this.车辆月付贷款 = 车辆月付贷款;
	}

	public String get贷款产品() {
		return 贷款产品;
	}

	public void set贷款产品(String 贷款产品) {
		this.贷款产品 = 贷款产品;
	}

	public String get贷款用途() {
		return 贷款用途;
	}

	public void set贷款用途(String 贷款用途) {
		this.贷款用途 = 贷款用途;
	}

	public String get单位人数() {
		return 单位人数;
	}

	public void set单位人数(String 单位人数) {
		this.单位人数 = 单位人数;
	}

	public String get房产购买总额() {
		return 房产购买总额;
	}

	public void set房产购买总额(String 房产购买总额) {
		this.房产购买总额 = 房产购买总额;
	}

	public String get房产月付贷款() {
		return 房产月付贷款;
	}

	public void set房产月付贷款(String 房产月付贷款) {
		this.房产月付贷款 = 房产月付贷款;
	}

	public String get放款金额() {
		return 放款金额;
	}

	public void set放款金额(String 放款金额) {
		this.放款金额 = 放款金额;
	}

	public String get放款期限() {
		return 放款期限;
	}

	public void set放款期限(String 放款期限) {
		this.放款期限 = 放款期限;
	}

	public String get个体经营类型() {
		return 个体经营类型;
	}

	public void set个体经营类型(String 个体经营类型) {
		this.个体经营类型 = 个体经营类型;
	}

	public String get工资发放方式() {
		return 工资发放方式;
	}

	public void set工资发放方式(String 工资发放方式) {
		this.工资发放方式 = 工资发放方式;
	}

	public String get雇员人数() {
		return 雇员人数;
	}

	public void set雇员人数(String 雇员人数) {
		this.雇员人数 = 雇员人数;
	}

	public String get行业() {
		return 行业;
	}

	public void set行业(String 行业) {
		this.行业 = 行业;
	}

	public String get婚姻状况() {
		return 婚姻状况;
	}

	public void set婚姻状况(String 婚姻状况) {
		this.婚姻状况 = 婚姻状况;
	}

	public String get教育程度() {
		return 教育程度;
	}

	public void set教育程度(String 教育程度) {
		this.教育程度 = 教育程度;
	}

	public String get经营场所所有() {
		return 经营场所所有;
	}

	public void set经营场所所有(String 经营场所所有) {
		this.经营场所所有 = 经营场所所有;
	}

	public String get经营场所月供金额() {
		return 经营场所月供金额;
	}

	public void set经营场所月供金额(String 经营场所月供金额) {
		this.经营场所月供金额 = 经营场所月供金额;
	}

	public String get经营场所月租金额() {
		return 经营场所月租金额;
	}

	public void set经营场所月租金额(String 经营场所月租金额) {
		this.经营场所月租金额 = 经营场所月租金额;
	}

	public String get居住地址省份城市() {
		return 居住地址省份城市;
	}

	public void set居住地址省份城市(String 居住地址省份城市) {
		this.居住地址省份城市 = 居住地址省份城市;
	}

	public String get每月房租() {
		return 每月房租;
	}

	public void set每月房租(String 每月房租) {
		this.每月房租 = 每月房租;
	}

	public String get年龄() {
		return 年龄;
	}

	public void set年龄(String 年龄) {
		this.年龄 = 年龄;
	}

	public String get商品房及商铺数目() {
		return 商品房及商铺数目;
	}

	public void set商品房及商铺数目(String 商品房及商铺数目) {
		this.商品房及商铺数目 = 商品房及商铺数目;
	}

	public String get申请额度() {
		return 申请额度;
	}

	public void set申请额度(String 申请额度) {
		this.申请额度 = 申请额度;
	}

	public String get申请期限() {
		return 申请期限;
	}

	public void set申请期限(String 申请期限) {
		this.申请期限 = 申请期限;
	}

	public String get同住人数() {
		return 同住人数;
	}

	public void set同住人数(String 同住人数) {
		this.同住人数 = 同住人数;
	}

	public String get现单位起始工作年数() {
		return 现单位起始工作年数;
	}

	public void set现单位起始工作年数(String 现单位起始工作年数) {
		this.现单位起始工作年数 = 现单位起始工作年数;
	}

	public String get现住址起始居住年数() {
		return 现住址起始居住年数;
	}

	public void set现住址起始居住年数(String 现住址起始居住年数) {
		this.现住址起始居住年数 = 现住址起始居住年数;
	}

	public String get小孩是否在深圳() {
		return 小孩是否在深圳;
	}

	public void set小孩是否在深圳(String 小孩是否在深圳) {
		this.小孩是否在深圳 = 小孩是否在深圳;
	}

	public String get性别() {
		return 性别;
	}

	public void set性别(String 性别) {
		this.性别 = 性别;
	}

	public String get月均营业额() {
		return 月均营业额;
	}

	public void set月均营业额(String 月均营业额) {
		this.月均营业额 = 月均营业额;
	}

	public String get月收入() {
		return 月收入;
	}

	public void set月收入(String 月收入) {
		this.月收入 = 月收入;
	}

	public String get自有物业类型() {
		return 自有物业类型;
	}

	public void set自有物业类型(String 自有物业类型) {
		this.自有物业类型 = 自有物业类型;
	}

	public String get居住年数() {
		return 居住年数;
	}

	public void set居住年数(String 居住年数) {
		this.居住年数 = 居住年数;
	}

	public String get居住月数() {
		return 居住月数;
	}

	public void set居住月数(String 居住月数) {
		this.居住月数 = 居住月数;
	}

	public String get按揭() {
		return 按揭;
	}

	public void set按揭(String 按揭) {
		this.按揭 = 按揭;
	}

	public String getReportId() {
		return ReportId;
	}

	public void setReportId(String reportId) {
		ReportId = reportId;
	}

	public Date getReportTime() {
		return ReportTime;
	}

	public void setReportTime(Date reportTime) {
		ReportTime = reportTime;
	}

	public String get贷款发放日期() {
		return 贷款发放日期;
	}

	public void set贷款发放日期(String 贷款发放日期) {
		this.贷款发放日期 = 贷款发放日期;
	}

	public String get贷款到期日期() {
		return 贷款到期日期;
	}

	public void set贷款到期日期(String 贷款到期日期) {
		this.贷款到期日期 = 贷款到期日期;
	}

	public String getCUST_ID() {
		return CUST_ID;
	}

	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}

	public String get每月支薪日() {
		return 每月支薪日;
	}

	public void set每月支薪日(String 每月支薪日) {
		this.每月支薪日 = 每月支薪日;
	}

	public String getReportbasics_main_4_PRVT_QUARTER_INT() {
		return Reportbasics_main_4_PRVT_QUARTER_INT;
	}

	public void setReportbasics_main_4_PRVT_QUARTER_INT(String reportbasics_main_4_PRVT_QUARTER_INT) {
		Reportbasics_main_4_PRVT_QUARTER_INT = reportbasics_main_4_PRVT_QUARTER_INT;
	}

	public String getReportbasics_main_4_oa_housetype() {
		return Reportbasics_main_4_oa_housetype;
	}

	public void setReportbasics_main_4_oa_housetype(String reportbasics_main_4_oa_housetype) {
		Reportbasics_main_4_oa_housetype = reportbasics_main_4_oa_housetype;
	}

	public String getReportbasics_main_4_PRVT_LAST_QUARTER_INT() {
		return Reportbasics_main_4_PRVT_LAST_QUARTER_INT;
	}

	public void setReportbasics_main_4_PRVT_LAST_QUARTER_INT(String reportbasics_main_4_PRVT_LAST_QUARTER_INT) {
		Reportbasics_main_4_PRVT_LAST_QUARTER_INT = reportbasics_main_4_PRVT_LAST_QUARTER_INT;
	}

	public Date getReportbasics_main_4_appl_date() {
		return Reportbasics_main_4_appl_date;
	}

	public void setReportbasics_main_4_appl_date(Date reportbasics_main_4_appl_date) {
		Reportbasics_main_4_appl_date = reportbasics_main_4_appl_date;
	}

	public String getReportbasics_main_4_PRVT_BAL() {
		return Reportbasics_main_4_PRVT_BAL;
	}

	public void setReportbasics_main_4_PRVT_BAL(String reportbasics_main_4_PRVT_BAL) {
		Reportbasics_main_4_PRVT_BAL = reportbasics_main_4_PRVT_BAL;
	}

	public String getReportbasics_main_4_PUBLIC_LAST_QUARTER_INT() {
		return Reportbasics_main_4_PUBLIC_LAST_QUARTER_INT;
	}

	public void setReportbasics_main_4_PUBLIC_LAST_QUARTER_INT(String reportbasics_main_4_PUBLIC_LAST_QUARTER_INT) {
		Reportbasics_main_4_PUBLIC_LAST_QUARTER_INT = reportbasics_main_4_PUBLIC_LAST_QUARTER_INT;
	}

	public String getReportbasics_main_4_oa_maritalstatus() {
		return Reportbasics_main_4_oa_maritalstatus;
	}

	public void setReportbasics_main_4_oa_maritalstatus(String reportbasics_main_4_oa_maritalstatus) {
		Reportbasics_main_4_oa_maritalstatus = reportbasics_main_4_oa_maritalstatus;
	}

	public String getReportbasics_main_4_oa_appl_amt() {
		return Reportbasics_main_4_oa_appl_amt;
	}

	public void setReportbasics_main_4_oa_appl_amt(String reportbasics_main_4_oa_appl_amt) {
		Reportbasics_main_4_oa_appl_amt = reportbasics_main_4_oa_appl_amt;
	}

	public String getReportbasics_main_4_city() {
		return Reportbasics_main_4_city;
	}

	public void setReportbasics_main_4_city(String reportbasics_main_4_city) {
		Reportbasics_main_4_city = reportbasics_main_4_city;
	}

	public String getReportbasics_main_4_PUBLIC_QUARTER_INT() {
		return Reportbasics_main_4_PUBLIC_QUARTER_INT;
	}

	public void setReportbasics_main_4_PUBLIC_QUARTER_INT(String reportbasics_main_4_PUBLIC_QUARTER_INT) {
		Reportbasics_main_4_PUBLIC_QUARTER_INT = reportbasics_main_4_PUBLIC_QUARTER_INT;
	}
	
	

	
}
