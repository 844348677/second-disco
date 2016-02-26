package szdb.cloudcustomer.inset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alibaba.fastjson.JSONObject;
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
import com.hdd.szdb.domain.Information;
import com.hdd.szdb.domain.NewData;

public class InsertCloudCustomerData {

	public static void main(String[] args){
/*		
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

        String sz = "6";
        List<NewData> nList = new ArrayList<NewData>();
        List<Information> inList = new ArrayList<Information>();
        //List jsonList = new LinkedList();
        try {


                nList = ndd.queryAllInCity(sz);
                System.out.println("总人数:"+nList.size());
                for(int i = 0;i<nList.size();i++){
                    NewData newData = (NewData)nList.get(i);
                    JSONObject ctjson = new JSONObject();
                    ctjson.put("appl_id",newData.getZaa());
                    ctjson.put("loan_limit",newData.getZbm());
                    ctjson.put("loan_period",newData.getZbn());

                    CloudCustomerTransformDao ccDao = new CloudCustomerTransformDaoImpl();
                    List<CloudCustomer> cclist = ccDao.queryByApplId(newData.getZaa());
                    //List<CloudCustomer> cclist = ccDao.queryByApplId("60448");
                    CloudCustomer cc = cclist.get(0);
                    ModuleOne mo = new ModuleOne(cc);
                    ModuleTwo mt = new ModuleTwo(cc);
                    ModuleThree mth = new ModuleThree(cc);
                    DSSTreeOne dto = new DSSTreeOne(mo);
                    DSSTreeTwo dt = new DSSTreeTwo(mt);
                    DSSTreeThree dtt = new DSSTreeThree(mth);
                    String credit_grade = CreditGrade.grade(dto,dt,dtt);
                    Double score = CreditGrade.defaultRate(credit_grade);
                    	
                    System.out.println("cg:"+credit_grade+"   "+"sc:"+score);

                    newData.setCreditgrade(credit_grade);
                    newData.setBadratio(score+"");
                    
                    //ctjson.put("credit_grade",credit_grade);
                    //jsonList.add(ctjson);
        			session.update(newData);
        			
                    System.out.println(i+"    "+i+"   "+i+"    "+i);
                    
            }
		
		
        }catch(Exception e){
        	System.out.println(e);
        }
	
		// 提交事务
		session.getTransaction().commit();

		// 关闭连接
		session.close();
		sf.close();*/
		
		
		
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

        String sz = "6";
        List<NewData> nList = new ArrayList<NewData>();
        List<Information> inList = new ArrayList<Information>();
        //List jsonList = new LinkedList();
        try {
            CloudCustomerTransformDao ccDao = new CloudCustomerTransformDaoImpl();
            List<CloudCustomer> cclist = ccDao.queryAll();

                nList = ndd.queryAllInCity(sz);
                System.out.println("总人数:"+nList.size());
                for(int i = 0;i<nList.size();i++){
                    NewData newData = (NewData)nList.get(i);



                    System.out.println("CClist.size"+cclist.size());
                    for(int j=0;j<cclist.size();j++){
                    	 CloudCustomer cc = cclist.get(j);
                    	 
                    	 if(newData.getZaa().equals(cc.getApplid())){
                             ModuleOne mo = new ModuleOne(cc);
                             ModuleTwo mt = new ModuleTwo(cc);
                             ModuleThree mth = new ModuleThree(cc);
                             DSSTreeOne dto = new DSSTreeOne(mo);
                             DSSTreeTwo dt = new DSSTreeTwo(mt);
                             DSSTreeThree dtt = new DSSTreeThree(mth);
                             String credit_grade = CreditGrade.grade(dto,dt,dtt);
                             Double score = CreditGrade.defaultRate(credit_grade);
                             	
                             System.out.println("cg:"+credit_grade+"   "+"sc:"+score);

                             newData.setCreditgrade(credit_grade);
                             newData.setBadratio(score+"");
                             
                             //ctjson.put("credit_grade",credit_grade);
                             //jsonList.add(ctjson);
                 			session.update(newData);
                 			
                             System.out.println(i+"    "+i+"   "+i+"    "+i);
                    	 }

                    	
                    	
                    }
                    
                    //List<CloudCustomer> cclist = ccDao.queryByApplId("60448");
                   
                    
            }
		
		
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
