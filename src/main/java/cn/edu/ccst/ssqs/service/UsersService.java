package cn.edu.ccst.ssqs.service;

import cn.edu.ccst.ssqs.entity.Student;
import cn.edu.ccst.ssqs.entity.Users;
import cn.edu.ccst.ssqs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserMapper userMapper;
    public Users login(String id, String password){
        if(id.length()>18){
            //System.out.println("返回"+userMapper.loginByIdCard(id,password));
            return userMapper.loginByIdCard(id,password);
        }else {
            return userMapper.loginByStudentId(id,password);
        }
    }

    public Student findById(String id){
        return  userMapper.findByStudentId(id);
    }
    public boolean UpdateStudent(Users users){
        int rs=  userMapper.updateStudent(users);
        return  rs>=1;
    }
}
