package szdb.setup;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestMethod {

    public static List<List> toGroup(List valueList){
        //为了方便计算，先设置32个点
        List resultList = new LinkedList();
        int valueSize = valueList.size();
        if (valueSize % 2 == 1){
            Double value = Double.parseDouble(""+valueList.get((valueSize-1)/2));
            Double beforeValue = Double.parseDouble(""+valueList.get((valueSize-1)/2-1));
            Double afterValue = Double.parseDouble(""+valueList.get((valueSize-1)/2+1));
            System.out.println(value);
            System.out.println(beforeValue);
            System.out.println(afterValue);
        
            if((value-beforeValue)<(afterValue-value)){

                //第一种情况 放在放在前面
            	System.out.println("1");
                resultList.add(valueList.subList(0,(valueSize+1)/2));
                resultList.add(valueList.subList((valueSize+1)/2,valueSize));
            }else {
                //第二种情况  放在后面
            	System.out.println("2");
                resultList.add(valueList.subList(0,(valueSize-1)/2));
                resultList.add(valueList.subList((valueSize-1)/2,valueSize));
            }
        }else {
           //第三种情况  是偶数
        	System.out.println("3");
            resultList.add(valueList.subList(0,valueSize/2));
            resultList.add(valueList.subList(valueSize/2,valueSize));
        }

        return resultList;
    }
    
    public static void main(String[] args){
    	List<Double> list = new LinkedList<Double>();
    	list.add(0.0);
    	list.add(0.5);
    	list.add(2.0);
    	list.add(5.1);
    	list.add(5.2);
      	list.add(2.0);
    	list.add(5.1);
    	list.add(0.0);
    	list.add(22.2);
    	list.add(0.5);
    	list.add(2.0);
    	list.add(5.1);
    	list.add(5.2);
    	list.add(9.2);
    	list.add(2.3);
    	list.add(5.1);
    	list.add(5.2);
    	list.add(9.2);
    	list.add(2.3);
    	list.add(5.3);
    	Collections.sort(list);
    	System.out.println(list);
    	
    	List<List> result = toGroup(list);
    	List<List> result2= new LinkedList<>();
    	List<List> result3= new LinkedList<>();
    	for(List rList : result){
    		List<List> a2=toGroup(rList);
/*    		result.remove(rList);
    		result.add(result2);*/
    		
    		//System.out.println(a2);
    		for(List rrList : a2){
    			List<List> a3=toGroup(rrList);
    			result2.add(rrList);
    			//result3.add(a3);
    			for(List rrrList : a3){
    				List<List> a4 = toGroup(rrrList);
    				result3.add(rrrList);
    			}
    		}
    	}
    	System.out.println(result2);
    	System.out.println(result3);
    }
}

