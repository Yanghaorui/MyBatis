package org.yhr.dao;

import org.yhr.mo.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    List<Student> get();

    Student getById(int id);

    List<Student> like(String name);

    int add(Student student);

    int update(Student student);

    int delete(int id);

    void updateByMap(Map<String,Object> map);
}
