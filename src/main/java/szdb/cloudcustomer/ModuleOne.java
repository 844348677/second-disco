package szdb.cloudcustomer;



/**
 * Created by liuh on 2016/1/27.
 */

public class ModuleOne {

    //贷记卡最近24个月逾期1期次数
    private Double x1;

    //信用卡最近6个月查询次数 + 贷款最近2个月查询次数
    private Double x2;

    private CloudCustomer customer;
    public ModuleOne(CloudCustomer customer){

        this.customer = customer;
    }

    public Double getX1(){

        return customer.getLoanCardDelyCount();
    }

    public Double getX2(){

        return customer.getCreitCard6QueryCount()+customer.getLoanQueryCount();
    }
}