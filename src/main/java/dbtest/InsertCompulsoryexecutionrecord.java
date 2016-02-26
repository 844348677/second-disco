package dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Beoverduesummaryoverview;
import com.hdd.dbtest.domain.Compulsoryexecutionrecord;

public class InsertCompulsoryexecutionrecord {
	
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Compulsoryexecutionrecord.csv";
		
/*		ReadCsvLine rcl = new ReadCsvLine();
		List list = rcl.loadCsvFirstLine(csvRoot+tableName, ',', "GBK", null, null, true);
		
		String a[] = (String[]) list.get(0);
		System.out.println("private long id;");
		System.out.println();
		for(int i=0;i<a.length;i++){
			System.out.println("private String "+a[i]+";");
			System.out.println();
		}*/
		
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
			Compulsoryexecutionrecord idi = new Compulsoryexecutionrecord();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				idi.setNo(a[1]);
				idi.setExecutiveCourt(a[2]);
				idi.setExecutiveCaseReason(a[3]);
				idi.setClosedWay(a[4]);
				idi.setApplyExecSubject(a[5]);
				idi.setAlreadyExecSubject(a[6]);
				
				String strDate = a[7];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				Date date = sdf.parse(strDate);
				
				idi.setFilingDate(date);
				
				String strDate2 = a[8];
				Date date2 = sdf.parse(strDate2);
				
				idi.setClosedDate(date2);

				idi.setApplyExecSubjectValue(a[9]);
				idi.setAlreadyExecSubjectValue(a[10]);
				idi.setCompulsoryexecutionrecord_CaseState(a[11]);
				
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
