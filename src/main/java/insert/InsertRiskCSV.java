package insert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.szdb.cloudcustomer.CloudCustomer;
import com.hdd.szdb.cloudcustomer.CloudCustomerTransformDao;
import com.hdd.szdb.cloudcustomer.CloudCustomerTransformDaoImpl;
import com.hdd.szdb.cloudcustomer.CreditGrade;
import com.hdd.szdb.cloudcustomer.DSSTreeOne;
import com.hdd.szdb.cloudcustomer.DSSTreeThree;
import com.hdd.szdb.cloudcustomer.DSSTreeTwo;
import com.hdd.szdb.cloudcustomer.ModuleOne;
import com.hdd.szdb.cloudcustomer.ModuleThree;
import com.hdd.szdb.cloudcustomer.ModuleTwo;
import com.hdd.szdb.cloudcustomer.dao.NewDataDao;
import com.hdd.szdb.cloudcustomer.dao.NewDataDaoImpl;
import com.hdd.szdb.domain.Add_info_22;
import com.hdd.szdb.domain.Information;
import com.hdd.szdb.domain.NewData;
import com.hdd.szdb.domain.Risk;

public class InsertRiskCSV {

	public static void main(String[] args) throws Exception{

		
		Configuration cfg = new Configuration();
		// 读取hibernate.cfg.xml中的配置
		cfg.configure();
		// 获取SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 获取Session
		Session session = sf.openSession();

		// 开启事务
		session.beginTransaction();

        NewDataDao ndd = new NewDataDaoImpl();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/python/15+1.csv"), "utf-8"));
        String head = "APPL_ID,loan_amount,credit_card_half_yearly_queried,loan_bi_yearly_queried,property_kind,loan_queried,current_person_interest,credit_card_quarterly_queried,loan_card_delayed,current_company_interest,previous_person_interest,previous_company_interest,other_loan,half_yearly_unpaid,audit_queried,guarantee_bi_yearly_queried,grade";
        pw.write(head);
        pw.write("\r\n");
        String sz = "6";
        List<NewData> nList = new ArrayList<NewData>();
        List<Information> inList = new ArrayList<Information>();
        //List jsonList = new LinkedList();
        
        

        CloudCustomerTransformDao ccDao1 = new CloudCustomerTransformDaoImpl();
        List<CloudCustomer> cclist1 = ccDao1.queryAll();
        System.out.println("ccDao::"+cclist1.size());
        
        
        
        try {


                nList = ndd.queryAllInCity(sz);
                System.out.println("总人数:"+nList.size());
                for(int i = 0;i<nList.size();i++){
                    NewData newData = (NewData)nList.get(i);
/*                    JSONObject ctjson = new JSONObject();
                    ctjson.put("appl_id",newData.getZaa());
                    ctjson.put("loan_limit",newData.getZbm());
                    ctjson.put("loan_period",newData.getZbn());*/

                    for(int j=0;j<cclist1.size();j++){
                    	
                        //List<CloudCustomer> cclist = ccDao.queryByApplId("60448");
                        CloudCustomer cc = cclist1.get(j);
                        
                        
                 
                        if(newData.getZaa().equals(cc.getApplid())){
                        	   /*                    ModuleOne mo = new ModuleOne(cc);
                            ModuleTwo mt = new ModuleTwo(cc);
                            ModuleThree mth = new ModuleThree(cc);
                            DSSTreeOne dto = new DSSTreeOne(mo);
                            DSSTreeTwo dt = new DSSTreeTwo(mt);
                            DSSTreeThree dtt = new DSSTreeThree(mth);
                            String credit_grade = CreditGrade.grade(dto,dt,dtt);
                            Double score = CreditGrade.defaultRate(credit_grade);*/
                            	
                            StringBuilder ssb = new  StringBuilder();
                            
                            String credit_grade = newData.getCreditgrade();
                            System.out.println(cc.getAuditQueryCount());
                            
                            System.out.println(cc.getAvgRepayment());
                            System.out.println(cc.getCreitCard3QueryCount());
                            System.out.println("cg:"+credit_grade+"   "+"sc:");

/*                            String loan_amount =cc.getLoanMoney()+"";
                            String credit_card_half_yearly_queried =cc.getCreitCard6QueryCount()+"";
                            String loan_bi_yearly_queried =cc.getLoanManage()+"";
                            String property_kind=cc.getPropertyType()+"";
                            String loan_queried=cc.getLoanQueryCount()+"";
                            String current_person_interest=cc.getCurrentInterest()+"";
                            String credit_card_quarterly_queried=cc.getCreitCard3QueryCount()+"";
                            String loan_card_delayed=cc.getLoanCardDelyCount()+"";
                            String current_company_interest=cc.getCurrentPubInterest()+"";
                            String previous_person_interest=cc.getPrevInterest()+"";
                            String previous_company_interest=cc.getPrevPubInterest()+"";
                            String other_loan=cc.getOtherLoan()+"";
                            String half_yearly_unpaid=cc.getAvgRepayment()+"";
                            String audit_queried=cc.getAuditQueryCount()+"";
                            String guarantee_bi_yearly_queried=cc.getGuaranteeQueried()+"";
                            String grade=credit_grade+"";*/
                            
                            NewData dd = cc.getDD();
                            Add_info_22 ai = cc.getAI();
                            
                            
                            
                            String person_income = dd.getZat();
                            String property_kind = dd.getZaz();
                            String audit_queried = dd.getZei();
                            String other_loan = dd.getZbx();
                            String loan_amount = cc.getLoanMoney()+"";
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
                            
                         // String property_kind=cc.getPropertyType()+"";
                            if("5".equals(property_kind)){
                            	property_kind = 1+"";
                            }else{
                            	property_kind = 0+"";
                            }
                            
                            ssb.append(newData.getZaa()).append(",");
                            
                            ssb.append(loan_amount).append(",");
                            ssb.append(credit_card_half_yearly_queried).append(",");
                            ssb.append(loan_bi_yearly_queried).append(",");
                            ssb.append(property_kind).append(",");
                            
                            ssb.append(loan_queried).append(",");
                            ssb.append(current_person_interest).append(",");
                            ssb.append(credit_card_quarterly_queried).append(",");
                            ssb.append(loan_card_delayed).append(",");
                            ssb.append(current_company_interest).append(",");
                 
                            ssb.append(previous_person_interest).append(",");
                            ssb.append(previous_company_interest).append(",");
                            ssb.append(other_loan).append(",");
                            ssb.append(half_yearly_unpaid).append(",");
                            ssb.append(audit_queried).append(",");
                            ssb.append(guarantee_bi_yearly_queried).append(",");
                            ssb.append(credit_grade);
                            
                           


                            pw.write(ssb.toString());
                			pw.write("\r\n");

                            System.out.println(ssb.toString());
        /*                    newData.setCreditgrade(credit_grade);
                            newData.setBadratio(score+"");*/
                            
        /*                    Risk  risk = new Risk();
                            risk.setA11(mo.getX1()+"");
                            risk.setA12(mo.getX2()+"");
                            risk.setA13(mt.getX11()+"");
                            risk.setA14(mt.getX4()+"");
                            risk.setA15(mth.getX1()+"");
                            risk.setA16(mth.getX2()+"");
                            risk.setA17(mth.getX3()+"");
                            risk.setA18(mth.getHalf()+"");
                            risk.setA19(mth.getX6()+"");
                            risk.setB11(credit_grade);*/
                            /*System.out.println("risk:"+risk.toString());*/
                            //ctjson.put("credit_grade",credit_grade);
                            //jsonList.add(ctjson);
                			//session.update(risk);
                			
                            System.out.println(i+"    "+i+"   "+i+"    "+i);
                        	
                        	
                        	
                        	
                        }
                        
                        
 
                    	
                    	
                    }

                    
            }
    			pw.close();
		
        }catch(Exception e){
        	System.out.println(e);
        }
	
		// 提交事务
		session.getTransaction().commit();

		// 关闭连接
		session.close();
		sf.close();
		
		
	}	
}
