package cloudcustomer;



import java.util.LinkedList;
import java.util.List;

import com.hdd.szdb.cloudcustomer.dao.Addinfo22Dao;
import com.hdd.szdb.cloudcustomer.dao.Addinfo22DaoImpl;
import com.hdd.szdb.cloudcustomer.dao.NewDataDao;
import com.hdd.szdb.cloudcustomer.dao.NewDataDaoImpl;
import com.hdd.szdb.domain.Add_info_22;
import com.hdd.szdb.domain.NewData;

/**
 * Created by liuh on 2016/1/26.
 */
public class CloudCustomerTransformDaoImpl implements CloudCustomerTransformDao {

    public List<CloudCustomer> queryAll() throws Exception {
        NewDataDao ddDao = new NewDataDaoImpl();
        Addinfo22Dao aiDao = new Addinfo22DaoImpl();
        List<NewData> ddList = null;
        List<Add_info_22> aiList = null;
        try {

        	/*
        	 ddList = ddDao.queryByApplId(appl_id);
             aiList = aiDao.queryByApplId(appl_id);
             */
        	ddList = ddDao.queryAllInCity("6");
        	aiList = aiDao.queryAllInCity("6");
        	
        	System.out.println("ddList"+ddList.size());
        	System.out.println("aiList"+aiList.size());
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        List<CloudCustomer> linkedList = new LinkedList<CloudCustomer>();
        
        for(int i =0 ;i<ddList.size();i++){
            NewData dd = ddList.get(i);

            	for(int j = 0 ; j<aiList.size() ; j++){
                    Add_info_22 ai = aiList.get(j);	
            		
                    if(dd.getZaa().equals(ai.getAPPL_ID())){
                    	
                    	
                    	
                        String person_income = dd.getZat();
                        String property_kind = dd.getZaz();
                        String audit_queried = dd.getZei();
                        String other_loan = dd.getZbx();
                        String loan_amount = dd.getZbm();
                        String loan_bi_yearly_queried = dd.getZek();
                        String guarantee_bi_yearly_queried = dd.getZel();
                        String half_yearly_unpaid = dd.getZcu();

                        String loan_card_delayed = ai.get贷记卡最近24个月逾期1期次数();
                        String credit_card_half_yearly_queried = ai.get信用卡最近6个月查询次数();
                        String credit_card_quarterly_queried = ai.get信用卡最近3个月查询次数();
                        String loan_queried = ai.get贷款最近2个月查询次数();
                        String current_person_interest = ai.get个人当季结息();
                        String previous_person_interest = ai.get个人上季结息();
                        String current_company_interest = ai.get对公当季结息();
                        String previous_company_interest = ai.get对公上季结息();

                        if(loan_card_delayed ==null || "".equals(loan_card_delayed)){
                            loan_card_delayed = 0+"";
                        }
                        if(credit_card_half_yearly_queried ==null || "".equals(credit_card_half_yearly_queried)){
                            credit_card_half_yearly_queried = 0+"";
                        }
                        if(credit_card_quarterly_queried ==null || "".equals(credit_card_quarterly_queried)){
                            credit_card_quarterly_queried = 0+"";
                        }
                        if(loan_queried ==null || "".equals(loan_queried)){
                            loan_queried = 0+"";
                        }

                        if(current_person_interest ==null || "".equals(current_person_interest)){
                            current_person_interest = -1+"";
                        }
                        if(previous_person_interest ==null || "".equals(previous_person_interest)){
                            previous_person_interest = -1+"";
                        }
                        if(current_company_interest ==null || "".equals(current_company_interest)){
                            current_company_interest = -1+"";
                        }
                        if(previous_company_interest ==null || "".equals(previous_company_interest)){
                            previous_company_interest = -1+"";
                        }

                        
                        //如果放款金额为空,为0 ,则用建议放款额度进行计算
                        
                        if("0".equals(loan_amount) || "".equals(loan_amount) || loan_amount == null  ){
                        	loan_amount = dd.getAdviseloan();
                        }
                        

                        CloudCustomer cc = new CloudCustomer();
                        if(audit_queried !=null && !"".equals(audit_queried)){
                            cc.setAuditQueryCount(Double.parseDouble(audit_queried));
                        }
                        if(half_yearly_unpaid != null && !"".equals(half_yearly_unpaid)){
                            cc.setAvgRepayment(Double.parseDouble(half_yearly_unpaid));
                        }
                        if(current_company_interest != null && !"".equals(current_person_interest)){
                            cc.setCurrentInterest(Double.parseDouble(current_person_interest));
                        }
                        if(credit_card_quarterly_queried != null && !"".equals(credit_card_quarterly_queried)){
                            cc.setCreitCard3QueryCount(Double.parseDouble(credit_card_quarterly_queried));
                        }
                        if(credit_card_half_yearly_queried != null && !"".equals(credit_card_half_yearly_queried)){
                            cc.setCreitCard6QueryCount(Double.parseDouble(credit_card_half_yearly_queried));
                        }
                        if(current_company_interest != null && !"".equals(current_company_interest)){
                            cc.setCurrentPubInterest(Double.parseDouble(current_company_interest));
                        }
                        if(guarantee_bi_yearly_queried != null && !"".equals(guarantee_bi_yearly_queried)){
                            cc.setGuaranteeQueried(Double.parseDouble(guarantee_bi_yearly_queried));
                        }
                        if(loan_card_delayed != null && !"".equals(loan_card_delayed)){
                            cc.setLoanCardDelyCount(Double.parseDouble(loan_card_delayed));
                        }
                        if(loan_bi_yearly_queried != null && !"".equals(loan_bi_yearly_queried)){
                            cc.setLoanManage(Double.parseDouble(loan_bi_yearly_queried));
                        }
                        if(loan_amount != null && !"".equals(loan_amount)){
                        	System.out.println("loan_amout:"+loan_amount);
                            cc.setLoanMoney(Double.parseDouble(loan_amount));
                        }
                        if(loan_queried != null && !"".equals(loan_queried)){
                            cc.setLoanQueryCount(Double.parseDouble(loan_queried));
                        }
                        if(other_loan != null && !"".equals(other_loan)){
                            cc.setOtherLoan(Double.parseDouble(other_loan));
                        }
                        if(previous_person_interest != null && !"".equals(previous_person_interest)){
                            cc.setPrevInterest(Double.parseDouble(previous_person_interest));
                        }
                        if(previous_company_interest != null && !"".equals(previous_company_interest)){
                            cc.setPrevPubInterest(Double.parseDouble(previous_company_interest));
                        }
                        if(property_kind != null && !"".equals(property_kind)){
                            cc.setPropertyType(Double.parseDouble(property_kind));
                        }
                        if(property_kind !=null && !"".equals(property_kind)){
                            cc.setLiveType(Double.parseDouble(property_kind));
                        }

                        
                        cc.setAI(ai);
                        cc.setDD(dd);

                        cc.setApplid(ai.getAPPL_ID());
                        	
                        linkedList.add(cc);
                    	
                    	
                    	
                    	
                    	
                    	
                    }
            		
            		
            		
            		
            		
            	}


            
        	
        }
 

        return linkedList;
    }

    


    public List<CloudCustomer> queryById(String id) throws Exception {
/*        DetailDao ddDao = new DetailDaoImpl();
        Addinfo2Dao aiDao = new Addinfo2DaoImpl();
        List<Detail> ddList = null;
        List<Add_info_2> aiList = null;
        try {
            ddList = ddDao.queryById("2");
            aiList = aiDao.queryById(ddList.get(0).getAPPL_ID());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Detail dd = ddList.get(0);
        Add_info_2 ai = aiList.get(0);

        String person_income = dd.get月收入();
        String property_kind = dd.get类型();
        String audit_queried = dd.get最近1个月内的查询次数贷款审批();
        String other_loan = dd.get其他贷款笔数();
        String loan_amount = dd.get放款金额();
        String loan_bi_yearly_queried = dd.get最近2年内的查询次数贷后管理();
        String guarantee_bi_yearly_queried = dd.get最近2年内的查询次数担保资格审查();
        String half_yearly_unpaid = dd.get未结清贷款最近六个月平均应还款();

        String loan_card_delayed = ai.get贷记卡最近24个月逾期1期次数();
        String credit_card_half_yearly_queried = ai.get信用卡最近6个月查询次数();
        String credit_card_quarterly_queried = ai.get信用卡最近3个月查询次数();
        String loan_queried = ai.get贷款最近2个月查询次数();
        String current_person_interest = ai.get个人当季结息();
        String previous_person_interest = ai.get个人上季结息();
        String current_company_interest = ai.get对公当季结息();
        String previous_company_interest = ai.get对公上季结息();

        if(loan_card_delayed ==null || "".equals(loan_card_delayed)){
            loan_card_delayed = 0+"";
        }
        if(credit_card_half_yearly_queried ==null || "".equals(credit_card_half_yearly_queried)){
            credit_card_half_yearly_queried = 0+"";
        }
        if(credit_card_quarterly_queried ==null || "".equals(credit_card_quarterly_queried)){
            credit_card_quarterly_queried = 0+"";
        }
        if(loan_queried ==null || "".equals(loan_queried)){
            loan_queried = 0+"";
        }

        if(current_person_interest ==null || "".equals(current_person_interest)){
            current_person_interest = 0+"";
        }
        if(previous_person_interest ==null || "".equals(previous_person_interest)){
            previous_person_interest = 0+"";
        }
        if(current_company_interest ==null || "".equals(current_company_interest)){
            current_company_interest = 0+"";
        }
        if(previous_company_interest ==null || "".equals(previous_company_interest)){
            previous_company_interest = 0+"";
        }


        CloudCustomer cc = new CloudCustomer();
        cc.setAuditQueryCount(Double.parseDouble(audit_queried));
        cc.setAvgRepayment(Double.parseDouble(half_yearly_unpaid));
        cc.setCurrentInterest(Double.parseDouble(current_person_interest));
        cc.setCreitCard3QueryCount(Double.parseDouble(credit_card_quarterly_queried));
        cc.setCreitCard6QueryCount(Double.parseDouble(credit_card_half_yearly_queried));
        cc.setCurrentPubInterest(Double.parseDouble(current_company_interest));
        cc.setGuaranteeQueried(Double.parseDouble(guarantee_bi_yearly_queried));
        cc.setLoanCardDelyCount(Double.parseDouble(loan_card_delayed));
        cc.setLoanManage(Double.parseDouble(loan_bi_yearly_queried));
        cc.setLoanMoney(Double.parseDouble(loan_amount));
        cc.setLoanQueryCount(Double.parseDouble(loan_queried));
        cc.setOtherLoan(Double.parseDouble(other_loan));
        cc.setPrevInterest(Double.parseDouble(previous_person_interest));
        cc.setPrevPubInterest(Double.parseDouble(previous_company_interest));
        cc.setPropertyType(Double.parseDouble(property_kind));


        List<CloudCustomer> linkedList = new LinkedList<CloudCustomer>();
        linkedList.add(cc);

        return linkedList;*/
    	
    	return null;
    }


    public List<CloudCustomer> queryByApplId(String appl_id) throws Exception {
        NewDataDao ddDao = new NewDataDaoImpl();
        Addinfo22Dao aiDao = new Addinfo22DaoImpl();
        List<NewData> ddList = null;
        List<Add_info_22> aiList = null;
        try {
            ddList = ddDao.queryByApplId(appl_id);
            aiList = aiDao.queryByApplId(appl_id);
        	/*
        	 ddList = ddDao.queryByApplId(appl_id);
             aiList = aiDao.queryByApplId(appl_id);
             */
        	
        } catch (Exception e) {
            e.printStackTrace();
        }

        NewData dd = ddList.get(0);
        Add_info_22 ai = aiList.get(0);

        String person_income = dd.getZat();
        String property_kind = dd.getZaz();
        String audit_queried = dd.getZei();
        String other_loan = dd.getZbx();
        String loan_amount = dd.getZbm();
        String loan_bi_yearly_queried = dd.getZek();
        String guarantee_bi_yearly_queried = dd.getZel();
        String half_yearly_unpaid = dd.getZcu();

        String loan_card_delayed = ai.get贷记卡最近24个月逾期1期次数();
        String credit_card_half_yearly_queried = ai.get信用卡最近6个月查询次数();
        String credit_card_quarterly_queried = ai.get信用卡最近3个月查询次数();
        String loan_queried = ai.get贷款最近2个月查询次数();
        String current_person_interest = ai.get个人当季结息();
        String previous_person_interest = ai.get个人上季结息();
        String current_company_interest = ai.get对公当季结息();
        String previous_company_interest = ai.get对公上季结息();

        if(loan_card_delayed ==null || "".equals(loan_card_delayed)){
            loan_card_delayed = 0+"";
        }
        if(credit_card_half_yearly_queried ==null || "".equals(credit_card_half_yearly_queried)){
            credit_card_half_yearly_queried = 0+"";
        }
        if(credit_card_quarterly_queried ==null || "".equals(credit_card_quarterly_queried)){
            credit_card_quarterly_queried = 0+"";
        }
        if(loan_queried ==null || "".equals(loan_queried)){
            loan_queried = 0+"";
        }

        if(current_person_interest ==null || "".equals(current_person_interest)){
            current_person_interest = -1+"";
        }
        if(previous_person_interest ==null || "".equals(previous_person_interest)){
            previous_person_interest = -1+"";
        }
        if(current_company_interest ==null || "".equals(current_company_interest)){
            current_company_interest = -1+"";
        }
        if(previous_company_interest ==null || "".equals(previous_company_interest)){
            previous_company_interest = -1+"";
        }

        
        //如果放款金额为空,为0 ,则用建议放款额度进行计算
        
        if("0".equals(loan_amount) || "".equals(loan_amount) || loan_amount == null  ){
        	loan_amount = dd.getAdviseloan();
        }
        

        CloudCustomer cc = new CloudCustomer();
        if(audit_queried !=null && !"".equals(audit_queried)){
            cc.setAuditQueryCount(Double.parseDouble(audit_queried));
        }
        if(half_yearly_unpaid != null && !"".equals(half_yearly_unpaid)){
            cc.setAvgRepayment(Double.parseDouble(half_yearly_unpaid));
        }
        if(current_company_interest != null && !"".equals(current_person_interest)){
            cc.setCurrentInterest(Double.parseDouble(current_person_interest));
        }
        if(credit_card_quarterly_queried != null && !"".equals(credit_card_quarterly_queried)){
            cc.setCreitCard3QueryCount(Double.parseDouble(credit_card_quarterly_queried));
        }
        if(credit_card_half_yearly_queried != null && !"".equals(credit_card_half_yearly_queried)){
            cc.setCreitCard6QueryCount(Double.parseDouble(credit_card_half_yearly_queried));
        }
        if(current_company_interest != null && !"".equals(current_company_interest)){
            cc.setCurrentPubInterest(Double.parseDouble(current_company_interest));
        }
        if(guarantee_bi_yearly_queried != null && !"".equals(guarantee_bi_yearly_queried)){
            cc.setGuaranteeQueried(Double.parseDouble(guarantee_bi_yearly_queried));
        }
        if(loan_card_delayed != null && !"".equals(loan_card_delayed)){
            cc.setLoanCardDelyCount(Double.parseDouble(loan_card_delayed));
        }
        if(loan_bi_yearly_queried != null && !"".equals(loan_bi_yearly_queried)){
            cc.setLoanManage(Double.parseDouble(loan_bi_yearly_queried));
        }
        if(loan_amount != null && !"".equals(loan_amount)){
        	System.out.println("loan_amout:"+loan_amount);
            cc.setLoanMoney(Double.parseDouble(loan_amount));
        }
        if(loan_queried != null && !"".equals(loan_queried)){
            cc.setLoanQueryCount(Double.parseDouble(loan_queried));
        }
        if(other_loan != null && !"".equals(other_loan)){
            cc.setOtherLoan(Double.parseDouble(other_loan));
        }
        if(previous_person_interest != null && !"".equals(previous_person_interest)){
            cc.setPrevInterest(Double.parseDouble(previous_person_interest));
        }
        if(previous_company_interest != null && !"".equals(previous_company_interest)){
            cc.setPrevPubInterest(Double.parseDouble(previous_company_interest));
        }
        if(property_kind != null && !"".equals(property_kind)){
            cc.setPropertyType(Double.parseDouble(property_kind));
        }
        if(property_kind !=null && !"".equals(property_kind)){
            cc.setLiveType(Double.parseDouble(property_kind));
        }



        List<CloudCustomer> linkedList = new LinkedList<CloudCustomer>();
        linkedList.add(cc);

        return linkedList;
    }
}
