package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hdd.szdb.domain.NewData;

/**
 * Created by liuh on 2016/1/26.
 */
public class NewDataDaoImpl implements NewDataDao {



    public List<NewData> queryAll() throws Exception {
        return null;
    }


    public List<NewData> queryById(String id) throws Exception {
        Configuration cfg = new Configuration();
        // 读取hibernate.cfg.xml中的配置
        cfg.configure();
        // 获取SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        // 获取Session
        Session session = sf.openSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "FROM NewData as nd WHERE nd.id = "+id;
        Query query = session.createQuery(hql);
        List<NewData> list  = query.list();

        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        session.close();
        sf.close();

        return list;
    }


    public List<NewData> queryByApplId(String appl_id) throws Exception {
        Session session = HibernateUtil.currentSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "FROM NewData as nd WHERE nd.zaa = "+appl_id;
        Query query = session.createQuery(hql);
        List<NewData> list  = query.list();

        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        HibernateUtil.closeSession();

        return list;
    }


    public List<NewData> queryAllInCity(String cityId) throws Exception {

        Session session = HibernateUtil.currentSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "select * from newdata where zaa in (select APPL_ID from add_info_22 where 签约城市= "+cityId+")";
        Query query = session.createSQLQuery(hql).addEntity(NewData.class);
        List<NewData> list  = query.list();

        //System.out.println(list.get(0).toString());
        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        HibernateUtil.closeSession();

        return list;
    }


    public List<NewData> queryBrokenInCity(String cityId) throws Exception {

        Session session = HibernateUtil.currentSession();

        String hql = "select * from newdata where zae = 1 and zaa in (select APPL_ID from add_info_22 where 签约城市= "+cityId+")";
        Query query = session.createSQLQuery(hql).addEntity(NewData.class);
        List<NewData> list  = query.list();

        //System.out.println(list.get(0).toString());
        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        HibernateUtil.closeSession();


        return list;
    }


    public List<NewData> queryAbidedInCity(String cityId) throws Exception {
        Session session = HibernateUtil.currentSession();

        String hql = "select * from newdata where zae = 0 and zaa in (select APPL_ID from add_info_22 where 签约城市= "+cityId+")";
        Query query = session.createSQLQuery(hql).addEntity(NewData.class);
        List<NewData> list  = query.list();

        //System.out.println(list.get(0).toString());
        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        HibernateUtil.closeSession();


        return list;
    }


    public List<NewData> queryNoneInCity(String cityId) throws Exception {
        Session session = HibernateUtil.currentSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "select * from newdata where zaa in (select APPL_ID from add_info_22 where 签约城市= "+cityId+")  and zac is null ";
        Query query = session.createSQLQuery(hql).addEntity(NewData.class);
        List<NewData> list  = query.list();

/*        String hql = "FROM Detail as dt WHERE dt.id = "+city;
        Query query = session.createQuery(hql);
        List<Information> list  = query.list();*/

        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接

        System.out.println("1:"+list.get(0).toString());
        HibernateUtil.closeSession();


        return list;
    }


}
