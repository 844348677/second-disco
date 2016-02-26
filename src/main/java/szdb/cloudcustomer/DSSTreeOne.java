package szdb.cloudcustomer;

/**
 * Created by liuh on 2016/1/28.
 */
public class DSSTreeOne {

    private ModuleOne moduleOne;

    public DSSTreeOne(ModuleOne moduleOne){

        this.moduleOne = moduleOne;
    }

    /**
     * module1计算结果
     * @return
     */
    public int compare(){

        int result = -1;
        Double x1 = moduleOne.getX1();
        Double x2 = moduleOne.getX2();

        if(x2 < 0.376488){

            result = -1;

        }else{

            if(x1 >= 0.08653845){

                if(x2 < 0.581845){
                    result = -1;
                }else{
                    result = 1;
                }

            }else {
                result = 1;
            }
        }
        return result;
    }
}
