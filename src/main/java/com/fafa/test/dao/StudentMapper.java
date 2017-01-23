package com.fafa.test.dao;

import java.util.List;

import com.fafa.test.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> selectAllInfo();
}