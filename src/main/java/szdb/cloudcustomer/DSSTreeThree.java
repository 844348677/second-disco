package szdb.cloudcustomer;

/**
 * Created by liuh on 2016/1/28.
 */
public class DSSTreeThree {

    //其他贷款笔数
    private Double x1;
    //最近2年内的查询次数-贷后管理
    private Double x2;
    //未结清贷款-最近六个月平均应还款/ 放款金额
    private Double x3;
    //globle_log10(1+平均季度结息) < ctr [1.0862]
    private Double x5;
    //最近2年内的查询次数-担保资格审查 + 信用卡最近3个月查询次数
    private Double x6;

    private ModuleThree moduleThree;
    public DSSTreeThree(ModuleThree moduleThree){

        this.moduleThree = moduleThree;
    }

    /**
     * 计算module3
     * @return
     */
    public int compare(){

        int result = 1;

        x1 = moduleThree.getX1();
        x2 = moduleThree.getX2();
        x3 = moduleThree.getX3();
        x5 = moduleThree.getX5();
        x6 = moduleThree.getX6();

        if(x6 < 0.176923){

            if(x5 < 0.5){

                if(x1 < 0.26){

                    if(x2 < 0.1129035){
                        result = -1;

                    }else{

                        if(x3 >= 0.0591723){
                            result = -1;
                        }else{
                            result = 1;
                        }
                    }
                }else{

                    if(x2 >= 0.08064515){

                        result = -1;
                    }else{

                        result = 1;
                    }
                }
            }else {

                if(x6 >= 0.1384615){

                    result = -1;

                }else{

                    if(x2 < 0.09139785){

                        if(x3 >= 0.03252485){

                            result = -1;

                        }else {

                            if(x3 <  0.01006322){
                                result =-1;
                            }else{
                                result = 1;
                            }
                        }

                    }else{

                        result = 1;
                    }
                }
            }
        }else{
            result = 1;
        }
        return result;
    }
}

