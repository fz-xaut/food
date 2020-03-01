package xaut.meal.system.utils;

import xaut.meal.system.pojo.OrderInDB;
import xaut.meal.system.pojo.Student;

public class Analysis {
    
    public OrderInDB AnalysisOrder(String msg) {
        
        OrderInDB orderInDB = new OrderInDB();
        msg = msg.replace("{", "");
        msg = msg.replace("}", "");
        msg = msg.replace("\"", "");
        String orders[] = msg.split(",");
        
        orderInDB.setFood_id((Integer.parseInt(orders[0].split(":")[1])));
        orderInDB.setStu_no((orders[6].split(":")[1]));
        
        return orderInDB;
    }
    public Student AnalysisStudent(String msg) {
        Student stu = new Student();
        msg = msg.replace("{", "");
        msg = msg.replace("}", "");
        msg = msg.replace("\"", "");
        String stus[] = msg.split(",");
        stu.setStuNo(stus[0].split(":")[1]);
        stu.setStuName(stus[1].split(":")[1]);
        stu.setStuAddress(stus[2].split(":")[1]);
        stu.setStuCall(stus[3].split(":")[1]);
        stu.setPassword(stus[4].split(":")[1]);
        return stu;
    }
}
