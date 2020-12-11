package com.qizegao.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class Student {
	
    @Pattern(regexp="^[\u2E80-\u9FFF]{2,5}"
    		,message=" 学生姓名必须是2-5位汉字 ")
    private String stuName;

    @Email(message = "邮箱格式不正确")
    private String email;
    
    private Integer stuId;

    private String gender;


    private Integer dId;
    
    private Department department; 
    
    

    public Student() {
		super();
	}

	public Student(Integer stuId, String stuName, String gender, String email, Integer dId) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.gender = gender;
		this.email = email;
		this.dId = dId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}