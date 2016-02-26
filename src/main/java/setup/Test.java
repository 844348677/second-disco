package setup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
    	 
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");
 
        System.out.println("\n例子1 - 计算'a'出现的次数");
        System.out.println("a : " + Collections.frequency(list, "a"));
 
        System.out.println("\n例子2 - 计算所有对象出现的次数");
        Set uniqueSet = new HashSet(list);
        for (Object temp : uniqueSet) {
            System.out.println(temp + ": " + Collections.frequency(list, temp));
        }
 
        System.out.println("\n例子3 -用Map来计算对象出现的次数");
        Map map = new HashMap();
 
        for (Object temp : list) {
            Integer count = (Integer) map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        printMap(map);
 
        System.out.println("\nMap排序-以key排序");
        Map treeMap = new TreeMap(map);
        printMap(treeMap);
 
    }
 
    public static void printMap(Map map) {
        for (Object  entry : map.entrySet()) {
            System.out.println("Key-value : " + ((Entry)entry).getKey() + "- "
                    + ((Entry)entry).getValue());
        }
    }
}
