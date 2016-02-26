package dbtest;/*package com.hdd.dbtest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.dbtest.domain.ReportId;
import com.hdd.test.maininterface.CsvDataLoader;
import com.hdd.test.maininterface.web.HddWebVisitor2;
import com.hdd.test.maininterface.web.WebBatchTest;

public class InsertData {
	public static void main(String[] args) throws Exception{
		
		CsvDataLoader ld = new CsvDataLoader("ReportId");
		ld.load();
		HddWebVisitor2 visitor = new HddWebVisitor2();
		
		// load id_list
		WebBatchTest util = new WebBatchTest();
		
		String ReportIdFileName = "data/DataCompare/ReportId_List.txt";
		
		List<String>  id_list = util.loadConfigFile(ReportIdFileName);
		
		Long i = (long) 100000;
		

		


		Configuration cfg = new Configuration();
		// 璇诲彇hibernate.cfg.xml涓殑閰嶇疆
		cfg.configure();
		// 鑾峰彇SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 鑾峰彇Session
		Session session = sf.openSession();

		// 寮�鍚簨鍔�
		session.beginTransaction();
		
		for(String report_id:id_list)
			
		{	

			ReportId ri = new ReportId();
			ri.setId(i);
			ri.setReportId(report_id);
			// 淇濆瓨
			session.save(ri);

			i++;

		}

		
		// 鎻愪氦浜嬪姟
		session.getTransaction().commit();

		// 鍏抽棴杩炴帴
		session.close();
		sf.close();
		

	}
}
*/