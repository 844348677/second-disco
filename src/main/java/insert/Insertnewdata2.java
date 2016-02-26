package insert;

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
import com.hdd.szdb.domain.Info_address;
import com.hdd.szdb.domain.Info_bill;
import com.hdd.szdb.domain.NewData;
import com.hdd.szdb.domain.Oa_datatoqh_5;

public class Insertnewdata2 {
	public static void main(String[] args) throws Exception{
		String csvRoot = "data/sz/";
		String tableName = "newdata.csv";
		
		
		Configuration cfg = new Configuration();
		// 读取hibernate.cfg.xml中的配置
		cfg.configure();
		// 获取SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 获取Session
		Session session = sf.openSession();

		// 开启事务
		session.beginTransaction();
		

        String hql = "select * from detail where 网点 in ('罗湖分行','宝安分行','福田分行','龙岗分行') and 审批状态 != '同意'";
        Query query = session.createSQLQuery(hql).addEntity(Oa_datatoqh_5.class);
        List<Oa_datatoqh_5> alist  = query.list();
		
		System.out.println(alist.get(2130).toString());
		
		for(int i=0;i<alist.size();i++){
			NewData idi = new NewData();
			idi.setId((long)(i+1+9992));
			Oa_datatoqh_5 oo = alist.get(i);
			
			

			idi.setZaa(oo.getAPPL_ID());
			idi.setZab(oo.get申请日期());
			idi.setZac(null);
			idi.setZad(null);
			idi.setZae(oo.getOverdue_flag());
			idi.setZaf(oo.get申请额度());
			idi.setZag(oo.get申请期限());
			idi.setZah(oo.get年龄());
			idi.setZai(oo.get性别());
			idi.setZaj(oo.get贷款用途());
			idi.setZak(oo.get婚姻状况());
			idi.setZal(oo.get教育程度());
			idi.setZam(oo.get同住人数());
			idi.setZan(null);
			idi.setZao(oo.get每月房租());
			idi.setZap(null);
			idi.setZaq(oo.get现住址起始居住年数());
			idi.setZar(oo.get行业());
			idi.setZas(oo.get现单位起始工作年数());
			idi.setZat(oo.get月收入());
			idi.setZau(null);
			idi.setZav(oo.get单位人数());
			idi.setZaw(oo.get工资发放方式());
			idi.setZax(null);
			idi.setZay(oo.get保密与否());
			idi.setZaz(oo.get类型());
			idi.setZba(oo.get房产购买总额());
			idi.setZbb(null);
			idi.setZbc(oo.get车辆购买方式());
			idi.setZbd(oo.get车辆购买贷款总额());
			idi.setZbe(oo.get车辆月付贷款());
			idi.setZbf(null);
			idi.setZbg(null);
			idi.setZbh(null);
			idi.setZbi(null);
			idi.setZbj(null);
			idi.setZbk(null);
			idi.setZbl(oo.get居住地址省份城市());
			idi.setZbm(oo.get放款金额());
			idi.setZbn(oo.get放款期限());
			idi.setZbo(oo.get贷款产品());
			idi.setZbp(null);
			idi.setZbq(oo.get自有物业类型());
			idi.setZbr(oo.get商品房及商铺数目());
			idi.setZbs(oo.get现住址居住月数());
			idi.setZbt(oo.get客户类别());
			idi.setZbu(oo.get婚姻状态());
			idi.setZbv(oo.get学历());
			idi.setZbw(oo.get房贷笔数());
			idi.setZbx(oo.get其他贷款笔数());
			idi.setZby(oo.get首笔贷款发放月份());
			idi.setZbz(oo.get贷记卡账户数());
			idi.setZca(oo.get首张贷记卡发卡月份());
			idi.setZcb(oo.get准贷记卡账户数());
			idi.setZcc(oo.get首张准贷记卡发卡月份());
			idi.setZcd(oo.get贷款逾期笔数());
			idi.setZce(oo.get贷款逾期月份数());
			idi.setZcf(oo.get贷款逾期单月最高逾期总额());
			idi.setZcg(oo.get贷款逾期最长逾期月数());
			idi.setZch(oo.get贷记卡逾期账户数());
			idi.setZci(oo.get贷记卡逾期月份数());
			idi.setZcj(oo.get贷记卡单月最高逾期总额());
			idi.setZck(oo.get贷记卡逾期最长逾期月数());
			idi.setZcl(oo.get准贷记卡60天以上透支账户数());
			idi.setZcm(oo.get准贷记卡60天以上透支月份数());
			idi.setZcn(oo.get准贷记卡60天以上透支单月最高透支余额());
			idi.setZco(oo.get准贷记卡60天以上透支最长透支月数());
			idi.setZcp(oo.get未结清贷款贷款法人机构数());
			idi.setZcq(oo.get未结清贷款贷款机构数());
			idi.setZcr(oo.get未结清贷款贷款笔数());
			idi.setZcs(oo.get未结清贷款合同总额());
			idi.setZct(oo.get未结清贷款余额());
			idi.setZcu(oo.get未结清贷款最近六个月平均应还款());
			idi.setZcv(oo.get未销户贷记卡发卡法人机构数());
			idi.setZcw(oo.get未销户贷记卡发卡机构数());
			idi.setZcx(oo.get未销户贷记卡账户数());
			idi.setZcy(oo.get未销户贷记卡授信总额());
			idi.setZcz(oo.get未销户贷记卡单家行最高授信额());
			idi.setZda(oo.get未销户贷记卡单家行最低授信额());
			idi.setZdb(oo.get未销户贷记卡已用额度());
			idi.setZdc(oo.get最近6个月平均使用额度());
			idi.setZdd(oo.get准贷记卡发卡法人机构数());
			idi.setZde(oo.get准贷记卡发卡机构数());
			idi.setZdf(oo.get准贷记卡账户数());
			idi.setZdg(oo.get准贷记卡授信总额());
			idi.setZdh(oo.get准贷记卡单家行最高授信额());
			idi.setZdi(oo.get准贷记卡单家行最低授信额());
			idi.setZdj(oo.get准贷记卡透支余额());
			idi.setZdk(oo.get准贷记卡最近6个月平均透支余额());
			idi.setZdl(oo.get担保笔数());
			idi.setZdm(oo.get担保金额());
			idi.setZdn(oo.get担保本金余额());
			idi.setZdo(oo.get住房公积金参缴地());
			idi.setZdp(oo.get住房公积金参缴日期());
			idi.setZdq(oo.get住房公积金初缴月份());
			idi.setZdr(oo.get住房公积金缴至月份());
			idi.setZds(oo.get住房公积金月缴存额());
			idi.setZdt(oo.get住房公积金缴费状态());
			idi.setZdu(oo.get住房公积金个人缴存比例());
			idi.setZdv(oo.get住房公积金公司缴存比例());
			idi.setZdw(oo.get住房公积金信息更新日期());
			idi.setZdx(oo.get养老保险参保地());
			idi.setZdy(oo.get养老保险参保日期());
			idi.setZdz(oo.get养老保险累计缴费月数());
			idi.setZea(oo.get养老保险参加工作月份());
			idi.setZeb(oo.get养老保险缴费状态());
			idi.setZec(oo.get养老保险个人缴费基数());
			idi.setZed(oo.get养老保险本月缴费金额());
			idi.setZee(oo.get养老保险信息更新日期());
			idi.setZef(oo.get养老保险终端或终止缴费原因());
			idi.setZeg(oo.get最近1个月内的查询机构数贷款审批());
			idi.setZeh(oo.get最近1个月内的查询机构数信用卡审批());
			idi.setZei(oo.get最近1个月内的查询次数贷款审批());
			idi.setZej(oo.get最近1个月内的查询次数信用卡审批());
			idi.setZek(oo.get最近2年内的查询次数贷后管理());
			idi.setZel(oo.get最近2年内的查询次数担保资格审查());
			idi.setZem(oo.get最近2年内的查询次数特约商户实名审查());
			idi.setZen(oo.getChange_nameflag());
			idi.setZeo(oo.getDegree());
			
			
			
			//System.out.print(i+" : ");
			

/*				idi.setZaa(oo.getAPPL_ID());
				idi.setZab(oo.get申请日期());
				idi.setZac(a[2]);
				idi.setZad(a[3]);
				idi.setZae(a[4]);
				idi.setZaf(a[5]);
				idi.setZag(a[6]);
				idi.setZah(a[7]);
				idi.setZai(a[8]);
				idi.setZaj(a[9]);
				idi.setZak(a[10]);
				idi.setZal(a[11]);
				idi.setZam(a[12]);
				idi.setZan(a[13]);
				idi.setZao(a[14]);
				idi.setZap(a[15]);
				idi.setZaq(a[16]);
				idi.setZar(a[17]);
				idi.setZas(a[18]);
				idi.setZat(a[19]);
				idi.setZau(a[20]);
				idi.setZav(a[21]);
				idi.setZaw(a[22]);
				idi.setZax(a[23]);
				idi.setZay(a[24]);
				idi.setZaz(a[25]);
				idi.setZba(a[26]);
				idi.setZbb(a[27]);
				idi.setZbc(a[28]);
				idi.setZbd(a[29]);
				idi.setZbe(a[30]);
				idi.setZbf(a[31]);
				idi.setZbg(a[32]);
				idi.setZbh(a[33]);
				idi.setZbi(a[34]);
				idi.setZbj(a[35]);
				idi.setZbk(a[36]);
				idi.setZbl(a[37]);
				idi.setZbm(a[38]);
				idi.setZbn(a[39]);
				idi.setZbo(a[40]);
				idi.setZbp(a[41]);
				idi.setZbq(a[42]);
				idi.setZbr(a[43]);
				idi.setZbs(a[44]);
				idi.setZbt(a[45]);
				idi.setZbu(a[46]);
				idi.setZbv(a[47]);
				idi.setZbw(a[48]);
				idi.setZbx(a[49]);
				idi.setZby(a[50]);
				idi.setZbz(a[51]);
				idi.setZca(a[52]);
				idi.setZcb(a[53]);
				idi.setZcc(a[54]);
				idi.setZcd(a[55]);
				idi.setZce(a[56]);
				idi.setZcf(a[57]);
				idi.setZcg(a[58]);
				idi.setZch(a[59]);
				idi.setZci(a[60]);
				idi.setZcj(a[61]);
				idi.setZck(a[62]);
				idi.setZcl(a[63]);
				idi.setZcm(a[64]);
				idi.setZcn(a[65]);
				idi.setZco(a[66]);
				idi.setZcp(a[67]);
				idi.setZcq(a[68]);
				idi.setZcr(a[69]);
				idi.setZcs(a[70]);
				idi.setZct(a[71]);
				idi.setZcu(a[72]);
				idi.setZcv(a[73]);
				idi.setZcw(a[74]);
				idi.setZcx(a[75]);
				idi.setZcy(a[76]);
				idi.setZcz(a[77]);
				idi.setZda(a[78]);
				idi.setZdb(a[79]);
				idi.setZdc(a[80]);
				idi.setZdd(a[81]);
				idi.setZde(a[82]);
				idi.setZdf(a[83]);
				idi.setZdg(a[84]);
				idi.setZdh(a[85]);
				idi.setZdi(a[86]);
				idi.setZdj(a[87]);
				idi.setZdk(a[88]);
				idi.setZdl(a[89]);
				idi.setZdm(a[90]);
				idi.setZdn(a[91]);
				idi.setZdo(a[92]);
				idi.setZdp(a[93]);
				idi.setZdq(a[94]);
				idi.setZdr(a[95]);
				idi.setZds(a[96]);
				idi.setZdt(a[97]);
				idi.setZdu(a[98]);
				idi.setZdv(a[99]);
				idi.setZdw(a[100]);
				idi.setZdx(a[101]);
				idi.setZdy(a[102]);
				idi.setZdz(a[103]);
				idi.setZea(a[104]);
				idi.setZeb(a[105]);
				idi.setZec(a[106]);
				idi.setZed(a[107]);
				idi.setZee(a[108]);
				idi.setZef(a[109]);
				idi.setZeg(a[110]);
				idi.setZeh(a[111]);
				idi.setZei(a[112]);
				idi.setZej(a[113]);
				idi.setZek(a[114]);
				idi.setZel(a[115]);
				idi.setZem(a[116]);
				idi.setZen(a[117]);
				idi.setZeo(a[118]);*/
				
				
				//System.out.print(a[j]+"   ");
			
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
