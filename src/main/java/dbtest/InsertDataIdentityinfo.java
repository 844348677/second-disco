package dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Identityinfo;

public class InsertDataIdentityinfo {
	public static void main(String[] args) throws Exception{
		
/*		CsvDataLoader ld = new CsvDataLoader("ReportId");
		ld.load();
		HddWebVisitor2 visitor = new HddWebVisitor2();
		
		// load id_list
		WebBatchTest util = new WebBatchTest();
		
		String ReportIdFileName = "data/DataCompare/ReportId_List.txt";
		
		List<String>  id_list = util.loadConfigFile(ReportIdFileName);
		
		Long i = (long) 100000;*/
		

/*		Identityinfo idi = new Identityinfo();
		
		idi.setId(2+"");
		idi.setReportId("2014050600001671231562");
		idi.setMaritalStatus("已婚");
		idi.setDegree("其他");
		idi.setIdentityinfoGender("男性");
		idi.setIdentityinfoEducation("中等专业学校或中等技术学校");
		
		String strDate = "1980-07-25";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = sdf.parse(strDate);
		
		idi.setIdentityinfoDateOfBirth(date);*/
		
		String csvRoot = "data/data_dev/";
		String tableName = "Identityinfo.csv";
		
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
			Identityinfo idi = new Identityinfo();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setReportId(a[0]);
				idi.setMaritalStatus(a[1]);
				idi.setDegree(a[2]);
				idi.setIdentityinfo_Gender(a[3]);
				idi.setIdentityinfo_Education(a[4]);
				String strDate = a[5];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				Date date = sdf.parse(strDate);
				
				idi.setIdentityinfo_DateOfBirth(date);
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
