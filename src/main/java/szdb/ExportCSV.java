package szdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.szdb.domain.NewData;
import com.hdd.szdb.domain.Oa_datatoqh_5;

public class ExportCSV {
	static SimpleDateFormat fmt = new SimpleDateFormat("yyyyMM");
	static long day_millis = 3600*1000*24;
	public static double transfer_date(String yyyymm, long appl_datetime ) throws ParseException{
		if (yyyymm==null || yyyymm.equals("") || yyyymm.equals("999999"))
			return 0;
		Date d = fmt.parse(yyyymm);
		long delta = appl_datetime - d.getTime()/day_millis ;
		
		return ((double) delta)/365;
	}
	
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "newdata.csv";
		String pyfile = "data/python/x_expert.csv";
		
		Configuration cfg = new Configuration();
		// 读取hibernate.cfg.xml中的配置
		cfg.configure();
		// 获取SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 获取Session
		Session session = sf.openSession();

		// 开启事务
		//session.beginTransaction();
		

        String hql = "select * from detail where 网点 in ('罗湖分行','宝安分行','福田分行','龙岗分行') and 审批状态 != '同意'";
        Query query = session.createSQLQuery(hql).addEntity(Oa_datatoqh_5.class);
        List<Oa_datatoqh_5> alist  = query.list();
		
		System.out.println(alist.get(2130).toString());
		//File datafile = new File("data/python/test.csv");
		//datafile.createNewFile();
//		PrintWriter pw = new PrintWriter("data/python/test.csv");
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/python/test.csv"), "gbk"));

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(pyfile), "gbk")); //传来的filename对应的csv文件
		
		String text = br.readLine();
		text = text+",appl_id";
		System.out.println(text);
		pw.write(text);
		pw.write("\r\n");
		long day_millis = 24*3600*1000;
		long year_millis = 365*24*3600*1000;
		long base = fmt.parse("196001").getTime()/day_millis;

		for(int i=0;i<alist.size();i++){
			NewData idi = new NewData();
			idi.setId((long)(i+1+9992));
			Oa_datatoqh_5 oo = alist.get(i);
			
			
			oo.get年龄();
			oo.get同住人数();
			oo.get客户类别();
			
			String type = oo.get客户类别();
			if("受薪".equals(type)){
				type = ""+0;
			}
			if("自雇".equals(type)){
				type = ""+1;
			}
			
			if(oo.get年龄() == null || "".equals(oo.get年龄())){
				oo.set年龄("-1");
			}
			if(oo.get同住人数() == null || "".equals(oo.get同住人数())){
				oo.set同住人数("3.5");
			}
			
			
			long appl_date = Long.parseLong(oo.get申请日期())+base;
			double first_loan = transfer_date(oo.get首笔贷款发放月份(),appl_date);
			double first_credit = transfer_date(oo.get首张贷记卡发卡月份(),appl_date);
			double first_qc = transfer_date(oo.get首张准贷记卡发卡月份(),appl_date);

			
			StringBuilder ssb =new StringBuilder();
			ssb.append(oo.get同住人数()).append(",");
			ssb.append(oo.get年龄()).append(",");
			ssb.append(oo.get房贷笔数()).append(",");
			ssb.append(oo.get其他贷款笔数()).append(",");
			ssb.append(oo.get贷款逾期笔数()).append(",");
			ssb.append(oo.get商品房及商铺数目()).append(",");
			ssb.append(oo.get担保笔数()).append(",");
			ssb.append(oo.get贷记卡账户数()).append(",");
			ssb.append(oo.get未销户贷记卡单家行最高授信额()).append(",");
			ssb.append(oo.get未销户贷记卡单家行最低授信额()).append(",");
			ssb.append(oo.get未销户贷记卡已用额度()).append(",");
			ssb.append(oo.get最近6个月平均使用额度()).append(",");
			ssb.append(oo.get准贷记卡授信总额()).append(",");
			ssb.append(oo.get准贷记卡单家行最高授信额()).append(",");
			ssb.append(oo.get准贷记卡单家行最低授信额()).append(",");
			ssb.append(oo.get准贷记卡透支余额()).append(",");
			ssb.append(oo.get准贷记卡最近6个月平均透支余额()).append(",");
			ssb.append(oo.get准贷记卡账户数()).append(",");
			ssb.append(oo.get准贷记卡60天以上透支账户数()).append(",");
			ssb.append(oo.get准贷记卡60天以上透支月份数()).append(",");
			ssb.append(oo.get准贷记卡60天以上透支单月最高透支余额()).append(",");
			ssb.append(oo.get准贷记卡60天以上透支最长透支月数()).append(",");
			ssb.append(oo.get准贷记卡发卡法人机构数()).append(",");
			ssb.append(oo.get准贷记卡发卡机构数()).append(",");
			ssb.append(oo.get准贷记卡账户数()).append(",");
			ssb.append(oo.get未结清贷款贷款法人机构数()).append(",");
			ssb.append(oo.get未结清贷款贷款机构数()).append(",");
			ssb.append(oo.get未结清贷款贷款笔数()).append(",");
			ssb.append(oo.get未销户贷记卡发卡法人机构数()).append(",");
			ssb.append(oo.get未销户贷记卡发卡机构数()).append(",");
			ssb.append(oo.get未销户贷记卡授信总额()).append(",");
			ssb.append(oo.get最近1个月内的查询机构数贷款审批()).append(",");
			ssb.append(oo.get最近1个月内的查询机构数信用卡审批()).append(",");
			ssb.append(oo.get最近1个月内的查询次数贷款审批()).append(",");
			ssb.append(oo.get最近1个月内的查询次数信用卡审批()).append(",");
			ssb.append(oo.get最近2年内的查询次数贷后管理()).append(",");
			ssb.append(oo.get最近2年内的查询次数担保资格审查()).append(",");
			ssb.append(oo.get最近2年内的查询次数特约商户实名审查()).append(",");
			ssb.append(first_loan).append(",");
			ssb.append(first_credit).append(",");
			ssb.append(first_qc).append(",");
			ssb.append(type).append(",");
			ssb.append(oo.get申请额度()).append(",");
			ssb.append(oo.get申请期限()).append(",");
			ssb.append(oo.getAPPL_ID());
			
			String textline =ssb.toString();
			pw.write(textline);
			pw.write("\r\n");
			
			
			
			
			//System.out.print(a[j]+"   ");
		
		//System.out.println();
		// 保存
		//session.save(idi);
	}

		pw.close();
	// 提交事务
	//session.getTransaction().commit();

	// 关闭连接
	session.close();
	sf.close();
}
}
