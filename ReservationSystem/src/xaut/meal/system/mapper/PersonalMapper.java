package xaut.meal.system.mapper;

import xaut.meal.system.pojo.Student;

public interface PersonalMapper {
    
    Student loginVerify(String stuName);
    
    void sign (Student stu);
    
    void change(Student stu);
}
