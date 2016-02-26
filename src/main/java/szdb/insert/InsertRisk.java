package szdb.insert;

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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;
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

public class InsertRisk {

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

        String sz = "6";
        NewDataDao ndd = new NewDataDaoImpl();
        List<NewData> alist  = new LinkedList<NewData>();
        alist = ndd.queryAllInCity(sz);

        
        CloudCustomerTransformDao ccDao1 = new CloudCustomerTransformDaoImpl();
        List<CloudCustomer> cclist1 = ccDao1.queryAll();
        System.out.println("ccDao::"+cclist1.size());
        
        
        String filename = "data/python/score_answer.csv";
    	BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), "utf-8")); //传来的filename对应的csv文件
		String text = br.readLine();
        List scoreList = new LinkedList();
        Map scoreMapById = new LinkedMap();
        while(( text = br.readLine())!=null){
        	scoreList.add(text);
        	String[] row = text.split(","); //将读的每行有分隔符分割，所得到的字符串数组
/*        	String[] newRow = new String[4];
        	newRow[0] = row[1];
        	newRow[1] = row[2];
        	newRow[2] = row[3];
        	newRow[3] = row[4];*/
        	scoreMapById.put(row[0], text);
        	
        }
	
        System.out.println("scoreList.size()"+scoreList.size());
        System.out.println(alist.size());
        for(int i = 0;i<alist.size();i++){
            NewData newData = (NewData)alist.get(i);
/*                    JSONObject ctjson = new JSONObject();
            ctjson.put("appl_id",newData.getZaa());
            ctjson.put("loan_limit",newData.getZbm());
            ctjson.put("loan_period",newData.getZbn());*/

            for(int j=0;j<cclist1.size();j++){
            	
                //List<CloudCustomer> cclist = ccDao.queryByApplId("60448");
                CloudCustomer cc = cclist1.get(j);
                ModuleOne mo = new ModuleOne(cc);
                ModuleTwo mt = new ModuleTwo(cc);
                ModuleThree mth = new ModuleThree(cc);
                DSSTreeOne dto = new DSSTreeOne(mo);
                DSSTreeTwo dt = new DSSTreeTwo(mt);
                DSSTreeThree dtt = new DSSTreeThree(mth);
                String credit_grade = CreditGrade.grade(dto,dt,dtt);
                Double score = CreditGrade.defaultRate(credit_grade);
                
         
                if(newData.getZaa().equals(cc.getApplid())){
                	Risk thirdpage = new Risk();
                	
                	thirdpage.setId((long)i+1);
                	thirdpage.setApplid(newData.getZaa());
                	thirdpage.setA11(mo.getX1()+"");
                	thirdpage.setA12(mo.getX2()+"");
                	thirdpage.setA13(mt.getX11()+"");
                	thirdpage.setA14(mt.getX4()+"");
                	thirdpage.setA15(mth.getX1()+"");
                	thirdpage.setA16(mth.getX2()+"");
                	thirdpage.setA17(mth.getX3()+"");
                	thirdpage.setA18(mth.getHalf()+"");
                	thirdpage.setA19(mth.getX6()+"");
                	
                	thirdpage.setB11(newData.getBadratio());
                	//thirdpage.setB12();
                	thirdpage.setB13(cc.getLoanMoney()+"");
                	//thirdpage.setB14(b11);
                	//thirdpage.setB15(b11);
                	
                	String rowLine = (String) scoreMapById.get(newData.getZaa()+"");
                	System.out.println(newData.getId());
                	System.out.println(rowLine);
                	String[] row = rowLine.split(",");
                	
                	thirdpage.setB16(row[1]);
                	thirdpage.setB17(row[2]);
                	thirdpage.setB18(row[3]);
                	thirdpage.setB19(row[4]);
                	
                	
                	System.out.println(i+"!!!!!!!:"+thirdpage.toString());
                	
                	session.save(thirdpage);
                }
                
            	
            }
        
        }
        
		// 提交事务
		session.getTransaction().commit();

		// 关闭连接
		session.close();
		sf.close();
		
		
	}	
}
