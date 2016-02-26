package dbtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class ReadCsvLine {
	String[] headers;
	String[][] data;
	int nColumns;
	String indexName;
	Indexer index;
	
	public List loadCsvFirstLine(String filename, char seperator, String encoding,List<String>colNames,String indexName,boolean isUniquelyRelated) 
			throws Exception{
		this.indexName = indexName; //reportId
		LinkedList<String[]> in = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), encoding)); //传来的filename对应的csv文件
		String text = br.readLine();
		headers = text.split("" + seperator); //将读的每行有分隔符分割，所得到的字符串数组
		String[] row = split(text, seperator);
		int count = 0;
		in.add(row); //如果每行元素没有少，把string数组加到linkedlist in中
		br.close();
		
		return in;
	}

	public List loadCsv(String filename, char seperator, String encoding,List<String>colNames,String indexName,boolean isUniquelyRelated)
			throws Exception {
		this.indexName = indexName; //reportId
		LinkedList<String[]> in = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), encoding)); //传来的filename对应的csv文件

		String text = br.readLine();
		headers = text.split("" + seperator); //将读的每行有分隔符分割，所得到的字符串数组
		nColumns = headers.length;  //有多少列
		int count = 0;
		while ((text = br.readLine()) != null) {  //循环行
			count++;
			String[] row = split(text, seperator);
			if (row.length != nColumns)
				throw new Exception(String.format(
						"csv line %d should have %d columns. line is: [%s]",
						count + 1, nColumns, text));
			in.add(row); //如果每行元素没有少，把string数组加到linkedlist in中
		}
		br.close();
		
		return in;
	}
	

	public void setIndex( boolean isUniquelyRelated)
			throws Exception {
		String col_name = indexName;
		if (col_name == null)
			throw new Exception("Index name is null pointer");
		
		for (int i = 0;i<headers.length;i++) {
			String name = headers[i];
			if (col_name.equals(name)) {
				
			}
			i++;
		}
		throw new Exception("Cannot find index column named: "+col_name);
	}

	public HashMap<String, Object> queryNull(String report_id) {
		if (index.bMultiple){
			LinkedList<Integer> row_id = index.multiple.get(report_id);
			if (row_id == null){
				return null;
			}else
				return query(report_id);
		}else{
			Integer row_id = index.single.get(report_id);
			if (row_id==null)
				return null;
			else
				return query(report_id);
		}
	}
	
	public HashMap<String, Object> query(String key){
		HashMap<String, Object> ret = new HashMap<>();
		if (index.bMultiple){
			LinkedList<Integer> row_id = index.multiple.get(key);
			if (row_id == null){
				for(int k=0;k<headers.length;k++){
					ret.put(headers[k], new String[0]);
				}
				return ret;
			}
				
			else{
				int nRows = row_id.size();
				for(int k=0;k<headers.length;k++){
					String hd = headers[k];
					String[] content = new String[nRows];
					for (int j=0;j<nRows;j++){
						content[j] = data[row_id.get(j)][k];
					}
					ret.put(hd, content);
				}
				return ret;
			}
		}
		else{
			Integer row_id = index.single.get(key);
			if (row_id==null)
			{
				for(int k=0;k<headers.length;k++){
					ret.put(headers[k], "");
				}
				return ret;
			}
			else{
				for(int k=0;k<headers.length;k++){
					String hd = headers[k];
					String content = data[row_id][k];
					ret.put(hd, content);
				}
				return ret;
			}
		}
	}
	
	
	final char quote = '\"';

	boolean isQuoteChar(char c) {
		return c == quote;
	}

	private boolean isSeperator(char c, char sep) {
		return c == sep;
	}

	final static int Ready_For_Next = 0;
	final static int Reading_With_Quote = 1;
	final static int Reading_Without_Quote = 2;

	private String[] split(String lineTxt, char sep) throws Exception {

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
