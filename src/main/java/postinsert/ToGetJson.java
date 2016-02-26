package postinsert;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ToGetJson {

    public static void main(String[] arg) throws Exception {
    	
        CloseableHttpClient httpclient1 = HttpClients.createDefault();

        
/*        HttpPost post = new HttpPost("http://hidimension.com:8066/lending_svc/customers/");
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("type", "lgd"));
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
        */

        String allCustomer = "http://hidimension.com:8066/lending_svc/customers";
        String brokenC = "http://hidimension.com:8066/lending_svc/customers?category=broken";
        String abiden = "http://hidimension.com:8066/lending_svc/customers?category=abided";
        String none = "http://hidimension.com:8066/lending_svc/customers?category=none";
        
        String informate ="http://hidimension.com:8066/lending_svc/customers/information?applid=66909";
        
        String risk = "http://hidimension.com:8066/lending_svc/risk?applid=66909";
        String risklgd = "http://hidimension.com:8066/lending_svc/risk/lgd?applid=66909";
        
        HttpGet get = new HttpGet("http://hidimension.com:8066/lending_svc/customers/");
        CloseableHttpResponse httpResponseGet = httpclient1.execute(get);
        
        
        HttpEntity httpEntity = httpResponseGet.getEntity();
        String responseData = EntityUtils.toString(httpEntity);
        int statusCode = httpResponseGet.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {// 200
            //LOG.info("预测成功!"+ responseData);
        	System.out.println(responseData);
        }
        
        
    }
	
}
