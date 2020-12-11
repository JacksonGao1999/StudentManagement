package com.qizegao.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qizegao.bean.Department;
import com.qizegao.bean.Student;
import com.qizegao.dao.DepartmentMapper;
import com.qizegao.dao.StudentMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	StudentMapper studentMapper;
	
	@Test
	public void test() {
//		System.out.println(departmentMapper);
		//org.apache.ibatis.binding.MapperProxy@53093491
		
//		//插入三个部门（使用逆向工程自动生成的方法）
//		departmentMapper.insertSelective(new Department(null, "学生部"));
//		departmentMapper.insertSelective(new Department(null, "信息部"));
//		departmentMapper.insertSelective(new Department(null, "记者部"));
//		departmentMapper.insertSelective(new Department(null, "实创部"));
		
		//插入学生
		
//		studentMapper.insertSelective(new Student(null, "白曜溥", "M", "yaopu@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "柴高岩", "M", "gaoyan@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "陈露", "M", "chenlu@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "褚宸皓", "M", "chenhao@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "冯金平", "M", "jinpin@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "高奇泽", "M", "qize@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "宫敏", "M", "gongmin@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "郭旭", "M", "guoxu@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "郝思远", "M", "siyuan@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "呼晓辉", "M", "xiaohui@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "家彦明", "M", "yanming@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "焦晨帆", "F", "chenfan@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "李兴栋", "M", "xindong@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "李英", "F", "liying@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "李源", "M", "liyuan@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "刘丹", "F", "liudan@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "牛旭东", "M", "xudong@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "牛泽鹏", "M", "zepeng@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "裴怡博", "M", "yibo@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "秦新宇", "M", "xinyu@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "师伟", "M", "shiwei@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "石宇飞", "M", "yufei@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "孙亚龙", "M", "yalong@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "王攀榕", "F", "panrong@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "王洋", "M", "wangyang@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "王振龙", "M", "zhenlong@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "魏超群", "M", "chaoqun@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "闫青", "F", "yanqing@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "杨华", "F", "yanghua@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "杨欢", "F", "yanghuan@163.com",3));
//		studentMapper.insertSelective(new Student(null, "杨凯", "F", "yangkai@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "姚丹娜", "F", "danna@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "由国婧", "F", "guojing@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "张强文", "M", "qiangwen@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "张勇", "M", "zhangyong@163.com", 4));
//		studentMapper.insertSelective(new Student(null, "测试用例1", "M", "ceshi@163.com", 1));
//		studentMapper.insertSelective(new Student(null, "测试用例1", "M", "ceshi@163.com", 2));
//		studentMapper.insertSelective(new Student(null, "测试用例1", "M", "ceshi@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "测试用例1", "M", "ceshi@163.com", 4));
		studentMapper.insertSelective(new Student(null, "冯阳阳", "M", "yangyang@163.com", 1));
		studentMapper.insertSelective(new Student(null, "王静玲", "F", "jingling@163.com", 2));
//		
//		
//		System.out.println("运行成功");
	}
}
