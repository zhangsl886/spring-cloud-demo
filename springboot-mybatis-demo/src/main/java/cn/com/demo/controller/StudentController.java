package cn.com.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.model.Student;
import cn.com.demo.service.StudentService;

@RestController
@RequestMapping(value = "/home")
public class StudentController {
	@Resource
    private StudentService studentService;
	
	@Resource
    private MyAuthenctiationSuccessHandler myAuthenticationSuccessHandler;
	
	@Resource
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;
	
    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(Student student){
    	String id = UUID.randomUUID().toString().replaceAll("-", "");
    	student.setId(id);
        return studentService.addStudent(student);
    }
    
    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public int updateUser(Student student){
        return studentService.updateStudent(student);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public int deleteUser(@RequestParam(name = "id") String id){
        return studentService.deleteStudent(id);
    }
    
    @ResponseBody
    @RequestMapping(value = "/get")
    public Object getUser(@RequestParam(name = "id") String id){
        return studentService.getStudentById(id);
    }
    
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return studentService.findAllStudent(pageNum,pageSize);
    }
    
    @RequestMapping(value = "/user")
    public ModelAndView hello(){
        ModelAndView mav = new ModelAndView("hello");
        Student student = studentService.findAllStudent(1, 10).get(0);
        mav.addObject("student", student);
        mav.addObject("now", DateFormat.getDateInstance().format(new Date()));
        return mav;
    }
    
    @ResponseBody
    @RequestMapping("/all")
    public Object findAllStudent(@RequestParam(name = "pageNum", required = false, defaultValue = "1")int pageNum,
    		@RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
    	 return studentService.findAllStudent(pageNum,pageSize);
    }
    
	@RequestMapping("/login")
	public ModelAndView login() { 
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
//    public ModelAndView login() {
//		 ModelAndView mav = new ModelAndView("login");
//		 return mav;
//	}
}
