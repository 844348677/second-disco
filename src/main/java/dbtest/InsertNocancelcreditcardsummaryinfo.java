package dbtest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Credittipsinfo;
import com.hdd.dbtest.domain.Nocancelcreditcardsummaryinfo;

public class InsertNocancelcreditcardsummaryinfo {

	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Nocancelcreditcardsummaryinfo.csv";
		
/*		ReadCsvLine rcl = new ReadCsvLine();
		List list = rcl.loadCsvFirstLine(csvRoot+tableName, ',', "GBK", null, null, true);
		
		String a[] = (String[]) list.get(0);
		System.out.println("private long id;");
		System.out.println();
		for(int i=0;i<a.length;i++){
			System.out.println("private String "+a[i]+";");
			System.out.println();
		}
		for(int i=0;i<a.length;i++){
	        //<property name="ExecutiveCourt" type="string"  column="ExecutiveCourt"/> 
	        System.out.println("<property name=\""+a[i]+"\" type=\"string\"  column=\""+a[i]+"\"/>");
	        System.out.println();
		}
		for(int i=0;i<a.length;i++){
			//		idi.setReportId(a[0]);
			String str = a[i];
			str  = str.substring(0,1).toUpperCase()+str.substring(1);
			System.out.println("idi.set"+str+"(a["+i+"]);");

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
			Nocancelcreditcardsummaryinfo idi = new Nocancelcreditcardsummaryinfo();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				idi.setHairpinLegalOrgNum(a[1]);
				idi.setNocancelcreditcardsummaryinfo_Last6MonthsAvgUseLimit(a[2]);
				idi.setNocancelcreditcardsummaryinfo_HairpinOrgNum(a[3]);
				idi.setNocancelcreditcardsummaryinfo_AccountNum(a[4]);
				idi.setNocancelcreditcardsummaryinfo_SingleBankMaxFinanceLimit(a[5]);
				idi.setNocancelcreditcardsummaryinfo_UsedCreditLimit(a[6]);
				idi.setNocancelcreditcardsummaryinfo_SingleBankMinFinanceLimit(a[7]);
				idi.setNocancelcreditcardsummaryinfo_FinanceProfits(a[8]);
				
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
