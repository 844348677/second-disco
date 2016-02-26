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
import com.hdd.szdb.domain.Oa_datatoqh_5;

public class Insertoa_datatoqh_5 {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "oa_datatoqh_5.csv";
		
		
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
			Oa_datatoqh_5 idi = new Oa_datatoqh_5();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setAPPL_ID(a[0]);
				idi.set申请日期(a[1]);
				idi.setOverdue_flag(a[2]);
				idi.set申请额度(a[3]);
				idi.set申请期限(a[4]);
				idi.set年龄(a[5]);
				idi.set性别(a[6]);
				idi.set贷款用途(a[7]);
				idi.set婚姻状况(a[8]);
				idi.set教育程度(a[9]);
				idi.set同住人数(a[10]);
				idi.set每月房租(a[11]);
				idi.set现住址起始居住年数(a[12]);
				idi.set行业(a[13]);
				idi.set现单位起始工作年数(a[14]);
				idi.set月收入(a[15]);
				idi.set单位人数(a[16]);
				idi.set工资发放方式(a[17]);
				idi.set保密与否(a[18]);
				idi.set类型(a[19]);
				idi.set房产购买总额(a[20]);
				idi.set车辆购买方式(a[21]);
				idi.set车辆购买贷款总额(a[22]);
				idi.set车辆月付贷款(a[23]);
				idi.set居住地址省份城市(a[24]);
				idi.set放款金额(a[25]);
				idi.set放款期限(a[26]);
				idi.set贷款产品(a[27]);
				idi.set自有物业类型(a[28]);
				idi.set商品房及商铺数目(a[29]);
				idi.set现住址居住月数(a[30]);
				idi.set客户类别(a[31]);
				idi.set审批状态(a[32]);
				idi.set审批意见(a[33]);
				idi.set联系人电话核查异常情况(a[34]);
				idi.set贷款用途及资金需求(a[35]);
				idi.set所处行业及公司人数描述(a[36]);
				idi.set月营业额净利润(a[37]);
				idi.set网点(a[38]);
				idi.set婚姻状态(a[39]);
				idi.set学历(a[40]);
				idi.set房贷笔数(a[41]);
				idi.set其他贷款笔数(a[42]);
				idi.set首笔贷款发放月份(a[43]);
				idi.set贷记卡账户数(a[44]);
				idi.set首张贷记卡发卡月份(a[45]);
				idi.set准贷记卡账户数(a[46]);
				idi.set首张准贷记卡发卡月份(a[47]);
				idi.set贷款逾期笔数(a[48]);
				idi.set贷款逾期月份数(a[49]);
				idi.set贷款逾期单月最高逾期总额(a[50]);
				idi.set贷款逾期最长逾期月数(a[51]);
				idi.set贷记卡逾期账户数(a[52]);
				idi.set贷记卡逾期月份数(a[53]);
				idi.set贷记卡单月最高逾期总额(a[54]);
				idi.set贷记卡逾期最长逾期月数(a[55]);
				idi.set准贷记卡60天以上透支账户数(a[56]);
				idi.set准贷记卡60天以上透支月份数(a[57]);
				idi.set准贷记卡60天以上透支单月最高透支余额(a[58]);
				idi.set准贷记卡60天以上透支最长透支月数(a[59]);
				idi.set未结清贷款贷款法人机构数(a[60]);
				idi.set未结清贷款贷款机构数(a[61]);
				idi.set未结清贷款贷款笔数(a[62]);
				idi.set未结清贷款合同总额(a[63]);
				idi.set未结清贷款余额(a[64]);
				idi.set未结清贷款最近六个月平均应还款(a[65]);
				idi.set未销户贷记卡发卡法人机构数(a[66]);
				idi.set未销户贷记卡发卡机构数(a[67]);
				idi.set未销户贷记卡账户数(a[68]);
				idi.set未销户贷记卡授信总额(a[69]);
				idi.set未销户贷记卡单家行最高授信额(a[70]);
				idi.set未销户贷记卡单家行最低授信额(a[71]);
				idi.set未销户贷记卡已用额度(a[72]);
				idi.set最近6个月平均使用额度(a[73]);
				idi.set准贷记卡发卡法人机构数(a[74]);
				idi.set准贷记卡发卡机构数(a[75]);
				idi.set准贷记卡账户数2(a[76]);
				idi.set准贷记卡授信总额(a[77]);
				idi.set准贷记卡单家行最高授信额(a[78]);
				idi.set准贷记卡单家行最低授信额(a[79]);
				idi.set准贷记卡透支余额(a[80]);
				idi.set准贷记卡最近6个月平均透支余额(a[81]);
				idi.set担保笔数(a[82]);
				idi.set担保金额(a[83]);
				idi.set担保本金余额(a[84]);
				idi.set住房公积金参缴地(a[85]);
				idi.set住房公积金参缴日期(a[86]);
				idi.set住房公积金初缴月份(a[87]);
				idi.set住房公积金缴至月份(a[88]);
				idi.set住房公积金月缴存额(a[89]);
				idi.set住房公积金缴费状态(a[90]);
				idi.set住房公积金个人缴存比例(a[91]);
				idi.set住房公积金公司缴存比例(a[92]);
				idi.set住房公积金信息更新日期(a[93]);
				idi.set养老保险参保地(a[94]);
				idi.set养老保险参保日期(a[95]);
				idi.set养老保险累计缴费月数(a[96]);
				idi.set养老保险参加工作月份(a[97]);
				idi.set养老保险缴费状态(a[98]);
				idi.set养老保险个人缴费基数(a[99]);
				idi.set养老保险本月缴费金额(a[100]);
				idi.set养老保险信息更新日期(a[101]);
				idi.set养老保险终端或终止缴费原因(a[102]);
				idi.set最近1个月内的查询机构数贷款审批(a[103]);
				idi.set最近1个月内的查询机构数信用卡审批(a[104]);
				idi.set最近1个月内的查询次数贷款审批(a[105]);
				idi.set最近1个月内的查询次数信用卡审批(a[106]);
				idi.set最近2年内的查询次数贷后管理(a[107]);
				idi.set最近2年内的查询次数担保资格审查(a[108]);
				idi.set最近2年内的查询次数特约商户实名审查(a[109]);
				idi.setChange_nameflag(a[110]);
				idi.setOa_chinsz(a[111]);
				idi.setOa_manageowntype(a[112]);
				idi.setDegree(a[113]);
				idi.setOa_indhighrflag(a[114]);
				idi.setOa_mortgage(a[115]);
				idi.setOa_housepayment(a[116]);
				idi.setOa_managerent(a[117]);
				idi.setOa_managepayment(a[118]);
				idi.setOa_manageavgtur(a[119]);
				idi.setLoan_begin(a[120]);
				idi.setLoan_end(a[121]);
				
				
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
