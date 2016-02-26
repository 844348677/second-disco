package szdb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class InsertUtil {
	static String[] headers;
	String[][] data;
	int nColumns;
	static String indexName;
	Indexer index;

	public static void readCsvLine(String filename, char seperator, String encoding,String indexName) throws Exception{
		indexName = indexName; //reportId
		LinkedList<String[]> in = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), encoding)); //传来的filename对应的csv文件
		String text = br.readLine();
		headers = text.split("" + seperator); //将读的每行有分隔符分割，所得到的字符串数组
		String[] row = split(text, seperator);
		int count = 0;
		in.add(row); //如果每行元素没有少，把string数组加到linkedlist in中
		br.close();
		
		
		String aa[] = (String[]) in.get(0);
		System.out.println("private long id;");

		for(int i=0;i<aa.length;i++){
			System.out.println("private String "+aa[i].replace("-", "")+";");

		}
		for(int i=0;i<aa.length;i++){
	        //<property name="ExecutiveCourt" type="string"  column="ExecutiveCourt"/> 
	        System.out.println("<property name=\""+aa[i].replace("-", "")+"\" type=\"string\"  column=\""+aa[i].replace("-", "")+"\"/>");
	        System.out.println();
		}
/*		for(int i=0;i<aa.length;i++){
			//		idi.setReportId(a[0]);
			String str = aa[i].replace("-", "");
			str  = str.substring(0,1).toUpperCase()+str.substring(1);
			System.out.println("idi.set"+str+"(a["+i+"]);");

		}*/
		
		 // `actual_amt8` varchar(255) DEFAULT NULL,
		for(int i=0 ;i<aa.length;i++){
			String str = aa[i].replace("-", "");
			str  = str.substring(0,1).toUpperCase()+str.substring(1);
			System.out.println("`"+str+"` text(400) DEFAULT NULL,");
		
		}
		for(int i=0;i<aa.length;i++){
			//		idi.setReportId(a[0]);
			String str = aa[i].replace("-", "");
			str  = str.substring(0,1).toUpperCase()+str.substring(1);
			System.out.println("ssb.append(oo.get"+str+"()).append(\",\");");
		}
		
		
	}
	public static void readCsvLineNewData(String filename, char seperator, String encoding,String indexName) throws Exception{
		indexName = indexName; //reportId
		LinkedList<String[]> in = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), encoding)); //传来的filename对应的csv文件
		String text = br.readLine();
		headers = text.split("" + seperator); //将读的每行有分隔符分割，所得到的字符串数组
		String[] row = split(text, seperator);
		int count = 0;
		in.add(row); //如果每行元素没有少，把string数组加到linkedlist in中
		br.close();
		
		List charList = new ArrayList();
		charList.add("a");
		charList.add("b");
		charList.add("c");
		charList.add("d");
		charList.add("e");
		charList.add("f");
		charList.add("g");
		charList.add("h");
		charList.add("i");
		charList.add("j");
		charList.add("k");
		charList.add("l");
		charList.add("m");
		charList.add("n");
		charList.add("o");
		charList.add("p");
		charList.add("q");
		charList.add("r");
		charList.add("s");
		charList.add("t");
		charList.add("u");
		charList.add("v");
		charList.add("w");
		charList.add("x");
		charList.add("y");
		charList.add("z");
		
		String aa[] = (String[]) in.get(0);
		System.out.println("private long id;");
		for(int i=0;i<aa.length;i++){
			System.out.println(""+aa[i]);
/*			if(i<26){
				System.out.println("private String za"+charList.get(i)+";");

			}else if(i<52){
				System.out.println("private String zb"+charList.get(i-26)+";");

			}else if(i<78){
				System.out.println("private String zc"+charList.get(i-52)+";");

			}else if(i<104){
				System.out.println("private String zd"+charList.get(i-78)+";");

			}else if(i<130){
				System.out.println("private String ze"+charList.get(i-104)+";");

			}*/
		}
		for(int i=0;i<aa.length;i++){
			//<property name="ExecutiveCourt" type="string"  column="ExecutiveCourt"/> 
			//System.out.println("<property name=\""+aa[i].replace("-", "")+"\" type=\"string\"  column=\""+aa[i].replace("-", "")+"\"/>");
			if(i<26){
				System.out.println("<property name=\"za"+charList.get(i)+"\" type=\"string\" length =\"60\"  column=\"za"+charList.get(i)+"\"/>");


			}else if(i<52){
				System.out.println("<property name=\"zb"+charList.get(i-26)+"\" type=\"string\" length =\"60\"  column=\"zb"+charList.get(i-26)+"\"/>");
	

			}else if(i<78){
				System.out.println("<property name=\"zc"+charList.get(i-52)+"\" type=\"string\" length =\"60\" column=\"zc"+charList.get(i-52)+"\"/>");
		

			}else if(i<104){
				System.out.println("<property name=\"zd"+charList.get(i-78)+"\" type=\"string\" length =\"60\" column=\"zd"+charList.get(i-78)+"\"/>");
	

			}else if(i<130){
				System.out.println("<property name=\"ze"+charList.get(i-104)+"\" type=\"string\" length =\"60\" column=\"ze"+charList.get(i-104)+"\"/>");


			}
		}
		for(int i=0;i<aa.length;i++){
			//		idi.setReportId(a[0]);

			if(i<26){
				
				String str ="za"+ (String) charList.get(i);
				str  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("idi.set"+str+"(a["+i+"]);");

			}else if(i<52){
				
				String str ="zb"+ (String) charList.get(i-26);
				str  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("idi.set"+str+"(a["+i+"]);");	

			}else if(i<78){
				
				String str ="zc"+  (String) charList.get(i-52);
				str  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("idi.set"+str+"(a["+i+"]);");	

			}else if(i<104){
			
				String str ="zd"+  (String) charList.get(i-78);
				str  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("idi.set"+str+"(a["+i+"]);");	

			}else if(i<130){
			
				String str ="ze"+  (String) charList.get(i-104);
				str  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("idi.set"+str+"(a["+i+"]);");

			}

		}
		/*
		 * 			ctjson.put("zab",newData.getZab());
			ctjson.put("zac",newData.getZac());
		 */
		
		for(int i=0;i<aa.length;i++){
			//		idi.setReportId(a[0]);

			if(i<26){
				
				String str ="za"+ (String) charList.get(i);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("ctjson.put(\""+str+"\",newData.get"+str2+"());");

			}else if(i<52){
				
				String str ="zb"+ (String) charList.get(i-26);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("ctjson.put(\""+str+"\",newData.get"+str2+"());");	

			}else if(i<78){
				
				String str ="zc"+  (String) charList.get(i-52);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("ctjson.put(\""+str+"\",newData.get"+str2+"());");	

			}else if(i<104){
			
				String str ="zd"+  (String) charList.get(i-78);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("ctjson.put(\""+str+"\",newData.get"+str2+"());");	

			}else if(i<130){
			
				String str ="ze"+  (String) charList.get(i-104);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("ctjson.put(\""+str+"\",newData.get"+str2+"());");

			}

		}
		
		
		// `actual_amt8` varchar(255) DEFAULT NULL,
/*		for(int i=0 ;i<aa.length;i++){
			String str = aa[i].replace("-", "");
			str  = str.substring(0,1).toUpperCase()+str.substring(1);
			System.out.println("`"+str+"` text(400) DEFAULT NULL,");
			
		}*/
		
		/**
		 * 
		 	JSONObject ctjson11 = new JSONObject();
			ctjson11.put("name","zab");
			ctjson11.put("title","申请日期");
			ctjson11.put("label",newData.getZab());
			ctjson11.put("value",Double.parseDouble(newData.getZab()));
			ctjson11.put("avg",null);
			ctjson11.put("max",null);
			
			String typeName11 = TypeDataUtil.getType("zaa");
			List jsonDataList11 = TypeDataUtil.getData("zaa");
			ctjson11.put("type",typeName11);
			ctjson11.put("data",jsonDataList11);
			
			list1.add(ctjson11); 
		 
		 */
		
		
		
		for(int i=0;i<aa.length;i++){
			//		idi.setReportId(a[0]);
//if(newData.getZaa() != null && !"".equals(newData.getZaa()) && !"null".equals(newData.getZaa()))
			if(i<26){
				
				String str ="za"+ (String) charList.get(i);
				String bstr  = str.substring(0,1).toUpperCase()+str.substring(1);
				
				System.out.println("JSONObject ctjson1"+(i+1)+" = new JSONObject();");
				System.out.println("ctjson1"+(i+1)+".put(\"name\",\""+str+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"title\",\""+aa[i]+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"label\",newData.get"+bstr+"());");
				System.out.println("if(newData.get"+bstr+"() != null && !\"\".equals(newData.get"+bstr+"()) && !\"null\".equals(newData.get"+bstr+"()))");
				System.out.println("ctjson1"+(i+1)+".put(\"value\",Double.parseDouble(newData.get"+bstr+"()));");
				System.out.println("ctjson1"+(i+1)+".put(\"avg\",null);");
				System.out.println("ctjson1"+(i+1)+".put(\"max\",null);");
				System.out.println("");
				System.out.println("String typeName1"+(i+1)+" = TypeDataUtil.getType(\""+str+"\");");
				System.out.println("List jsonDataList1"+(i+1)+" = TypeDataUtil.getData(\""+str+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"type\",typeName1"+(i+1)+");");
				System.out.println("ctjson1"+(i+1)+".put(\"data\",jsonDataList1"+(i+1)+");");
				System.out.println("");

				System.out.println("list1.add(ctjson1"+(i+1)+");");
				
				
				
				

			}else if(i<52){
				
				String str ="zb"+ (String) charList.get(i-26);
				String bstr  = str.substring(0,1).toUpperCase()+str.substring(1);
				
				System.out.println("JSONObject ctjson1"+(i+1)+" = new JSONObject();");
				System.out.println("ctjson1"+(i+1)+".put(\"name\",\""+str+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"title\",\""+aa[i]+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"label\",newData.get"+bstr+"());");
				System.out.println("if(newData.get"+bstr+"() != null && !\"\".equals(newData.get"+bstr+"()) && !\"null\".equals(newData.get"+bstr+"()))");
				System.out.println("ctjson1"+(i+1)+".put(\"value\",Double.parseDouble(newData.get"+bstr+"()));");
				System.out.println("ctjson1"+(i+1)+".put(\"avg\",null);");
				System.out.println("ctjson1"+(i+1)+".put(\"max\",null);");
				
				System.out.println("");
				System.out.println("String typeName1"+(i+1)+" = TypeDataUtil.getType(\""+str+"\");");
				System.out.println("List jsonDataList1"+(i+1)+" = TypeDataUtil.getData(\""+str+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"type\",typeName1"+(i+1)+");");
				System.out.println("ctjson1"+(i+1)+".put(\"data\",jsonDataList1"+(i+1)+");");
				System.out.println("");
				
				System.out.println("list1.add(ctjson1"+(i+1)+");");

			}else if(i<78){
				
				String str ="zc"+  (String) charList.get(i-52);
				String bstr  = str.substring(0,1).toUpperCase()+str.substring(1);
				
				System.out.println("JSONObject ctjson1"+(i+1)+" = new JSONObject();");
				System.out.println("ctjson1"+(i+1)+".put(\"name\",\""+str+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"title\",\""+aa[i]+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"label\",newData.get"+bstr+"());");
				System.out.println("if(newData.get"+bstr+"() != null && !\"\".equals(newData.get"+bstr+"()) && !\"null\".equals(newData.get"+bstr+"()))");
				System.out.println("ctjson1"+(i+1)+".put(\"value\",Double.parseDouble(newData.get"+bstr+"()));");
				System.out.println("ctjson1"+(i+1)+".put(\"avg\",null);");
				System.out.println("ctjson1"+(i+1)+".put(\"max\",null);");
				
				System.out.println("");
				System.out.println("String typeName4"+(i+1)+" = TypeDataUtil.getType(\""+str+"\");");
				System.out.println("List jsonDataList4"+(i+1)+" = TypeDataUtil.getData(\""+str+"\");");
				System.out.println("ctjson4"+(i+1)+".put(\"type\",typeName4"+(i+1)+");");
				System.out.println("ctjson4"+(i+1)+".put(\"data\",jsonDataList4"+(i+1)+");");
				System.out.println("");
				
				System.out.println("list1.add(ctjson1"+(i+1)+");");	

			}else if(i<104){
			
				String str ="zd"+  (String) charList.get(i-78);
				String bstr  = str.substring(0,1).toUpperCase()+str.substring(1);
				
				System.out.println("JSONObject ctjson1"+(i+1)+" = new JSONObject();");
				System.out.println("ctjson1"+(i+1)+".put(\"name\",\""+str+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"title\",\""+aa[i]+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"label\",newData.get"+bstr+"());");
				System.out.println("if(newData.get"+bstr+"() != null && !\"\".equals(newData.get"+bstr+"()) && !\"null\".equals(newData.get"+bstr+"()))");
				System.out.println("ctjson1"+(i+1)+".put(\"value\",Double.parseDouble(newData.get"+bstr+"()));");
				System.out.println("ctjson1"+(i+1)+".put(\"avg\",null);");
				System.out.println("ctjson1"+(i+1)+".put(\"max\",null);");
				System.out.println("");
				System.out.println("String typeName7"+(i+1)+" = TypeDataUtil.getType(\""+str+"\");");
				System.out.println("List jsonDataList7"+(i+1)+" = TypeDataUtil.getData(\""+str+"\");");
				System.out.println("ctjson7"+(i+1)+".put(\"type\",typeName7"+(i+1)+");");
				System.out.println("ctjson7"+(i+1)+".put(\"data\",jsonDataList7"+(i+1)+");");
				System.out.println("");
				
				System.out.println("list1.add(ctjson1"+(i+1)+");");

			}else if(i<130){
			
				String str ="ze"+  (String) charList.get(i-104);
				String bstr  = str.substring(0,1).toUpperCase()+str.substring(1);
				
				System.out.println("JSONObject ctjson1"+(i+1)+" = new JSONObject();");
				System.out.println("ctjson1"+(i+1)+".put(\"name\",\""+str+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"title\",\""+aa[i]+"\");");
				System.out.println("ctjson1"+(i+1)+".put(\"label\",newData.get"+bstr+"());");
				System.out.println("if(newData.get"+bstr+"() != null && !\"\".equals(newData.get"+bstr+"()) && !\"null\".equals(newData.get"+bstr+"()))");
				System.out.println("ctjson1"+(i+1)+".put(\"value\",Double.parseDouble(newData.get"+bstr+"()));");
				System.out.println("ctjson1"+(i+1)+".put(\"avg\",null);");
				System.out.println("ctjson1"+(i+1)+".put(\"max\",null);");
				
				System.out.println("");
				System.out.println("String typeName8"+(i+1)+" = TypeDataUtil.getType(\""+str+"\");");
				System.out.println("List jsonDataList8"+(i+1)+" = TypeDataUtil.getData(\""+str+"\");");
				System.out.println("ctjson8"+(i+1)+".put(\"type\",typeName8"+(i+1)+");");
				System.out.println("ctjson8"+(i+1)+".put(\"data\",jsonDataList8"+(i+1)+");");
				System.out.println("");
				System.out.println("list1.add(ctjson1"+(i+1)+");");

			}

		}
		
		/**
		 
            String zaa = customer.getZaa();
            if(zaa != null && !"".equals(zaa) && !"null".equals(zaa) && !"NaN".equals(zaa))
                zaaList.add(zaa);
            valueMap.put("zaa",zaaList);
		 */
		
		for(int i=0;i<aa.length;i++){
			//		idi.setReportId(a[0]);

			if(i<26){
				
				String str ="za"+ (String) charList.get(i);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("String "+str+" = customer.get"+str2+"();");
				System.out.println("if("+str+" != null && !\"\".equals("+str+") && !\"null\".equals("+str+") && !\"NaN\".equals("+str+"))");
				System.out.println(""+str+"List.add("+str+");");
				System.out.println("valueMap.put(\""+str+"\","+str+"List);");
				
				


			}else if(i<52){
				
				String str ="zb"+ (String) charList.get(i-26);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("String "+str+" = customer.get"+str2+"();");
				System.out.println("if("+str+" != null && !\"\".equals("+str+") && !\"null\".equals("+str+") && !\"NaN\".equals("+str+"))");
				System.out.println(""+str+"List.add("+str+");");
				System.out.println("valueMap.put(\""+str+"\","+str+"List);");

			}else if(i<78){
				
				String str ="zc"+  (String) charList.get(i-52);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("String "+str+" = customer.get"+str2+"();");
				System.out.println("if("+str+" != null && !\"\".equals("+str+") && !\"null\".equals("+str+") && !\"NaN\".equals("+str+"))");
				System.out.println(""+str+"List.add("+str+");");
				System.out.println("valueMap.put(\""+str+"\","+str+"List);");

			}else if(i<104){
			
				String str ="zd"+  (String) charList.get(i-78);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("String "+str+" = customer.get"+str2+"();");
				System.out.println("if("+str+" != null && !\"\".equals("+str+") && !\"null\".equals("+str+") && !\"NaN\".equals("+str+"))");
				System.out.println(""+str+"List.add("+str+");");
				System.out.println("valueMap.put(\""+str+"\","+str+"List);");

			}else if(i<130){
			
				String str ="ze"+  (String) charList.get(i-104);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("String "+str+" = customer.get"+str2+"();");
				System.out.println("if("+str+" != null && !\"\".equals("+str+") && !\"null\".equals("+str+") && !\"NaN\".equals("+str+"))");
				System.out.println(""+str+"List.add("+str+");");
				System.out.println("valueMap.put(\""+str+"\","+str+"List);");

			}

		}
		
		/**
		 
        List zaaList = new ArrayList();
	 */
		
		for(int i=0;i<aa.length;i++){
			//System.out.println(""+aa[i]);
			if(i<26){
				System.out.println("List za"+charList.get(i)+"List = new ArrayList();");
				//System.out.println("private String za"+charList.get(i)+";");
				

			}else if(i<52){
				System.out.println("List zb"+charList.get(i-26)+"List = new ArrayList();");
				//System.out.println("private String zb"+charList.get(i-26)+";");

			}else if(i<78){
				System.out.println("List zc"+charList.get(i-52)+"List = new ArrayList();");
				//System.out.println("private String zc"+charList.get(i-52)+";");

			}else if(i<104){
				System.out.println("List zd"+charList.get(i-78)+"List = new ArrayList();");
				//System.out.println("private String zd"+charList.get(i-78)+";");

			}else if(i<130){
				System.out.println("List ze"+charList.get(i-104)+"List = new ArrayList();");
				//System.out.println("private String ze"+charList.get(i-104)+";");

			}
		}
		
		for(int i=0;i<aa.length;i++){
			//		idi.setReportId(a[0]);

			if(i<26){
				
				String str ="za"+ (String) charList.get(i);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("if(\""+str+"\".equals(name)) return get"+str2+"();");

			}else if(i<52){
				
				String str ="zb"+ (String) charList.get(i-26);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("if(\""+str+"\".equals(name)) return get"+str2+"();");

			}else if(i<78){
				
				String str ="zc"+  (String) charList.get(i-52);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("if(\""+str+"\".equals(name)) return get"+str2+"();");	

			}else if(i<104){
			
				String str ="zd"+  (String) charList.get(i-78);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("if(\""+str+"\".equals(name)) return get"+str2+"();");

			}else if(i<130){
			
				String str ="ze"+  (String) charList.get(i-104);
				String str2  = str.substring(0,1).toUpperCase()+str.substring(1);
				System.out.println("if(\""+str+"\".equals(name)) return get"+str2+"();");

			}

		}
		
		
	}
	
	
	final static char quote = '\"';

	static boolean isQuoteChar(char c) {
		return c == quote;
	}

	static private boolean isSeperator(char c, char sep) {
		return c == sep;
	}

	final static int Ready_For_Next = 0;
	final static int Reading_With_Quote = 1;
	final static int Reading_Without_Quote = 2;
	
	static private String[] split(String lineTxt, char sep) throws Exception {

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
	
	class Indexer {

		String name;
		int id;
		boolean bMultiple;
		HashMap<String, Integer> single = new HashMap<>();
		HashMap<String, LinkedList<Integer>> multiple = new HashMap<>();

		Indexer(String name2, int i) {
			name = name2;
			id = i;
		}

		public void set1v1(String[] indexData) throws Exception {
			int total = indexData.length;
			for (int i = 0; i < total; i++) {
				String key = indexData[i];
				if (single.containsKey(key))
					throw new Exception(String.format(
							"duplicated key[%s] for column[%s]", key, name));
				single.put(key, i);
			}
			bMultiple = false;
		}

		public void set1vN(String[] indexData) {
			int total = indexData.length;
			for (int i = 0; i < total; i++) {
				String key = indexData[i];
				if (!multiple.containsKey(key)) {
					multiple.put(key, new LinkedList<Integer>());
				}
				multiple.get(key).add(i);
			}
			bMultiple = true;
		}
	}
	
}
