package com.wzres.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
/**
 * @ClassName：MybatisUtil
 * @description：Mybatis工具类
 * @date：2023-02-16 15:55
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sessionFactory  = null;
    //类加载执行：创建sqlSessionFactory对象
    static {
        try {
            sessionFactory   = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *获取会话对象
     * @return 会话对象
     */

    public  static  SqlSession openSession(){
        return sessionFactory.openSession();
    }
}