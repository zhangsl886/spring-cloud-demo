package cn.com.demo.service;

import java.util.List;

import cn.com.demo.model.Student;

public interface StudentService {
	
	/**
	 * 新增学生信息
	 * @param record
	 * @return
	 */
	public int addStudent(Student record);
	
	/*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
	public List<Student> findAllStudent(int pageNum, int pageSize);
	
	/**
	 * 删除学生信息（物理删除）
	 * @param id
	 * @return
	 */
	public int deleteStudent(String id);

	/**
	 * 更新学生信息
	 * @param record
	 * @return
	 */
	public int updateStudent(Student record);
	
	/**
	 * 获取学生信息
	 * @param id
	 * @return
	 */
	public Student getStudentById(String id);
}
