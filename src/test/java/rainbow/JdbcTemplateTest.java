package rainbow;

import domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IStudentService;

import java.util.List;

/**
 * Created by pengfei on 2017/9/20.
 */
public class JdbcTemplateTest {
    public static void main(String[] args) {
        declarativeTxTest();

    }
    //Declarative transaction test.声明式事务管理测试，AOP+tx综合使用。

    private static void declarativeTxTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:mybatis/application.xml");

        Student student = new Student(20, "darling", "female");
        IStudentService service = (IStudentService) context.getBean("studentService");

        service.testDeclarativeTx(25);

        service.testDeclarativeTx(14);
    }

    private static void sumTestA() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:mybatis/application.xml");

        Student student = new Student(20, "Elisabeth", "female");

        IStudentService service = (IStudentService) context.getBean("studentService");

        service.insertStudent(student);
        service.updateStudent(2, 24);

        student = service.queryStudent(2);

        System.out.println("Check result:" + student);

        List<Student> students = service.getAllStudent();

        for (Student s : students) {
            System.out.println(s);
        }

        student = service.queryStudentByCall(students.size());
        System.out.println("Find by call:" + student);

        System.out.println("begin transaction test");
        service.testTxManager(3, "darling", "male");
    }
}
