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
import com.hdd.szdb.domain.Info_loan;

public class Insertinfo_loan {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "info_loan.csv";
		
		
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
			Info_loan idi = new Info_loan();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setAPPL_ID(a[0]);
				idi.set贷款编号(a[1]);
				idi.set贷款五级分类(a[2]);
				idi.set贷款信用卡还款记录(a[3]);
				idi.set贷款本金余额(a[4]);
				idi.set贷款剩余还款期数(a[5]);
				idi.set贷款本月应还款(a[6]);
				idi.set贷款应还款日(a[7]);
				idi.set贷款本月实还款(a[8]);
				idi.set贷款最近一次还款日期(a[9]);
				idi.set贷款当前逾期期数(a[10]);
				idi.set贷款当前逾期金额(a[11]);
				idi.set贷款逾期3160天未还本金(a[12]);
				idi.set贷款逾期6190天未还本金(a[13]);
				idi.set贷款逾期91180天未还本金(a[14]);
				idi.set贷款逾期180天以上未还本金(a[15]);
				idi.set贷款发放日期(a[16]);
				idi.set贷款金额(a[17]);
				idi.set贷款类型(a[18]);
				idi.set担保类型(a[19]);
				idi.set贷款期数(a[20]);
				idi.set还款方式(a[21]);
				idi.set贷款到期日期(a[22]);
				idi.set是否结清(a[23]);
				idi.set结清月份(a[24]);
				idi.set转出前最后一次还款日期(a[25]);
				idi.set转出余额(a[26]);
				idi.set信息更新日期(a[27]);
				idi.set还款状态开始月份(a[28]);
				idi.set还款状态结束月份(a[29]);
				idi.setLoan_credit_detail(a[30]);
				
				
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
