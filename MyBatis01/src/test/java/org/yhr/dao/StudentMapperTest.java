package org.yhr.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.yhr.mo.Student;
import org.yhr.utils.MybatisUtils;

import java.util.List;

public class StudentMapperTest {

    @Test
    public void selectTest(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        students.forEach(System.out::println);

        sqlSession.close();

    }

}
