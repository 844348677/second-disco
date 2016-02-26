package szdb.cloudcustomer;



/**
 * Created by liuh on 2016/1/27.
 */
public class ModuleThree {

    public static Double CTR = 1.0862;
    public static Double X3_MAX = 1.9439;
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

    private CloudCustomer customer;
    public ModuleThree(CloudCustomer customer){
        this.customer = customer;
    }
    public Double getX1() {
        x1 = customer.getOtherLoan();
        return x1;
    }
    public Double getX2() {
        x2 = customer.getLoanManage();
        return x2;
    }

    public Double getX3() {

        x3 = customer.getAvgRepayment()/customer.getLoanMoney();

        if(x3 > X3_MAX){
            x3 = X3_MAX;
        }else if(x3 <= 0){
            x3 =0d;
        }

        return x3/X3_MAX;
    }

    public Double getHalf(){
        //平均季度结息=个人平均+对公平均
        double person = 0;
        double pub = 0;
        double avg = 0;
        //计算个人平均结息
        if(customer.getCurrentInterest() != -1 && customer.getPrevInterest() != -1){

            person = (customer.getCurrentInterest()+customer.getPrevInterest())/2;

        }else if(customer.getCurrentInterest() != -1){

            person = customer.getCurrentInterest();

        }else if(customer.getPrevInterest() != -1){

            person = customer.getPrevInterest();
        }

        //计算公共平均结息
        if(customer.getCurrentPubInterest() != -1 && customer.getPrevPubInterest() != -1){

            pub = (customer.getCurrentPubInterest()+customer.getPrevPubInterest())/2;

        }else if(customer.getPrevPubInterest() != -1){

            pub = customer.getPrevPubInterest();

        }else if(customer.getCurrentPubInterest() != -1){

            pub = customer.getCurrentPubInterest();
        }

        //计算平均结息 10^2.5-1
        avg = person + pub;
        double max = Math.pow(10.0, 2.5)-1;

        if(avg >= max){

            avg = max;
        }
        return avg;

    }


    public Double getX5() {

        //平均季度结息=个人平均+对公平均
        double person = 0;
        double pub = 0;
        double avg = 0;
        //计算个人平均结息
        if(customer.getCurrentInterest() != -1 && customer.getPrevInterest() != -1){

            person = (customer.getCurrentInterest()+customer.getPrevInterest())/2;

        }else if(customer.getCurrentInterest() != -1){

            person = customer.getCurrentInterest();

        }else if(customer.getPrevInterest() != -1){

            person = customer.getPrevInterest();
        }

        //计算公共平均结息
        if(customer.getCurrentPubInterest() != -1 && customer.getPrevPubInterest() != -1){

            pub = (customer.getCurrentPubInterest()+customer.getPrevPubInterest())/2;

        }else if(customer.getPrevPubInterest() != -1){

            pub = customer.getPrevPubInterest();

        }else if(customer.getCurrentPubInterest() != -1){

            pub = customer.getCurrentPubInterest();
        }

        //计算平均结息 10^2.5-1
        avg = person + pub;
        double max = Math.pow(10.0, 2.5)-1;

        if(avg >= max){

            avg = max;
        }

        if(Math.log10(avg+1) < CTR){
            x5= 1.0;
        }else{
            x5 = 0.0;
        }

        if(customer.getCurrentPubInterest() == -1 &&
                customer.getCurrentInterest() == -1 &&
                customer.getPrevInterest() == -1 &&
                customer.getPrevPubInterest() == -1){
            x5 = 0.0;
        }
        return x5;
    }
    public Double getX6() {
        x6 = customer.getCreitCard3QueryCount()+customer.getGuaranteeQueried();
        return x6;
    }


}
