package insert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.ReadCsvLine;
import com.hdd.dbtest.domain.Quasicreditcard;
import com.hdd.szdb.domain.Add_info_1;
import com.hdd.szdb.domain.Info_address;
import com.hdd.szdb.domain.Info_bill;

public class Insertadd_info_1 {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "add_info_1.csv";
		
		
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
			Add_info_1 idi = new Add_info_1();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setAPPL_ID(a[0]);
				idi.setReciv_amt1(a[1]);
				idi.setReciv_amt2(a[2]);
				idi.setReciv_amt3(a[3]);
				idi.setReciv_amt4(a[4]);
				idi.setReciv_amt5(a[5]);
				idi.setReciv_amt6(a[6]);
				idi.setActual_amt1(a[7]);
				idi.setActual_amt2(a[8]);
				idi.setActual_amt3(a[9]);
				idi.setActual_amt4(a[10]);
				idi.setActual_amt5(a[11]);
				idi.setActual_amt6(a[12]);
				idi.setActual_amt7(a[13]);
				idi.setActual_amt8(a[14]);
				idi.setActual_amt9(a[15]);
				idi.set首次逾期期数(a[16]);
				idi.set首次逾期后还清距离逾期天数(a[17]);
				
				
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
