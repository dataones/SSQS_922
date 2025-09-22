package cn.edu.ccst.ssqs.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long id; // 自增主键
    private Long studentId; // 学生ID（对应表中student_id）
    private Long courseId; // 课程ID（对应表中course_id）
    private BigDecimal averageScore; // 平均成绩（对应表中average_score）
    private BigDecimal gpa; // 绩点（对应表中gpa）
    private String gradeType; // 成绩类型（对应表中grade_type，如"期中"、"期末"）
    private Integer status; // 状态
    private LocalDateTime createdAt; // 创建时间（对应表中created_at）
    private LocalDateTime updatedAt; // 更新时间（对应表中updated_at）
    private Integer pyScore; // Python成绩（对应表中py_score）
    private Integer javaScore; // Java成绩（对应表中java_score）
    private Integer noSqlScore; // NoSql成绩（对应表中NoSql_score）
    private Integer wxScore; // 微信小程序成绩（对应表中WX_score）
    private Integer vueScore; // Vue成绩（对应表中vue_score）
}
