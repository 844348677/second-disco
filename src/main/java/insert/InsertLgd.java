package insert;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.ReadCsvLine;
import com.hdd.szdb.domain.Lgd;
import com.hdd.szdb.domain.NewData;

public class InsertLgd {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/python/";
		String tableName = "LGD_curve.csv";
		
		
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
			Lgd idi = new Lgd();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				//System.out.println(a[0]);
				String applidd[] = a[0].split(".");
				String applid = a[0].substring(0, a[0].length()-2);
				System.out.println(applid);
				idi.setApplid(applid);
				idi.setAmout10000(a[1]);
				idi.setAmout20000(a[2]);
				idi.setAmout30000(a[3]);
				idi.setAmout40000(a[4]);
				idi.setAmout50000(a[5]);
				idi.setAmout60000(a[6]);
				idi.setAmout70000(a[7]);
				idi.setAmout80000(a[8]);
				idi.setAmout90000(a[9]);
				idi.setAmout100000(a[10]);
				idi.setAmout110000(a[11]);
				idi.setAmout120000(a[12]);
				idi.setAmout130000(a[13]);
				idi.setAmout140000(a[14]);
				idi.setAmout150000(a[15]);
				idi.setAmout160000(a[16]);
				idi.setAmout170000(a[17]);
				idi.setAmout180000(a[18]);
				idi.setAmout190000(a[19]);
				idi.setAmout200000(a[20]);
				idi.setAmout210000(a[21]);
				idi.setAmout220000(a[22]);
				idi.setAmout230000(a[23]);
				idi.setAmout240000(a[24]);
				idi.setAmout250000(a[25]);
				idi.setAmout260000(a[26]);
				idi.setAmout270000(a[27]);
				idi.setAmout280000(a[28]);
				idi.setAmout290000(a[29]);
				idi.setAmout300000(a[30]);
				idi.setAmout310000(a[31]);
				idi.setAmout320000(a[32]);
				idi.setAmout330000(a[33]);
				idi.setAmout340000(a[34]);
				idi.setAmout350000(a[35]);
				idi.setAmout360000(a[36]);
				idi.setAmout370000(a[37]);
				idi.setAmout380000(a[38]);
				idi.setAmout390000(a[39]);
				idi.setAmout400000(a[40]);
				idi.setAmout410000(a[41]);
				idi.setAmout420000(a[42]);
				idi.setAmout430000(a[43]);
				idi.setAmout440000(a[44]);
				idi.setAmout450000(a[45]);
				idi.setAmout460000(a[46]);
				idi.setAmout470000(a[47]);
				idi.setAmout480000(a[48]);
				idi.setAmout490000(a[49]);

				
				
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
