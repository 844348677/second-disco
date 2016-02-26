package szdb.cloudcustomer;

/**
 * Created by liuh on 2016/1/28.
 */
public class DSSTreeTwo {

    private ModuleTwo moduleTwo;
    public DSSTreeTwo(ModuleTwo moduleTwo){
        this.moduleTwo = moduleTwo;
    }

    /**
     * module2计算结果
     * @return
     */
    public int compare(){


        Double x1 = moduleTwo.getX1();
        if(x1 ==null || "".equals(x1)){
            x1 = 0.0;
        }
        Double x4 = moduleTwo.getX4();
        int result = -1;

        if(x4 < 0.190909){
            result = -1;

        }else{

            if(x1 < 0.5){

                if(x4 < 0.469697){
                    result = -1;
                }else{
                    result = 1;
                }
            }else{
                result = 1;
            }
        }
        return result;
    }
}
