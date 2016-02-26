package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hdd.szdb.domain.Add_info_22;
import com.hdd.szdb.domain.NewData;

/**
 * Created by liuh on 2016/1/26.
 */
public class Addinfo22DaoImpl implements Addinfo22Dao {


    public List<Add_info_22> queryAll() throws Exception {
        Configuration cfg = new Configuration();
        // 读取hibernate.cfg.xml中的配置
        cfg.configure();
        // 获取SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        // 获取Session
        Session session = sf.openSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "FROM Add_info_22 ";
        Query query = session.createQuery(hql);
        List<Add_info_22> list = query.list();

        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        session.close();
        sf.close();

        return list;
    }


    public List<Add_info_22> queryById(String id) throws Exception {
        Configuration cfg = new Configuration();
        // 读取hibernate.cfg.xml中的配置
        cfg.configure();
        // 获取SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        // 获取Session
        Session session = sf.openSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "FROM Add_info_22 as ai WHERE ai.id =  "+id;
        Query query = session.createQuery(hql);
        List<Add_info_22> list = query.list();

        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        session.close();
        sf.close();

        return list;
    }


    public List<Add_info_22> queryByApplId(String appl_id) throws Exception {
        Configuration cfg = new Configuration();
        // 读取hibernate.cfg.xml中的配置
        cfg.configure();
        // 获取SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        // 获取Session
        Session session = sf.openSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "FROM Add_info_22 as ai WHERE ai.APPL_ID =  "+appl_id;
        Query query = session.createQuery(hql);
        List<Add_info_22> list = query.list();

        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        session.close();
        sf.close();

        return list;
    }
    
    public List<Add_info_22> queryAllInCity(String cityId) {
        Session session = (Session) HibernateUtil.currentSession();

        String hql = "select * from add_info_22 where 签约城市= "+cityId;
        Query query = session.createSQLQuery(hql).addEntity(Add_info_22.class);
        List<Add_info_22> list  = query.list();

        //System.out.println(list.get(0).toString());
        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        HibernateUtil.closeSession();


        return list;
    }
    
    
}
