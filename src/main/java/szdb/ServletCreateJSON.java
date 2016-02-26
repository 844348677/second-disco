package szdb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class ServletCreateJSON {
	
	public static void main(String[] args) throws Exception{
		
		
		//InsertUtil.readCsvLine(csvRoot+tableName, ',', "GBK",null);
/*        jobj.put("id",newData.getId());
        jobj.put("zaa",newData.getZaa());*/
		

		String english = "data/json/newenglish.txt";
		String encoding = "GBK";
		

		BufferedReader br2 = new BufferedReader(new InputStreamReader(
				new FileInputStream(english), encoding)); //传来的filename对应的csv文件
		

		int count = 0;
		String text1 ;
		JSONObject obj=new  JSONObject();
		List list = new LinkedList();
		while((text1 = br2.readLine()) != null){
			//String text2=br2.readLine();
			String text3 = text1.substring(0,1).toUpperCase()+text1.substring(1);
			System.out.println("jobj.put(\""+text1+"\",newData.get"+text3+"());");
		}
		list.add(obj);
		System.out.println(obj.toJSONString());
		System.out.println(list);
/*		String text1 = br.readLine();
		String text2 = br.readLine();
		System.out.println(text1);
		System.out.println(text2);
		
		String text21 = br2.readLine();
		String text22 = br2.readLine();
		System.out.println(text21);
		System.out.println(text22);*/
		
		
		
	
	} 
}
