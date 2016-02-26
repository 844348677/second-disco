package dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Pensioninsurancepayrecord;
import com.hdd.dbtest.domain.Perguaranteeinfo;

public class InsertPerguaranteeinfo {

	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Perguaranteeinfo.csv";
		
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
			Perguaranteeinfo idi = new Perguaranteeinfo();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				idi.setPerguaranteeinfo_No(a[1]);
				idi.setGuarLoanIssuingAgency(a[2]);
				idi.setGuarLoanContractAmount(a[3]);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String strDate = a[4];
				if(strDate != null && !"".equals(strDate)){
					Date date = sdf.parse(strDate);
					idi.setGuarLoanIssueDate(date);
				}
				
				String strDate2 = a[5];
				if(strDate2 != null && !"".equals(strDate2)){
					Date date = sdf.parse(strDate);
					idi.setGuarLoanDueDate(date);
				}
				
				idi.setGuarAmount(a[6]);
				idi.setGuarLoanPrincipalAmount(a[7]);
				
				String strDate3 = a[8];
				if(strDate3 != null && !"".equals(strDate3)){
					Date date = sdf.parse(strDate);
					idi.setSettlementDate(date);
				}
				
				idi.setPerguaranteeinfo_GuarLoanFiveclasscode(a[9]);
				
				
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
