package dbtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Compulsoryexecutionrecord;
import com.hdd.dbtest.domain.Creditloanapproquerydetailed;

public class InsertCreditloanapproquerydetailed {

	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Creditloanapproquerydetailed.csv";
		
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



		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(csvRoot+tableName), "GBK")); //传来的filename对应的csv文件

		String text = br.readLine();
		


		int count = 0;
		while ((text = br.readLine()) != null) {  //循环行
			
			count++;
			Creditloanapproquerydetailed idi = new Creditloanapproquerydetailed();
			idi.setId((long)count);
			String[] a = split(text, ',');
			idi.setReportId(a[0]);
			idi.setNO(a[1]);
			idi.setQueryOperator(a[2]);
			idi.setCreditloanapproquerydetailed_QueryReason(a[3]);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			String strDate = a[4];
			Date date = sdf.parse(strDate);
			
			idi.setCreditloanapproquerydetailed_QueryDate(date);
			if (a.length != 5)
				throw new Exception(String.format(
						"csv line %d should have %d columns. line is: [%s]",
						count + 1, 5, text));
			session.save(idi);
		}
		
		
		
		

		

		br.close();
		
		// 提交事务
		session.getTransaction().commit();

		// 关闭连接
		session.close();
		sf.close();
		
	}
	
	final static char quote = '\"';
	
	 static boolean isQuoteChar(char c) {
		return c == quote;
	}
	
	final static int Ready_For_Next = 0;
	final static int Reading_With_Quote = 1;
	final static int Reading_Without_Quote = 2;
	
	static private String[] split(String lineTxt, char sep) throws Exception {

		char[] cs = lineTxt.toCharArray();
		boolean inQuote = false;
		boolean bFirst = true;
		int from = 0;
		int to = 0;
		LinkedList<String> ret = new LinkedList<>();
		int k = 0;
		int status = 0;
		while (k < cs.length) {
			char c = cs[k];
			switch (status) {
			case Ready_For_Next:
				if (isQuoteChar(c)) {
					status = Reading_With_Quote;
					k++;
					from = k;
				} else if (c == sep) {
					status = Ready_For_Next;
					k++;
					ret.add("");
				} else {
					status = Reading_Without_Quote;
					from = k++;
				}

				break;

			case Reading_With_Quote:
				if (isQuoteChar(c) && (k == cs.length - 1 || cs[k + 1] == sep)) {
					to = k;
					k = k + 2;
					status = Ready_For_Next;
					ret.add(lineTxt.substring(from, to).trim());
				} else {
					k++;
				}

				break;

			case Reading_Without_Quote:
				if (c == sep) {
					to = k++;
					ret.add(lineTxt.substring(from, to).trim());
					status = Ready_For_Next;
				} else {
					k++;
				}
				break;
			}
		}
		// fix the tail when ends up with seperator
		String lastField;
		if (status==Ready_For_Next)
			lastField = "";
		else if (status==Reading_With_Quote)
			if (isQuoteChar(cs[cs.length-1]))
				lastField = lineTxt.substring(from, cs.length-1);
			else
				throw new Exception("Reading with Quote, last char must be \"");
		else if (status==Reading_Without_Quote)
			lastField = lineTxt.substring(from);	
		else
			throw new Exception("Unknown status "+status);
		ret.add(lastField);
		String[] arr = new String[ret.size()];
		ret.toArray(arr);
		return arr;
	}
}
