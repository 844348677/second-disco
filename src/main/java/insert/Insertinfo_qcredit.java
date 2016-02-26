package insert;

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
import com.hdd.szdb.domain.Info_qcredit;

public class Insertinfo_qcredit {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "info_qcredit.csv";
		
		
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
			Info_qcredit idi = new Info_qcredit();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setAPPL_ID(a[0]);
				idi.set账户状态(a[1]);
				idi.set编号(a[2]);
				idi.set贷款信用卡还款记录(a[3]);
				idi.set准贷记卡共享额度(a[4]);
				idi.set准贷记卡透支余额(a[5]);
				idi.set准贷记卡最近6个月平均透支余额(a[6]);
				idi.set准贷记卡最大透支余额(a[7]);
				idi.set准贷记卡账单日(a[8]);
				idi.set准贷记卡本月实还款(a[9]);
				idi.set准贷记卡最近一次还款日期(a[10]);
				idi.set准贷记卡透支180天以上未付余额(a[11]);
				idi.set开户日期(a[12]);
				idi.set币种(a[13]);
				idi.set额度(a[14]);
				idi.set担保类型(a[15]);
				idi.set关户月份(a[16]);
				idi.set更新日期(a[17]);
				idi.set坏账前最后一次还款日期(a[18]);
				idi.set坏账前最后一次还款余额(a[19]);
				idi.set还款状态开始年月(a[20]);
				idi.set还款状态结束年月(a[21]);
				
				
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
