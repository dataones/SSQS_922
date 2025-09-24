package cn.edu.ccst.ssqs.controller;

import cn.edu.ccst.ssqs.common.SessionConst;
import cn.edu.ccst.ssqs.entity.Student;
import cn.edu.ccst.ssqs.entity.Users;
import cn.edu.ccst.ssqs.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("student_index")
public class UsersController {
    @Autowired
    UsersService service;
    @PostMapping("grades")
    @ResponseBody
    public Map<String, Object> findByStudentId(@RequestParam("id") String id, HttpSession session){

        Map<String,Object> map = new HashMap<>();
        Student currStudents = (Student) session.getAttribute(SessionConst.SESSION_STUDENT);
        String studentIdFromSession = String.valueOf(currStudents.getStudentId());
        System.out.println(studentIdFromSession);
        if(studentIdFromSession.equals(id)){
            Student student = service.findById(studentIdFromSession);
            System.out.println(student);
            if (student != null) {
                map.put("status", "success");
                map.put("message", "查询用户信息成功");
                map.put("data", student);
            } else {
                map.put("status", "error");
                map.put("message", "未查询到该用户信息");
            }
        }else System.out.println("null");
        return map;
    }
    @PostMapping("updateStudent")
    @ResponseBody
    public Map<String, Object> updateStudent(@RequestParam("student_id") String studentid,
                                            @RequestParam("phone") String phone,
                                            @RequestParam("email") String email,
                                            @RequestParam("className") String className){
        Users users = new Users();
        users.setStudentid(studentid);
        users.setClassName(className);
        users.setPhone(phone);
        users.setEmail(email);
        System.out.println(users);
        Map<String,Object> map = new HashMap<>();
        if (service.UpdateStudent(users)){
            map.put("status","success");
        }else {
            map.put("status", "error");
            map.put("mag", "未知原因失败");
        }
        return map;
    }
}
