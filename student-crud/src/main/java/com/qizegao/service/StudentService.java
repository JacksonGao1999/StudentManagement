package com.qizegao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qizegao.bean.Student;
import com.qizegao.bean.StudentExample;
import com.qizegao.bean.StudentExample.Criteria;
import com.qizegao.dao.StudentMapper;

@Service
public class StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	//查询所有学生
	public List<Student> getAll() {
		//创建Example类定义查询条件
		StudentExample studentExample = new StudentExample();
		studentExample.setOrderByClause("stu_id asc");
		return studentMapper.selectByExampleWithDept(studentExample);
	}
	
	//校验用户名是否已经存在于数据库
	public boolean checkUser(String stuName) {
		//指定条件的查询
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStuNameEqualTo(stuName);
		long count = studentMapper.countByExample(example);
		return count == 0;
	}
	
	//保存学生
	public void saveStu(Student student) {
		studentMapper.insertSelective(student); //MBG生成的方法
	}
	
	//根据id查询学生信息
	public Student getStu(Integer id) {
		Student student = studentMapper.selectByPrimaryKey(id);
		return student;
	}
	
	//保存更新后的学生的信息
	public void updateStu(Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
	}
	
	//单个删除
	public void deleteStu(Integer id) {
		studentMapper.deleteByPrimaryKey(id);
	}
	
	//批量删除
	public void deleteBatch(List<Integer> ids) {
		StudentExample studentExample = new StudentExample();
		Criteria criteria = studentExample.createCriteria();
		
		//delete from tbl_stu where stu_id in(1,2,3...) 
		criteria.andStuIdIn(ids);
		
		studentMapper.deleteByExample(studentExample);
	}
}

