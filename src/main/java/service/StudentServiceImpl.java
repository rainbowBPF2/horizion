package service;

import dao.StudentDao;
import domain.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by pengfei on 2017/9/20.
 */

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDao dao;

    private final static Logger logger = Logger.getLogger(StudentServiceImpl.class);

    public void insertStudent(Student student) {
        if (student != null) {
            this.dao.create(student.getName(), student.getMale(), student.getAge());
        } else {
            logger.error("Illegal parameter:student");
            throw new IllegalArgumentException("Student cannot be null");
        }
    }

    public void updateStudent(int id, int age) {
        if (id <= 0 || age <= 0) {
            logger.error("Illegal parameter:id/age");
            throw new IllegalArgumentException("Illegal parameter id/age ");
        } else {
            this.dao.update(id, age);
        }
    }

    public List<Student> getAllStudent() {
        List<Student> results = this.dao.listStudents();

        logger.info("Find all students from db.");

        return results;
    }

    public void deleteStudent(int id) {
        if (id <= 0) {
            logger.error("Illegal parameter");
            throw new IllegalArgumentException("Id should be above 0");
        } else {
            this.dao.delete(id);
        }
    }

    public Student queryStudent(int id) {
        if (id <= 0)
            throw new IllegalArgumentException();
        else {
            Student student = this.dao.findStudent(id);
            return student;
        }
    }

    public Student queryStudentByCall(int id) {
        if (id <= 0)
            throw new IllegalArgumentException();
        else {
            Student s = this.dao.getStudentByCall(id);
            logger.info("Find user by call:" + id);
            return s;
        }
    }

    public void testTxManager(int id, String name, String male) {
        if (id <= 0 || StringUtils.isEmpty(name) || StringUtils.isEmpty(male)) {
            logger.error("Illegal parameter id/name/male");
            throw new IllegalArgumentException();
        } else {
            this.dao.transactionTest(id, name, male);
            logger.info("Transaction test success in service");
        }
    }

    public void testDeclarativeTx(int age) {

        logger.info("service tx begin");
        this.dao.declarativeTxTest(age);
        logger.info("service tx end");

    }
}
