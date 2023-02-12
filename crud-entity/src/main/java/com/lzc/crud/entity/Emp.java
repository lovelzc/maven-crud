package com.lzc.crud.entity;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;

public class Emp {
    private Integer empId;

    @Pattern(regexp = "^[\u2E80-\u9FFF]{2,5}",
            message = "员工姓名必须是2-5位汉字"
    )
    private String empName;

    private Integer age;

    private String sex;

    @Email(message = "邮箱格式不正确")
    private String email;

    private Integer deptId;

    private Dept dept;

    public Emp() {
    }

    public Emp(Integer empId, String empName, Integer age, String sex, String email, Integer deptId) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.deptId = deptId;
    }

    public Emp(Integer empId, String empName, Integer age, String sex, String email, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                ", dept=" + dept +
                '}';
    }
}
