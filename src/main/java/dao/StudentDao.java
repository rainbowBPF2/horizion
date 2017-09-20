package dao;

import domain.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by pengfei on 2017/9/20.
 */
public interface StudentDao {

    public void setDataSource(DataSource dataSource);

    public void create(String name,String male,int age);

    public Student findStudent(int id);

    public List<Student> listStudents();

    public void delete(int id);

    public void update(int id,int age);

    public Student getStudentByCall(int id);

    public void transactionTest(int id,String name, String male);

    public void declarativeTxTest(int age);

}
