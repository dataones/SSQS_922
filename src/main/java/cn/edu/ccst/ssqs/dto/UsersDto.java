package cn.edu.ccst.ssqs.dto;

import cn.edu.ccst.ssqs.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private Long id; // 对应表中的自增主键id
    private String student_id; // 学号(对应表中的student_id)
    private String name; // 姓名
    private String id_card; // 身份证号(对应表中的id_card)
    private String gender; // 性别(男/女)
    private String className; // 班级名称(对应表中的class_name)
    private String phone; // 手机号
    private String email; // 邮箱
    private String password; // 密码(加密存储)
    private String avatarUrl; // 头像URL(对应表中的avatar_url)
    private Integer status; // 状态
    private LocalDateTime createdAt; // 创建时间(对应表中的created_at)
    private LocalDateTime updatedAt; // 更新时间(对应表中的updated_at)
    private BigDecimal averageGpa; // 平均成绩（对应表中average_score）
    private Integer courseCount;
    private Integer PasscourseCount;
    public static  UsersDto UsersToUsersDot(Users users){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setStudent_id(users.getStudentid());
        usersDto.setId_card(users.getIdcard());
        usersDto.setName(users.getName());
        usersDto.setGender(users.getGender());
        usersDto.setClassName(users.getClassName());
        usersDto.setPhone(users.getPhone());
        usersDto.setEmail(users.getEmail());
        usersDto.setAverageGpa(users.getAverageGpa());
        usersDto.setStatus(users.getStatus());
        usersDto.setCourseCount(users.getCourseCount());
        usersDto.setPasscourseCount(users.getPasscourseCount());
        return usersDto;
    }
}