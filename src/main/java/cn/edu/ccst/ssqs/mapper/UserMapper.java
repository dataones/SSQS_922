package cn.edu.ccst.ssqs.mapper;

import cn.edu.ccst.ssqs.entity.Student;
import cn.edu.ccst.ssqs.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface UserMapper {

    /**
     * 根据身份证和密码登录系统
     * <p>功能：验证用户名和密码，允许医生登录系统。</p>
     *
     * @param idCard     身份证号
     * @param password 密码
     * @return 登录对象
     */
    Users loginByIdCard(@Param("id_card") String idCard, @Param("password") String password);

    /**
     * 根据用户名和密码登录系统
     * <p>功能：验证用户名和密码，允许医生登录系统。</p>
     *
     * @param studentId   学号
     * @param password 密码
     * @return 登录对象
     */
    Users loginByStudentId(@Param("student_id") String studentId, @Param("password") String password);

    /**
     * 根据学号查询成绩
     * @param student_id     学号
     * @return 登录对象
     */
    Student findByStudentId(@Param("student_id") String student_id);
    int updateStudent(Users users);
    int verifyUserIdentity(String id,String phone);
    int resetPassword(String id,String newPassword);
}
