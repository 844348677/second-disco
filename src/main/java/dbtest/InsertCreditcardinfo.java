package dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Compulsoryexecutionrecord;
import com.hdd.dbtest.domain.Creditcardinfo;


public class InsertCreditcardinfo {
	
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Creditcardinfo.csv";
		
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
		// 璇诲彇hibernate.cfg.xml涓殑閰嶇疆
		cfg.configure();
		// 鑾峰彇SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 鑾峰彇Session
		Session session = sf.openSession();

		// 寮�鍚簨鍔�
		session.beginTransaction();
		

		ReadCsvLine rcl = new ReadCsvLine();
		
		//tb.loadCsv(csvRoot+tableName, ',', 	"GBK",columnDict.get(tableName),indexName,false);
		
		// csv file dir
		List list = rcl.loadCsv(csvRoot+tableName, ',', "GBK", null, null, true);
		
		for(int i=0;i<list.size();i++){
			Creditcardinfo idi = new Creditcardinfo();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);

				idi.setCredit_num(a[1]);

				idi.setOrg(a[2]);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String strDate = a[3];
				if(strDate != null && !"".equals(strDate)){
					Date date = sdf.parse(strDate);
					idi.setBillingDate(date);
				}
				
				String strDate2 = a[4];
				if(strDate2 != null && !"".equals(strDate2)){
					Date date2 = sdf.parse(strDate2);
					
					idi.setTheLastestRepayDay(date2);
				}
				
				String strDate3 = a[5];
				if(strDate3 != null && !"".equals(strDate3)){
					Date date3 = sdf.parse(strDate3);
					
					idi.setCreadit_opendate(date3);
				}
				


				idi.setCurrency_type(a[6]);

				idi.setCredit_busnum(a[7]);

				idi.setAccount_closemonth(a[8]);
				
				String strDate4 = a[9];
				if(strDate4 != null && !"".equals(strDate4)){
					Date date4 = sdf.parse(strDate4);
					
					idi.setAccount_infodate(date4);
				}


				idi.setPay_beginmonth(a[10]);

				idi.setPay_endmonth(a[11]);

				idi.setCreditcardinfo_Month24RepayStatus(a[12]);

				idi.setCreditcardinfo_CurrentOverdueNum(a[13]);

				idi.setCreditcardinfo_Last6MonthsAve(a[14]);

				idi.setCreditcardinfo_warranty_type(a[15]);

				idi.setCreditcardinfo_ThisMonthActualRepayAmount(a[16]);

				idi.setCreditcardinfo_UsedCreditLimit(a[17]);

				idi.setCreditcardinfo_credit_limit(a[18]);

				idi.setCreditcardinfo_CurrentOverdueAmount(a[19]);

				idi.setCreditcardinfo_account_status(a[20]);

				idi.setCreditcardinfo_SharedCreditLimit(a[21]);

				idi.setCreditcardinfo_ThisMonthRepayAmount(a[22]);

				idi.setCreditcardinfo_MaxUsedCreditLimit(a[23]);
				
				//System.out.print(a[j]+"   ");
			}
			//System.out.println();
			// 淇濆瓨
			session.save(idi);
		}
		


		
		// 鎻愪氦浜嬪姟
		session.getTransaction().commit();

		// 鍏抽棴杩炴帴
		session.close();
		sf.close();
		
	}
}
