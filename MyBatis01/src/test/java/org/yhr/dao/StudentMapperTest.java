package org.yhr.dao;

import org.junit.Test;
import org.yhr.mo.Student;
import org.yhr.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperTest {


    @Test
    public void selectTest(){
        //执行
        MybatisUtils.select(StudentMapper.class,(mapper)->{
            List<Student> students = mapper.get();
            students.forEach(System.out::println);
        });
    }

    @Test
    public void getByIdTest(){
        MybatisUtils.select(StudentMapper.class,(mapper)->{
            Student student = mapper.getById(10);
            System.out.println(student);
        });
    }


    @Test
    public void addTest(){
        MybatisUtils.exe(StudentMapper.class,studentMapper -> {
            Student student = new Student();
            student.setAge(25);
            student.setName("姓名");
            int add = studentMapper.add(student);
            System.out.println(add);
        });
    }

    @Test
    public void updateTest(){
        MybatisUtils.exe(StudentMapper.class,studentMapper -> {
            Student student = new Student();
            student.setId(1);
            student.setName("第一");
            student.setAge(13);
            int update = studentMapper.update(student);
            System.out.println(update);
        });
    }

    @Test
    public void deleteTest(){
        MybatisUtils.exe(StudentMapper.class,studentMapper -> {
            int delete = studentMapper.delete(7);
            System.out.println(delete);
        });
    }


    @Test
    public void likeTest(){
        MybatisUtils.select(StudentMapper.class,studentMapper -> {
            List<Student> like = studentMapper.like("%小%");
            like.forEach(System.out::println);
        });
    }

    @Test
    public void mapTest(){
        MybatisUtils.exe(StudentMapper.class,studentMapper -> {
            Map<String,Object> map = new HashMap<>(4);
            map.put("username","第二");
            map.put("no",2);
            studentMapper.updateByMap(map);
        });
    }


}
