package dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Persummaryguarantee;
import com.hdd.dbtest.domain.Quasicreditcard;

public class InsertQuasicreditcard {

	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Quasicreditcard.csv";
		
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
			Quasicreditcard idi = new Quasicreditcard();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String strDate = a[1];
				if(strDate != null && !"".equals(strDate)){
					Date date = sdf.parse(strDate);
					idi.setBillingDate(date);
				}
				
				String strDate2 = a[2];
				if(strDate2 != null && !"".equals(strDate2)){
					Date date = sdf.parse(strDate2);
					idi.setTheLastestRepayDay(date);
				}
				
				idi.setOverOver180UnpaidBalan(a[3]);
				
				String strDate3 = a[4];
				if(strDate3 != null && !"".equals(strDate3)){
					Date date = sdf.parse(strDate3);
					idi.setQcreadit_opendate(date);
				}
				
				idi.setQorg(a[5]);
				idi.setCurrency_type(a[6]);
				idi.setQcredit_busnum(a[7]);
				idi.setAccount_closemonth(a[8]);
				
				String strDate4 = a[9];
				if(strDate4 != null && !"".equals(strDate4)){
					Date date = sdf.parse(strDate3);
					idi.setAccount_infodate(date);
				}
				
				idi.setPay_beginmonth(a[10]);
				idi.setPay_endmonth(a[11]);
				idi.setThisMonthRepayDay(a[12]);
				idi.setQuasicreditcard_OverdraftBalance(a[13]);
				idi.setQuasicreditcard_ThisMonthActualRepayAmount(a[14]);
				idi.setQuasicreditcard_qcredit_num(a[15]);
				idi.setQuasicreditcard_SharedCreditLimit(a[16]);
				idi.setQuasicreditcard_MaxOverBalan(a[17]);
				idi.setQuasicreditcard_qcredit_limit(a[18]);
				idi.setQuasicreditcard_Month24RepayStatus(a[19]);
				idi.setQuasicreditcard_qcredit_type(a[20]);
				idi.setQuasicreditcard_account_status(a[21]);
				idi.setQuasicreditcard_Last6MonthsAveOverBalan(a[22]);
				
				
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
