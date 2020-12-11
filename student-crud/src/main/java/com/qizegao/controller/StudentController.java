package com.qizegao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qizegao.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qizegao.bean.Student;
import com.qizegao.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//分页查询学生数据
	@RequestMapping("/stus")
	@ResponseBody //导入Jackson包使用
	public Msg getStusWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Student> stus = studentService.getAll();
		PageInfo page = new PageInfo(stus, 5); //PageInfo封装了分页的详细信息
		return Msg.success().add("pageInfo", page);
	}
	
	//检查用户名是否已经存在于数据库
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("stuName")String stuName){
		
		//先判断用户名是否满足正则表达式，若不满足无需去数据库查询
		String regx = "^[\u2E80-\u9FFF]{2,5}";
		if(!stuName.matches(regx)){
			return Msg.fail().add("va_msg", "学生姓名必须是2-5位汉字");
		}
		
		//数据库用户名重复校验
		boolean b = studentService.checkUser(stuName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "学生姓名已存在");
		}
	}
	
	//保存学生
	@RequestMapping(value="/stu",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(@Valid Student student, BindingResult result){
		
		if (result.hasErrors()) {
			
			//JSR303校验结果有错误时，将JSR303校验结果封装在map中
			
			Map<String, Object> map = new HashMap<String, Object>();
			//获取所有有错误的字段
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				//getFiled表示错误的字段名
				//getDefaultMessage表示JavaBean定义的错误信息
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		} else {
			//校验结果无误时
			studentService.saveStu(student);
			return Msg.success();
		}
	}
	
	//根据id查询学生信息
	@RequestMapping(value="/stu/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Msg getStu(@PathVariable("id")Integer id){
		
		Student student = studentService.getStu(id);
		return Msg.success().add("stu", student);
	}
	
	//保存更新后的学生信息
	@ResponseBody
	@RequestMapping(value="/stu/{stuId}", method=RequestMethod.PUT)
	public Msg saveStu(Student student){
		studentService.updateStu(student);
		return Msg.success();
	}
	
	//删除学生
	//批量删除时不同的学生通过 "-" 连接
	@ResponseBody
	@RequestMapping(value="/stu/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//将所有学生id组装成集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			studentService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			studentService.deleteStu(id);
		}
		return Msg.success();
	}
	
}

