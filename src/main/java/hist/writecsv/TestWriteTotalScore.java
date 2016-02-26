package hist.writecsv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.szdb.domain.Oa_datatoqh_5;
import com.hdd.szdb.domain.Risk;

public class TestWriteTotalScore {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException{
		
		Configuration cfg = new Configuration();
		// 读取hibernate.cfg.xml中的配置
		cfg.configure();
		// 获取SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 获取Session
		Session session = sf.openSession();
		
		
        String hql = "select * from risk ";
        Query query = session.createSQLQuery(hql).addEntity(Risk.class);
        List<Risk> alist  = query.list();
        System.out.println("list.size()"+alist.size());
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/hist/test.csv"), "gbk"));
        
        
        for(int i=0;i<alist.size();i++){
        	Risk risk = alist.get(i);
        	System.out.println("total:"+risk.getB19());
        	
        	pw.write(risk.getB19());
			pw.write("\r\n");
        }
		
		pw.close();
        
		// 关闭连接
		session.close();
		sf.close();
		
	}
	
}
