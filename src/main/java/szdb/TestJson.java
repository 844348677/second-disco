package szdb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hdd.szdb.domain.Information;

public class TestJson {
	
    public static List<Information> queryById(String id) throws Exception {
        Configuration cfg = new Configuration();
        // 读取hibernate.cfg.xml中的配置
        cfg.configure();
        // 获取SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        // 获取Session
        Session session = sf.openSession();

        // 开启事务
        //session.beginTransaction();

        String hql = "FROM Information as if WHERE if.id = "+id;
        Query query = session.createQuery(hql);
        List<Information> list  = query.list();

        // 提交事务
        //session.getTransaction().commit();
        // 关闭连接
        session.close();
        sf.close();

        return list;
        
        
        /*        List<Information> ddlist = null;
        try {
            ddlist = queryById("2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("::"+ddlist.get(0));*/
    }

	public static void main(String[] args) {
/*		// 创建一个文件对象
		File datafile = new File("data/test.json");

		if (datafile.exists() && datafile.isFile()) {
			System.out.println("使用已经存在的datafile.txt文件");
		} else {
			try {
				// 创建文件
				datafile.createNewFile();
				System.out.println("创建datafile.txt文件");
			} catch (IOException e) {
				System.out.println("创建datafile.txt文件失败,错误信息：" + e.getMessage());
				return;
			}
		}

		// 下面开始向文件中写入数据
		try {
			// 创建一个printWriter类的实例，其构造函函数是一个File对象
			PrintWriter pw = new PrintWriter(datafile);

			// 调用writer()方法写入数据
			pw.write("[");
			pw.write("\r\n\t");
			pw.write("{");
			pw.write("\r\n\t\t");
			pw.write("1111");
			pw.write("\r\n\t");
			pw.write("}");
			pw.write("\r\n");
			pw.write("]");

			// 调用close()方法释放资源
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件!错误信息为：" + e.getMessage());
		}*/
		
		
        List<Information> ddlist = null;
        try {
            ddlist = queryById("2");
            
            
            
            
            Information inf = ddlist.get(0);
            JSONObject jobj = new JSONObject();
            //jobj = (JSONObject) JSON.parse(inf.toString());
            jobj.put("id", inf.getId());
            
            
            System.out.println(jobj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("::"+ddlist.get(0));
        
        
        
        
        
	}
}
