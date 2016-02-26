package szdb;

public class ForToWriteCode {

	
	/*
	 * 
	 *             String x1 = risk.getA11();
	             if(x1 != null && !"".equals(x1) && !"null".equals(x1))
                x1List.add(x1);
                valueMap.put("x1",x1List);
	 */
	public static void main(String[] args){
		
		for(int i = 1 ; i<10 ;i++){
			
			System.out.println("String x"+i+" = risk.getA1"+i+"();");
			System.out.println("if(x"+i+" != null && !\"\".equals(x"+i+") && !\"null\".equals(x"+i+"))");
			System.out.println("x"+i+"List.add(x"+i+");");
			System.out.println("valueMap.put(\"x"+i+"\",x"+i+"List);");
			
		}
		
	}
	
}
