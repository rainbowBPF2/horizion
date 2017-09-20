package service;

import domain.Student;

import java.util.List;

/**
 * Created by pengfei on 2017/9/20.
 */
public interface IStudentService {
    public void insertStudent(Student student);

    public void updateStudent(int id, int age);

    public List<Student> getAllStudent();

    public void deleteStudent(int id);

    public Student queryStudent(int id);

    public Student queryStudentByCall(int id);

    public void testTxManager(int id, String name, String male);

    public void testDeclarativeTx(int age);

}
