package insert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.ReadCsvLine;
import com.hdd.dbtest.domain.Quasicreditcard;
import com.hdd.szdb.domain.Info_address;
import com.hdd.szdb.domain.Info_bill;
import com.hdd.szdb.domain.Info_profession;

public class Insertinfo_profession {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "info_profession.csv";
		
		
		Configuration cfg = new Configuration();
		// 读取hibernate.cfg.xml中的配置
		cfg.configure();
		// 获取SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 获取Session
		Session session = sf.openSession();

		// 开启事务
		session.beginTransaction();
		

		ReadCsvLine rcl = new ReadCsvLine();
		
		//tb.loadCsv(csvRoot+tableName, ',', 	"GBK",columnDict.get(tableName),indexName,false);
		
		// csv file dir
		List list = rcl.loadCsv(csvRoot+tableName, ',', "GBK", null, null, true);
		
		for(int i=0;i<list.size();i++){
			Info_profession idi = new Info_profession();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setAPPL_ID(a[0]);
				idi.set职业信息工作单位(a[1]);
				idi.set职业信息单位地址(a[2]);
				idi.set职业信息职业(a[3]);
				idi.set职业信息行业(a[4]);
				idi.set职业信息职务(a[5]);
				idi.set职业信息职称(a[6]);
				idi.setJob_update(a[7]);
				idi.setJob_no(a[8]);
				idi.setJob_begin(a[9]);
				idi.setWor_profession(a[10]);
				idi.setWor_industry(a[11]);
				idi.setWor_position(a[12]);
				idi.setWor_profession_2(a[13]);
				idi.setWor_begin(a[14]);
				idi.setWor_update(a[15]);
				
				
				//System.out.print(a[j]+"   ");
			}
			//System.out.println();
			// 保存
			session.save(idi);
		}

		
		// 提交事务
		session.getTransaction().commit();

		// 关闭连接
		session.close();
		sf.close();
	}
}
