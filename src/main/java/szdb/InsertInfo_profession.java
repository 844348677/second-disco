package szdb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.ReadCsvLine;
import com.hdd.dbtest.domain.Occupationinfo;

public class InsertInfo_profession {
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
			Occupationinfo idi = new Occupationinfo();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				idi.setOccupation(a[3]);
				idi.setCompanyType(a[4]);
				idi.setPosition(a[5]);
				idi.setPostTitle(a[6]);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String strDate = a[7];
				if(strDate != null && !"".equals(strDate)){
					Date date = sdf.parse(strDate);
					idi.setOccupationinfo_InfoUpdateDate(date);
				}

				idi.setOccupationinfo_NoEmploy(a[8]);
				
				String str = a[9];
				if(str != "9999" && !"9999".equals(str)){	
					idi.setOccupationinfo_EmployedYear(a[9]);
				}
				
				idi.set职业信息工作单位(a[1]);
				idi.set职业信息单位地址(a[2]);
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
