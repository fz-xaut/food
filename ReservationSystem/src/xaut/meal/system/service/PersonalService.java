package xaut.meal.system.service;

import xaut.meal.system.pojo.Student;

public interface PersonalService {
    
    Student loginVerify(String stuName);
    
    void sign(Student stu);
    
    void change(Student stu);

}
