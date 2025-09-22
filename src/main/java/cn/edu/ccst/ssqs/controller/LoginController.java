package cn.edu.ccst.ssqs.controller;

import cn.edu.ccst.ssqs.common.SessionConst;
import cn.edu.ccst.ssqs.dto.UsersDto;
import cn.edu.ccst.ssqs.entity.Student;
import cn.edu.ccst.ssqs.entity.Users;
import cn.edu.ccst.ssqs.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(
            @RequestBody Map<String, String> params,
            HttpSession session) {
        String id = params.get("id");
        String password = params.get("password");

        // 1. 打印登录参数（排查前端传入的账号是否正确）
        //System.out.println("【登录接口】前端传入的账号: " + id);
        //System.out.println("【登录接口】前端传入的密码: " + (password != null ? "******" : "null"));

        Map<String, Object> map = new HashMap<>();
        Users users = usersService.login(id, password);

        // 2. 打印数据库查询结果（核心排查点）
        //System.out.println("【登录接口】数据库查询到的用户: " + (users != null ? users.toString() : "null"));
        //System.out.println("【登录接口】数据库查询到的student_id: " + (users != null ? users.getStudentid() : "null"));

        if (users != null) {
            // 3. 登录成功后打印Session存储的student_id
            //System.out.println("【登录接口】即将存入Session的student_id: " + users.getStudentid());
            session.setAttribute(SessionConst.SESSION_USER, users);

            if (users.getStatus() == 1) {
                Student student=usersService.findById(users.getStudentid());
                session.setAttribute(SessionConst.SESSION_STUDENT, student);
                map.put("status", "SUCCESS");
                map.put("msg", "登录成功");
            } else {
                map.put("status", "ERROR");
                map.put("msg", "登陆失败,用户禁止登录！！！");
            }
        } else {
            map.put("status", "ERROR");
            map.put("msg", "登陆失败,用户名或密码错误！！！");
        }
        return map;
    }

    @GetMapping("/getCurr")
    @ResponseBody
    public Map<String, Object> getUsers(HttpSession session) {
        Users users = (Users) session.getAttribute(SessionConst.SESSION_USER);

        // 4. 打印从Session中获取的用户信息（核心排查点）
       // System.out.println("【getCurr接口】从Session获取的用户: " + (users != null ? users.toString() : "null"));
        //System.out.println("【getCurr接口】从Session获取的student_id: " + (users != null ? users.getStudentid() : "null"));

        Map<String, Object> map = new HashMap<>();
        if (users != null) {
            UsersDto dto = UsersDto.UsersToUsersDot(users);
            // 5. 打印转换后DTO中的student_id
            //System.out.println("【getCurr接口】转换后DTO的student_id: " + dto.getStudent_id());

            map.put("status", "SUCCESS");
            map.put("user", dto);
        } else {
            map.put("status", "ERROR");
            map.put("msg", "未获取到登陆状态");
        }
        return map;
    }
}
