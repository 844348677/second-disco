package cloudcustomer;



import java.util.List;

/**
 * Created by liuh on 2016/1/26.
 */
public interface CloudCustomerTransformDao {

    List<CloudCustomer> queryAll() throws Exception;

    List<CloudCustomer>  queryById(String id) throws Exception;

    List<CloudCustomer>  queryByApplId(String id) throws Exception;



}
