package xaut.meal.system.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xaut.meal.system.pojo.Student;
import xaut.meal.system.service.PersonalService;
import xaut.meal.system.utils.Analysis;

@Controller
public class PersonalController {

    @Autowired
    private PersonalService personalService;
    /*登录*/
    @RequestMapping("verify")
    public String loginverify(HttpServletRequest request) throws UnsupportedEncodingException {
        
        
        String stuName = new String(request.getParameter("stuName").getBytes("iso8859-1"), "utf-8");
        String password = new String(request.getParameter("password").getBytes("iso8859-1"), "utf-8");
        Student stu = personalService.loginVerify(stuName);
        if (stu == null) {
            return "login.jsp";
        } else if (password != "" && stu.getPassword().equals(password)) {
            request.getSession().setAttribute("stu", stu);
            return "/WEB-INF/jsp/index.jsp";
        } else {
            return "login.jsp";
        }
    }

    /*注册*/
    @RequestMapping(value = "sign", method = RequestMethod.POST)
    public String sigUp(@ModelAttribute Student stu,HttpServletRequest request) throws UnsupportedEncodingException {

        
        stu.setPassword(new String(stu.getPassword().getBytes("iso8859-1"), "utf-8"));
        stu.setStuAddress(new String(stu.getStuAddress().getBytes("iso8859-1"), "utf-8"));
        stu.setStuCall(new String(stu.getStuCall().getBytes("iso8859-1"), "utf-8"));
        stu.setStuName(new String(stu.getStuName().getBytes("iso8859-1"), "utf-8"));
        stu.setStuNo(new String(stu.getStuNo().getBytes("iso8859-1"), "utf-8"));
        personalService.sign(stu);
        return "login.jsp";
    }
    
    /*修改个人信息*/
    @RequestMapping("change")
    @ResponseBody
    public String change (@RequestBody String message,HttpServletRequest request) {
        try {
            Analysis analysis = new Analysis();
            Student stu = analysis.AnalysisStudent(message);
            personalService.change(stu);
            request.getSession().setAttribute("stu", stu);
            return "success";
        }catch(Exception e) {
            return "error";
        }
    }
}
