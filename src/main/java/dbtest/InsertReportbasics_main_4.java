package dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.Queryrecordsum;
import com.hdd.dbtest.domain.Reportbasics_main_4;

public class InsertReportbasics_main_4 {

	public static void main(String[] args) throws Exception{
		String csvRoot = "data/data_dev/";
		String tableName = "Reportbasics_main_4.csv";
		
/*		ReadCsvLine rcl = new ReadCsvLine();
		List list = rcl.loadCsvFirstLine(csvRoot+tableName, ',', "GBK", null, null, true);
		
		String a[] = (String[]) list.get(0);
		System.out.println("private long id;");
		System.out.println();
		for(int i=0;i<a.length;i++){
			System.out.println("private String "+a[i]+";");
			System.out.println();
		}
		for(int i=0;i<a.length;i++){
	        //<property name="ExecutiveCourt" type="string"  column="ExecutiveCourt"/> 
	        System.out.println("<property name=\""+a[i]+"\" type=\"string\"  column=\""+a[i]+"\"/>");
	        System.out.println();
		}
		for(int i=0;i<a.length;i++){
			//		idi.setReportId(a[0]);
			String str = a[i];
			str  = str.substring(0,1).toUpperCase()+str.substring(1);
			System.out.println("idi.set"+str+"(a["+i+"]);");

		}*/
		
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
			Reportbasics_main_4 idi = new Reportbasics_main_4();
			idi.setId((long)(i+1));
			String a[] = (String[]) list.get(i);
			
			//System.out.print(i+" : ");
			
			for(int j=0;j<a.length;j++){
				idi.setOa_status(a[0]);
				idi.setAPPL_ID(a[1]);
				idi.setOa_loan_amt(a[2]);
				idi.setOa_result(a[3]);
				idi.setOa_opinion(a[4]);
				idi.set客户类别(a[5]);
				idi.set保密与否(a[6]);
				idi.set车辆购买贷款总额(a[7]);
				idi.set车辆购买方式(a[8]);
				idi.set车辆月付贷款(a[9]);
				idi.set贷款产品(a[10]);
				idi.set贷款用途(a[11]);
				idi.set单位人数(a[12]);
				idi.set房产购买总额(a[13]);
				idi.set房产月付贷款(a[14]);
				idi.set放款金额(a[15]);
				idi.set放款期限(a[16]);
				idi.set个体经营类型(a[17]);
				idi.set工资发放方式(a[18]);
				idi.set雇员人数(a[19]);
				idi.set行业(a[20]);
				idi.set婚姻状况(a[21]);
				idi.set教育程度(a[22]);
				idi.set经营场所所有(a[23]);
				idi.set经营场所月供金额(a[24]);
				idi.set经营场所月租金额(a[25]);
				idi.set居住地址省份城市(a[26]);
				idi.set每月房租(a[27]);
				idi.set年龄(a[28]);
				idi.set商品房及商铺数目(a[29]);
				idi.set申请额度(a[30]);
				idi.set申请期限(a[31]);
				idi.set同住人数(a[32]);
				idi.set现单位起始工作年数(a[33]);
				idi.set现住址起始居住年数(a[34]);
				idi.set小孩是否在深圳(a[35]);
				idi.set性别(a[36]);
				idi.set月均营业额(a[37]);
				idi.set月收入(a[38]);
				idi.set自有物业类型(a[39]);
				idi.set居住年数(a[40]);
				idi.set居住月数(a[41]);
				idi.set按揭(a[42]);
				idi.setReportId(a[43]);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String strDate = a[44];
				if(strDate != null && !"".equals(strDate)){
					Date date = sdf.parse(strDate);
					idi.setReportTime(date);
				}
				
				idi.set贷款发放日期(a[45]);
				idi.set贷款到期日期(a[46]);
				idi.setCUST_ID(a[47]);
				idi.set每月支薪日(a[48]);
				idi.setReportbasics_main_4_PRVT_QUARTER_INT(a[49]);
				idi.setReportbasics_main_4_oa_housetype(a[50]);
				idi.setReportbasics_main_4_PRVT_LAST_QUARTER_INT(a[51]);
				
				String strDate2 = a[52];
				if(strDate2 != null && !"".equals(strDate2)){
					Date date = sdf.parse(strDate);
					idi.setReportbasics_main_4_appl_date(date);
				}
				
				idi.setReportbasics_main_4_PRVT_BAL(a[53]);
				idi.setReportbasics_main_4_PUBLIC_LAST_QUARTER_INT(a[54]);
				idi.setReportbasics_main_4_oa_maritalstatus(a[55]);
				idi.setReportbasics_main_4_oa_appl_amt(a[56]);
				idi.setReportbasics_main_4_city(a[57]);
				idi.setReportbasics_main_4_PUBLIC_QUARTER_INT(a[58]);
				
				
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
