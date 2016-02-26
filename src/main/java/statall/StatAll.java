package statall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hdd.szdb.cloudcustomer.dao.HibernateUtil;
import com.hdd.szdb.domain.NewData;

public class StatAll {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException{
		
		
	     Session session = HibernateUtil.currentSession();
		
	        String hql = "select * from newdata where zaa in (select APPL_ID from add_info_22 where 签约城市= 6)";
	        Query query = session.createSQLQuery(hql).addEntity(NewData.class);
	        List<NewData> list  = query.list();

	        
	        
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/python/test.csv"), "gbk"));
       
	     
	     HibernateUtil.closeSession();
		
	}
	
}
