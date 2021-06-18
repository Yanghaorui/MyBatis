package org.yhr.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


    /**
     * 查询
     * 查询不用提交事务
     */
    public static <T> void select(Class<T> clazz,ExeMapper<T> exe){
        MybatisUtils.exe(clazz,exe,null);
    }

    /**
     * 增删改
     * 需要提交事务
     */
    public static <T> void exe(Class<T> clazz,ExeMapper<T> exe){
        MybatisUtils.exe(clazz,exe,SqlSession::commit);
    }


    private static <T> void exe(Class<T> clazz,ExeMapper<T> exe,Commit commit){
        //获取sqlSession对象
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            //执行
            T t = sqlSession.getMapper(clazz);
            exe.exe(t);
            if(null != commit){
                commit.commit(sqlSession);
            }
        }catch (Exception e){
            System.out.println("exe mapper error:" + e);
        }
    }

}
