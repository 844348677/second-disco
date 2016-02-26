package cloudcustomer;



/**
 * Created by liuh on 2016/1/27.
 */
public class ModuleTwo {
    //房产类型=租用=1
    private Double x1;
    //最近1个月内的查询次数-贷款审批 + 信用卡最近3个月查询次数
    private Double x4;

    private CloudCustomer customer;

    public ModuleTwo(CloudCustomer customer){
        this.customer = customer;
    }

    public Double getX1(){
        return customer.getPropertyType();
    }

    public Double getX11(){
        return customer.getLiveType();
    }

    public Double getX4(){

        return customer.getAuditQueryCount()+customer.getCreitCard3QueryCount();
    }


}
