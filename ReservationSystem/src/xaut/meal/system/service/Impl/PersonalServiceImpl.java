package xaut.meal.system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xaut.meal.system.mapper.PersonalMapper;
import xaut.meal.system.pojo.Student;
import xaut.meal.system.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService {
    
    @Autowired
    private PersonalMapper personalMapper;
    
    @Override
    public Student loginVerify(String stuName) {
        Student stu = null;
        try {
            stu = personalMapper.loginVerify(stuName);
        }catch (Exception e){
            return stu;
        }
        return stu;
    }

    @Override
    public void sign(Student stu) {
        
        personalMapper.sign(stu);
        
    }

    @Override
    public void change(Student stu) {
        
        personalMapper.change(stu);
    }
}
