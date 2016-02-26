package hist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.szdb.domain.NewData;
import com.hdd.szdb.domain.Oa_datatoqh_5;

public class TestHist {

	public static void main(String[] args) throws Exception{
		
		Configuration cfg = new Configuration();
		// 读取hibernate.cfg.xml中的配置
		cfg.configure();
		// 获取SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 获取Session
		Session session = sf.openSession();

		// 开启事务
		//session.beginTransaction();
		
			//所有人
	       String hql1 = "select * from newdata where zaa in (select APPL_ID from add_info_22 where 签约城市= 6)";
	       	//已经贷款
	       String hql11 = "select * from newdata where zaa in (select APPL_ID from add_info_22 where 签约城市= 6) and zac is not null ";
	       //违约
	       String hql2 = "select * from newdata where zae = 1 and  zaa in (select APPL_ID from add_info_22 where 签约城市= 6) and zac is not null ";
	       //未违约
	       String hql3 = "select * from newdata where zae = 0 and  zaa in (select APPL_ID from add_info_22 where 签约城市= 6) and zac is not null ";
	       //为借贷  "zaf": "申请额度",
	       String hql4 = "select * from newdata where zaa in (select APPL_ID from add_info_22 where 签约城市= 6)   and zac is null ";
	       
	       
	       
	        Query query = session.createSQLQuery(hql4).addEntity(NewData.class);
	        List<NewData> alist  = query.list();
			
			System.out.println(alist.size());
			
			List dataList = new ArrayList();
			
			
			double total = 0 ;
			BigDecimal bdtotal = new BigDecimal(0);
			double max =0;
			
			
			
			for(int i=0;i<alist.size();i++){
				
				NewData idi = alist.get(i);
				
				//double fangkuanjine = Double.parseDouble(idi.getZbm());    //放贷金额
				double fangkuanjine = Double.parseDouble(idi.getZaf());  //申请金额
				
				BigDecimal fangkuanjinebd = new BigDecimal(fangkuanjine);
				
				//ageList.add(Double.parseDouble(idi.getZbm()));   //放贷金额
				dataList.add(Double.parseDouble(idi.getZaf()));   //申请金额
				
				bdtotal = bdtotal.add(fangkuanjinebd);
				
				
				if(Double.parseDouble(idi.getZaf())>max){
					max = Double.parseDouble(idi.getZaf());
				}

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
				//session.save(idi);
			}
			System.out.println("Max::"+max);
			System.out.println("::"+alist.size());
			System.out.println("total:"+bdtotal.toString());
			System.out.println("average:"+(bdtotal.divide(new BigDecimal(2422),6,BigDecimal.ROUND_HALF_UP)).doubleValue());
			
			System.out.println("dataList"+dataList);
			// 提交事务
			//session.getTransaction().commit();

			// 关闭连接
			session.close();
			sf.close();
		
		
	}
	
}
