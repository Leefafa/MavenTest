package com.fafa.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fafa.test.dao.StudentMapper;
import com.fafa.test.model.Student;

/**
 * MyBaties测试
 * @author fafa
 * @data Jan 22, 2017
 * @time 11:23:30 AM
 * 
 */
public class MyBatisTest 
{
	private StudentMapper studentMapper;
	List<Student> info=studentMapper.selectAllInfo();
	public static void main(String[] args)
    {
    	try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
            	StudentMapper mapper = session.getMapper(StudentMapper.class);
                List<Student> studentInfos = mapper.selectAllInfo();
                if (studentInfos == null) {
                    System.out.println("The result is null.");
                } else {
                	System.out.println("编号\t姓名\t性别\t出生日期\t\t班级");
                    for (Student student : studentInfos) {
                    	System.out.println(student.getStudentId()+"\t"+student.getStudentName()+"\t"
            					+student.getStudentSex()+"\t"+student.getStudentBirthday()+"\t"+student.getClassId());
                    }
                }
            } finally {
                session.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


