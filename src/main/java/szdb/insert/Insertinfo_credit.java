package szdb.insert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.ReadCsvLine;
import com.hdd.dbtest.domain.Quasicreditcard;
import com.hdd.szdb.domain.Info_address;
import com.hdd.szdb.domain.Info_bill;
import com.hdd.szdb.domain.Info_credit;

public class Insertinfo_credit {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "info_credit.csv";
		
		
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
			Info_credit idi = new Info_credit();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setAPPL_ID(a[0]);
				idi.setAccount_status(a[1]);
				idi.set贷记卡编号(a[2]);
				idi.set贷款信用卡还款记录(a[3]);
				idi.set贷记卡共享额度(a[4]);
				idi.set贷记卡已用额度(a[5]);
				idi.set贷记卡最近6个月平均使用额度(a[6]);
				idi.set贷记卡最大使用额度(a[7]);
				idi.set贷记卡本月应还款(a[8]);
				idi.set贷记卡账单日(a[9]);
				idi.set贷记卡本月实还款(a[10]);
				idi.set贷记卡最近一次还款日期(a[11]);
				idi.set贷记卡当前逾期期数(a[12]);
				idi.set贷记卡当前逾期金额(a[13]);
				idi.set信用卡开户日期(a[14]);
				idi.set信用卡币种(a[15]);
				idi.set信用卡额度(a[16]);
				idi.set信用卡担保类型(a[17]);
				idi.set信用卡关户年月(a[18]);
				idi.set信用卡信息更新日期(a[19]);
				idi.set信用卡呆账前最后一次还款日期(a[20]);
				idi.set信用卡呆账余额(a[21]);
				idi.set信用卡还款记录开始年月(a[22]);
				idi.set信用卡还款记录结束年月(a[23]);
				
				
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
