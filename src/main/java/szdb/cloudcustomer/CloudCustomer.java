package szdb.cloudcustomer;

import com.hdd.szdb.domain.Add_info_22;
import com.hdd.szdb.domain.NewData;

/**
 * Created by liuh on 2016/1/26.
 */
public class CloudCustomer {


    private NewData dd ;
    private Add_info_22 ai ;
    
    public NewData getDD(){
    	return this.dd;
    }
    public void setDD(NewData dd){
    	this.dd = dd;
    }
    
    public Add_info_22 getAI(){
    	return this.ai;
    }
    public void setAI(Add_info_22 ai){
    	this.ai = ai ;
    }
    
	
    /**
     * 贷记卡最近24个月逾期1期最多次数
     */
    public static final Double LOAN_CARD_COUNT_DELY_MAX = 52.0;

    /**
     * 信用卡最近6个月查询最大次数
     */
    public static final Double CREIT_CARD_SIX_MONTH_QUERY_COUNT_MAX = 21.0;
    //贷款最近2个月查询最大次数
    public static final Double LOAN_TWO_MONTH_QUERY_COUNT_MAX = 16.0;
    //最近1个月内的查询最大次数-贷款审批
    public static final Double AUDIT_ONE_MONTH_QUERY_COUNT_MAX = 11.0;
    //信用卡最近3个月查询最大次数
    public static final Double CREIT_CARD_THREE_MONTH_QUERY_COUNT_MAX = 15.0;
    //其他贷款笔数
    public static final Double OTHER_LOAN_COUNT_MAX = 25.0;
    //最近2年内的查询次数-贷后管理
    public static final Double LOAN_MANAGE_MAX = 93.0;
    //近2年内 担保资格审查 查询次数
    public static final Double GUARANTEE_BI_YEARLY_QUERIED_MAX = 13.0;

    public CloudCustomer(){

    }
    /**
     * 贷记卡最近24个月逾期1期次数
     */
    //@JSONField(name="loan_card_delayed")
    private Double loanCardDelyCount;

    /**
     * 信用卡最近6个月查询次数
     */
   // @JSONField(name="credit_card_half_yearly_queried")
    private Double creitCard6QueryCount;

    /**
     * 贷款最近2个月查询次数
     */
    //@JSONField(name="loan_queried")
    private Double loanQueryCount;

    /**
     * 房产类型,租用=1,自有=0
     */
    //@JSONField(name="property_kind")
    private Double propertyType;

    /**
     * 最近1个月内的查询次数-贷款审批
     */
   // @JSONField(name="audit_queried")
    private Double auditQueryCount;

    /**
     * 信用卡最近3个月查询次数
     */
    //@JSONField(name="credit_card_quarterly_queried")
    private Double creitCard3QueryCount;

    /**
     * 其他贷款笔数
     */
   // @JSONField(name="other_loan")
    private Double otherLoan;

    /**
     * 最近2年内的查询次数-贷后管理
     */
   // @JSONField(name="loan_bi_yearly_queried")
    private Double loanManage;

    /**
     * 近2年内 担保资格审查 查询次数
     */
   // @JSONField(name="guarantee_bi_yearly_queried")
    private Double guaranteeQueried;
    /**
     * 未结清贷款-最近六个月平均应还款
     */
   // @JSONField(name="half_yearly_unpaid")
    private Double avgRepayment;

    /**
     * 放款金额
     */
   // @JSONField(name="loan_amount")
    private Double loanMoney;

    /**
     * 当季个人结息
     */
  //  @JSONField(name="current_person_interest")
    private Double currentInterest;


    /**
     * 上季个人结息
     */
   // @JSONField(name="previous_person_interest")
    private Double prevInterest;

    /**
     * 当季对公结息
     */
   // @JSONField(name="current_company_interest")
    private Double currentPubInterest;

    /**
     * 上季对公结息
     */
  //  @JSONField(name="previous_company_interest")
    private Double prevPubInterest;


    private Double liveType;

    public  Double getLiveType(){
        return liveType;
    }

    public  void setLiveType(Double liveType){

        this.liveType = liveType;
    }

    public Double getLoanCardDelyCount() {
        //归一化
        double count  = CeritUtil.one(loanCardDelyCount, LOAN_CARD_COUNT_DELY_MAX);
        return count;
    }
    public void setLoanCardDelyCount(Double loanCardDelyCount) {
        this.loanCardDelyCount = loanCardDelyCount;
    }

    public Double getCreitCard6QueryCount() {
        double count = CeritUtil.one(creitCard6QueryCount, CREIT_CARD_SIX_MONTH_QUERY_COUNT_MAX);
        return count;
    }

    public void setCreitCard6QueryCount(Double creitCard6QueryCount) {
        this.creitCard6QueryCount = creitCard6QueryCount;
    }

    public Double getLoanQueryCount() {
        double count = CeritUtil.one(loanQueryCount, LOAN_TWO_MONTH_QUERY_COUNT_MAX);
        return count;
    }

    public void setLoanQueryCount(Double loanQueryCount) {
        this.loanQueryCount = loanQueryCount;
    }

    public Double getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Double propertyType) {
        this.propertyType = propertyType;
    }

    public Double getAuditQueryCount() {
        double count = CeritUtil.one(auditQueryCount, AUDIT_ONE_MONTH_QUERY_COUNT_MAX);
        return count;
    }

    public void setAuditQueryCount(Double auditQueryCount) {
        this.auditQueryCount = auditQueryCount;
    }

    public Double getCreitCard3QueryCount() {
        double count = CeritUtil.one(creitCard3QueryCount, CREIT_CARD_THREE_MONTH_QUERY_COUNT_MAX);
        return count;
    }

    public void setCreitCard3QueryCount(Double creitCard3QueryCount) {
        this.creitCard3QueryCount = creitCard3QueryCount;
    }

    public Double getOtherLoan() {

        double count  = CeritUtil.one(otherLoan,OTHER_LOAN_COUNT_MAX);
        return count;
    }

    public void setOtherLoan(Double otherLoan) {
        this.otherLoan = otherLoan;
    }

    public Double getLoanManage() {
        double count  = CeritUtil.one(loanManage, LOAN_MANAGE_MAX);
        return count;
    }

    public void setLoanManage(Double loanManage) {
        this.loanManage = loanManage;
    }

    public Double getGuaranteeQueried() {
        double count  = CeritUtil.one(guaranteeQueried, GUARANTEE_BI_YEARLY_QUERIED_MAX);
        return count;
    }
    public void setGuaranteeQueried(Double guaranteeQueried) {
        this.guaranteeQueried = guaranteeQueried;
    }
    public Double getAvgRepayment() {
        return avgRepayment;
    }

    public void setAvgRepayment(Double avgRepayment) {
        this.avgRepayment = avgRepayment;
    }

    public Double getLoanMoney() {

        //loanMoney = CeritUtil.one(loanManage, LOAN_MANAGE_MAX);
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Double getCurrentInterest() {
        return currentInterest;
    }

    public void setCurrentInterest(Double currentInterest) {
        this.currentInterest = currentInterest;
    }

    public Double getPrevInterest() {
        return prevInterest;
    }

    public void setPrevInterest(Double prevInterest) {
        this.prevInterest = prevInterest;
    }

    public Double getCurrentPubInterest() {
        return currentPubInterest;
    }

    public void setCurrentPubInterest(Double currentPubInterest) {
        this.currentPubInterest = currentPubInterest;
    }

    public Double getPrevPubInterest() {
        return prevPubInterest;
    }

    public void setPrevPubInterest(Double prevPubInterest) {
        this.prevPubInterest = prevPubInterest;
    }

    @Override
    public String toString() {
        return "CloudCustomer{" +
                "loanCardDelyCount=" + loanCardDelyCount +
                ", creitCard6QueryCount=" + creitCard6QueryCount +
                ", loanQueryCount=" + loanQueryCount +
                ", propertyType=" + propertyType +
                ", auditQueryCount=" + auditQueryCount +
                ", creitCard3QueryCount=" + creitCard3QueryCount +
                ", otherLoan=" + otherLoan +
                ", loanManage=" + loanManage +
                ", guaranteeQueried=" + guaranteeQueried +
                ", avgRepayment=" + avgRepayment +
                ", loanMoney=" + loanMoney +
                ", currentInterest=" + currentInterest +
                ", prevInterest=" + prevInterest +
                ", currentPubInterest=" + currentPubInterest +
                ", prevPubInterest=" + prevPubInterest +
                '}';
    }
    
    
    private String applid;
    
    public String getApplid(){
    	return this.applid;
    }
    
    public void setApplid(String applid){
    	this.applid= applid;
    }
    
    
    
}
