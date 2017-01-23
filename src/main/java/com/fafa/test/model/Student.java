package com.fafa.test.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String studentId;

    private String studentName;

    private String studentSex;

    private Date studentBirthday;

    private String classId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public String getStudentBirthday() {
    	//格式化Date
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");
    	String date = dateFormat.format(studentBirthday);
        return date;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }
}