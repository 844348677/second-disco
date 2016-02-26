package dbtest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Beoverduesummaryinfo;
import com.hdd.dbtest.domain.Beoverduesummaryoverview;

public class InsertBeoverduesummaryoverview {

	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Beoverduesummaryoverview.csv";
		
/*		ReadCsvLine rcl = new ReadCsvLine();
		List list = rcl.loadCsvFirstLine(csvRoot+tableName, ',', "GBK", null, null, true);
		
		String a[] = (String[]) list.get(0);
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
			Beoverduesummaryoverview idi = new Beoverduesummaryoverview();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				idi.setBeoverduesummaryoverview_GuarantorCompenInfoSumNumber(a[1]);
				idi.setBeoverduesummaryoverview_GuarantorCompenInfoSumAmount(a[2]);
				idi.setBeoverduesummaryoverview_BadDebtsInfoSumAmount(a[3]);
				idi.setBeoverduesummaryoverview_AssetsDisposalInfoSumAmount(a[4]);
				idi.setBeoverduesummaryoverview_BadDebtsInfoSumNum(a[5]);
				idi.setBeoverduesummaryoverview_AssetsDisposalInfoSumNumber(a[6]);

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
