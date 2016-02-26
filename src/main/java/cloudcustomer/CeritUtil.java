package cloudcustomer;

public class CeritUtil {

	
	/**
	 * 归一化算法
	 * @param value
	 * @param max
	 * @return
	 */
	public static Double one(Double value,Double max){
		
		Double normalized = 0d;
		
		if(value >= max){
			normalized = max.doubleValue();
		}else if(value <= 0){
			normalized = 0d;
		}
		
		normalized = value.doubleValue() / max.doubleValue();
		
		return normalized;
	}
}