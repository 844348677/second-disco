package dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Credittipsinfo;
import com.hdd.dbtest.domain.Loaninfo;

public class InsertLoaninfo {
	

	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Loaninfo.csv";
		
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
			Loaninfo idi = new Loaninfo();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				idi.setLoan_num(a[1]);
				idi.setOrg(a[2]);
				idi.setFiveGradeClassific(a[3]);
				idi.setMonth24RepayStatus(a[4]);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String strDate = a[5];
				if(strDate != null && !"".equals(strDate)){
					Date date = sdf.parse(strDate);
					idi.setThisMonthRepayDay(date);
				}
				
				idi.setThisMonthActualRepayAmount(a[6]);
				
				String strDate2 = a[7];
				if(strDate2 != null && !"".equals(strDate2)){
					Date date = sdf.parse(strDate2);
					idi.setTheLastestRepayDay(date);
				}
				
				idi.setCurrentOverdueNum(a[8]);
				
				String strDate3 = a[9];
				if(strDate3 != null && !"".equals(strDate3)){
					Date date = sdf.parse(strDate3);
					idi.setLoan_begindate(date);
				}
				
				idi.setLoan_busnum(a[10]);
				idi.setLoan_repperiods(a[11]);
				idi.setLoan_reptype(a[12]);

				
				String strDate4 = a[13];
				if(strDate4 != null && !"".equals(strDate4)){
					Date date = sdf.parse(strDate4);
					idi.setLoan_enddate(date);
				}
				
				String strDate5 = a[14];
				if(strDate5 != null && !"".equals(strDate5)){
					Date date = sdf.parse(strDate5);
					idi.setLoan_enddate(date);
				}
				
				idi.setUpdate_mon(a[15]);
				idi.setPay_beginmonth(a[16]);
				idi.setPay_endmonth(a[17]);
				idi.setCurrency_type(a[18]);
				idi.setLoaninfo_Overdue180Days(a[19]);
				idi.setLoaninfo_CurrentOverdueAmount(a[20]);
				idi.setLoaninfo_Overdue31To60Days(a[21]);
				idi.setLoaninfo_loan_amt(a[22]);
				idi.setLoaninfo_ThisMonthRepayAmount(a[23]);
				idi.setLoaninfo_is_guaranteed_loan(a[24]);
				idi.setLoaninfo_Overdue91To180Days(a[25]);
				idi.setLoaninfo_loan_status(a[26]);
				idi.setLoaninfo_loan_type(a[27]);
				idi.setLoaninfo_Overdue61To90Days(a[28]);
				idi.setLoaninfo_PrincipalBalance(a[29]);
				idi.setLoaninfo_RemainRepayNum(a[30]);
				
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
