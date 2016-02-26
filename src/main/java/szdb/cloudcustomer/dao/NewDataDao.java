package szdb.cloudcustomer.dao;



import java.util.List;

import com.hdd.szdb.domain.NewData;

/**
 * Created by liuh on 2016/1/26.
 */
public interface NewDataDao {

    List<NewData> queryAll() throws Exception;

    List<NewData>  queryById(String id) throws Exception;

    List<NewData>  queryByApplId(String appl_id) throws Exception;

    List<NewData> queryAllInCity(String cityId) throws Exception;

    List<NewData> queryBrokenInCity(String cityId) throws Exception;

    List<NewData> queryAbidedInCity(String cityId) throws Exception;


    List<NewData>  queryNoneInCity(String city) throws Exception;
}
