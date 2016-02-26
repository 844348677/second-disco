package insert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.ReadCsvLine;
import com.hdd.dbtest.domain.Quasicreditcard;
import com.hdd.szdb.domain.Add_info_22;
import com.hdd.szdb.domain.Info_address;
import com.hdd.szdb.domain.Info_bill;

public class Insertadd_info_22 {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "add_info_22.csv";
		
		
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
			Add_info_22 idi = new Add_info_22();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setAPPL_ID(a[0]);
				idi.set签约城市(a[1]);
				idi.set个人当季结息(a[2]);
				idi.set个人上季结息(a[3]);
				idi.set对公当季结息(a[4]);
				idi.set对公上季结息(a[5]);
				idi.set账户余额(a[6]);
				idi.setOverdue_flag_1(a[7]);
				idi.set信用卡最近1个月查询次数(a[8]);
				idi.set信用卡最近2个月查询次数(a[9]);
				idi.set信用卡最近3个月查询次数(a[10]);
				idi.set信用卡最近6个月查询次数(a[11]);
				idi.set贷款最近1个月查询次数(a[12]);
				idi.set贷款最近2个月查询次数(a[13]);
				idi.set贷款最近3个月查询次数(a[14]);
				idi.set贷款最近6个月查询次数(a[15]);
				idi.set所有最近1个月查询次数(a[16]);
				idi.set所有最近2个月查询次数(a[17]);
				idi.set所有最近3个月查询次数(a[18]);
				idi.set所有最近6个月查询次数(a[19]);
				idi.set贷款最近3个月逾期1期以上次数(a[20]);
				idi.set贷款最近6个月逾期1期以上次数(a[21]);
				idi.set贷款最近12个月逾期1期以上次数(a[22]);
				idi.set贷款最近24个月逾期1期以上次数(a[23]);
				idi.set贷记卡最近3个月逾期1期次数(a[24]);
				idi.set贷记卡最近6个月逾期1期次数(a[25]);
				idi.set贷记卡最近12个月逾期1期次数(a[26]);
				idi.set贷记卡最近24个月逾期1期次数(a[27]);
				idi.set贷记卡额度大于等于10000最近开户额度使用率(a[28]);
				idi.set贷记卡额度使用率大于1的账户数(a[29]);
				idi.set证件号码所属省(a[30]);
				
				
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
