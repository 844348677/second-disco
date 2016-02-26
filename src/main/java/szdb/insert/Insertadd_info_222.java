package szdb.insert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.ReadCsvLine;
import com.hdd.dbtest.domain.Quasicreditcard;
import com.hdd.szdb.domain.Add_info_2;
import com.hdd.szdb.domain.Add_info_22;
import com.hdd.szdb.domain.Info_address;
import com.hdd.szdb.domain.Info_bill;
import com.hdd.szdb.domain.NewData;

public class Insertadd_info_222 {
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
		

		//ReadCsvLine rcl = new ReadCsvLine();
		
		//tb.loadCsv(csvRoot+tableName, ',', 	"GBK",columnDict.get(tableName),indexName,false);
		
		// csv file dir
		
		
		
		
		
		
		//List list = rcl.loadCsv(csvRoot+tableName, ',', "GBK", null, null, true);
		
		
        //String hql = "select * from add_info_2 where APPL_ID in (select APPL_ID from information where 网点 in ('罗湖分行','宝安分行','福田分行','龙岗分行') and 审批状态 != '同意');";
        //Query query = session.createSQLQuery(hql).addEntity(Add_info_2.class);
        //List<Add_info_2> alist  = query.list();
		
		//System.out.println(alist.get(2130).toString());
        
		String pyfile = "data/python/given_loan.csv";
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(pyfile), "gbk")); //传来的filename对应的csv文件
		
		String text = br.readLine();
		System.out.println(text);
		
		String headers[] = text.split(",");
		System.out.println(headers[1]);
		
		
		String hql = "select * from newdata where zaa in (select APPL_ID from add_info_22 where 签约城市= 6)  and zac is null ";
		
		Query query = session.createSQLQuery(hql).addEntity(NewData.class);
        List<NewData> alist  = query.list();
		
		System.out.println(alist.size());
		int  j =0;
		while((text=br.readLine())!= null){
			String aaa[] = text.split(",");


			

			String hql1 = "From NewData as nd where nd.zaa = " + Integer.parseInt(aaa[0]);
			
			Query query1 = session.createQuery(hql1);
			List<NewData> nd1 = query1.list();
			
			//session.update(arg0);
			String applloan = nd1.get(0).getZaf();
			double  all = (Double.parseDouble(aaa[1]))*(Double.parseDouble(applloan));
			
			NewData newData = nd1.get(0);
			
			if(all<0){
				all =0;
			}
			if(Double.parseDouble(aaa[1])<0){
				aaa[1]=0+"";
			}
			
			newData.setAdviseloan(all+"");
			newData.setAdviseratio(aaa[1]+"");
			
			session.update(newData);
			System.out.println(all);
			
			System.out.println(nd1.get(0).getZaa()+"!!!"+aaa[1]);
			
			
		}
		
		for(int i=0;i<alist.size();i++){
			
			
			
			
			
			
			
			
			
			
			
			
			
		/*	Add_info_22 idi = new Add_info_22();
			
			idi.setId((long)(i+1+9737));
			//String a[] = (String[]) alist.get(i);
			Add_info_2 iii = alist.get(i);
			//System.out.print(i+" : ");
			
			
				idi.setAPPL_ID(iii.getAPPL_ID());
				idi.set签约城市("6");
				idi.set个人当季结息(iii.get个人上季结息());
				idi.set个人上季结息(iii.get个人上季结息());
				idi.set对公当季结息(iii.get对公当季结息());
				idi.set对公上季结息(iii.get对公上季结息());
				idi.set账户余额(iii.get账户余额());
				idi.setOverdue_flag_1(iii.getOverdue_flag_1());
				idi.set信用卡最近1个月查询次数(iii.get信用卡最近1个月查询次数());
				idi.set信用卡最近2个月查询次数(iii.get信用卡最近2个月查询次数());
				idi.set信用卡最近3个月查询次数(iii.get信用卡最近3个月查询次数());
				idi.set信用卡最近6个月查询次数(iii.get信用卡最近6个月查询次数());
				idi.set贷款最近1个月查询次数(iii.get贷款最近1个月查询次数());
				idi.set贷款最近2个月查询次数(iii.get贷款最近2个月查询次数());
				idi.set贷款最近3个月查询次数(iii.get贷款最近3个月查询次数());
				idi.set贷款最近6个月查询次数(iii.get贷款最近6个月查询次数());
				idi.set所有最近1个月查询次数(iii.get所有最近1个月查询次数());
				idi.set所有最近2个月查询次数(iii.get所有最近2个月查询次数());
				idi.set所有最近3个月查询次数(iii.get所有最近3个月查询次数());
				idi.set所有最近6个月查询次数(iii.get所有最近6个月查询次数());
				idi.set贷款最近3个月逾期1期以上次数(iii.get贷款最近3个月逾期1期以上次数());
				idi.set贷款最近6个月逾期1期以上次数(iii.get贷款最近6个月逾期1期以上次数());
				idi.set贷款最近12个月逾期1期以上次数(iii.get贷款最近12个月逾期1期以上次数());
				idi.set贷款最近24个月逾期1期以上次数(iii.get贷款最近24个月逾期1期以上次数());
				idi.set贷记卡最近3个月逾期1期次数(iii.get贷记卡最近3个月逾期1期次数());
				idi.set贷记卡最近6个月逾期1期次数(iii.get贷记卡最近6个月逾期1期次数());
				idi.set贷记卡最近12个月逾期1期次数(iii.get贷记卡最近12个月逾期1期次数());
				idi.set贷记卡最近24个月逾期1期次数(iii.get贷记卡最近24个月逾期1期次数());
				idi.set贷记卡额度大于等于10000最近开户额度使用率(iii.get贷记卡额度大于等于10000最近开户额度使用率());
				idi.set贷记卡额度使用率大于1的账户数(iii.get贷记卡额度使用率大于1的账户数());
				idi.set证件号码所属省(iii.get证件号码所属省());
				
				
				//System.out.print(a[j]+"   ");
			
			//System.out.println();
			// 保存
			session.save(idi);*/
		}
        
	
		
		
		
		
/*		for(int i=0;i<list.size();i++){
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
		}*/

		
		// 提交事务
		session.getTransaction().commit();

		// 关闭连接
		session.close();
		sf.close();
	}
}
