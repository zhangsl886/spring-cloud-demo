package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> selectAllStudent();
    
    int updateBatchStudent(List<Student> record);
    
    int insertBatchStudent(List<Student> record);
}