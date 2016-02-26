package szdb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;


public class ReadLineCreateJson2 {

	String[] headers;
	String[][] data;
	int nColumns;
	String indexName;
	
	public List loadCsvFirstLine(String filename, char seperator, String encoding,List<String>colNames,String indexName,boolean isUniquelyRelated) 
			throws Exception{
		this.indexName = indexName; //reportId
		LinkedList in = new LinkedList();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), encoding)); //传来的filename对应的csv文件
		String text = br.readLine();
		headers = text.split("" + seperator); //将读的每行有分隔符分割，所得到的字符串数组

		int count = 0;
		in.add(text); //如果每行元素没有少，把string数组加到linkedlist in中
		br.close();
		
		return in;
		
		

	}
	
	public static void main(String[] args) throws Exception, FileNotFoundException{
		String chinese = "data/json/newchinese.txt";
		String english = "data/json/newenglish.txt";
		String encoding = "GBK";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(chinese), encoding)); //传来的filename对应的csv文件
		BufferedReader br2 = new BufferedReader(new InputStreamReader(
				new FileInputStream(english), encoding)); //传来的filename对应的csv文件
		

		int count = 0;
		String text1 ;
		JSONObject obj=new  JSONObject();
		List list = new LinkedList();
		while((text1 = br.readLine()) != null){
			String text2=br2.readLine();
			//obj.put(text2, text1);
			//System.out.println(obj.toJSONString());
			//list.add(obj);
			//System.out.println(":::"+text1+"::::"+text2+":::");
			
			String str = text2.replace("-", "");
			str  = str.substring(0,1).toUpperCase()+str.substring(1);
			
			
			System.out.println("idi.set"+str+"(oo.get"+text1+"());");
		}
/*		list.add(obj);
		System.out.println(obj.toJSONString());
		System.out.println(list);*/
		
		
		/*				idi.setZaa(oo.getAPPL_ID());
		idi.setZab(oo.get申请日期());
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
