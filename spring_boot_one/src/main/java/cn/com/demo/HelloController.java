package cn.com.demo;

import java.text.DateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ConfigurationProperties(prefix ="student")
public class HelloController {
	
	@Resource
	private AuthorSettings authorSettings;
	
//	@RequestMapping("/hello")
//    public String hello(Model view) {
////        return "Hello Spring Boot!";
//		view.addAttribute("content", "姓名："+name+"；"+"年龄："+age);
//		view.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
//        return "hello";
//    }
	
	/**
     * 响应到JSP页面hello
     */
    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("content", "姓名："+authorSettings.getName()+"；"+"年龄："+authorSettings.getAge());
        mav.addObject("now", DateFormat.getDateInstance().format(new Date()));
        return mav;
    }
}
