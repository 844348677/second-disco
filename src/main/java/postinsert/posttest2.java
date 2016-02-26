package postinsert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alibaba.fastjson.JSONObject;
import com.hdd.szdb.domain.NewData;
import com.hdd.szdb.domain.Risk;

public class posttest2 {


    public static void main(String[] arg) throws Exception {
    	
    	
		Configuration cfg = new Configuration();
		// 读取hibernate.cfg.xml中的配置
		cfg.configure();
		// 获取SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		// 获取Session
		Session session = sf.openSession();

		// 开启事务
		session.beginTransaction();
		

		String hql = "select * from risk ";
        Query query = session.createSQLQuery(hql).addEntity(Risk.class);
        List<Risk> dataList  = query.list();
        
        
		// 提交事务
		session.getTransaction().commit();

		// 关闭连接
		session.close();
		sf.close();
		System.out.println(dataList.size());
		System.out.println(dataList.get(0));
/*		for(int i =0;i<dataList.size();i++){
			//System.out.println(dataList.get(i));
			String customer = dataList.get(i).toString();
	        String a[] = split(customer,'|');
	        //System.out.println(customer);
	       // System.out.println(a.length);
	        System.out.println(i+":"+a.length);
	        if(a.length!=20){
	        	System.out.println("111111111");
	        }
	        
		}*/
		for(int i =0;i<dataList.size();i++){
	        CloseableHttpClient httpclient1 = HttpClients.createDefault();

	        //HttpPost post = new HttpPost("http://hidimension.com:8066/lending_svc/insert/");
	        HttpPost post = new HttpPost("http://localhost:8080/insert/");
	        List<NameValuePair> list = new ArrayList<NameValuePair>();
	        list.add(new BasicNameValuePair("type", "risk"));
	        list.add(new BasicNameValuePair("param", dataList.get(i).toString()));
	        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,"UTF-8");
	        post.setEntity(uefEntity);
	        
	        // 执行, 获得HttpResponse
	        CloseableHttpResponse httpResponse = httpclient1.execute(post);

	        HttpEntity httpEntity = httpResponse.getEntity();
	        String responseData = EntityUtils.toString(httpEntity);
	        int statusCode = httpResponse.getStatusLine().getStatusCode();
	        if (statusCode == HttpStatus.SC_OK) {// 200
	            //LOG.info("预测成功!"+ responseData);
	        	System.out.println(responseData);
	        }
		}
		

        

		
    }
	final static int Ready_For_Next = 0;
	final static int Reading_With_Quote = 1;
	final static int Reading_Without_Quote = 2;
    
	private static String[] split(String lineTxt, char sep) throws Exception {

		char[] cs = lineTxt.toCharArray();
		boolean inQuote = false;
		boolean bFirst = true;
		int from = 0;
		int to = 0;
		LinkedList<String> ret = new LinkedList<>();
		int k = 0;
		int status = 0;
		while (k < cs.length) {
			char c = cs[k];
			switch (status) {
			case Ready_For_Next:
				if (isQuoteChar(c)) {
					status = Reading_With_Quote;
					k++;
					from = k;
				} else if (c == sep) {
					status = Ready_For_Next;
					k++;
					ret.add("");
				} else {
					status = Reading_Without_Quote;
					from = k++;
				}

				break;

			case Reading_With_Quote:
				if (isQuoteChar(c) && (k == cs.length - 1 || cs[k + 1] == sep)) {
					to = k;
					k = k + 2;
					status = Ready_For_Next;
					ret.add(lineTxt.substring(from, to).trim());
				} else {
					k++;
				}

				break;

			case Reading_Without_Quote:
				if (c == sep) {
					to = k++;
					ret.add(lineTxt.substring(from, to).trim());
					status = Ready_For_Next;
				} else {
					k++;
				}
				break;
			}
		}
		// fix the tail when ends up with seperator
		String lastField;
		if (status==Ready_For_Next)
			lastField = "";
		else if (status==Reading_With_Quote)
			if (isQuoteChar(cs[cs.length-1]))
				lastField = lineTxt.substring(from, cs.length-1);
			else
				throw new Exception("Reading with Quote, last char must be \"");
		else if (status==Reading_Without_Quote)
			lastField = lineTxt.substring(from);	
		else
			throw new Exception("Unknown status "+status);
		ret.add(lastField);
		String[] arr = new String[ret.size()];
		ret.toArray(arr);
		return arr;
	}
	
	static final char quote = '\"';

	static boolean isQuoteChar(char c) {
		return c == quote;
	}
}
