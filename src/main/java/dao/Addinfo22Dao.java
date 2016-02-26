package dao;



import java.util.List;

import com.hdd.szdb.domain.Add_info_22;

/**
 * Created by liuh on 2016/1/25.
 */
public interface Addinfo22Dao {

    List<Add_info_22> queryAll() throws Exception;

    List<Add_info_22>  queryById(String id) throws Exception;

    List<Add_info_22>  queryByApplId(String appl_id) throws Exception;

	List<Add_info_22> queryAllInCity(String string);
}
