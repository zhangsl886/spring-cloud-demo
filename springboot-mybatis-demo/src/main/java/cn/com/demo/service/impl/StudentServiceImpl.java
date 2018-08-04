package cn.com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.demo.mapper.StudentMapper;
import cn.com.demo.model.Student;
import cn.com.demo.service.StudentService;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
    private StudentMapper studentMapper;//这里会报错，但是并不会影响
	
	@Override
	public int addStudent(Student record) {
		return studentMapper.insert(record);
	}

	@Override
	public List<Student> findAllStudent(int pageNum, int pageSize) {
		 //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
		return studentMapper.selectAllStudent();
	}

	@Override
	public int deleteStudent(String id) {
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateStudent(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public Student getStudentById(String id) {
		return studentMapper.selectByPrimaryKey(id);
	}

}
