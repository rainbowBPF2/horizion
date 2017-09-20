package dao;

import domain.Student;
import domain.StudentMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by pengfei on 2017/9/20.
 */

@Repository
public class StudentDaoImpl implements StudentDao {

    private final static Logger logger = Logger.getLogger(StudentDaoImpl.class);

    private DataSource dataSource;
    private JdbcTemplate template;

    @Autowired
    private PlatformTransactionManager txManager;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }

    public void create(String name, String male, int age) {
        String sql = "insert into student (name, male,age) values(?, ?, ?)";
        int rows = this.template.update(sql, name, male, age);
        logger.info("Create a student in db, affect rows:" + rows);

    }

    public Student findStudent(int id) {
        String sql = "select * from student where id = ?";
        Student student = (Student) this.template.queryForObject(sql, new StudentMapper(), id);
        logger.info("get student with id:" + id);
        return student;
    }

    public List<Student> listStudents() {
        String sql = "select * from student";
        List<Student> students = this.template.query(sql, new StudentMapper());

        logger.info("Got students");
        return students;
    }

    public void delete(int id) {
        String sql = "delete from student where id= ?";
        this.template.update(sql, id);
        logger.info("Delete student with id:" + id);
    }

    public void update(int id, int age) {
        String sql = "update student set age =? where id= ?";
        this.template.update(sql, age, id);

    }

    public Student getStudentByCall(int id) {
        SimpleJdbcCall call = new SimpleJdbcCall(this.dataSource).withProcedureName("getStudentRecord");
        SqlParameterSource in = new MapSqlParameterSource("in_id", id);

        Map<String, Object> out = call.execute(in);

        Student student = new Student();
        student.setName((String) out.get("out_name"));
        student.setAge((Integer) out.get("out_age"));

        return student;
    }

    public void transactionTest(int id, String name, String male) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(def);

        try {
            String sql1 = "update student set name =? where id= ?";

            this.template.update(sql1, name, id);

            String sql2 = "insert into student (name, male) values (?, ?) ";
            this.template.update(sql2, name, male);

//            //Test transaction function.
//            if (id % 2 == 1)
//                throw new RecoverableDataAccessException("");

            txManager.commit(status);
            logger.info("Transaction test success in dao");
        } catch (DataAccessException e) {
            logger.error("error found in TX execution.");
            txManager.rollback(status);
            throw e;
        }

        return;
    }

    public void declarativeTxTest(int age) {
        logger.info("dao tx begin");
        String sql = "insert into student (name, age) values(?, ?)";
        this.template.update(sql, "mary dianna", age);
        if (age < 18)
            throw new RuntimeException();
        logger.info("dao tx end");
    }
}
